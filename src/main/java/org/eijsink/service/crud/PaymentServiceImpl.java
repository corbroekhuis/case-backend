package org.eijsink.service.crud;

import org.eijsink.exception.EijsinkException;
import org.eijsink.repository.PaymentRepository;
import org.eijsink.model.Payment;

import org.eijsink.service.ics.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService{

    CardService cardService;
    PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(CardService cardService,
                     PaymentRepository paymentRepository){
        this.cardService = cardService;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment save(Payment payment, String cardNumber) throws EijsinkException {

        if(payment.getType() == Payment.PAYMENT_TYPE.CARD){
            if( !cardService.checkCard(cardNumber, payment.getAmount())){
                throw new EijsinkException("Card check failed");
            }
        }

        return paymentRepository.save(payment);
    }

    @Override
    public Iterable<Payment> saveAll(Iterable<Payment> payments){
        return paymentRepository.saveAll(payments);
    }

    @Override
    public Optional<Payment> findById(Long id){
        return paymentRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id){
        return paymentRepository.existsById(id);
    }

    @Override
    public Iterable<Payment> findAll(){
        return paymentRepository.findAll();
    }

    @Override
    public Iterable<Payment> findAllById(Iterable<Long> ids){
        return paymentRepository.findAllById(ids);
    }

    @Override
    public long count(){
        return paymentRepository.count();
    }

    @Override
    public void deleteById(Long id){
        paymentRepository.deleteById(id);
    }

    @Override
    public void delete(Payment payment){
        paymentRepository.delete(payment);
    }

    @Override
    public void deleteAll(Iterable<? extends Payment> payments){
        paymentRepository.deleteAll(payments);
    }

    @Override
    public void deleteAll(){
        paymentRepository.deleteAll();
    }

}

