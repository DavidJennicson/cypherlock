package com.example.cypher.service;

import com.example.cypher.ent.UserEntity;
import com.example.cypher.service.impl.UserExistsException;
import com.example.cypher.response.Response;
import java.util.List;
import java.util.Optional;

public interface  UserService {
    List<UserEntity> findAllUsers();
    Optional<UserEntity> findbyId(Long id);
    Response saveUser(UserEntity userEntity) throws UserExistsException;
    UserEntity updateUser(UserEntity userEntity);
    void deleteUser(Long id);

}
