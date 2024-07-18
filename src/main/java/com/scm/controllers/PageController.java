package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

  @Autowired
  private UserService userService;

  @RequestMapping("/home")
  public String home(Model model) {
    System.out.println("Home page handler");
    // sending data to view
    model.addAttribute("name", "Substring Technologies");
    model.addAttribute("Sanjeev", "Sagar");
    model.addAttribute("githubRepo", "https://github.com/sanjeev0228/");
    return "home";
  }

  // about
  @RequestMapping("/about")
  public String aboutPage() {
    System.out.println("About Page Loading");
    return "about";

  }

  // contact
  @GetMapping("/contact")
  public String contact() {
    return new String("contact");
  }

  // this is showing login page
  @GetMapping("/login")
  public String login() {
    return new String("login");
  }

  // services

  @RequestMapping("/services")
  public String servicesPage() {
    System.out.println("services page loading");
    return "services";
  }

  @GetMapping("/register")
  public String register(Model model) {

    UserForm userForm= new UserForm();
     
    model.addAttribute("user", userForm)
    return ("register");
  }

  // proceessing register
  @RequestMapping(value = "/do-register", method = RequestMethod.POST)
  public String processRegister(@ModelAttribute UserForm userForm) {

   User user=  User.builder().build();
//userSerivce
userSerivce.saveUser(user)


    // redirect login page
    return "redirect:/register";
  }

}
