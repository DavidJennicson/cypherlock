package com.example.cypher.controllers;

import com.example.cypher.ent.UserEntity;
import com.example.cypher.response.Response;
import com.example.cypher.service.UserService;

import com.example.cypher.service.impl.UserExistsException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public List<UserEntity> findAll()
    {
        return userService.findAllUsers();
    }
    @GetMapping("/find/{id}")
    public Optional<UserEntity>  findbyId(@PathVariable("id") Long id)
    {
        return userService.findbyId(id);
    }
    @PostMapping("/save")
    public Response saveUser(@RequestBody UserEntity userEntity) throws UserExistsException {return userService.saveUser(userEntity); }
    @PutMapping("/update")
    public UserEntity updateUser(@RequestBody  UserEntity userEntity)
    {
        return userService.updateUser(userEntity);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id)
    {
        userService.deleteUser(id);
    }
}
