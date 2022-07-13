package com.johnsonmima.school.service;




// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.johnsonmima.school.model.Contact;

import lombok.extern.slf4j.Slf4j;


@Slf4j // generates log
@Service
//@RequestScope  // creates a new bean instance everytime
//@SessionScope    // use the same bean instance everytime
//@ApplicationScope  // only one instace is created and available in the spring framework

public class ContactService {

    // log instance
    //private static Logger log = LoggerFactory.getLogger(ContactService.class);
    
// save db

public boolean isSaved(Contact contact){

boolean isSavedToDB = false;

log.info(contact.toString());

return isSavedToDB;

}


}
