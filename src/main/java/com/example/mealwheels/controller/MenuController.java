package com.example.mealwheels.controller;

import com.example.mealwheels.dao.MenuDao;
import com.example.mealwheels.dao.UserDao;
import com.example.mealwheels.entity.Menu;
import com.example.mealwheels.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private UserDao userDao; // Assuming you have a UserDao or UserRepository

    @PostMapping("/createFoodBatch")
    @PreAuthorize("hasRole('Partner')")
    Menu menu(@RequestBody Menu menu, Authentication authentication) {
        String currentUsername = authentication.getName();

        // Retrieve the current user details from the database based on the username
        User currentUser = userDao.findByUserName(currentUsername); // Assuming you have a method to find user by username in your UserDao or UserRepository

        // Assign the current user as the owner of the fund
        menu.setUser(currentUser);

        return menuDao.save(menu);
    }

}
