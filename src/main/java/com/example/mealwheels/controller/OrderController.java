package com.example.mealwheels.controller;

import com.example.mealwheels.dao.OrderDao;
import com.example.mealwheels.dao.UserDao;
import com.example.mealwheels.entity.Order;
import com.example.mealwheels.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao; // Assuming you have a UserDao or UserRepository

    @PostMapping("/createFoodOrder")
    @PreAuthorize("hasRole('User')")
    Order order(@RequestBody Order order, Authentication authentication) {
        String currentUsername = authentication.getName();

        // Retrieve the current user details from the database based on the username
        User currentUser = userDao.findByUserName(currentUsername); // Assuming you have a method to find user by username in your UserDao or UserRepository

        // Assign the current user as the owner of the fund
        order.setUser(currentUser);

        return orderDao.save(order);
    }
}
