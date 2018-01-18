package com.greenfoxacademy.galleryapp.controllers;

import com.greenfoxacademy.galleryapp.models.Picture;
import com.greenfoxacademy.galleryapp.repositories.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuctionController {

  @Autowired
  PictureRepository pictureRepository;

  @GetMapping({"/auction"})
  public String list(Model model) {
    List<Picture> pictures = (List<Picture>) pictureRepository.findAll();
    List<Picture> unSold = new ArrayList<>();
    for (Picture picture : pictures) {
      if (picture.getIsSold() == false) {
        unSold.add(picture);
      }
    }
    model.addAttribute("pictures", unSold);
    return "auction";
  }

 @PostMapping("/add")
  public String buy(@ModelAttribute Picture picture) {
   picture.setIsSold(true);
   return "redirect:/costumer/{name}";
  }
}
