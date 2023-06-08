package org.eijsink.service.internal.nl;

import jakarta.persistence.criteria.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eijsink.exception.EijsinkException;
import org.eijsink.model.OrderRound;
import org.eijsink.model.OrderRoundItem;
import org.eijsink.model.Payment;
import org.eijsink.model.Ticket;
import org.eijsink.service.bank.BankService;
import org.eijsink.service.cloud.CloudService;
import org.eijsink.service.crud.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TicketProcessServiceImpl implements TicketProcessService {

    protected static final Logger logger = LogManager.getLogger();

    @Value("${db.url}")
    String url;
    @Value("${db.url}")
    String user;
    @Value("${db.url}")
    String password;

    @Autowired
    CloudService cloudService;
    @Autowired
    TicketService ticketService;
    @Autowired
    BankService bankService;

    @Override
    public void procesTicket(Ticket ticket) throws EijsinkException {

        double change = checkPayments( ticket.getPayments(), ticket.getMainOrder().getOrderRounds());
        if( change < 0){
            throw new EijsinkException( "Errno: 364553 - Payments not sufficient: " + change);
        }

        try {
            bankService.tranferToEijsink( getTotalPrices(ticket.getMainOrder().getOrderRounds()), ticket);
        } catch (IOException e) {
            throw new EijsinkException( "Errno: 368573 - Unable to transfer: " + e.getMessage());
        }

        String token = "not-valid";
        try {
            token = cloudService.login( url + "/login", user, password);
            String response = cloudService.callApi( url + "/ticket", token, ticket);
            cloudService.logout( url + "/logout");
            ticket.setClosed(true);
            ticketService.save( ticket);
            logger.info("Processing succesful for ticket: " + ticket.getId());

        } catch (IOException e) {
            throw new EijsinkException( "Errno: 364553 - Unable to logon: " + e.getMessage());
        }
    }

    private double checkPayments(List<Payment> payments, List<OrderRound> orderRounds){

        double totalPayment = 0;
        double totalPrice = getTotalPrices(orderRounds);
        for( Payment payment: payments) {
            totalPayment+=payment.getAmount();
        }

        return totalPayment - totalPrice;
    }

    private double getTotalPrices(List<OrderRound> orderRounds){
        double totalPrice = 0;
        for(OrderRound orderRound: orderRounds) {
            for(OrderRoundItem orderRoundItem: orderRound.getOrderRoundItems()){
                totalPrice+=orderRoundItem.getItem().getPrice();
            }
        }
        return totalPrice;
    }
}
