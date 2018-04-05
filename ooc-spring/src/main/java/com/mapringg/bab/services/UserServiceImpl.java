package com.mapringg.bab.services;

import com.google.gson.Gson;
import com.mapringg.bab.models.Customer;
import com.mapringg.bab.models.User;
import com.mapringg.bab.models.UserType;
import com.mapringg.bab.repositories.CustomerRepository;
import com.mapringg.bab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author mapring
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private final Gson gson;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Gson gson) {
        this.userRepository = userRepository;
        this.gson = gson;
    }

    @Override
    public List<Customer> list() {
        List<Customer> userList = new ArrayList<>();
        for (Customer customer : userRepository.findAll()) {
            if (customer instanceof User) {
                userList.add(customer);
            }
        }
        return userList;
    }

    @Override
    public Customer add(String json) {
        User user = gson.fromJson(json, User.class);
        if (userRepository.existsByEmail(user.getEmail())) {
            return null;
        }
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user.setUserType(UserType.USER);
        userRepository.save(user);
        return user;
    }

    @Override
    public Customer getUser(String json) {
        User user = gson.fromJson(json, User.class);
        if (!userRepository.existsByEmail(user.getEmail())) {
            return null;
        }
        return userRepository.findByEmail(user.getEmail());
    }

    public User editUser(String json) {
        User user = gson.fromJson(json, User.class);
        User userFromDB = userRepository.findUserById(user.getId());
        userFromDB.setFirstName(user.getFirstName());
        userFromDB.setLastName(user.getLastName());
        userFromDB.setMobilePhone(user.getMobilePhone());
        userFromDB.setEmail(user.getEmail());
        userRepository.save(userFromDB);
        return userFromDB;
    }
}
