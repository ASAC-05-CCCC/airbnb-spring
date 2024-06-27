package com.Cccccc.airbnb.domain.room.utils;

import com.Cccccc.airbnb.domain.entity.Bedroom;
import com.Cccccc.airbnb.domain.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class BriefRoomInfoUtil {
    public static List<String>  BriefRoomInfo(Room room, Bedroom bedroom) {
        List<String> list = new ArrayList<String>();
        list.add("최대 인원 " + room.getMaxPeopleCount() +"명");
        list.add("침실 " + Integer.valueOf(bedroom.getQueen_bed_count()+bedroom.getKing_bed_count()+ bedroom.getDouble_bed_count())+ "개");
        list.add("욕실 " + room.getBathroomCount() + "개");
        return list;
    }
}
