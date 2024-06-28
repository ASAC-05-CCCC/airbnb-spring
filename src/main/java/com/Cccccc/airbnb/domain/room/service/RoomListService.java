package com.Cccccc.airbnb.domain.room.service;

import com.Cccccc.airbnb.domain.entity.Room;
import com.Cccccc.airbnb.domain.room.dto.request.RoomFilterRequestDto;
import com.Cccccc.airbnb.domain.room.dto.response.RoomListResponseDto;
import com.Cccccc.airbnb.domain.room.repository.RoomListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class RoomListService {

    private final RoomListRepository roomListRepository;

    // 마포T타운 위치
    private static final double FIXED_LATITUDE = 37.554380;
    private static final double FIXED_LONGITUDE = 126.909260;

    public Page<RoomListResponseDto> getFilteredRooms(Pageable pageable, RoomFilterRequestDto roomFilterRequestDto) {
//        Page<Room> rooms = roomListRepository.findFilteredRooms(pageable, roomFilterDto);
        Page<Room> rooms = roomListRepository.findFilteredRooms(pageable,
                roomFilterRequestDto.getLocation(),
                roomFilterRequestDto.getGuest(),
                roomFilterRequestDto.getMinPrice(),
                roomFilterRequestDto.getMaxPrice(),
                roomFilterRequestDto.getBedCount(),
                roomFilterRequestDto.getBathroomCount(),
                roomFilterRequestDto.getIsPreference(),
                roomFilterRequestDto.getFacilitiesOption(),
                roomFilterRequestDto.getBedroomCount());
        return rooms.map(this::convertToDto);
    }
    private RoomListResponseDto convertToDto(Room room) {
        RoomListResponseDto dto = new RoomListResponseDto();
        dto.setAccommodationId(room.getId());
        dto.setAccommodationName(room.getTitle());
        dto.setCountryLocationName(room.getCountry() + " " + room.getCity());
        dto.setRating(room.getRoomRating().getRating());
        dto.setDistance(String.format("%.1f km", calculateDistance(room.getLatitude(), room.getLongitude())));

        // 현재 날짜 기준으로 3일 더해서
        LocalDate currentDate = LocalDate.now();
        dto.setStartDate(currentDate.toString());
        dto.setEndDate(currentDate.plusDays(3).toString());

        dto.setPricePerDay(Integer.parseInt(room.getPrice()));
        dto.setImageUrl(Arrays.asList(room.getImage_url_1(), room.getImage_url_2(), room.getImage_url_3(), room.getImage_url_4(), room.getImage_url_5()));
        dto.setGuestFavorite(room.getGuest_favorite());

        return dto;
    }

    private double calculateDistance(double roomLatitude, double roomLongitude) {
        final int R = 6371; // 지구 반지름 (km)
        double latDistance = Math.toRadians(roomLatitude - RoomListService.FIXED_LATITUDE);
        double lonDistance = Math.toRadians(roomLongitude - RoomListService.FIXED_LONGITUDE);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(RoomListService.FIXED_LATITUDE)) * Math.cos(Math.toRadians(roomLatitude))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // km로 변환
    }
}
