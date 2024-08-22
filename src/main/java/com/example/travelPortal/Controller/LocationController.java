package com.example.travelPortal.Controller;

import com.example.travelPortal.Service.LocationService;
import com.example.travelPortal.Service.UserService;
import com.example.travelPortal.entity.Location;
import com.example.travelPortal.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/post")
    public Location addUser(@RequestBody Location user){
        return locationService.addUser(user);
    }

    @GetMapping
    public List<Location> getAllUser(){
        return locationService.getAllUser();
    }

    @GetMapping("/{id}")
    public Location getUserById(@PathVariable Long id){
        return locationService.getUserById(id);
    }
}
