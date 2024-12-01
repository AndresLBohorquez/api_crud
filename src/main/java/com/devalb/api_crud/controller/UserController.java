package com.devalb.api_crud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devalb.api_crud.entity.User;
import com.devalb.api_crud.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getAll() {
        logger.info("Fetching all users");
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        logger.info("Fetching user with ID: {}", id);
        User user = userService.getById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        logger.info("Adding user: {}", user);
        String response = userService.addUser(user);
        return ResponseEntity.status(201).body(response);
    }

    @PostMapping("/users")
    public ResponseEntity<List<User>> addUsers(@RequestBody List<User> users) {
        logger.info("Adding multiple users: {}", users);
        List<User> savedUsers = userService.addUsers(users);
        return ResponseEntity.status(201).body(savedUsers);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<String> editUser(@PathVariable Long id, @RequestBody User user) {
        logger.info("Editing user with ID: {}", id);
        String response = userService.editUser(id, user);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        logger.info("Deleting user with ID: {}", id);
        String response = userService.deleteUser(id);
        return ResponseEntity.ok(response);
    }
}