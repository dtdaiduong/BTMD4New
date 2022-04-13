package com.cg.repository.photoRepository;

import com.cg.model.Photo;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class PhotoRepository implements IPhotoRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Photo> findAll(){
        TypedQuery<Photo> query = em.createQuery("select c from Photo c", Photo.class);
        return query.getResultList();
    }

    @Override
    public Photo findById(Long id){
        TypedQuery<Photo> query = em.createQuery("select c from Photo c where  c.id=:id", Photo.class);
        query.setParameter("id", id);
        try{
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void remove(Long id){
        Photo photo = findById(id);
        if(photo!=null){
            em.remove(photo);
        }
    }

    @Override
    public void save(Photo photo){
        if(photo.getId()!=null){
            em.merge(photo);
        }else {
            em.persist(photo);
        }
    }

    public Photo like(Long id){
        Session session = null;
        Transaction transaction = null;
        try {
            SessionBuilder<SessionBuilder> sessionFactory = null;
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Photo comment = findById(id);
            comment.setLikeCount(comment.getLikeCount()+1);
            session.saveOrUpdate(comment);
            transaction.commit();
            return comment;
        } catch (Exception ex){
            ex.printStackTrace();
            if (transaction !=null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
        return null;
    }
}
