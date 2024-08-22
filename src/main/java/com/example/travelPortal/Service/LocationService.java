package com.example.travelPortal.Service;

import com.example.travelPortal.Repository.LocationRepo;
import com.example.travelPortal.Repository.UserRepo;
import com.example.travelPortal.entity.Location;
import com.example.travelPortal.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepo locationRepo;

    public Location addUser(Location user){
        return locationRepo.save(user);
    }

    public List<Location> getAllUser(){
        return locationRepo.findAll();
    }

    public Location getUserById(Long id){
        return locationRepo.findById(id).orElseThrow(()-> new RuntimeException("No user id found"));
    }
}
