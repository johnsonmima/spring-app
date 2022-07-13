package com.johnsonmima.school.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {

  @RequestMapping(value = { "", "/", "home" }) // map multiple path
  public String displayHomePage(Model model) {
    // model help to hold the values needed by the ui
    // title
    model.addAttribute("title", "Welcome");
    return "home.html";
  }

  
}
