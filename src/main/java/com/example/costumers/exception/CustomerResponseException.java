package com.example.costumers.exception;

import java.time.ZonedDateTime;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomerResponseException {
    private final String message;
    private final HttpStatus status;
    private final ZonedDateTime time;

    public CustomerResponseException(String message, HttpStatus status, ZonedDateTime time) {
        this.message = message;
        this.status = status;
        this.time = time;
    }
}
