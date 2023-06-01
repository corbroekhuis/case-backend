package org.eijsink.service;

import org.eijsink.repository.MainOrderRepository;
import org.eijsink.model.MainOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainOrderServiceImpl implements MainOrderService{

    MainOrderRepository mainOrderRepository;

    @Autowired
    public MainOrderServiceImpl(MainOrderRepository mainOrderRepository){
      this.mainOrderRepository = mainOrderRepository;
    }

    @Override
    public MainOrder save(MainOrder mainOrder){
        return mainOrderRepository.save(mainOrder);
    }

    @Override
    public Iterable<MainOrder> saveAll(Iterable<MainOrder> mainOrders){
        return mainOrderRepository.saveAll(mainOrders);
    }

    @Override
    public Optional<MainOrder> findById(Long id){
        return mainOrderRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id){
        return mainOrderRepository.existsById(id);
    }

    @Override
    public Iterable<MainOrder> findAll(){
        return mainOrderRepository.findAll();
    }

    @Override
    public Iterable<MainOrder> findAllById(Iterable<Long> ids){
        return mainOrderRepository.findAllById(ids);
    }

    @Override
    public long count(){
        return mainOrderRepository.count();
    }

    @Override
    public void deleteById(Long id){
        mainOrderRepository.deleteById(id);
    }

    @Override
    public void delete(MainOrder mainOrder){
        mainOrderRepository.delete(mainOrder);
    }

    @Override
    public void deleteAll(Iterable<? extends MainOrder> mainOrders){
        mainOrderRepository.deleteAll(mainOrders);
    }

    @Override
    public void deleteAll(){
        mainOrderRepository.deleteAll();
    }

}

