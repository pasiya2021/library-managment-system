package org.example.service;

import org.example.dto.AdminSignIn;
import org.example.dto.AdminSignUp;

public interface AdminService {
    void adminSignUp(AdminSignUp admin);

    void adminSignIn(AdminSignIn admin);
}
