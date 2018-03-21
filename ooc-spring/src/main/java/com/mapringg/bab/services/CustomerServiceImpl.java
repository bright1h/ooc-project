package com.mapringg.bab.services;

import com.mapringg.bab.models.Customer;
import com.mapringg.bab.models.Guest;
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
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getGuests() {
        List<Customer> guestList = new ArrayList<>();
        for (Customer customer : customerRepository.findAll()) {
            if (customer instanceof Guest) {
                guestList.add(customer);
            }
        }
        return guestList;
    }

    @Override
    public List<Customer> getUsers() {
        List<Customer> userList = new ArrayList<>();
        for (Customer customer : customerRepository.findAll()) {
            if (customer instanceof User) {
                userList.add(customer);
            }
        }
        return userList;
    }

    @Override
    public List<Customer> getAdmins() {
        List<Customer> adminList = new ArrayList<>();
        for (Customer customer : customerRepository.findAll()) {
            if (customer instanceof User && ((User) customer).getUserType() == UserType.ADMIN) {
                adminList.add(customer);
            }
        }
        return adminList;
    }

    @Override
    public List<Customer> getUsersByEmail(String email) {
        List<Customer> usersByEmail = new ArrayList<>();
        for (Customer customer : customerRepository.findAllByEmail(email)) {
            if (customer instanceof User && ((User) customer).getUserType() == UserType.USER) {
                usersByEmail.add(customer);
            }
        }
        return usersByEmail;
    }
}