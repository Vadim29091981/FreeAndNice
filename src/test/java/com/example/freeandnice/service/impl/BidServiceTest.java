package com.example.freeandnice.service.impl;

import com.example.freeandnice.entities.Bid;
import com.example.freeandnice.repository.BidRepository;
import com.example.freeandnice.utils.DataUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class BidServiceTest {

    @Mock
    BidRepository bidRepository;
    @InjectMocks
    BidService bidService;

    @Test
    public void testUpload() {
        Bid bid =  DataUtils.getBid(); //
        bidService.createBid(bid);
        assertThat(bidService.getBidById((DataUtils.getBid().getId()))).isNotNull();

    }

}