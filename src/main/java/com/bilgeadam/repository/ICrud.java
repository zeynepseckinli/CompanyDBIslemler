package com.bilgeadam.repository;

public interface ICrud<T> {
    boolean save(T t);
}
