package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
  
  @GetMapping("/")
  public String getRoot() {
    return "login/login";
  }
  
  @GetMapping("/login")
  public String getLogin() {
    return "login/login";
  }
}
