package com.greenfoxacademy.galleryapp.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
public class Artist {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
  private List<Picture> artworks;

  public Artist() {
    artworks = new ArrayList<>();
  }

  public Artist(String name) {
    this.name = name;
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

  public List<Picture> getArtworks() {
    return artworks;
  }

  public void setArtworks(List<Picture> artworks) {
    this.artworks = artworks;
  }

  public void deleteArtwork(Picture picture) {
  }

  public void addPictureToArtworks(Picture picture) {
    picture.setArtist(this);
    artworks.add(picture);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Artist artist = (Artist) o;

    return this.getName().equals(artist.getName());
  }
}
