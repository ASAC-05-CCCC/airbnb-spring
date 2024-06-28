package com.Cccccc.airbnb.domain.room.repository;

import com.Cccccc.airbnb.domain.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query("SELECT count(DISTINCT r) FROM Room r " +
            "JOIN Bedroom b ON b.room = r " +
            "JOIN RoomFacility rf ON rf.room = r " +
            "JOIN Facility f ON rf.facility = f " +
            "WHERE (:minPrice IS NULL OR CAST(r.price AS integer) >= :minPrice) AND " +
            "(:maxPrice IS NULL OR CAST(r.price AS integer) <= :maxPrice) AND " +
            "(:bedCount IS NULL OR (SELECT SUM(bd.queen_bed_count + bd.king_bed_count + bd.double_bed_count) FROM Bedroom bd WHERE bd.room = r) = :bedCount)  AND " +
            "(:bathroomCount IS NULL OR r.bathroomCount = :bathroomCount) AND " +
            "(:isPreference IS NULL OR r.guest_favorite = :isPreference) AND " +
            "(:facilitiesOption IS NULL OR f.id IN :facilitiesOption) AND"  +
            "(:bedroomCount IS NULL OR (SELECT COUNT(bd) FROM Bedroom bd WHERE bd.room = r) = :bedroomCount)")

    Integer getRoomCount(
            @Param("minPrice") Integer minPrice,
            @Param("maxPrice") Integer maxPrice,
            @Param("bedroomCount") Integer bedroomCount,
            @Param("bedCount") Integer bedCount,
            @Param("bathroomCount") Integer bathroomCount,
            @Param("isPreference") Boolean isPreference,
            @Param("facilitiesOption") List<Integer> facilitiesOption);
}
