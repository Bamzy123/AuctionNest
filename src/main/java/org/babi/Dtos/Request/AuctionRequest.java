package org.babi.Dtos.Request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class AuctionRequest {
    @NotBlank
    private String title;
    private String description;
    @Future
    private LocalDateTime startTime;
    @Future
    private LocalDateTime endTime;
    private List<@NotBlank String> imagePaths;
}