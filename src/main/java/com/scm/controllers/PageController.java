package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {


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

}
