package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class PageController {
  
  @RequestMapping("/home")
  public String home(Model model) {
      System.out.println("Home page handler");
      // sending data to view
      model.addAttribute("name", "Substring Technologies");
      model.addAttribute("Sanjeev", "Sagar");
      model.addAttribute("githubRepo", "https://github.com/sanjeev0228/");
      return "home";
  }


//about
   @RequestMapping("/about") 
  public String aboutPage(){
    System.out.println("About Page Loading");
    return "about";

  }  

//services
@RequestMapping("/services")
public String servicePage(){
  System.out.println("services page loading");
  return "service";
}
 // contact page
 @RequestMapping("/contact")
  public String contact() {
      return new String("contact");
    }
// this is showing login page
@RequestMapping("/login")
  public String login() {
    return new String("login");
    }


// registration page
@RequestMapping("/signup")
public String register() {
       
      // model.addAttribute("userForm", userForm);

        return "register";
    }


}
