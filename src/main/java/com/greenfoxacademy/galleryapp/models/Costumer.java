package com.greenfoxacademy.galleryapp.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Costumer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  @OneToMany
  private List<Picture> boughtPictures;

  public Costumer() {
  }

  public Costumer(String name, List<Picture> boughtPictures) {
    this.name = name;
    this.boughtPictures = boughtPictures;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Picture> getBoughtPictures() {
    return boughtPictures;
  }

  public void setBoughtPictures(List<Picture> boughtPictures) {
    this.boughtPictures = boughtPictures;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Costumer costumer = (Costumer) o;

    return this.getName().equals(costumer.getName());
  }
}
