package org.eijsink.service.crud;

import org.eijsink.repository.TicketRepository;
import org.eijsink.model.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{

    TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository){
      this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket save(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    @Override
    public Iterable<Ticket> saveAll(Iterable<Ticket> tickets){
        return ticketRepository.saveAll(tickets);
    }

    @Override
    public Optional<Ticket> findById(Long id){
        return ticketRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id){
        return ticketRepository.existsById(id);
    }

    @Override
    public Iterable<Ticket> findAll(){
        return ticketRepository.findAll();
    }

    @Override
    public Iterable<Ticket> findAllById(Iterable<Long> ids){
        return ticketRepository.findAllById(ids);
    }

    @Override
    public long count(){
        return ticketRepository.count();
    }

    @Override
    public void deleteById(Long id){
        ticketRepository.deleteById(id);
    }

    @Override
    public void delete(Ticket ticket){
        ticketRepository.delete(ticket);
    }

    @Override
    public void deleteAll(Iterable<? extends Ticket> tickets){
        ticketRepository.deleteAll(tickets);
    }

    @Override
    public void deleteAll(){
        ticketRepository.deleteAll();
    }

}

