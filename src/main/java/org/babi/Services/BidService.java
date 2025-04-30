package org.babi.Services;

import org.babi.Dtos.Request.BidRequest;
import org.babi.Dtos.Response.BidResponse;
import org.babi.Exceptions.AuctionNotFoundException;
import org.babi.Models.Auction;
import org.babi.Models.Bid;
import org.babi.Repositories.AuctionRepository;
import org.babi.Repositories.BidRepository;
import org.babi.Validations.ValidationUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BidService {
    private final AuctionRepository auctionRepository;
    private final BidRepository bidRepository;

    public BidService(AuctionRepository auctionRepository, BidRepository bidRepository) {
        this.auctionRepository = auctionRepository;
        this.bidRepository = bidRepository;
    }

    public BidResponse placeBid(BidRequest req) {
        Auction auction = auctionRepository.findById(req.getAuctionId()).orElseThrow(() -> new AuctionNotFoundException("Auction not found"));
        ValidationUtil.validateBid(auction, req.getAmount());

        Bid bid = new Bid();
        bid.setAuctionId(req.getAuctionId());
        bid.setBidderId(req.getBidderId());
        bid.setAmount(req.getAmount());
        bid.setTimestamp(LocalDateTime.now());
        Bid savedBid = bidRepository.save(bid);

        auction.setHighestBid(req.getAmount());
        auction.setHighestBidderId(req.getBidderId());
        auctionRepository.save(auction);

        return new BidResponse();
    }
}