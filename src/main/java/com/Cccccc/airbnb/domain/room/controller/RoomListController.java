package com.Cccccc.airbnb.domain.room.controller;

import com.Cccccc.airbnb.domain.room.dto.RoomFilterDto;
import com.Cccccc.airbnb.domain.room.dto.RoomListDto;
import com.Cccccc.airbnb.domain.room.service.RoomListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/c2/room")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class RoomListController {
    private final RoomListService roomListService;

    @GetMapping
    public Page<RoomListDto> getFilteredRooms(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "20") int size,
                                              @ModelAttribute RoomFilterDto roomFilterDto) {
        Pageable pageable = PageRequest.of(page, size);
        return roomListService.getFilteredRooms(pageable, roomFilterDto);
    }
}
