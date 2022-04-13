package com.cg.controller;

import com.cg.model.Photo;
import com.cg.service.photoService.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class PhotoController {
    @Autowired
    private IPhotoService photoService;

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("photo", new Photo());
        List<Photo> photos = photoService.findAll();
        modelAndView.addObject("photos", photos);
        return modelAndView;
    }

    @PostMapping
    public String save(Photo photo) {
        photoService.save(photo);
        return "redirect:/home";
    }

    @PostMapping(value = "like/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Photo> like(@PathVariable(name = "id") Long id) {
        Photo comment = photoService.like(id);
        System.out.println(comment.getLikeCount());
        if (comment == null) {
            return new ResponseEntity<>(comment, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
}
