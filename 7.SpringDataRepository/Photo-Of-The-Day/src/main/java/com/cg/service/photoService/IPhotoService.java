package com.cg.service.photoService;

import com.cg.model.Photo;
import com.cg.service.IGeneralService;


public interface IPhotoService extends IGeneralService<Photo> {

    Photo like(Long id);
}
