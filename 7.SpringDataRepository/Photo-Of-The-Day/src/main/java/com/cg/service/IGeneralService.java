package com.cg.service;

import com.cg.model.Photo;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T findById(long id);

    void remove(Long id);

    void save(T t);

}
