package org.eijsink.controller;

import java.util.Collections;

import org.eijsink.service.OrderRoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import org.eijsink.model.OrderRound;

@RestController
@RequestMapping("/api")
public class OrderRoundController {

    protected static final Logger logger = LogManager.getLogger();

    OrderRoundService orderRoundService;
    
    @Autowired
    public OrderRoundController(OrderRoundService orderRoundService){
        this.orderRoundService = orderRoundService;

    }

    @PutMapping(value = "/orderround", consumes = "application/json", produces = "application/json")
    public ResponseEntity<OrderRound> saveOrderRound( @RequestBody final OrderRound orderRound) {

        logger.info("Inside 'saveOrderRoundById'");

        orderRoundService.save(orderRound);
        return ResponseEntity.ok(orderRound) ;

    }

    @GetMapping(value = "/orderround/{id}", produces = "application/json")
    public ResponseEntity<OrderRound> getOrderRoundById( @PathVariable final Long id) {

        logger.info("Inside 'getOrderRoundById'");

        try {
            OrderRound orderRound = orderRoundService.findById(id).orElse(null);
            return ResponseEntity.ok( orderRound);
        } catch (Exception e) {
            return ResponseEntity.ok( null);
        }

    }

    @GetMapping(value = "/orderround", produces = "application/json")
    public ResponseEntity<Iterable<OrderRound>> getAllOrderRounds() {

        logger.info("Inside 'getAllOrderRounds'");

        try {
            Iterable<OrderRound> orderRounds = orderRoundService.findAll();
            return ResponseEntity.ok( orderRounds);
        } catch (Exception e) {
            return ResponseEntity.ok( Collections.emptyList());
        }

    }

    @DeleteMapping(value = "/orderround/{orderround}", produces = "text/plain")
    public ResponseEntity<String> deleteOrderRoundById( @PathVariable final Long id) {

        logger.info("Inside 'deleteOrderRoundById'");

        try {
            orderRoundService.deleteById(id);
            return ResponseEntity.ok( "Item with id: " + id + " is deleted");
        } catch (Exception e) {
            return ResponseEntity.ok( "Item with id: " + id + " may NOT be deleted");
        }

    }

}

