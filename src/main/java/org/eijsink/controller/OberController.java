package org.eijsink.controller;

import java.util.Collections;

import org.eijsink.service.OberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import org.eijsink.model.Ober;

@RestController
@RequestMapping("/api")
public class OberController {

    protected static final Logger logger = LogManager.getLogger();

    OberService oberService;
    
    @Autowired
    public OberController(OberService oberService){
        this.oberService = oberService;

    }

    @PutMapping(value = "/ober", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Ober> saveOber( @RequestBody final Ober ober) {

        logger.info("Inside 'saveOberById'");

        oberService.save(ober);
        return ResponseEntity.ok(ober) ;

    }

    @GetMapping(value = "/ober/{id}", produces = "application/json")
    public ResponseEntity<Ober> getOberById( @PathVariable final Long id) {

        logger.info("Inside 'getOberById'");

        try {
            Ober ober = oberService.findById(id).orElse(null);
            return ResponseEntity.ok( ober);
        } catch (Exception e) {
            return ResponseEntity.ok( null);
        }

    }

    @GetMapping(value = "/ober", produces = "application/json")
    public ResponseEntity<Iterable<Ober>> getAllObers() {

        logger.info("Inside 'getAllObers'");

        try {
            Iterable<Ober> obers = oberService.findAll();
            return ResponseEntity.ok( obers);
        } catch (Exception e) {
            return ResponseEntity.ok( Collections.emptyList());
        }

    }

    @DeleteMapping(value = "/ober/{ober}", produces = "text/plain")
    public ResponseEntity<String> deleteOberById( @PathVariable final Long id) {

        logger.info("Inside 'deleteOberById'");

        try {
            oberService.deleteById(id);
            return ResponseEntity.ok( "Item with id: " + id + " is deleted");
        } catch (Exception e) {
            return ResponseEntity.ok( "Item with id: " + id + " may NOT be deleted");
        }

    }

}

