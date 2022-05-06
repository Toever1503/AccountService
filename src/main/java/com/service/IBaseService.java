package com.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBaseService<T, M, K> {
    T findById(K id);
    T add(M m);
    T update(M m);
    boolean deleteById(K id);
    Page<T> search(String keyword, Pageable page);
    Page<T> findAll(Pageable page);
    List<T> findAll();
}
