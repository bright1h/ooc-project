package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Customer;
import com.mapringg.bab.models.Guest;
import com.mapringg.bab.models.User;
import com.mapringg.bab.models.UserType;
import com.mapringg.bab.repositories.CustomerRepository;
import com.mapringg.bab.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author mapring
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerRepository customerRepository;
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @PostMapping(path = "/users")
    public void createUser(
            @RequestParam String firstName,
            @RequestParam String email,
            @RequestParam String mobilePhone,
            @RequestParam String lastName,
            @RequestParam String password
    ) {
        UserType userType = UserType.USER;
        User user = new User(firstName, email, mobilePhone, lastName, password, userType);
        customerRepository.save(user);
    }

    @PostMapping(path = "/guests")
    public void createGuest(
            @RequestParam String firstName,
            @RequestParam String email,
            @RequestParam String mobilePhone
    ) {
        Guest guest = new Guest(firstName, email, mobilePhone);
        customerRepository.save(guest);
    }

    @GetMapping(path = "/getUsers")
    public Iterable<Customer> getUsers() {
        return customerService.getUsers();
    }

    @GetMapping(path = "/getGuests")
    public Iterable<Customer> getGuests() {
        return customerService.getGuests();
    }

    @GetMapping(path = "/getAdmins")
    public Iterable<Customer> getAdmins() {
        return customerService.getAdmins();
    }
}
