package org.eijsink.service;

import org.eijsink.repository.OberRepository;
import org.eijsink.model.Ober;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OberServiceImpl implements OberService{

    OberRepository oberRepository;

    @Autowired
    public OberServiceImpl(OberRepository oberRepository){
      this.oberRepository = oberRepository;
    }

    @Override
    public Ober save(Ober ober){
        return oberRepository.save(ober);
    }

    @Override
    public Iterable<Ober> saveAll(Iterable<Ober> obers){
        return oberRepository.saveAll(obers);
    }

    @Override
    public Optional<Ober> findById(Long id){
        return oberRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id){
        return oberRepository.existsById(id);
    }

    @Override
    public Iterable<Ober> findAll(){
        return oberRepository.findAll();
    }

    @Override
    public Iterable<Ober> findAllById(Iterable<Long> ids){
        return oberRepository.findAllById(ids);
    }

    @Override
    public long count(){
        return oberRepository.count();
    }

    @Override
    public void deleteById(Long id){
        oberRepository.deleteById(id);
    }

    @Override
    public void delete(Ober ober){
        oberRepository.delete(ober);
    }

    @Override
    public void deleteAll(Iterable<? extends Ober> obers){
        oberRepository.deleteAll(obers);
    }

    @Override
    public void deleteAll(){
        oberRepository.deleteAll();
    }

}

