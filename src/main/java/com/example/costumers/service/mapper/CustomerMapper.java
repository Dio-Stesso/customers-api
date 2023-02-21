package com.example.costumers.service.mapper;

import com.example.costumers.dto.request.CustomerRequestDto;
import com.example.costumers.dto.response.CustomerResponseDto;
import com.example.costumers.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toEntity(CustomerRequestDto customerRequestDto) {
        if (customerRequestDto == null) {
            return null;
        } else {
            Customer customer = new Customer();
            customer.setFirstName(customerRequestDto.getFirstName());
            customer.setLastName(customerRequestDto.getLastName());
            customer.setPhoneNumber(customerRequestDto.getPhoneNumber());
            customer.setEmail(customerRequestDto.getEmail());
            customer.setApp(customerRequestDto.getApp());
            customer.setDate(customerRequestDto.getDate());
            return customer;
        }
    }

    public CustomerResponseDto toDto(Customer customer) {
        if (customer == null) {
            return null;
        } else {
            CustomerResponseDto customerResponseDto = new CustomerResponseDto();
            customerResponseDto.setId(customer.getId());
            customerResponseDto.setFirstName(customer.getFirstName());
            customerResponseDto.setLastName(customer.getLastName());
            customerResponseDto.setPhoneNumber(customer.getPhoneNumber());
            customerResponseDto.setEmail(customer.getEmail());
            customerResponseDto.setApp(customer.getApp());
            customerResponseDto.setDate(customer.getDate());
            return customerResponseDto;
        }
    }
}
