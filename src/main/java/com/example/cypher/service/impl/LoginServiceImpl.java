package com.example.cypher.service.impl;
import com.example.cypher.enc.SHA512;

import com.example.cypher.ent.UserEntity;
import com.example.cypher.repo.LoginRepo;
import com.example.cypher.service.LoginService;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
@Service
public class LoginServiceImpl implements LoginService {
private final LoginRepo loginRepo;

    @Override
    public String Login(UserEntity userEntity) throws NoSuchAlgorithmException {
        String psw= String.valueOf(loginRepo.findPasswordByUsername(String.valueOf(userEntity.getUsername())));

        Boolean res=SHA512.verifySHA512(psw,SHA512.encryptSHA512(String.valueOf(userEntity.getPassword())));
        System.out.println(psw+" "+res+" "+String.valueOf(userEntity.getUsername()));
        if (res==true)
        {
            return "Password matches";
        }
        else
        {
            return "Error in matching";
        }
    }

    public LoginServiceImpl(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;

    }
}
