package com.example.mealwheels.controller;

import com.example.mealwheels.dao.CareDao;
import com.example.mealwheels.dao.UserDao;
import com.example.mealwheels.entity.CareRequest;
import com.example.mealwheels.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CareController {

    @Autowired
    private CareDao careDao;

    @Autowired
    private UserDao userDao;

    @PostMapping("/careRequest")
    @PreAuthorize("hasRole('User')")
    CareRequest careRequest(@RequestBody CareRequest careRequest, Authentication authentication) {
        String currentUsername = authentication.getName();
        User currentUser = userDao.findByUserName(currentUsername);
        careRequest.setUser(currentUser);
        return careDao.save(careRequest);
    }

//    @PostMapping("/careRequest")
//    @PreAuthorize("hasRole('User')")
//    CareRequest careRequest(@RequestBody CareRequest careRequest) {
//        return careDao.save(careRequest);
//    }
}
