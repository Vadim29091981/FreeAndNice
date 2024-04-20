package com.example.freeandnice.service.impl;


import com.example.freeandnice.entities.Bid;
import com.example.freeandnice.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BidService {
    private final BidRepository bidRepository;

    @Autowired
    public BidService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    public void createBid(Bid bid) {
        bidRepository.save(bid);
    }

    public Optional<Bid> getBidById(UUID id) {
        return bidRepository.findById(id);
    }

    public Bid updateBid(UUID id, Bid updatedBid) {
        return bidRepository.save(updatedBid);
    }

    public void deleteBidById(UUID id) {
        bidRepository.deleteById(id);
    }
}
