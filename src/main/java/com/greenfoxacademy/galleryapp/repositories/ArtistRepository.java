package com.greenfoxacademy.galleryapp.repositories;
import com.greenfoxacademy.galleryapp.models.Artist;
import com.greenfoxacademy.galleryapp.models.Picture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {

  Artist findArtistByArtworks(Picture picture);
  Artist findByName (String name);
  Artist findById (long id);
}
