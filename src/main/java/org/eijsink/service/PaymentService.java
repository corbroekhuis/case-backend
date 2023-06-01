package org.eijsink.service;

import org.eijsink.model.Payment;

import java.util.Optional;

public interface PaymentService {

    public Payment save(Payment payment);

    public Iterable<Payment> saveAll(Iterable<Payment> payments);

    public Optional<Payment> findById(Long id);

    public boolean existsById(Long id);

    public Iterable<Payment> findAll();

    public Iterable<Payment> findAllById(Iterable<Long> ids);

    public long count();

    public void deleteById(Long id);

    public void delete(Payment payment);

    public void deleteAll(Iterable<? extends Payment> payments);

    public void deleteAll();

}

