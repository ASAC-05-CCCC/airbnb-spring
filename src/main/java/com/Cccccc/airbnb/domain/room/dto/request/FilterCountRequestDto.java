package com.Cccccc.airbnb.domain.room.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class FilterCountRequestDto {
    private Integer minPrice;
    private Integer maxPrice;
    private Integer bedroomCount;
    private Integer bedCount;
    private Integer bathroomCount;
    private Boolean isPreference;
    private List<Integer> facilitiesOption;
//    private List<Integer> hostLanguage;
}
