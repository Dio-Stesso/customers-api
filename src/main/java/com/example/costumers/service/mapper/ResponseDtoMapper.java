package com.example.costumers.service.mapper;

public interface ResponseDtoMapper<D, E> {
    D toDto(E entity);
}
