package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.Entity.AdminEntity;
import org.example.dto.AdminSignIn;
import org.example.dto.AdminSignUp;
import org.example.repository.AdminRepository;
import org.example.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public void adminSignUp(AdminSignUp admin) {

        String encodedPassword = passwordEncoder.encode(admin.getPassword());

        AdminEntity entity = new AdminEntity();
        entity.setFullName(admin.getFullName());
        entity.setEmail(admin.getEmail());
        entity.setPassword(encodedPassword);
        adminRepository.save(entity);


        // AdminEntity entity = AdminEntity.builder()
        //    .fullName(admin.getFullName())
        //    .email(admin.getEmail())
        //    .password(admin.getPassword())
        //    .build();
        //adminRepository.save(entity);



        // AdminEntity entity = mapper.map(admin, AdminEntity.class);
        //adminRepository.save(entity);
    }

    @Override
    public void adminSignIn(AdminSignIn admin) {

        AdminEntity adminEntity = adminRepository.findByEmail(admin.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(admin.getPassword(), adminEntity.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }
    }
}
