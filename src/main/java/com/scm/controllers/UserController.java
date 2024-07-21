package com.scm.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/user")
public class UserController {

      // user dashbaord page

      @RequestMapping(value = "/dashboard")
      public String userDashboard() {
          System.out.println("User dashboard");
          return "user/dashboard";
      }
  
      // user profile page
  
      @RequestMapping(value = "/profile")
      public String userProfile(Model model, Authentication authentication) {
  
          return "user/profile";
      }

}
