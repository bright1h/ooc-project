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
    public ResponseEntity<String> add(@RequestBody String json) {
        if (userService.add(json) == null) {
            return ResponseEntity.badRequest().body("Email already exist");
        }
        else {
            return ResponseEntity.ok("Registered");
        }
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody String json) {
        User user = (User) userService.getUser(json);
        LoginResponse loginResponse = new LoginResponse();
        if (user == null) {
            loginResponse.setMessage("error");
        }
        else {
            loginResponse.setId(user.getId());
            loginResponse.setUserType(user.getUserType().toString());
            loginResponse.setMessage("success");
        }
        return loginResponse;
    }

    @GetMapping("/all")
    public Iterable<Customer> findAll() {
        return userService.list();
    }
}
