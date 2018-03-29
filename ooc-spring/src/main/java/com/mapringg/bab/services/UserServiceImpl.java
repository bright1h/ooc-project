package com.mapringg.bab.services;

import com.google.gson.Gson;
import com.mapringg.bab.models.Customer;
import com.mapringg.bab.models.User;
import com.mapringg.bab.models.UserType;
import com.mapringg.bab.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mapring
 */
@Service
public class UserServiceImpl implements UserService {

    private CustomerRepository customerRepository;

    public UserServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> list() {
        List<Customer> userList = new ArrayList<>();
        for (Customer customer : customerRepository.findAll()) {
            if (customer instanceof User) {
                userList.add(customer);
            }
        }
        return userList;
    }

    @Override
    public Customer add(String json) {
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        user.setUserType(UserType.USER);
        customerRepository.save(user);
        return user;
    }
}
