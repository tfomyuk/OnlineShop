package ua.teamchallenge.onlineShop.controller;

import org.springframework.http.ResponseEntity;

import java.util.UUID;

@SuppressWarnings("unused")
public interface CrudController<T> {
    ResponseEntity<?> getAll();

    ResponseEntity<?> getById(UUID id);

    ResponseEntity<?> create(T t);

    ResponseEntity<?> update(T t);

    ResponseEntity<?> delete(T t);

    ResponseEntity<?> deleteById(UUID id);

    ResponseEntity<?> deleteAll();
}
