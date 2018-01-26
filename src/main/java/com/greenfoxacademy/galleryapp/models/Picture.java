package com.greenfoxacademy.galleryapp.models;

import javax.persistence.*;

@Entity
public class Picture {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long price;
  private boolean isSold;
  private String url;
  private String title;
  @OneToOne
  private Artist artist;
  @OneToOne
  private Costumer owner;

  public Picture() {
  }

  public Picture(String title,String url, long price) {
    this.title = title;
    this.url = url;
    this.price = price;
    this.isSold = false;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public boolean getIsSold() {
    return isSold;
  }

  public void setIsSold(boolean sold) {
    isSold = sold;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Costumer getOwner() {
    return owner;
  }

  public void setOwner(Costumer owner) {
    this.owner = owner;
  }

  public Artist getArtist() {
    return artist;
  }

  public void setArtist(Artist artist) {
    this.artist = artist;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Picture picture = (Picture) o;

    return this.getTitle().equals(picture.getTitle());
  }
}
