package com.cg.service.photoService;


import com.cg.model.Photo;
import com.cg.repository.photoRepository.IPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PhotoService implements IPhotoService{
    @Autowired
    public IPhotoRepository photoRepository;

    @Override
    public List<Photo> findAll() {
        return photoRepository.findAll();
    }

    @Override
    public Photo findById(long id) {
        return photoRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        photoRepository.remove(id);
    }

    @Override
    public void save(Photo photo) {
        photoRepository.save(photo);
    }

    @Override
    public Photo like(Long id) {
        return null;
    }
}
