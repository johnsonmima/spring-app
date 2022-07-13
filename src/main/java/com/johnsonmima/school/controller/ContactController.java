package com.johnsonmima.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.johnsonmima.school.model.Contact;
import com.johnsonmima.school.service.ContactService;

@Controller
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }
    
    @RequestMapping(value = {"contact"})
    public String contactUS(Model model){
        model.addAttribute("title", "Contact Us");
        return "contact.html";
    }
    // sendMessage

    @PostMapping(value = "/sendMessage")
    public ModelAndView saveMessage(Contact contact){
        // save to db
        boolean saved = contactService.isSaved(contact);
        
        return new ModelAndView("redirect:/contact");
    }
}
