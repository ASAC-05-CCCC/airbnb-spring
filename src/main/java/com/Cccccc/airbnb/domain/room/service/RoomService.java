package com.Cccccc.airbnb.domain.room.service;


import com.Cccccc.airbnb.domain.room.exception.RoomNotFoundException;
import com.Cccccc.airbnb.domain.room.dto.HostResponseDto;
import com.Cccccc.airbnb.domain.entity.Room;
import com.Cccccc.airbnb.domain.room.repository.RoomRepository;
import com.Cccccc.airbnb.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository  RoomRepository ;

    public HostResponseDto getUserByRoomId(Integer roomId) {
        Room room = RoomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException("Room with id " + roomId + " not found"));

        User user = room.getUser();
        return new HostResponseDto(user.getId(), user.getName(), user.getImage());
    }
}
