package com.greenfoxacademy.galleryapp.services;

import com.greenfoxacademy.galleryapp.models.Picture;
import com.greenfoxacademy.galleryapp.repositories.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService {

  @Autowired
  PictureRepository pictureRepository;

  public void savePicture(Picture picture) {
    List<Picture> pictures = (List<Picture>) pictureRepository.findAll();
    if (!pictures.contains(picture)) {
      pictureRepository.save(picture);
    }
  }
}
