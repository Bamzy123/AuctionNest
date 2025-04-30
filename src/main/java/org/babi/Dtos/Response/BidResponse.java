package org.babi.Dtos.Response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class BidResponse {
    private String id;
    private String auctionId;
    private String bidderId;
    private BigDecimal amount;
    private LocalDateTime timestamp;
}