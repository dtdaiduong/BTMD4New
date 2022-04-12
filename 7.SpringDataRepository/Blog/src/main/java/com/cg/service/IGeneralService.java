package com.cg.service;

import com.cg.model.Blog;

import java.util.List;

public interface IGeneralService<T> {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);
}
