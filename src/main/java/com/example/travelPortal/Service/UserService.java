package com.example.travelPortal.Service;

import com.example.travelPortal.Repository.UserRepo;
import com.example.travelPortal.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User addUser(User user){
       return userRepo.save(user);
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public User getUserById(Long id){
        return userRepo.findById(id).orElseThrow(()-> new RuntimeException("No user id found"));
    }


}
