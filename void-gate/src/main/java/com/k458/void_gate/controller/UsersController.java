package com.k458.void_gate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.k458.void_gate.model.User;
import com.k458.void_gate.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll()
    {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id)
    {
        User userById = userService.getUserById(id);
        if (userById == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new User());
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
        User userById = userService.getUserById(user.getId());
        if (userById == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new User());
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id)
    {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
