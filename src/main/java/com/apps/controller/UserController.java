package com.apps.controller;

import com.apps.dto.UserDto;
import com.apps.entity.User;
import com.apps.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // Save from frontend
    @PostMapping
    public User saveUser(@Valid @RequestBody UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        return service.saveUser(user);
    }

    // Fetch to frontend
    @GetMapping
    public List<User> getUsers() {
        return service.getAllUsers();
    }
}
