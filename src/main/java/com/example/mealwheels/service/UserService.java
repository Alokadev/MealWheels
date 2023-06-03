package com.example.mealwheels.service;


import com.example.mealwheels.dao.RoleDao;
import com.example.mealwheels.dao.UserDao;
import com.example.mealwheels.entity.Role;
import com.example.mealwheels.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        Role donorRole = new Role();
        donorRole.setRoleName("Donor");
        donorRole.setRoleDescription("Donor related users");
        roleDao.save(donorRole);

        Role careRole = new Role();
        careRole.setRoleName("Care");
        careRole.setRoleDescription("Care related users");
        roleDao.save(careRole);

        Role partnerRole = new Role();
        partnerRole.setRoleName("Partner");
        partnerRole.setRoleDescription("Partner related users");
        roleDao.save(partnerRole);

        Role riderRole = new Role();
        riderRole.setRoleName("Rider");
        riderRole.setRoleDescription("Rider related users");
        roleDao.save(riderRole);

        User adminUser = new User();
        adminUser.setUserName("admin");
        adminUser.setUserPassword(getEncodedPassword("admin"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setEnabled(true);
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User user = new User();
        user.setUserName("aloka");
        user.setUserPassword(getEncodedPassword("aloka"));
        user.setUserFirstName("Aloka");
        user.setUserLastName("Devapriya");
        user.setEnabled(true);
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);

        User care = new User();
        care.setUserName("careuser");
        care.setUserPassword(getEncodedPassword("care"));
        care.setUserFirstName("Care");
        care.setUserLastName("Devapriya");
        care.setEnabled(true);
        Set<Role> careRoles = new HashSet<>();
        careRoles.add(careRole);
        care.setRole(careRoles);
        userDao.save(care);
    }

    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userDao.save(user);
    }

    public User registerNewDonor(User user) {
        Role role = roleDao.findById("Donor").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }

    public User registerNewAdmin(User user) {
        Role role = roleDao.findById("Admin").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }

    public User registerNewCare(User user) {
        Role role = roleDao.findById("Care").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }

    public User registerNewPartner(User user) {
        Role role = roleDao.findById("Partner").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }

    public User registerNewRider(User user) {
        Role role = roleDao.findById("Rider").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

}
