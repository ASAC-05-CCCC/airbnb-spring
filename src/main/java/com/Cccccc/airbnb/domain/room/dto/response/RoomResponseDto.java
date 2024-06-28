package com.Cccccc.airbnb.domain.room.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public class RoomResponseDto {
    private Integer accommodationId;
    private String accommodationName;
    private String countryLocationName;
    private String locationName;
    private List briefRoomInfo;
    private Boolean guestFavorite;
    private Float rating;
    private Integer reviewCount;
    private String hostName;
    private LocalDateTime hostSince;
    private String hostImage;
    private String pricePerDay;
    private List imageUrl;
    private String desc;

}
