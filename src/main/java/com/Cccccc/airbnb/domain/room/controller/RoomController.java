package com.Cccccc.airbnb.domain.room.controller;

import com.Cccccc.airbnb.domain.room.dto.HostResponseDto;
import com.Cccccc.airbnb.domain.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/c2/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/host/{id}")
    public HostResponseDto getHostByRoomId(@PathVariable Integer id) {
        return roomService.getHostByRoomId(id);
    }
}
