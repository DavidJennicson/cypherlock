package com.example.cypher.service.impl;

import com.example.cypher.ent.UserEntity;
import com.example.cypher.repo.UserRepo;
import com.example.cypher.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<UserEntity> findbyId(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userRepo.save(userEntity);
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        return userRepo.save(userEntity);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }


}
