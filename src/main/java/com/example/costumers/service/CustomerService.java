package com.example.costumers.service;

import com.example.costumers.entity.Customer;
import com.example.costumers.exception.CustomerNotFoundException;
import com.example.costumers.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CrudService<Customer> {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer save(Customer entity) {
        return repository.save(entity);
    }

    @Override
    public Customer get(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new CustomerNotFoundException("The customer with " + id + " ID not to be found."));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Customer findByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber).orElseThrow(() ->
                new CustomerNotFoundException("The customer with " + phoneNumber
                        + " phone number not to be found."));
    }

    public Customer findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new CustomerNotFoundException(
                "The customer with " + email + " email not to be found."));
    }
}
