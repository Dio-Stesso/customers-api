package com.example.costumers.dto.request;

import com.example.costumers.validation.Email;
import com.example.costumers.validation.PhoneNumber;
import java.time.LocalDate;
import lombok.Data;

@Data
public class CustomerRequestDto {
    private String firstName;
    private String lastName;
    @PhoneNumber
    private String phoneNumber;
    @Email
    private String email;
    private String app;
    private LocalDate date;
}
