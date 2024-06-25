package com.Cccccc.airbnb.domain.room.service.host;


import com.Cccccc.airbnb.domain.room.controller.common.RoomNotFoundException;
import com.Cccccc.airbnb.domain.room.controller.host.dto.HostResponseDto;
import com.Cccccc.airbnb.domain.room.entity.Room;
import com.Cccccc.airbnb.domain.room.repository.RoomRepository;
import com.Cccccc.airbnb.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HostService {
    private final RoomRepository  RoomRepository ;

    public HostResponseDto getUserByRoomId(Integer roomId) {
        Room room = RoomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException("Room with id " + roomId + " not found"));

        User user = room.getUser();
        return new HostResponseDto(user.getId(), user.getName(), user.getImage());
    }
}
