package com.example.freeandnice.repository;

import com.example.freeandnice.entities.Bid;
import com.example.freeandnice.entities.Item;
import com.example.freeandnice.service.impl.BidService;
import com.example.freeandnice.service.impl.ItemService;
import com.example.freeandnice.utils.DataUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class BidRepositoryTest {
        @Mock
        BidRepository bidRepository;


        @Test
        public void testUpload() {
            Bid bid =  DataUtils.getBid(); //
            bidRepository.save(bid);
            assertThat(bidRepository.findById(bid.getId())).isNotNull();
        }


}