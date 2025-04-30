package org.babi.Services;

import org.babi.Dtos.Request.BidRequest;
import org.babi.Dtos.Response.BidResponse;
import org.babi.Exceptions.AuctionNotFoundException;
import org.babi.Models.Auction;
import org.babi.Repositories.AuctionRepository;
import org.babi.Validations.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidService {
    private final AuctionRepository auctionRepository;

    public BidService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public BidResponse placeBid(BidRequest req) {
        Auction auction = auctionRepository.findById(req.getAuctionId())
                .orElseThrow(() -> new AuctionNotFoundException("Auction not found"));
        ValidationUtil.validateBid(auction, req.getAmount());
        auction.setHighestBid(req.getAmount());
        auction.setHighestBidderId(req.getBidderId());
        auctionRepository.save(auction);
        return new BidResponse(true, "Bid placed successfully");
    }
}