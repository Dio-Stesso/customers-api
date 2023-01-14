package com.example.costumers.dto.response;

import java.time.LocalDate;
import lombok.Data;

@Data
public class CustomerResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String app;
    private LocalDate date;
}
