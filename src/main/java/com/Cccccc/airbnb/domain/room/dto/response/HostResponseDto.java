package com.Cccccc.airbnb.domain.room.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class HostResponseDto {
    private String name;
    private boolean superhost;
    private Integer reviewCount;
    private float rating;
    private LocalDateTime hostSince;
    private String image;
}
