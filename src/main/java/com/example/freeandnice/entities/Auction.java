package com.example.freeandnice.entities;


import com.example.freeandnice.enums.AuctionStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "auctions")
public class Auction {
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    @Column(name = "start_at")
    private OffsetDateTime startAt;
    @Column(name = "finish_at")
    private OffsetDateTime finishAt;
    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL)
    private List<Bid> bidList;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AuctionStatus status;

    public Auction() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OffsetDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(OffsetDateTime startAt) {
        this.startAt = startAt;
    }

    public OffsetDateTime getFinishAt() {
        return finishAt;
    }

    public void setFinishAt(OffsetDateTime finishAt) {
        this.finishAt = finishAt;
    }

    public List<Bid> getBidList() {
        return bidList;
    }

    public void setBidList(List<Bid> bidList) {
        this.bidList = bidList;
    }

    public AuctionStatus getStatus() {
        return status;
    }

    public void setStatus(AuctionStatus status) {
        this.status = status;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
