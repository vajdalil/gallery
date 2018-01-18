package com.greenfoxacademy.galleryapp.repositories;

import com.greenfoxacademy.galleryapp.models.Artist;
import com.greenfoxacademy.galleryapp.models.Costumer;
import com.greenfoxacademy.galleryapp.models.Picture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends CrudRepository<Picture, Long> {

  List<Picture> findAllByArtist(Artist artist);
  List <Picture> findAllBy(Costumer owner);
  Picture findByTitle (String title);
}
