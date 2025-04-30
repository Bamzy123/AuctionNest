package org.babi.Dtos.Request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BidRequest {
    @NotBlank
    private String auctionId;
    @DecimalMin("100000")
    private BigDecimal amount;
}