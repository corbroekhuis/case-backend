package org.eijsink.service;

import org.eijsink.model.MainOrder;

import java.util.Optional;

public interface MainOrderService {

    public MainOrder save(MainOrder mainOrder);

    public Iterable<MainOrder> saveAll(Iterable<MainOrder> mainOrders);

    public Optional<MainOrder> findById(Long id);

    public boolean existsById(Long id);

    public Iterable<MainOrder> findAll();

    public Iterable<MainOrder> findAllById(Iterable<Long> ids);

    public long count();

    public void deleteById(Long id);

    public void delete(MainOrder mainOrder);

    public void deleteAll(Iterable<? extends MainOrder> mainOrders);

    public void deleteAll();

}

