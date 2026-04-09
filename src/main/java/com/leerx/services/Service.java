package com.leerx.services;

import com.leerx.entities.Request;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.Optional;

public interface Service<T> {

    void persist(T t);

    void merge(T request);

    Optional<T> read(Long id) throws EntityNotFoundException;

    void delete(Long id);
}
