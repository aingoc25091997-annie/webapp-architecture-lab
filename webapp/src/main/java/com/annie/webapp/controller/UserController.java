package com.annie.webapp.controller;

import com.annie.webapp.model.User;
import com.annie.webapp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public int registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User userRequest) {
        Optional<User> userOptional = userRepository.findByUser(userRequest.getUsername());
        if (userOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User ko ton tai");
        }

        User user = userOptional.get();

        if (user.getPassword().equals(userRequest.getPassword())){
            return ResponseEntity.ok("Login success, welcome: " + user.getLastname());
        } else {
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sai mat khau");
        }
    }
}