package com.example.cypher.service;
import com.example.cypher.ent.UserEntity;
import com.example.cypher.response.Response;

import java.security.NoSuchAlgorithmException;

public interface LoginService {
public Response Login(UserEntity userEntity) throws NoSuchAlgorithmException;
}
