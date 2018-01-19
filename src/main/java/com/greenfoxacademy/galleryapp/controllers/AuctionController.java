package com.greenfoxacademy.galleryapp.controllers;

import com.greenfoxacademy.galleryapp.models.Artist;
import com.greenfoxacademy.galleryapp.models.Costumer;
import com.greenfoxacademy.galleryapp.models.Picture;
import com.greenfoxacademy.galleryapp.repositories.CostumerRepository;
import com.greenfoxacademy.galleryapp.repositories.PictureRepository;
import com.greenfoxacademy.galleryapp.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuctionController {

  @Autowired
  PictureService pictureService;
  @Autowired
  CostumerRepository costumerRepository;

  @GetMapping("/auction/{name}")
  public String list(Model model) {
    List<Picture> pictures = pictureService.findAll();
    List<Picture> unSold = new ArrayList<>();
    for (Picture picture : pictures) {
      if (picture.getIsSold() == false) {
        unSold.add(picture);
      }
    }
    model.addAttribute("pictures", unSold);
    return "auction";
  }

 @PostMapping("/buy")
  public String buy(Model model, @PathVariable String name, @ModelAttribute Picture picture) {
   Costumer costumer = costumerRepository.findByName(name);
   model.addAttribute("picture", picture);
   picture.setOwner(costumer);
   picture.setIsSold(true);
   return "redirect:/costumer/" + costumer.getName();
  }

  /**
  @RequestMapping("/auction/search")
  public String search(Model model, @ModelAttribute Artist artist) {
    List<Picture> pictures = pictureService.findAllByArtist(artist);
    model.addAttribute("pictures", pictures);
    return "redirect/auction";
  }
  **/
}
