package com.Cccccc.airbnb.domain.room.controller.host;

import com.Cccccc.airbnb.domain.room.controller.host.dto.HostResponseDto;
import com.Cccccc.airbnb.domain.room.service.host.HostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/c2/room/host")
@RequiredArgsConstructor
public class HostController {

    private final HostService hostService;

    @GetMapping("/{id}")
    public HostResponseDto getUserByRoomId(@PathVariable Integer id) {
        return hostService.getUserByRoomId(id);
    }
}
