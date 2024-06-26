package com.Cccccc.airbnb.domain.room.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

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
