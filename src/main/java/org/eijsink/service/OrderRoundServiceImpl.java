package org.eijsink.service;

import org.eijsink.repository.OrderRoundRepository;
import org.eijsink.model.OrderRound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderRoundServiceImpl implements OrderRoundService{

    OrderRoundRepository orderRoundRepository;

    @Autowired
    public OrderRoundServiceImpl(OrderRoundRepository orderRoundRepository){
      this.orderRoundRepository = orderRoundRepository;
    }

    @Override
    public OrderRound save(OrderRound orderRound){
        return orderRoundRepository.save(orderRound);
    }

    @Override
    public Iterable<OrderRound> saveAll(Iterable<OrderRound> orderRounds){
        return orderRoundRepository.saveAll(orderRounds);
    }

    @Override
    public Optional<OrderRound> findById(Long id){
        return orderRoundRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id){
        return orderRoundRepository.existsById(id);
    }

    @Override
    public Iterable<OrderRound> findAll(){
        return orderRoundRepository.findAll();
    }

    @Override
    public Iterable<OrderRound> findAllById(Iterable<Long> ids){
        return orderRoundRepository.findAllById(ids);
    }

    @Override
    public long count(){
        return orderRoundRepository.count();
    }

    @Override
    public void deleteById(Long id){
        orderRoundRepository.deleteById(id);
    }

    @Override
    public void delete(OrderRound orderRound){
        orderRoundRepository.delete(orderRound);
    }

    @Override
    public void deleteAll(Iterable<? extends OrderRound> orderRounds){
        orderRoundRepository.deleteAll(orderRounds);
    }

    @Override
    public void deleteAll(){
        orderRoundRepository.deleteAll();
    }

}

