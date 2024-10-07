package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.Entity.UserEntity;
import org.example.dto.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService Service;



    @GetMapping("/get-all-users")
    public List<UserEntity> getAllUsers() {
        return Service.getAllUsers();
    }

    @PostMapping("/add-user")
    public void addUser(@RequestBody User user) {
        Service.addUser(user);
    }
}
