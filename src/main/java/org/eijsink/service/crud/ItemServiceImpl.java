package org.eijsink.service.crud;

import org.eijsink.repository.ItemRepository;
import org.eijsink.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemServiceImpl implements ItemService{

    ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository){
      this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item){
        return itemRepository.save(item);
    }

    @Override
    public Iterable<Item> saveAll(Iterable<Item> items){
        return itemRepository.saveAll(items);
    }

    @Override
    public Optional<Item> findById(Long id){
        return itemRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id){
        return itemRepository.existsById(id);
    }

    @Override
    public Iterable<Item> findAll(){
        return itemRepository.findAll();
    }

    @Override
    public Iterable<Item> findAllById(Iterable<Long> ids){
        return itemRepository.findAllById(ids);
    }

    @Override
    public long count(){
        return itemRepository.count();
    }

    @Override
    public void deleteById(Long id){
        itemRepository.deleteById(id);
    }

    @Override
    public void delete(Item item){
        itemRepository.delete(item);
    }

    @Override
    public void deleteAll(Iterable<? extends Item> items){
        itemRepository.deleteAll(items);
    }

    @Override
    public void deleteAll(){
        itemRepository.deleteAll();
    }

    @Override
    public Iterable<Item> filterByNameContaining( String chars) {

        Iterable<Item> items = itemRepository.findAll();

        List<Item> filtered = StreamSupport.stream(
                        items.spliterator(), false)
                .filter( i -> i.getName().contains( chars))
                .collect(Collectors.toList());

        return items;
    }

}

