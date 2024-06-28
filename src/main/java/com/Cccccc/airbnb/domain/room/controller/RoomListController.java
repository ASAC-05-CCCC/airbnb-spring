package com.Cccccc.airbnb.domain.room.controller;

import com.Cccccc.airbnb.domain.room.dto.request.RoomFilterRequestDto;
import com.Cccccc.airbnb.domain.room.dto.response.RoomListResponseDto;
import com.Cccccc.airbnb.domain.room.service.RoomListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/c2/room")
@RequiredArgsConstructor
public class RoomListController {
    private final RoomListService roomListService;

    @GetMapping
    public Page<RoomListResponseDto> getFilteredRooms(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "20") int size,
                                                      @ModelAttribute RoomFilterRequestDto roomFilterRequestDto) {
        Pageable pageable = PageRequest.of(page, size);
        return roomListService.getFilteredRooms(pageable, roomFilterRequestDto);
    }
}
