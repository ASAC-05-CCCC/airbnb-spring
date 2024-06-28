package com.Cccccc.airbnb.domain.room.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class RoomListResponseDto {
    private Integer accommodationId;
    private String accommodationName;
    private String countryLocationName;
    private Float rating;
    private String distance;
    private String startDate;
    private String endDate;
    private Integer pricePerDay;
    private List<String> imageUrl;
    private boolean guestFavorite;
}
