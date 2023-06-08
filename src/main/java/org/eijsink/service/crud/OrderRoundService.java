package org.eijsink.service.crud;

import org.eijsink.model.OrderRound;

import java.util.Optional;

public interface OrderRoundService {

    public OrderRound save(OrderRound orderRound);

    public Iterable<OrderRound> saveAll(Iterable<OrderRound> orderRounds);

    public Optional<OrderRound> findById(Long id);

    public boolean existsById(Long id);

    public Iterable<OrderRound> findAll();

    public Iterable<OrderRound> findAllById(Iterable<Long> ids);

    public long count();

    public void deleteById(Long id);

    public void delete(OrderRound orderRound);

    public void deleteAll(Iterable<? extends OrderRound> orderRounds);

    public void deleteAll();

}

