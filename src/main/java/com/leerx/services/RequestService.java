package com.leerx.services;

import com.leerx.entities.Request;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
public class RequestService implements Service<Request> {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void persist(Request request) {
        entityManager.persist(request);
    }

    @Override
    @Transactional
    public void merge(Request request) {
        entityManager.merge(request);
    }

    @Override
    @Transactional
    public Optional<Request> read(Long id) {
        return Optional.ofNullable(entityManager.find(Request.class, id));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Request request = entityManager.find(Request.class, id);
        entityManager.remove(request);
    }
}
