package com.johnsonmima.school.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.johnsonmima.school.model.Contact;
import com.johnsonmima.school.service.ContactService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

        // first send a new contact object which will be used for validation
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }
    // sendMessage

    @PostMapping(value = "/sendMessage")
    public String saveMessage(@Valid @ModelAttribute(name = "contact") Contact contact, Errors errors){
        

        if(errors.hasErrors()){
            log.error("Form errors" + errors.toString());
            return "contact.html";

        }

        // save to db
        boolean saved = contactService.isSaved(contact);
        
        return "redirect:/contact";
    }
}
