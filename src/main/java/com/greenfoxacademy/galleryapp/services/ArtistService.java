package com.greenfoxacademy.galleryapp.services;
import com.greenfoxacademy.galleryapp.models.Artist;
import com.greenfoxacademy.galleryapp.models.Picture;
import com.greenfoxacademy.galleryapp.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArtistService {

  @Autowired
  ArtistRepository artistRepository;

  public ArtistService() {

  }

  public Artist loginArtist(Artist artist) {
    List<Artist> artists = (List<Artist>) artistRepository.findAll();
    if (!artists.contains(artist)) {
      registerArtist(artist);
      return artist;
    }
    return artistRepository.findByName(artist.getName());
  }

  private void registerArtist(Artist artist) {
    artistRepository.save(artist);
  }

  public List<Artist> findAll() {
    return (List<Artist>) artistRepository.findAll();
  }

  public Artist findbyName(String name) {
    return  artistRepository.findByName(name);
  }

  public Artist findById (long id) {
    return artistRepository.findById(id);
  }

  public Artist findByArtworks(Picture picture) {
    return artistRepository.findArtistByArtworks(picture);
  }

  public void save(String artistName, Picture picture) {
    Artist artist = artistRepository.findByName(artistName);
    picture.setArtist(artist);
    if (!artist.getArtworks().contains(picture)) {
      artist.getArtworks().add(picture);
    }
  }
}
