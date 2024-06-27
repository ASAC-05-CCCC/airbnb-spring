package com.Cccccc.airbnb.domain.room.service;


import com.Cccccc.airbnb.domain.entity.Bedroom;
import com.Cccccc.airbnb.domain.entity.RoomRating;
import com.Cccccc.airbnb.domain.room.dto.FooterResponseDto;
import com.Cccccc.airbnb.domain.room.dto.RoomResponseDto;
import com.Cccccc.airbnb.domain.room.exception.RoomNotFoundException;
import com.Cccccc.airbnb.domain.room.dto.HostResponseDto;
import com.Cccccc.airbnb.domain.entity.Room;
import com.Cccccc.airbnb.domain.room.repository.BedroomRepository;
import com.Cccccc.airbnb.domain.room.repository.RoomRatingRepository;
import com.Cccccc.airbnb.domain.room.repository.RoomRepository;
import com.Cccccc.airbnb.domain.entity.User;
import com.Cccccc.airbnb.domain.room.utils.BriefRoomInfoUtil;
import com.Cccccc.airbnb.domain.room.utils.ImageUrlUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository  RoomRepository ;
    private final RoomRatingRepository RoomRatingRepository;
    private final BedroomRepository BedroomRepository;

    public HostResponseDto getHostByRoomId(Integer roomId) {
        Room room = RoomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException("Room with id " + roomId + " not found"));
        RoomRating roomRating =  RoomRatingRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException("Room with id " + roomId + " not found"));
        User user = room.getUser();

        return new HostResponseDto(
                user.getName(),
                user.getSuperhost(),
                roomRating.getReview_count(),
                roomRating.getRating(),
                user.getHostSince(),
                user.getImage());
    }

    public RoomResponseDto getRoomByRoomId(Integer roomId) {
        Room room = RoomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException("Room with id " + roomId + " not found"));
        Bedroom bedroom = BedroomRepository.findById(roomId)
                .orElseThrow(()-> new RoomNotFoundException("Room with id " + roomId + " not found"));
        RoomRating roomRating =  RoomRatingRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException("Room with id " + roomId + " not found"));

        User user = room.getUser();
        List<String> briefRoomInfo = BriefRoomInfoUtil.BriefRoomInfo(room,bedroom);
        List<String> imageUrl = ImageUrlUtil.getImageUrl(room);
        return new RoomResponseDto(
                room.getId(),
                room.getTitle(),
                room.getCountry() + room.getCity(),
                room.getSubTitle(),
                briefRoomInfo,
                room.getGuest_favorite(),
                roomRating.getRating(),
                roomRating.getReview_count(),
                user.getName(),
                user.getHostSince(),
                user.getImage(),
                room.getPrice(),
                imageUrl,
                room.getDescription()
        );
    }

    public FooterResponseDto getFooterByRoomId(Integer roomId) {
        Room room = RoomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException("Room with id " + roomId + " not found"));

        return new FooterResponseDto(
                room.getRegion_name_1(),
                room.getRegion_name_2(),
                room.getCity()
        );
    }
}
