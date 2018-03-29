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
public class AdminServiceImpl implements AdminService {

    private CustomerRepository customerRepository;

    public AdminServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> list() {
        List<Customer> adminList = new ArrayList<>();
        for (Customer customer : customerRepository.findAll()) {
            if (customer instanceof User && ((User) customer).getUserType() == UserType.ADMIN) {
                adminList.add(customer);
            }
        }
        return adminList;
    }

    @Override
    public Customer add(String json) {
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        user.setUserType(UserType.ADMIN);
        customerRepository.save(user);
        return user;
    }
}
