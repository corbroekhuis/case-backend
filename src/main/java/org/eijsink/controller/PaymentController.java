package org.eijsink.controller;

import java.util.Collections;

import org.eijsink.exception.EijsinkException;
import org.eijsink.service.crud.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import org.eijsink.model.Payment;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class PaymentController {

    protected static final Logger logger = LogManager.getLogger();

    PaymentService paymentService;
    
    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;

    }

    @PutMapping(value = "/payment", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Payment> savePayment( @RequestBody final Payment payment,
                        @RequestParam("cardNumber") String cardNumber ) {

        logger.info("Inside 'savePayment'");

        try {
            paymentService.save(payment, cardNumber);
        } catch (EijsinkException e) {
            throw new ResponseStatusException(
                    HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage(), e);
        }
        return ResponseEntity.ok(payment) ;

    }

    @GetMapping(value = "/payment/{id}", produces = "application/json")
    public ResponseEntity<Payment> getPaymentById( @PathVariable final Long id) {

        logger.info("Inside 'getPaymentById'");

        try {
            Payment payment = paymentService.findById(id).orElse(null);
            return ResponseEntity.ok( payment);
        } catch (Exception e) {
            return ResponseEntity.ok( null);
        }

    }

    @GetMapping(value = "/payment", produces = "application/json")
    public ResponseEntity<Iterable<Payment>> getAllPayments() {

        logger.info("Inside 'getAllPayments'");

        try {
            Iterable<Payment> payments = paymentService.findAll();
            return ResponseEntity.ok( payments);
        } catch (Exception e) {
            return ResponseEntity.ok( Collections.emptyList());
        }

    }

    @DeleteMapping(value = "/payment/{id}", produces = "text/plain")
    public ResponseEntity<String> deletePaymentById( @PathVariable final Long id) {

        logger.info("Inside 'deletePaymentById'");

        try {
            paymentService.deleteById(id);
            return ResponseEntity.ok( "Item with id: " + id + " is deleted");
        } catch (Exception e) {
            return ResponseEntity.ok( "Item with id: " + id + " may NOT be deleted");
        }

    }

}

