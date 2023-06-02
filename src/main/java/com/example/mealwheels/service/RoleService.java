package com.example.mealwheels.service;

import com.example.mealwheels.dao.RoleDao;
import com.example.mealwheels.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }

}
