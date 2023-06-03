package com.example.mealwheels.controller;

import com.example.mealwheels.dao.FundDao;
import com.example.mealwheels.dao.UserDao;
import com.example.mealwheels.entity.Fund;
import com.example.mealwheels.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.core.Authentication;

@RestController
public class FundController {

    @Autowired
    private FundDao fundDao;

    @Autowired
    private UserDao userDao; // Assuming you have a UserDao or UserRepository

    @PostMapping("/createNewFund")
    @PreAuthorize("hasRole('Donor')")
    Fund newFund(@RequestBody Fund newFund, Authentication authentication) {
        String currentUsername = authentication.getName();

        // Retrieve the current user details from the database based on the username
        User currentUser = userDao.findByUserName(currentUsername); // Assuming you have a method to find user by username in your UserDao or UserRepository

        // Assign the current user as the owner of the fund
        newFund.setUser(currentUser);

        return fundDao.save(newFund);
    }
}
