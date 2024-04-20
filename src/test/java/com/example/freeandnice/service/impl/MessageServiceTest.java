package com.example.freeandnice.service.impl;

import com.example.freeandnice.entities.Bid;
import com.example.freeandnice.entities.Message;
import com.example.freeandnice.repository.BidRepository;
import com.example.freeandnice.repository.MessageRepo;
import com.example.freeandnice.utils.DataUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class MessageServiceTest {
    @Mock
    MessageRepo messageRepo;
    @InjectMocks
    MessageService messageService;

    @Test
    public void testUpload() {
        Message message =  DataUtils.getMessage(); //
        messageRepo.save(message);
        assertThat(messageService.getMessageById(DataUtils.getMessage().getId())).isNotNull();

    }
}

