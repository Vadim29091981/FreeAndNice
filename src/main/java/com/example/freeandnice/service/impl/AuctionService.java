package com.example.freeandnice.service.impl;

import com.example.freeandnice.entities.Auction;
import com.example.freeandnice.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuctionService {
    private final AuctionRepository auctionRepository;

    @Autowired
    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public void createAuction(Auction auction) {
        if (auction == null) {
            throw new NullPointerException("Error!");
        }
        auctionRepository.save(auction);
    }

    public Optional<Auction> getAuctionById(UUID id) {
        return auctionRepository.findById(id);
    }

    public Auction updateAuction(UUID id, Auction updatedAuction) {
        return auctionRepository.save(updatedAuction);
    }

    public void deleteAuctionById(UUID id) {
        auctionRepository.deleteById(id);
    }
}
