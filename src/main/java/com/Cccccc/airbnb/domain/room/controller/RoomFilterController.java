package com.Cccccc.airbnb.domain.room.controller;

import com.Cccccc.airbnb.domain.room.dto.request.FilterCountRequestDto;
import com.Cccccc.airbnb.domain.room.dto.response.RoomFacilityResponseDto;
import com.Cccccc.airbnb.domain.room.service.RoomFilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/c2/room")
public class RoomFilterController {
    private final RoomFilterService roomFilterService;

    @GetMapping("/count")
    public Integer getRoomCount(@ModelAttribute FilterCountRequestDto filterCountRequestDto ) {
        Integer roomCountResult = roomFilterService.getRoomCount(filterCountRequestDto);
        return roomCountResult;
    }

    @GetMapping("/{id}/facility")
    public List<RoomFacilityResponseDto> getRoomFacility(@PathVariable Integer id) {
        List<RoomFacilityResponseDto> roomFacilityResult = roomFilterService.getRoomFacility(id);
        return roomFacilityResult;
    }

}
