package com.Cccccc.airbnb.domain.room.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class FacilityResponseDto {
    private Integer mainType;
    private String subType;
    private List<String> facilityName;
    private List<Integer> id;
}
