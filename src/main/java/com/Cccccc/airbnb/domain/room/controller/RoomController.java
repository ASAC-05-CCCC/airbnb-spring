package com.Cccccc.airbnb.domain.room.controller;

import com.Cccccc.airbnb.domain.room.dto.response.*;
import com.Cccccc.airbnb.domain.room.dto.request.FilterCountRequestDto;
import com.Cccccc.airbnb.domain.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/c2/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/host/{id}")
    public HostResponseDto getHostByRoomId(@PathVariable Integer id) {
        return roomService.getHostByRoomId(id);
    }

    @GetMapping("/{id}")
    public RoomResponseDto getRoomByRoomId(@PathVariable Integer id){
        return roomService.getRoomByRoomId(id);
    }

    @GetMapping("/footer/{id}")
    public FooterResponseDto getFooterByRoomId(@PathVariable Integer id){
        return roomService.getFooterByRoomId(id);
    }

    @GetMapping("/filter/category")
    public List<CategoryResponseDto> getCategories() {
        return roomService.getAllCategories();
    }

    @GetMapping("/filter/count")
    public Integer getRoomCount(@ModelAttribute FilterCountRequestDto filterCountRequestDto ) {
        Integer roomCountResult = roomService.getRoomCount(filterCountRequestDto);
        return roomCountResult;
    }

    @GetMapping("/{id}/facility")
    public List<RoomFacilityResponseDto> getRoomFacility(@PathVariable Integer id) {
        List<RoomFacilityResponseDto> roomFacilityResult = roomService.getRoomFacility(id);
        return roomFacilityResult;
    }

    @GetMapping("/filter/facility")
    public List<FacilityResponseDto> getFacilityList(@RequestParam Integer mainType) {
        List<FacilityResponseDto> facilityList = roomService.getFacilityList(mainType);

        return facilityList;
    }
}
