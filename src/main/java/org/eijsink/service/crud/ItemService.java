package org.eijsink.service.crud;

import org.eijsink.model.Item;

import java.util.Optional;

public interface ItemService {

    public Item save(Item item);

    public Iterable<Item> saveAll(Iterable<Item> items);

    public Optional<Item> findById(Long id);

    public boolean existsById(Long id);

    public Iterable<Item> findAll();

    public Iterable<Item> findAllById(Iterable<Long> ids);

    public long count();

    public void deleteById(Long id);

    public void delete(Item item);

    public void deleteAll(Iterable<? extends Item> items);

    public void deleteAll();

    Iterable< Item> filterByNameContaining( String name);

}

