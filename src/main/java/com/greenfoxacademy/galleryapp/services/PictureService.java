package com.greenfoxacademy.galleryapp.services;

import com.greenfoxacademy.galleryapp.models.Artist;
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

  public List<Picture> findAll() {
    return (List<Picture>) pictureRepository.findAll();
  }

  public Picture findByTitle (String title) {
    return pictureRepository.findByTitle(title);
  }

  public Picture findByID(long id) {
    return pictureRepository.findOne(id);
  }

  public List <Picture> findAllByArtistName(String name) {
   return pictureRepository.findAllByArtist_Name(name);
  }

  public void delete(long id) {
    pictureRepository.deleteById(id);
  }

  public void deleteByID(long id) {
    pictureRepository.deleteById(id);
  }
}
