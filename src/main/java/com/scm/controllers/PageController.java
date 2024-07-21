package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
     
    model.addAttribute("userForm", userForm);
    return ("register");
  }

  // proceessing register
  @RequestMapping(value = "/do-register", method = RequestMethod.POST)
  public String processRegister(@Valid @ModelAttribute UserForm userForm,BindingResult rBindingResult, HttpSession session) {

    System.out.println("Proceessing registration ");
    // fetch form data
    // userform
    System.out.println(userForm);
    
    if (rBindingResult.hasErrors()) {
      return "register";
  }

    User user = new User();
    user.setName(userForm.getName());
    user.setEmail(userForm.getEmail());
    user.setPassword(userForm.getPassword());
    user.setAbout(userForm.getAbout());
    user.setPhoneNumber(userForm.getPhoneNumber());
    user.setEnabled(false);
    user.setProfilePic(
        "https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75");

    User savedUser = userService.saveUser(user);

    System.out.println("user saved :");

    // message add
    Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();

    session.setAttribute("message", message);

    // redirect login page
    return "redirect:/register";
  }

}
