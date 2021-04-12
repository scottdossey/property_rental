package com.tts.rental.property.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Rental
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Size(min=2, max=30)
    private String customerFirstName;
    
    @Size(min=2, max=30)
    private String customerLastName;
    
    @Email
    private String emailAddress;
    
    @CreditCardNumber
    private String creditCardNumber;
    
    @Digits(integer=3, fraction=2)
    private double cost;
    
    @PastOrPresent
    private Date rentalDate;
}
