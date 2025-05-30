package com.in28minutes.rest.webservices.restful_web_services.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.rest.webservices.restful_web_services.User.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
    // This interface extends JpaRepository to provide CRUD operations for Post
    // entity
    // No additional methods are needed as JpaRepository provides all necessary
    // methods
}