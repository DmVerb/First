package org.example.SpringBootApplication.services;


import java.util.Collection;

public interface CRUDService<T> {
    T getById(Long id);
    Collection<T> getALL();
    void create(T item);
    void update(T item);
    void delete(Long id);
}
