package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.SignupForm;

@Controller
@RequestMapping("/user")
public class SignupController {
  
  @GetMapping("/signup")
  public String getSignup(@ModelAttribute SignupForm form) {
    return "user/signup"; 
  }
  
  @PostMapping("/signup")
  public String postSignup(@ModelAttribute SignupForm form) {
    return "redirect:/login";
  }
}
