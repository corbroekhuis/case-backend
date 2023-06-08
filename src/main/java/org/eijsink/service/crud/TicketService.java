package org.eijsink.service.crud;

import org.eijsink.model.Ticket;

import java.util.Optional;

public interface TicketService {

    public Ticket save(Ticket ticket);

    public Iterable<Ticket> saveAll(Iterable<Ticket> tickets);

    public Optional<Ticket> findById(Long id);

    public boolean existsById(Long id);

    public Iterable<Ticket> findAll();

    public Iterable<Ticket> findAllById(Iterable<Long> ids);

    public long count();

    public void deleteById(Long id);

    public void delete(Ticket ticket);

    public void deleteAll(Iterable<? extends Ticket> tickets);

    public void deleteAll();

}

