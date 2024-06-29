package com.Cccccc.airbnb.domain.room.repository;

import com.Cccccc.airbnb.domain.entity.Facility;
import com.Cccccc.airbnb.domain.room.dto.response.RoomFacilityResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Integer> {
    @Query("SELECT new com.Cccccc.airbnb.domain.room.dto.response.RoomFacilityResponseDto(f.facilityName, f.facilityImageName) " +
            "FROM Facility f JOIN RoomFacility rf ON f.id = rf.facility.id " +
            "WHERE rf.room.id = :id")
    List<RoomFacilityResponseDto> getRoomFacility(Integer id);

    List<Facility> findAllByMainType(Integer mainType);
}
