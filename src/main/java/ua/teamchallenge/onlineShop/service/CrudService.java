package ua.teamchallenge.onlineShop.service;

import java.util.List;
import java.util.UUID;

public interface CrudService<T> {
    List<T> findAll();

    T findById(UUID id);

    T create(T t);

    T update(T t);

    void delete(T t);

    void deleteById(UUID id);

    void deleteAll();
}
