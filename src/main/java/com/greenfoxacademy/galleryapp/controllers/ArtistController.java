package com.greenfoxacademy.galleryapp.controllers;

import com.greenfoxacademy.galleryapp.models.Artist;
import com.greenfoxacademy.galleryapp.models.Costumer;
import com.greenfoxacademy.galleryapp.models.Picture;
import com.greenfoxacademy.galleryapp.services.ArtistService;
import com.greenfoxacademy.galleryapp.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ArtistController {

  @Autowired
  ArtistService artistService;
  @Autowired
  PictureService pictureService;

  @GetMapping("/login/artist")
  public String showLogin(Model model) {
    model.addAttribute("artist", new Artist());
    return "artistLogin";
  }

  @PostMapping("/login/artist")
  private String handleLogin(Model model, @ModelAttribute Artist artist) {
    Artist loggedInArtist = artistService.loginArtist(artist);
    model.addAttribute("artist", loggedInArtist);
    return "redirect:/artist/" + artist.getName();
  }

  @GetMapping("/artist/{name}")
  public String showArtist(Model model, @PathVariable String name) {
    Artist artist = artistService.findbyName(name);
    model.addAttribute("artist", artist);
    model.addAttribute("newPicture", new Picture());
    return "artist";
  }

  @PostMapping("/artist/{name}")
  public String createNewPicture(Model model, @PathVariable String name, Picture picture) {
    Artist artist = artistService.findbyName(name);
    model.addAttribute("artist", artist);
    artistService.save(name, picture);
    pictureService.savePicture(picture);
    return "redirect:/artist/" + artist.getName();
  }
  @GetMapping("/edit/{id}")
  public String edit(Model model, @PathVariable long id) {
    Picture picture = pictureService.findByID(id);
    model.addAttribute("picture", picture);
    return "edit";
  }

  @PostMapping("/edit/{id}/save")
  public String editTodo( @ModelAttribute Picture picture, @PathVariable long id) {
    picture.setId(id);
    pictureService.savePicture(picture);
    return "redirect:/artist/" + picture.getArtist().getName();
  }

  @RequestMapping("/delete/{id}")
  public String delete(@PathVariable long id) {
    Picture picture = pictureService.findByID(id);
    Artist artist = artistService.findByArtworks(picture);
    pictureService.deleteByID(id);
    return "redirect:/artist" + artist.getName();
  }

}
