package org.eijsink.service;

import org.eijsink.repository.PaymentRepository;
import org.eijsink.model.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService{

    PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository){
      this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment save(Payment payment){
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

