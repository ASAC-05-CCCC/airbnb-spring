package com.Cccccc.airbnb.domain.room.service;


import com.Cccccc.airbnb.domain.entity.*;
import com.Cccccc.airbnb.domain.room.dto.response.*;
import com.Cccccc.airbnb.domain.room.dto.request.FilterCountRequestDto;
import com.Cccccc.airbnb.domain.room.exception.RoomNotFoundException;
import com.Cccccc.airbnb.domain.room.repository.*;
import com.Cccccc.airbnb.domain.room.utils.BriefRoomInfoUtil;
import com.Cccccc.airbnb.domain.room.utils.ImageUrlUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository ;
    private final RoomRatingRepository RoomRatingRepository;
    private final BedroomRepository BedroomRepository;
    private final CategoryRepository categoryRepository;
    private final FacilityRepository facilityRepository;

    public HostResponseDto getHostByRoomId(Integer roomId) {
        Room room = roomRepository.findById(roomId)
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
        Room room = roomRepository.findById(roomId)
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
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException("Room with id " + roomId + " not found"));

        return new FooterResponseDto(
                room.getRegion_name_1(),
                room.getRegion_name_2(),
                room.getCity()
        );
    }

    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryResponseDto(category.getCategory_name(), category.getImage()))
                .collect(Collectors.toList());
    }

    public Integer getRoomCount(FilterCountRequestDto filterCountRequestDto) {
        Integer result = roomRepository.getRoomCount(filterCountRequestDto.getMinPrice(),
                filterCountRequestDto.getMaxPrice(),
                filterCountRequestDto.getBedroomCount(),
                filterCountRequestDto.getBedCount(),
                filterCountRequestDto.getBathroomCount(),
                filterCountRequestDto.getIsPreference(),
                filterCountRequestDto.getFacilitiesOption());

        return result;
    }

    public List<RoomFacilityResponseDto> getRoomFacility(Integer id) {
        List<RoomFacilityResponseDto> result = facilityRepository.getRoomFacility(id);
        return result;
    }

    public List<FacilityResponseDto> getFacilityList(Integer mainType) {
        List<Facility> facilities = facilityRepository.findAllByMainType(mainType);

        Map<String, List<Facility>> groupedFacilities = facilities.stream()
                .collect(Collectors.groupingBy(Facility::getSubType));

        return groupedFacilities.entrySet().stream()
                .map(entry -> new FacilityResponseDto(
                        mainType,
                        entry.getKey(),
                        entry.getValue().stream().map(Facility::getFacilityName).collect(Collectors.toList()),
                        entry.getValue().stream().map(Facility::getId).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }
}
