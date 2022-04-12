package com.cg.repository;

import java.util.List;

public interface IGeneralRepository <T>{
    List findAll();

    T findById(Long id);

    void remove(Long id);

    void save(T t);
}
