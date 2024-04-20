package com.example.freeandnice.service.impl;


import com.example.freeandnice.entities.Item;
import com.example.freeandnice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void createItem(Item item) {
        if (item == null) {
            throw new NullPointerException("You aren't fill all fields");
        }
        itemRepository.save(item);
    }

    public Optional<Item> getItemById(UUID id) {
        return itemRepository.findById(id);
    }

    //todo find all item by some criteria (category, rating etc)

    public Item updateItem(UUID id, Item updatedItem) {
        return itemRepository.save(updatedItem);
    }

    public void deleteItemById(UUID id) {
        itemRepository.deleteById(id);
    }
}
