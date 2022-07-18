package com.johnsonmima.school.controller;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DashboardController {

    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET})
    public String dashbord(Model model, Authentication authentication){
        model.addAttribute("username", authentication.getUsername());
    

        return "dashboard.html";

    }
    
}
