package com.example.freeandnice.repository;

import com.example.freeandnice.entities.Item;
import com.example.freeandnice.entities.Message;
import com.example.freeandnice.service.impl.ItemService;
import com.example.freeandnice.service.impl.MessageService;
import com.example.freeandnice.utils.DataUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class MessageRepoTest {
    @InjectMocks
    MessageService messageService;
    @Test
    public void testUpload() {
        Message message =  DataUtils.getMessage(); //
        messageService.createMessage(message);
        assertThat(messageService.getMessageById(DataUtils.getMessage().getId())).isNotNull();

    }

}