package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.Entity.UserEntity;
import org.example.dto.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addUser(@RequestBody User user) {
        Service.addUser(user);
        return ResponseEntity.ok("User added successfully");

    }

    @GetMapping("/get-user/{id}")
    public UserEntity getUserById(@PathVariable("id") Long id) {
        return Service.getUserById(id);
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        Service.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @GetMapping("/find-user/{userName}")
    public User findByUserName(@PathVariable String userName) {
        return Service.findByUserName(userName);
    }

    @GetMapping("/exist-user/{userName}")
    public boolean existUser(@PathVariable String userName) {
        return Service.existUser(userName);
    }


}
