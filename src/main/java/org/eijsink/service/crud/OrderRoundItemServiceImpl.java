package org.eijsink.service.crud;

import org.eijsink.repository.OrderRoundItemRepository;
import org.eijsink.model.OrderRoundItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderRoundItemServiceImpl implements OrderRoundItemService{

    OrderRoundItemRepository orderRoundItemRepository;

    @Autowired
    public OrderRoundItemServiceImpl(OrderRoundItemRepository orderRoundItemRepository){
      this.orderRoundItemRepository = orderRoundItemRepository;
    }

    @Override
    public OrderRoundItem save(OrderRoundItem orderRoundItem){
        return orderRoundItemRepository.save(orderRoundItem);
    }

    @Override
    public Iterable<OrderRoundItem> saveAll(Iterable<OrderRoundItem> orderRoundItems){
        return orderRoundItemRepository.saveAll(orderRoundItems);
    }

    @Override
    public Optional<OrderRoundItem> findById(Long id){
        return orderRoundItemRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id){
        return orderRoundItemRepository.existsById(id);
    }

    @Override
    public Iterable<OrderRoundItem> findAll(){
        return orderRoundItemRepository.findAll();
    }

    @Override
    public Iterable<OrderRoundItem> findAllById(Iterable<Long> ids){
        return orderRoundItemRepository.findAllById(ids);
    }

    @Override
    public long count(){
        return orderRoundItemRepository.count();
    }

    @Override
    public void deleteById(Long id){
        orderRoundItemRepository.deleteById(id);
    }

    @Override
    public void delete(OrderRoundItem orderRoundItem){
        orderRoundItemRepository.delete(orderRoundItem);
    }

    @Override
    public void deleteAll(Iterable<? extends OrderRoundItem> orderRoundItems){
        orderRoundItemRepository.deleteAll(orderRoundItems);
    }

    @Override
    public void deleteAll(){
        orderRoundItemRepository.deleteAll();
    }

}

