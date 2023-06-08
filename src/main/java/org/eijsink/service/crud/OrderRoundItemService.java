package org.eijsink.service.crud;

import org.eijsink.model.OrderRoundItem;

import java.util.Optional;

public interface OrderRoundItemService {

    public OrderRoundItem save(OrderRoundItem orderRoundItem);

    public Iterable<OrderRoundItem> saveAll(Iterable<OrderRoundItem> orderRoundItems);

    public Optional<OrderRoundItem> findById(Long id);

    public boolean existsById(Long id);

    public Iterable<OrderRoundItem> findAll();

    public Iterable<OrderRoundItem> findAllById(Iterable<Long> ids);

    public long count();

    public void deleteById(Long id);

    public void delete(OrderRoundItem orderRoundItem);

    public void deleteAll(Iterable<? extends OrderRoundItem> orderRoundItems);

    public void deleteAll();

}

