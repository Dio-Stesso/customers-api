package com.example.costumers.controller;

import com.example.costumers.dto.request.CustomerRequestDto;
import com.example.costumers.dto.response.CustomerResponseDto;
import com.example.costumers.entity.Customer;
import com.example.costumers.service.CustomerService;
import com.example.costumers.service.mapper.CustomerMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService service;
    private final CustomerMapper mapper;

    public CustomerController(CustomerService service, CustomerMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    @Tag(name = "Save a customer", description = "Save a new customer to DataBase.")
    public CustomerResponseDto save(@RequestBody @Valid CustomerRequestDto requestDto) {
        return mapper.toDto(service.save(mapper.toEntity(requestDto)));
    }

    @PostMapping("/{id}")
    @Tag(name = "Save a customer", description = "Change an existing customer data.")
    public CustomerResponseDto save(@PathVariable Long id,
                                    @RequestBody @Valid CustomerRequestDto requestDto) {
        Customer customer = mapper.toEntity(requestDto);
        customer.setId(id);
        return mapper.toDto(service.save(customer));
    }

    @DeleteMapping("/{id}")
    @Tag(name = "Delete a customer", description = "Delete an existing customer data.")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    @Tag(name = "Find a customer", description = "Find some customer by their ID.")
    public CustomerResponseDto findById(@PathVariable Long id) {
        return mapper.toDto(service.get(id));
    }

    @GetMapping("/numbers")
    @Tag(name = "Find a customer", description = "Find some customer by their phone number.")
    public CustomerResponseDto findByPhoneNumber(@RequestParam String phoneNumber) {
        return mapper.toDto(service.findByPhoneNumber(phoneNumber));
    }

    @GetMapping("/emails")
    @Tag(name = "Find a customer", description = "Find some customer by their email.")
    public CustomerResponseDto findByEmail(@RequestParam String email) {
        return mapper.toDto(service.findByEmail(email));
    }
}
