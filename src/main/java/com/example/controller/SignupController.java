package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.form.GroupOrder;
import com.example.form.SignupForm;

@Controller
@RequestMapping("/user")
public class SignupController {
  
  @Autowired
  private UserService userService;
  
  @Autowired
  private ModelMapper modelMapper;
  
  @GetMapping("/signup")
  public String getSignup(@ModelAttribute SignupForm form) {
    return "user/signup"; 
  }
  
  @PostMapping("/signup")
  public String postSignup(
    @ModelAttribute @Validated(GroupOrder.class) SignupForm form,
    BindingResult bindingResult) {
    
    if (bindingResult.hasErrors()) {
      return getSignup(form);
    }
    
    MUser user = modelMapper.map(form, MUser.class);
    
    userService.signup(user);
    
    return "redirect:/login";
  }
}
