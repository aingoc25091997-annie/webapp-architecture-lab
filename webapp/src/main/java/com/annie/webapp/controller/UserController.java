package com.annie.webapp.controller;

import com.annie.webapp.dto.LoginResponse;
import com.annie.webapp.model.User;
import com.annie.webapp.repository.UserRepository;
import com.annie.webapp.util.JWTTokenProvider;
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
    public ResponseEntity<LoginResponse> loginUser(@RequestBody User userRequest) {
        Optional<User> userOptional = userRepository.findByUser(userRequest.getUsername());

        if (userOptional.isEmpty()){
            LoginResponse failResponse = new LoginResponse("fail", "username ko ton tai");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failResponse);
        }

        User user = userOptional.get();

        if (user.getPassword().equals(userRequest.getPassword())){
            String token = JWTTokenProvider.generateToken(user.getId(), user.getUsername());
            LoginResponse successResponse = new LoginResponse(token, "succes", "Welcome : " + user.getUsername());
            return ResponseEntity.ok(successResponse);
        } else {
            LoginResponse failRespone = new LoginResponse("fail", "Sai mat khau");
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failRespone);
        }
    }
}