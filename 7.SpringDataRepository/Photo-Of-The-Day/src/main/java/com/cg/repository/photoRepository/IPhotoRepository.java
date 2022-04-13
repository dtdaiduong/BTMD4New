package com.cg.repository.photoRepository;


import com.cg.model.Photo;
import com.cg.repository.IGeneralRepository;

import java.util.List;

public interface IPhotoRepository extends IGeneralRepository<Photo> {
    Photo like(Long id);
}
