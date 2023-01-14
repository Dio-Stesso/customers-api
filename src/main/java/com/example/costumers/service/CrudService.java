package com.example.costumers.service;

public interface CrudService<E> {
    E save(E entity);

    E get(Long id);

    void delete(Long id);
}
