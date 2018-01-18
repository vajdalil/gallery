package com.greenfoxacademy.galleryapp.services;
import com.greenfoxacademy.galleryapp.models.Costumer;
import com.greenfoxacademy.galleryapp.models.Picture;
import com.greenfoxacademy.galleryapp.repositories.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CostumerService {

  @Autowired
  CostumerRepository costumerRepository;

  public CostumerService() {
  }

  public Costumer loginCostumer(Costumer costumer) {
    if (!((List<Costumer>) costumerRepository.findAll()).contains(costumer)) {
      registerCostumer(costumer);
      return costumer;
    }
    return costumer;
  }

  private void registerCostumer(Costumer costumer) {
    costumerRepository.save(costumer);
  }

  public List<Costumer> findAll() {
    return (List<Costumer>) costumerRepository.findAll();
  }

  public Costumer findbyName(String costumerName) {
    return costumerRepository.findByName(costumerName);
  }

  public void save(String costumerName, Picture picture) {
    Costumer costumer = costumerRepository.findByName(costumerName);
    picture.setOwner(costumer);
  }
}
