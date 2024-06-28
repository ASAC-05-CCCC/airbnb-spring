package com.Cccccc.airbnb.domain.room.service;

import com.Cccccc.airbnb.domain.room.dto.request.FilterCountRequestDto;
import com.Cccccc.airbnb.domain.room.dto.response.RoomFacilityResponseDto;
import com.Cccccc.airbnb.domain.room.repository.RoomFacilityRepository;
import com.Cccccc.airbnb.domain.room.repository.RoomFilterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomFilterService {
    private final RoomFacilityRepository roomFacilityRepository;
    private final RoomFilterRepository roomFilterRepository;

    public Integer getRoomCount(FilterCountRequestDto filterCountRequestDto) {
        Integer result = roomFilterRepository.getRoomCount(filterCountRequestDto.getMinPrice(),
                filterCountRequestDto.getMaxPrice(),
                filterCountRequestDto.getBedroomCount(),
                filterCountRequestDto.getBedCount(),
                filterCountRequestDto.getBathroomCount(),
                filterCountRequestDto.getIsPreference(),
                filterCountRequestDto.getFacilitiesOption());

        return result;
    }

    public List<RoomFacilityResponseDto> getRoomFacility(Integer id) {
        List<RoomFacilityResponseDto> result = roomFacilityRepository.getRoomFacility(id);
        return result;
    }
}
