package com.cg.service.blogService;

import com.cg.model.Blog;
import com.cg.repository.blogRepository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogService implements IBlogService{
    @Autowired
    public IBlogRepository blogRepository;

    @Override
    public List<Blog>findAll(){
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id){
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog){
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id){
        blogRepository.remove(id);
    }
}
