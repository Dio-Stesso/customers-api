package com.example.costumers.service.mapper;

import com.example.costumers.dto.request.CustomerRequestDto;
import com.example.costumers.dto.response.CustomerResponseDto;
import com.example.costumers.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements RequestDtoMapper<CustomerRequestDto, Customer>,
        ResponseDtoMapper<CustomerResponseDto, Customer> {
    @Override
    public Customer toEntity(CustomerRequestDto dto) {
        Customer customer = new Customer();
        customer.setApp(dto.getApp());
        customer.setDate(dto.getDate());
        customer.setEmail(dto.getEmail());
        customer.setLastName(dto.getLastName());
        customer.setFirstName(dto.getFirstName());
        customer.setPhoneNumber(dto.getPhoneNumber());
        return customer;
    }

    @Override
    public CustomerResponseDto toDto(Customer entity) {
        CustomerResponseDto responseDto = new CustomerResponseDto();
        responseDto.setId(entity.getId());
        responseDto.setApp(entity.getApp());
        responseDto.setDate(entity.getDate());
        responseDto.setEmail(entity.getEmail());
        responseDto.setLastName(entity.getLastName());
        responseDto.setFirstName(entity.getFirstName());
        responseDto.setPhoneNumber(entity.getPhoneNumber());
        return responseDto;
    }
}
