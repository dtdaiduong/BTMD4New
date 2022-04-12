package com.cg.repository.blogRepository;

import com.cg.model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepository implements IBlogRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List findAll(){
        TypedQuery<Blog> query = em.createQuery("SELECT b FROM Blog b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id){
        TypedQuery<Blog> query = em.createQuery("SELECT b FROM Blog b WHERE b.id = :id", Blog.class);
        query.setParameter("id", id);
        try{
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void remove(Long id){
        Blog blog = findById(id);
        if (blog!=null){
            em.remove(blog);
        }
    }

    @Override
    public void save(Blog blog){
        if(blog.getId()!=null){
            em.merge(blog);
        } else {
            em.persist(blog);
        }
    }
}
