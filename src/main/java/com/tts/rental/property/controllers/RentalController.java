package com.tts.rental.property.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tts.rental.property.models.Rental;
import com.tts.rental.property.repositories.RentalRepository;

//Annotated with @RestController rather than @Controller.
//What does @RestController do. Well it signifies that this
//controller is going to be used for API. But Specifically
//it means the same thing as a combination of two other 
//annotations:
//    @Controller
//    @ResponseBody
//@Controller you are familiar with. @ResponseBody says that
//the return value from the controller is going to be the actual 
//BODY of the response.

@RestController 
public class RentalController
{    
    @Autowired
    private RentalRepository repository;
    
    @PostMapping("/rentals")
    public ResponseEntity<Void> createRental(@RequestBody @Valid Rental rental, 
                                             BindingResult bindingResult)
    {
        if (repository.findByEmailAddress(rental.getEmailAddress()) != null)
        {
           bindingResult.rejectValue("emailAddress", "error.email", "Email address is already taken");            
        }
        if (bindingResult.hasErrors()) 
        {            
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        repository.save(rental);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }    
}

//if (repository.findByEmailAddress(rental.getEmailAddress()) != null)
//{
//  bindingResult.rejectValue("emailAddress", "error.email", "Email address is already taken");            
//}
