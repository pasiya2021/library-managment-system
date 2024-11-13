package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.dto.AdminSignIn;
import org.example.dto.AdminSignUp;
import org.example.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {


    private final AdminService adminService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> adminSignUp(@RequestBody AdminSignUp admin) {

        adminService.adminSignUp(admin);
        return ResponseEntity.ok("Admin signed up successfully");
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> adminSignIn(@RequestBody AdminSignIn admin) {

        adminService.adminSignIn(admin);
        return ResponseEntity.ok("Admin signed in successfully");

    }
}
