package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Customer;
import com.mapringg.bab.models.User;
import com.mapringg.bab.services.UserService;
import com.mapringg.bab.utils.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author mapring
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(path = "/add")
    public String add(@RequestBody String json) {
        if (userService.add(json) == null) {
            return "fail";
        }
        else {
            return "success";
        }
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody String json) {
        User user = (User) userService.getUser(json);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setEmail(user.getEmail());
        loginResponse.setUserType(user.getUserType().toString());
        return loginResponse;
    }

    @GetMapping("/all")
    public Iterable<Customer> findAll() {
        return userService.list();
    }

    @PostMapping("/find")
    public Customer getUser(@RequestBody String json) {
        Customer user = userService.getUser(json);
        return user;
    }

    @PostMapping("/update")
    public User editUser(@RequestBody String gson) {
        return userService.editUser(gson);
    }
}
