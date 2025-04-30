package org.babi.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "bids")
public class Bid {
    @Id
    private String id;
    private String auctionId;
    private String bidderId;
    private BigDecimal amount;
    private LocalDateTime timestamp;
}