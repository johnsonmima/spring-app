package com.johnsonmima.school.service;




// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.johnsonmima.school.model.Contact;

import lombok.extern.slf4j.Slf4j;


@Slf4j // generates log
@Service
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
