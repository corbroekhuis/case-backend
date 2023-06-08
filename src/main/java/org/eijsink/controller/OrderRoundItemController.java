package org.eijsink.controller;

import java.util.Collections;

import org.eijsink.service.crud.OrderRoundItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import org.eijsink.model.OrderRoundItem;

@RestController
@RequestMapping("/api")
public class OrderRoundItemController {

    protected static final Logger logger = LogManager.getLogger();

    OrderRoundItemService orderRoundItemService;
    
    @Autowired
    public OrderRoundItemController(OrderRoundItemService orderRoundItemService){
        this.orderRoundItemService = orderRoundItemService;

    }

    @PutMapping(value = "/orderrounditem", consumes = "application/json", produces = "application/json")
    public ResponseEntity<OrderRoundItem> saveOrderRoundItem( @RequestBody final OrderRoundItem orderRoundItem) {

        logger.info("Inside 'saveOrderRoundItemById'");

        orderRoundItemService.save(orderRoundItem);
        return ResponseEntity.ok(orderRoundItem) ;

    }

    @GetMapping(value = "/orderrounditem/{id}", produces = "application/json")
    public ResponseEntity<OrderRoundItem> getOrderRoundItemById( @PathVariable final Long id) {

        logger.info("Inside 'getOrderRoundItemById'");

        try {
            OrderRoundItem orderRoundItem = orderRoundItemService.findById(id).orElse(null);
            return ResponseEntity.ok( orderRoundItem);
        } catch (Exception e) {
            return ResponseEntity.ok( null);
        }

    }

    @GetMapping(value = "/orderrounditem", produces = "application/json")
    public ResponseEntity<Iterable<OrderRoundItem>> getAllOrderRoundItems() {

        logger.info("Inside 'getAllOrderRoundItems'");

        try {
            Iterable<OrderRoundItem> orderRoundItems = orderRoundItemService.findAll();
            return ResponseEntity.ok( orderRoundItems);
        } catch (Exception e) {
            return ResponseEntity.ok( Collections.emptyList());
        }

    }

    @DeleteMapping(value = "/orderrounditem/{id}", produces = "text/plain")
    public ResponseEntity<String> deleteOrderRoundItemById( @PathVariable final Long id) {

        logger.info("Inside 'deleteOrderRoundItemById'");

        try {
            orderRoundItemService.deleteById(id);
            return ResponseEntity.ok( "Item with id: " + id + " is deleted");
        } catch (Exception e) {
            return ResponseEntity.ok( "Item with id: " + id + " may NOT be deleted");
        }

    }

}

