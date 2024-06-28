package com.Cccccc.airbnb.domain.entity.common;

import java.util.Locale;

public enum StatusType {
    ACTIVATE(0, "ACTIVATE"),
    DELETED(1, "DELETED");

    final int number;
    final String status;

    StatusType(int number, String status) {
        this.number = number;
        this.status = status;
    }
}
