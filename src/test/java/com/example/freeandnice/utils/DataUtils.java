package com.example.freeandnice.utils;

import com.example.freeandnice.entities.*;

import java.util.UUID;

public class DataUtils {

    public static FileData getFileDataTransient() {
        return FileData.builder()
                .name("Vadim")
                .type("photo")
                .filePath("c:/photo")
                .user(new User())
                .build();
    }

    public static FileData getFileDataPersisted() {

        return FileData.builder()
                .id(1l)
                .name("Vadim")
                .type("photo")
                .filePath("c:/photo")
                .user(new User())
                .build();
    }

    public static User getUser() {
        return User.builder()
                .id(1l)
                .firstname("Vadim")
                .lastname("Yevstiunin")
                .email("vadimyevstiunin@gmail.com")
                .password("Vadim")
                .phoneNumber("+491628369238")
                .build();
    }

    public static Item getItem() {
        Item item = new Item();
        item.setId(new UUID(12, 15));
        return item;

    }

    public static Bid getBid() {
        Bid bid = new Bid();
        bid.setId(new UUID(12, 15));
        return bid;
    }

    public static Message getMessage() {
        Message message = new Message();
        message.setId((1));
        return message;
    }
    public static Rating getRating() {
        Rating rating = new Rating();
        rating.setId(new UUID(12, 15));
        return rating;
    }
}
