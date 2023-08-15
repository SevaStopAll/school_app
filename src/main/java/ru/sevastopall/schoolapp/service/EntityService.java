package ru.sevastopall.schoolapp.service;


import java.util.Collection;
import java.util.Optional;


public interface EntityService<T> {

    Optional<T> save(T entity);

    Optional<T> findById(int id);

    Collection<T> findAll();
}
