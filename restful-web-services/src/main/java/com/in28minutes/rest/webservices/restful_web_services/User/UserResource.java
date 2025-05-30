package com.in28minutes.rest.webservices.restful_web_services.User;

import java.net.URI;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

    private UserDaoService service;

    // Constructor Injection
    public UserResource(UserDaoService service) {
        this.service = service;
    }

    // GET /users
    // Retrieve All Users
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    // http://localhost:8080/users
    // EntityModel<User> - Used to represent a single User resource
    // WebMvcLinkBuilder - Used to add links to the User resource

    // GET /users/{id}
    // Retrieve User by ID
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }
        // Create an EntityModel for the User
        EntityModel<User> entityModel = EntityModel.of(user);
        // Add a link to the User resource itself
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        // Add a link to delete the User
        entityModel.add(link.withRel("all-users"));

        // Add a link to create a new User
        return entityModel;
    }

    // POST /users
    // Create a User
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        service.save(user);
        // Location of the created resource
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // DELETE /users/{id}
    // Delete a User by ID
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }

}
