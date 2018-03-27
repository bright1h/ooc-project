package com.mapringg.bab.controllers;

import com.mapringg.bab.jsons.AuthenticateStatus;
import com.mapringg.bab.jsons.LoginForm;
import com.mapringg.bab.models.User;
import com.mapringg.bab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final UserRepository userRepository;

    @Autowired
    public AuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping
    public AuthenticateStatus authenticated(@RequestBody LoginForm loginForm) {
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();


        User user = userRepository.findUserByEmail(email);

        String hashedPassword = user.getPassword();

        AuthenticateStatus authenticateStatus = new AuthenticateStatus();

        if (BCrypt.checkpw(password, hashedPassword)) {
            authenticateStatus.setLoginSuccess(true);
            authenticateStatus.setUserType(user.getUserType());
        }
        else {
            authenticateStatus.setLoginSuccess(false);
        }

        return authenticateStatus;
    }

}
