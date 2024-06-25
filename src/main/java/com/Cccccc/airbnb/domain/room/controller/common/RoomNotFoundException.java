package com.Cccccc.airbnb.domain.room.controller.common;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(String message) {
        super(message);
    }
}