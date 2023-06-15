package org.eijsink.controller;

import java.util.Collections;

import org.eijsink.service.crud.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import org.eijsink.model.Item;

@RestController
@RequestMapping("/api")
public class ItemController {

    protected static final Logger logger = LogManager.getLogger();

    ItemService itemService;
    
    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;

    }

    @PutMapping(value = "/item", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Item> saveItem( @RequestBody final Item item) {

        logger.info("Inside 'saveItemById'");

        itemService.save(item);
        return ResponseEntity.ok(item) ;

    }

    @GetMapping(value = "/item/{id}", produces = "application/json")
    public ResponseEntity<Item> getItemById( @PathVariable final Long id) {

        logger.info("Inside 'getItemById'");

        try {
            Item item = itemService.findById(id).orElse(null);
            return ResponseEntity.ok( item);
        } catch (Exception e) {
            return ResponseEntity.ok( null);
        }

    }

    @GetMapping(value = "/item", produces = "application/json")
    public ResponseEntity<Iterable<Item>> getAllItems() {

        logger.info("Inside 'getAllItems'");

        try {
            Iterable<Item> items = itemService.findAll();
            return ResponseEntity.ok( items);
        } catch (Exception e) {
            return ResponseEntity.ok( Collections.emptyList());
        }

    }
    // http://localhost/api/item/filter
    @GetMapping(value = "/item/filter", produces = "application/json")
    public ResponseEntity<Iterable<Item>> filterItemsByChars(
            @RequestParam("chars") String chars) {

        logger.info("Inside 'filterItemsByChars'");

        try {
            Iterable<Item> items = itemService.filterByNameContaining( chars);
            return ResponseEntity.ok( items);
        } catch (Exception e) {
            return ResponseEntity.ok( Collections.emptyList());
        }

    }

    @DeleteMapping(value = "/item/{id}", produces = "text/plain")
    public ResponseEntity<String> deleteItemById( @PathVariable final Long id) {

        logger.info("Inside 'deleteItemById'");

        try {
            itemService.deleteById(id);
            return ResponseEntity.ok( "Item with id: " + id + " is deleted");
        } catch (Exception e) {
            return ResponseEntity.ok( "Item with id: " + id + " may NOT be deleted");
        }

    }

}

