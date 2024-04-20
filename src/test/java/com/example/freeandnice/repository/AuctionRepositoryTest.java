package com.example.freeandnice.repository;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AuctionRepositoryTest {

    @Autowired
    private AuctionRepository auctionRepository;

    @BeforeEach
    public void setup() {
        auctionRepository.deleteAll();
    }
}


