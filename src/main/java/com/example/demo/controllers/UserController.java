package com.example.demo.controllers;


import com.example.demo.entity.User;
import com.example.demo.entity.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<User> getUser() {
        return userService.getUser();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping()
    public ResponseEntity<Long> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }



    @PutMapping()
    public ResponseEntity<Long> updateUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(userDTO));
    }


}
