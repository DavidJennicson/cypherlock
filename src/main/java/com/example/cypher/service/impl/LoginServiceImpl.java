package com.example.cypher.service.impl;
import com.example.cypher.enc.SHA512;

import com.example.cypher.ent.UserEntity;
import com.example.cypher.repo.LoginRepo;
import com.example.cypher.response.Response;
import com.example.cypher.service.LoginService;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
@Service
public class LoginServiceImpl implements LoginService {
private final LoginRepo loginRepo;

    @Override
    public Response Login(UserEntity userEntity) throws NoSuchAlgorithmException {
        String psw= String.valueOf(loginRepo.findPasswordByUsername(String.valueOf(userEntity.getUsername())));

        Boolean res=SHA512.verifySHA512(psw,SHA512.encryptSHA512(String.valueOf(userEntity.getPassword())));
        System.out.println(psw+" "+res+" "+String.valueOf(userEntity.getUsername()));
        if (res==true)
        {
            Response myResponse = new Response("Login successful", 200);
            return myResponse;
        }

            Response myResponse = new Response("Username or Password is invalid",400);
            return myResponse;
    }

    public LoginServiceImpl(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;

    }
}
