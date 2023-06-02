package com.example.cypher.controllers;

import com.example.cypher.ent.UserEntity;
import com.example.cypher.response.Response;
import com.example.cypher.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

 @PostMapping("/")
    public Response Login(@RequestBody UserEntity userEntity) throws NoSuchAlgorithmException {
       return loginService.Login(userEntity);
    }
}
