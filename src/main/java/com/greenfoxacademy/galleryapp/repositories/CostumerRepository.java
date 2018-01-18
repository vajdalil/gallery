package com.greenfoxacademy.galleryapp.repositories;

import com.greenfoxacademy.galleryapp.models.Costumer;
import com.greenfoxacademy.galleryapp.models.Picture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepository extends CrudRepository <Costumer, Long> {

  Costumer findByName (String Name);
  Costumer findByBoughtPictures (Picture picture);
}
