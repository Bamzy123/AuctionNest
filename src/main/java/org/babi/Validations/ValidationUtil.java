package org.babi.Validations;

import org.babi.Exceptions.InvalidOperationException;
import org.babi.Models.Auction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ValidationUtil {

    public static void validateAuctionTimes(LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime.isBefore(LocalDateTime.now()) || endTime.isBefore(startTime))
            throw new InvalidOperationException("Invalid auction time range");
    }

    public static void validateBid(Auction auction, BigDecimal bidAmount) {
        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(auction.getStartTime()) || now.isAfter(auction.getEndTime()))
            throw new InvalidOperationException("Bidding is not open for this auction");
        BigDecimal minimum = auction.getHighestBid() != null ? auction.getHighestBid() : auction.getInitialPrice();
        if (bidAmount.compareTo(minimum) <= 0)
            throw new InvalidOperationException("Bid must be higher than current highest bid");
    }
}