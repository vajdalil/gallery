package com.greenfoxacademy.galleryapp.controllers;

import com.greenfoxacademy.galleryapp.models.Artist;
import com.greenfoxacademy.galleryapp.models.Picture;
import com.greenfoxacademy.galleryapp.repositories.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ExhibitionController {

  @Autowired
  PictureRepository pictureRepository;

  @GetMapping({"/exhibition"})
  public String list(Model model) {
    List<Picture> pictures = (List<Picture>) pictureRepository.findAll();
    model.addAttribute("pictures", pictures);
    return "exhibition";
  }

  @RequestMapping("/exhibition/search")
  public String search(Model model, @ModelAttribute Artist artist) {
    List<Picture> pictures = pictureRepository.findAllByArtist(artist);
    model.addAttribute("pictures", pictures);
    return "exhibition";
  }
}
