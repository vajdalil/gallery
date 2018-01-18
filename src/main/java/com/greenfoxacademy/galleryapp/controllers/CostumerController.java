package com.greenfoxacademy.galleryapp.controllers;

import com.greenfoxacademy.galleryapp.models.Artist;
import com.greenfoxacademy.galleryapp.models.Costumer;
import com.greenfoxacademy.galleryapp.repositories.CostumerRepository;
import com.greenfoxacademy.galleryapp.services.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CostumerController {

  @Autowired
  CostumerService costumerService;

  @GetMapping("/login/costumer")
  public String showLogin(Model model) {
    model.addAttribute("costumer", new Artist());
    return "costumerLogin";
  }

  @PostMapping("/login/costumer")
  private String handleLogin(Model model, @ModelAttribute Costumer costumer) {
    Costumer loggedInCostumer = costumerService.loginCostumer(costumer);
    model.addAttribute("costumer", loggedInCostumer);
    return "redirect:/costumer/" + costumer.getName();
  }

  @GetMapping("/costumer/{name}")
  public String showCostumer(Model model, @PathVariable String name) {
    Costumer costumer = costumerService.findbyName(name);
    model.addAttribute("costumer", costumer);
    return "costumer";
  }

}
