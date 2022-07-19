package com.johnsonmima.school.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
    

    


@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})    
public String login(@RequestParam(value = "error", required = false) String error, 
@RequestParam(value = "logout", required = false) String logout,   Model model) {


String errorMessage = null;

if(error != null){
errorMessage = "Invalid username or Password";
}


if(logout != null){
errorMessage = "Logged out :)";
}


model.addAttribute("response", errorMessage);



    return "login.html";
}



// Logout 

@RequestMapping(value = "/logout", method = {RequestMethod.GET})
public String logoutPage(HttpServletRequest request, HttpServletResponse response){

Authentication auth = SecurityContextHolder.getContext().getAuthentication();

if(auth != null){
    new SecurityContextLogoutHandler().logout(request, response, auth);
}

    return "redirect:/login?logout=true";
}

}
