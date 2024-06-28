package com.Cccccc.airbnb.domain.room.repository;

import com.Cccccc.airbnb.domain.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomListRepository extends JpaRepository<Room, Integer> {
    @Query("SELECT DISTINCT r FROM Room r " +
            "JOIN Bedroom b ON b.room = r " +
            "JOIN RoomFacility rf ON rf.room = r " +
            "JOIN Facility f ON rf.facility = f " +
            "WHERE (:location IS NULL OR r.country = :location) AND " +
            "(:guest IS NULL OR r.maxPeopleCount >= :guest ) AND " +
            "(:minPrice IS NULL OR CAST(r.price AS integer) >= :minPrice) AND " +
            "(:maxPrice IS NULL OR CAST(r.price AS integer) <= :maxPrice) AND " +
            "(:bedCount IS NULL OR (SELECT SUM(bd.queen_bed_count + bd.king_bed_count + bd.double_bed_count) FROM Bedroom bd WHERE bd.room = r) = :bedCount)  AND " +
            "(:bathroomCount IS NULL OR r.bathroomCount = :bathroomCount) AND " +
            "(:isPreference IS NULL OR r.guest_favorite = :isPreference) AND " +
            "(:facilitiesOption IS NULL OR f.id IN :facilitiesOption) AND"  +
            "(:bedroomCount IS NULL OR (SELECT COUNT(bd) FROM Bedroom bd WHERE bd.room = r) = :bedroomCount)")
    Page<Room> findFilteredRooms(Pageable pageable,
                                 @Param("location") String location,
                                 @Param("guest") Integer guest,
                                 @Param("minPrice") Integer minPrice,
                                 @Param("maxPrice") Integer maxPrice,
                                 @Param("bedCount") Integer bedCount,
                                 @Param("bathroomCount") Integer bathroomCount,
                                 @Param("isPreference") Boolean isPreference,
                                 @Param("facilitiesOption") List<Integer> facilitiesOption,
                                 @Param("bedroomCount") Integer bedroomCount
    );
}