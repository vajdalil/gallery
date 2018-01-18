package com.greenfoxacademy.galleryapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GalleryController {

  @RequestMapping({"/", "/main"})
  public String showMainPage(){
    return "main";
  }
}
