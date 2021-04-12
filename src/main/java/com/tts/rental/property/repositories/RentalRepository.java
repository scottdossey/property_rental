package com.tts.rental.property.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tts.rental.property.models.Rental;

public interface RentalRepository extends CrudRepository<Rental, Long>
{
    //Since this has a single Rental return type
    //It means that it will return one T as per:
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-return-types
    //
    // * A unique entity. Expects the query method to return one result at most. If no result is found, null is returned.
    // More than one result triggers an IncorrectResultSizeDataAccessException       
    Rental findByEmailAddress(String emailAddress);
    
    //If you want to be able to handle duplicate emailAddresses
    //You'd need to have the return type be List<Rental>
}
