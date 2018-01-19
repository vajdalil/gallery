package com.greenfoxacademy.galleryapp.controllers;

import com.greenfoxacademy.galleryapp.models.Picture;
import com.greenfoxacademy.galleryapp.services.ArtistService;
import com.greenfoxacademy.galleryapp.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ExhibitionController {

  @Autowired
  PictureService pictureService;
  @Autowired
  ArtistService artistService;

  @GetMapping({"/exhibition"}) // a search functionben az action-nél lesz: @{exhibition}
  public String list(@RequestParam (value = "search", required = false) String artistName, Model model) { //a valeu="search" a html-ben az input name="search" lesz
    if (artistName != null) {  // ha nincs search beadva, akkor az mindig null!!!
      model.addAttribute("searchValue", artistName);
      model.addAttribute("pictures", pictureService.findAllByArtistName(artistName));
    }
    else{
      List<Picture> pictures = pictureService.findAll();
      model.addAttribute("pictures", pictures);
      model.addAttribute("searchValue", "Search...");
    }
    return "exhibition";
  }
}
