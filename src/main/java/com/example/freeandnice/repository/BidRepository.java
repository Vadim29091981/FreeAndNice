package com.example.freeandnice.repository;


import com.example.freeandnice.entities.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BidRepository extends JpaRepository<Bid, UUID> {


}
