package com.in28minutes.rest.webservices.restful_web_services.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.rest.webservices.restful_web_services.User.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    // This interface will automatically provide CRUD operations for User entities
    // The JpaRepository interface provides methods like save, findById, findAll,
    // deleteById, etc.
    // No additional code is needed here as Spring Data JPA will implement the
    // methods at runtime

}