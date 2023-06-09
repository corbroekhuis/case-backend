package org.eijsink.controller;

import java.util.Collections;

import org.eijsink.exception.EijsinkException;
import org.eijsink.service.crud.TicketService;
import org.eijsink.service.internal.nl.TicketProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import org.eijsink.model.Ticket;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class TicketController {

    protected static final Logger logger = LogManager.getLogger();

    TicketService ticketService;
    TicketProcessService ticketProcessService;
    
    @Autowired
    public TicketController(TicketService ticketService, TicketProcessService ticketProcessService){
        this.ticketService = ticketService;
        this.ticketProcessService = ticketProcessService;

    }

    @PostMapping(value = "/ticket/process", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Ticket> processTicket( @RequestBody final Ticket ticket)  {

        logger.info("Inside 'processTicket'");
        long ticketId = ticket.getId();
        try {
            ticketProcessService.procesTicket(ticket);
        } catch (EijsinkException e) {
            throw new ResponseStatusException(
                    HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage(), e);
        }
        Ticket closedTicket = ticketService.findById( ticketId).get();
        return ResponseEntity.ok(ticket) ;

    }

    @PutMapping(value = "/ticket", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Ticket> saveTicket( @RequestBody final Ticket ticket) {

        logger.info("Inside 'saveTicketById'");

        ticketService.save(ticket);
        return ResponseEntity.ok(ticket) ;

    }

    @GetMapping(value = "/ticket/{id}", produces = "application/json")
    public ResponseEntity<Ticket> getTicketById( @PathVariable final Long id) {

        logger.info("Inside 'getTicketById'");

        try {
            Ticket ticket = ticketService.findById(id).orElse(null);
            return ResponseEntity.ok( ticket);
        } catch (Exception e) {
            return ResponseEntity.ok( null);
        }

    }

    @GetMapping(value = "/ticket", produces = "application/json")
    public ResponseEntity<Iterable<Ticket>> getAllTickets() {

        logger.info("Inside 'getAllTickets'");

        try {
            Iterable<Ticket> tickets = ticketService.findAll();
            return ResponseEntity.ok( tickets);
        } catch (Exception e) {
            return ResponseEntity.ok( Collections.emptyList());
        }

    }

    @DeleteMapping(value = "/ticket/{id}", produces = "text/plain")
    public ResponseEntity<String> deleteTicketById( @PathVariable final Long id) {

        logger.info("Inside 'deleteTicketById'");

        try {
            ticketService.deleteById(id);
            return ResponseEntity.ok( "Item with id: " + id + " is deleted");
        } catch (Exception e) {
            return ResponseEntity.ok( "Item with id: " + id + " may NOT be deleted");
        }

    }

}

