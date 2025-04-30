package org.babi.Models;

import lombok.Getter;
import lombok.Setter;
import org.babi.Enums.AuctionStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Document(collection = "auctions")
public class Auction {
    @Id
    private String id;
    private String title;
    private String description;
    private BigDecimal initialPrice = new BigDecimal("100000");
    private BigDecimal highestBid = initialPrice;
    private String highestBidderId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<String> imagePaths;
    private String sellerId;
    private AuctionStatus status;
}