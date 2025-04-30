package org.babi.Repositories;

import org.babi.Enums.AuctionStatus;
import org.babi.Models.Auction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionRepository extends MongoRepository<Auction, String> {
    List<Auction> findBySellerId(String sellerId);
    List<Auction> findByStatus(AuctionStatus status);
}