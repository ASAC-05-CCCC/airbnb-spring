package com.Cccccc.airbnb.domain.review.common;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private ExceptionType type;

    public CustomException(ExceptionType type, String cause) {
        super(cause);
        this.type = type;
    }
}
