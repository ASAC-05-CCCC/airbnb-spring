package com.Cccccc.airbnb.domain.room.utils;

import com.Cccccc.airbnb.domain.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class ImageUrlUtil {
    public static List<String> getImageUrl(Room room) {
        List<String> list = new ArrayList<String>();
        list.add(room.getImage_url_1());
        list.add(room.getImage_url_2());
        list.add(room.getImage_url_3());
        list.add(room.getImage_url_4());
        list.add(room.getImage_url_5());
        return list;
    }
}
