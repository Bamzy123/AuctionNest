package org.babi.Dtos.Request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BidRequest {
    @NotBlank
    private String auctionId;
    @NotBlank
    private String bidderId;
    @DecimalMin("100000")
    private BigDecimal amount;
}