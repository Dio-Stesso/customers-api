package com.example.costumers.service.mapper;

public interface RequestDtoMapper<D, E> {
    E toEntity(D dto);
}
