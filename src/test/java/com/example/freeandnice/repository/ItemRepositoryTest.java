package com.example.freeandnice.repository;

import com.example.freeandnice.entities.FileData;
import com.example.freeandnice.entities.Item;
import com.example.freeandnice.service.StorageService;
import com.example.freeandnice.service.impl.ItemService;
import com.example.freeandnice.utils.DataUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ItemRepositoryTest {
    @Mock
    ItemRepository itemRepository;
    @Test
    public void testUpload() {
        Item item =  DataUtils.getItem(); //
        itemRepository.save(item);
        assertThat(itemRepository.findById(item.getId())).isNotNull();

    }

}