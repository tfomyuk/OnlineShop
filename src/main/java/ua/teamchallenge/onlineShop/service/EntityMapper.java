package ua.teamchallenge.onlineShop.service;

public interface EntityMapper<T,A> {
    T mapToDto(A a);
    A mapToDao(T t);
}
