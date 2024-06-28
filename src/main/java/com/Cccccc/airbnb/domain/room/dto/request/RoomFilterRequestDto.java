package com.Cccccc.airbnb.domain.room.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class RoomFilterRequestDto {
    private String location;
    private Integer guest;
    private Integer minPrice;
    private Integer maxPrice;
    private Integer bedCount;
    private Integer bathroomCount;
    private Boolean isPreference;
    private List<Integer> facilitiesOption;
    private Integer bedroomCount;
}
