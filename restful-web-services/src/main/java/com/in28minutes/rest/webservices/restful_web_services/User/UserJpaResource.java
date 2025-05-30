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

import com.in28minutes.rest.webservices.restful_web_services.jpa.PostRepository;
import com.in28minutes.rest.webservices.restful_web_services.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

    private UserRepository userRepository;

    private PostRepository postRepository;

    // Constructor Injection
    public UserJpaResource(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    // GET /users
    // Retrieve All Users
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        // Use the UserRepository to find all users
        return userRepository.findAll();
    }

    // http://localhost:8080/users
    // GET /users/{id}
    // Retrieve User by ID
    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        // Use the UserRepository to find the user by ID
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("id-" + id));

        // Create an EntityModel for the User
        EntityModel<User> resource = EntityModel.of(user);

        // Add a self link to the User resource
        WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkToUsers.withRel("all-users"));

        return resource;
    }

    // POST /users
    // Create a User
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        userRepository.save(user);
        // Location of the created resource
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // DELETE /users/{id}
    // Delete a User by ID
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        // Use the UserRepository to delete the user by ID
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {
        // Use the UserRepository to find the user by ID
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("id-" + id));

        // Return the list of posts for the user
        return user.getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
        // Use the UserRepository to find the user by ID
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("id-" + id));

        // Set the user for the post
        post.setUser(user);

        // Save the post using PostRepository
        Post savedPost = postRepository.save(post);

        // Location of the created resource
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{postId}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
