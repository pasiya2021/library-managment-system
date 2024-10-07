package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.Entity.UserEntity;
import org.example.dto.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository Repository;

    private final ModelMapper mapper;


//    @Bean
//    public void setsup() {
//        this.mapper = new ModelMapper();
//    }

    @Override
    public List<UserEntity> getAllUsers() {
       return Repository.findAll();
    }

    @Override
    public void addUser(User user) {

        UserEntity entity = mapper.map(user,UserEntity.class);
        Repository.save(entity);

//        UserEntity userEntity = new UserEntity();
//        userEntity.setFirstName(user.getFirstName());
//        userEntity.setLastName(user.getLastName());
//        userEntity.setUserName(user.getUserName());
//        userEntity.setEmail(user.getEmail());
//        userEntity.setAddress(user.getAddress());
//        userEntity.setAddress2(user.getAddress2());
//        userEntity.setCountry(user.getCountry());
//        userEntity.setPhoneNumber(user.getPhoneNumber());
//        Repository.save(userEntity);
    }

    @Override
    public UserEntity getUserById(Long id) {
        return Repository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
            Repository.deleteById(id);
    }

    @Override
    public User findByUserName(String userName) {
        return mapper.map(Repository.findByUserName(userName),User.class);
    }

    @Override
    public boolean existUser(String userName) {
        return Repository.existsUserByUserName(userName);
    }
}
