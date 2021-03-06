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
  @Autowired
  Artist artist;
  @Autowired
  ArtistService artistService;

  public void savePicture(Picture picture) {
    List<Picture> pictures = (List<Picture>) pictureRepository.findAll();
    if (!pictures.contains(picture)) {
      pictureRepository.save(picture);
    }
  }

  public void updatePicture (Picture picture) {
    pictureRepository.save(picture);
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
    Picture picture = pictureRepository.findOne(id);
    Artist artist = artistService.findByArtworks(picture);
    artist.getArtworks().remove(picture);
    pictureRepository.delete(picture);
  }

}
