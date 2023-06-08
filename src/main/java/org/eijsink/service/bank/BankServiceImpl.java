package org.eijsink.service.bank;

import org.eijsink.model.MainOrder;
import org.eijsink.model.Ticket;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BankServiceImpl implements BankService{

    @Override
    public void tranferToEijsink(double totalPrices, Ticket ticket) throws IOException {

        int a = 8;
        if( a < 0){
            throw new IOException("No connection - Transfer failed for ticket: " + ticket.getId());
        }

    }
}
