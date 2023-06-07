package com.example.cypher.service.impl;
import java.io.File;
import com.example.cypher.ent.UserEntity;
import com.example.cypher.repo.UserRepo;
import com.example.cypher.response.Response;
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
    public Response saveUser(UserEntity userEntity) throws UserExistsException {
        List <UserEntity> data=userRepo.findAll();
        for(UserEntity userEntityelement:data)
        {
            System.out.println(userEntityelement.getUsername());
            if (String.valueOf(userEntityelement.getUsername()).equals(String.valueOf(userEntity.getUsername())))
            {
                Response myResponse=new Response("User already exists",400);
                return myResponse;
            }


        }
        Response myResponse=new Response("User created successfully",200);
        userRepo.save(userEntity);
        Long id =Long.valueOf(userRepo.findIdByUsername(userEntity.getUsername()));
        File f1=new File("storage\\"+String.valueOf(id));
        boolean bool=f1.mkdir();
        if(bool)
        {
            System.out.println("Successfully created");
        }
        else
        {
            System.out.println("Error");
        }
        return myResponse ;
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
