package com.hotel.management.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/home")
public class HomeController {

  @GetMapping("/all")
  public String allAccess() {
    return "Welcome!!";
  }
}
