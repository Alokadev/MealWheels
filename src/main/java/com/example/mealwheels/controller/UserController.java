package com.example.mealwheels.controller;

import com.example.mealwheels.entity.User;
import com.example.mealwheels.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/reg/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @PostMapping({"/reg/registerNewDonor"})
    public User registerNewDonor(@RequestBody User user) {
        return userService.registerNewDonor(user);
    }

    @PostMapping({"/reg/registerNewAdmin"})
    public User registerNewAdmin(@RequestBody User user) {
        return userService.registerNewAdmin(user);
    }

    @PostMapping({"/reg/registerNewCare"})
    public User registerNewCare(@RequestBody User user) {
        return userService.registerNewCare(user);
    }

    @PostMapping({"/reg/registerNewPartner"})
    public User registerNewPartner(@RequestBody User user) {
        return userService.registerNewPartner(user);
    }

    @PostMapping({"/reg/registerNewRider"})
    public User registerNewRider(@RequestBody User user) {
        return userService.registerNewRider(user);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }

}
