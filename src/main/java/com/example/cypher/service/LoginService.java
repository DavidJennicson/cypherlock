package com.example.cypher.service;
import com.example.cypher.ent.UserEntity;

import java.security.NoSuchAlgorithmException;

public interface LoginService {
public String Login(UserEntity userEntity) throws NoSuchAlgorithmException;
}
