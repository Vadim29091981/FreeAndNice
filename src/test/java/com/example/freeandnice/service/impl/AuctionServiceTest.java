package com.example.freeandnice.service.impl;

import com.example.freeandnice.entities.Auction;
import com.example.freeandnice.repository.AuctionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class AuctionServiceTest {

    AuctionRepository auctionRepository = mock(AuctionRepository.class);

    AuctionService auctionService = new AuctionService(auctionRepository);

    @Test
    public void testAddition(){
        auctionService.createAuction(new Auction());
        given(auctionRepository.count()).willReturn(auctionRepository.count());
        Assertions.assertEquals(1, auctionRepository.count());
    }

}