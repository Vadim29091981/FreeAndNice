package com.example.freeandnice.repository;


import com.example.freeandnice.entities.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, UUID> {
}
