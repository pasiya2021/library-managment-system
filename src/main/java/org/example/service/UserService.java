package org.example.service;

import org.example.Entity.UserEntity;
import org.example.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<UserEntity> getAllUsers();

    void addUser(User user);

    UserEntity getUserById(Long id);

    void deleteUser(Long id);

    User findByUserName(String userName);

    boolean existUser(String userName);
}
