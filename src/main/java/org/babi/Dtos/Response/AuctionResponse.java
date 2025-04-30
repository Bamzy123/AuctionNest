package org.babi.Dtos.Response;

import lombok.Getter;
import lombok.Setter;
import org.babi.Enums.AuctionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class AuctionResponse {
    private String id;
    private String title;
    private String description;
    private BigDecimal initialPrice;
    private BigDecimal highestBid;
    private String highestBidderId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<String> imagePaths;
    private AuctionStatus status;
}