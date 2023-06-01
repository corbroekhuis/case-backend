package org.eijsink.controller;

import java.util.Collections;

import org.eijsink.service.MainOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import org.eijsink.model.MainOrder;

@RestController
@RequestMapping("/api")
public class MainOrderController {

    protected static final Logger logger = LogManager.getLogger();

    MainOrderService mainOrderService;
    
    @Autowired
    public MainOrderController(MainOrderService mainOrderService){
        this.mainOrderService = mainOrderService;

    }

    @PutMapping(value = "/mainorder", consumes = "application/json", produces = "application/json")
    public ResponseEntity<MainOrder> saveMainOrder( @RequestBody final MainOrder mainOrder) {

        logger.info("Inside 'saveMainOrderById'");

        mainOrderService.save(mainOrder);
        return ResponseEntity.ok(mainOrder) ;

    }

    @GetMapping(value = "/mainorder/{id}", produces = "application/json")
    public ResponseEntity<MainOrder> getMainOrderById( @PathVariable final Long id) {

        logger.info("Inside 'getMainOrderById'");

        try {
            MainOrder mainOrder = mainOrderService.findById(id).orElse(null);
            return ResponseEntity.ok( mainOrder);
        } catch (Exception e) {
            return ResponseEntity.ok( null);
        }

    }

    @GetMapping(value = "/mainorder", produces = "application/json")
    public ResponseEntity<Iterable<MainOrder>> getAllMainOrders() {

        logger.info("Inside 'getAllMainOrders'");

        try {
            Iterable<MainOrder> mainOrders = mainOrderService.findAll();
            return ResponseEntity.ok( mainOrders);
        } catch (Exception e) {
            return ResponseEntity.ok( Collections.emptyList());
        }

    }

    @DeleteMapping(value = "/mainorder/{mainorder}", produces = "text/plain")
    public ResponseEntity<String> deleteMainOrderById( @PathVariable final Long id) {

        logger.info("Inside 'deleteMainOrderById'");

        try {
            mainOrderService.deleteById(id);
            return ResponseEntity.ok( "Item with id: " + id + " is deleted");
        } catch (Exception e) {
            return ResponseEntity.ok( "Item with id: " + id + " may NOT be deleted");
        }

    }

}

