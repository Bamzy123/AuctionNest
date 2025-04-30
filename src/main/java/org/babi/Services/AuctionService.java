package org.babi.Services;

import org.babi.Dtos.Request.AuctionRequest;
import org.babi.Enums.AuctionStatus;
import org.babi.Exceptions.AuctionNotFoundException;
import org.babi.Models.Auction;
import org.babi.Repositories.AuctionRepository;
import org.babi.Validations.ValidationUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AuctionService {
    private final AuctionRepository auctionRepository;

    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public Auction createAuction(AuctionRequest req, String sellerId) {
        ValidationUtil.validateAuctionTimes(req.getStartTime(), req.getEndTime());
        Auction auction = new Auction();
        auction.setTitle(req.getTitle());
        auction.setDescription(req.getDescription());
        auction.setStartTime(req.getStartTime());
        auction.setEndTime(req.getEndTime());
        auction.setImagePaths(req.getImagePaths());
        auction.setSellerId(sellerId);
        auction.setInitialPrice(new BigDecimal("100000"));
        auction.setHighestBid(null);
        auction.setStatus(AuctionStatus.PENDING);
        return auctionRepository.save(auction);
    }

    public List<Auction> getActiveAuctions() {
        return auctionRepository.findByStatus(AuctionStatus.ACTIVE);
    }

    public Auction getAuctionById(String auctionId) {
        return auctionRepository.findById(auctionId).orElseThrow(() -> new AuctionNotFoundException("Auction not found"));
    }
}