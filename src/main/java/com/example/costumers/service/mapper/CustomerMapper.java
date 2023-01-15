package com.example.costumers.service.mapper;

import com.example.costumers.dto.request.CustomerRequestDto;
import com.example.costumers.dto.response.CustomerResponseDto;
import com.example.costumers.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerRequestDto customerRequestDto);

    CustomerResponseDto toDto(Customer customer);
}
