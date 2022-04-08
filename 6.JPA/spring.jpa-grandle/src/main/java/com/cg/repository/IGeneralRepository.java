package com.cg.repository;

import com.cg.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGeneralRepository <T>{
    List<T> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);

    Page<Customer> findAll(Pageable pageable);
}
