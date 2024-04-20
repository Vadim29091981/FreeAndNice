package com.example.freeandnice.service.impl;

import com.example.freeandnice.entities.Message;
import com.example.freeandnice.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageRepo messageRepository;

    @Autowired
    public MessageService(MessageRepo messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void createMessage(Message message) {
    }

    public boolean getMessageById(Integer id) {
        return false;
    }
}
