package com.mapringg.bab.services;

import com.google.gson.Gson;
import com.mapringg.bab.models.Customer;
import com.mapringg.bab.models.Guest;
import com.mapringg.bab.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mapring
 */
@Service
public class GuestServiceImpl implements GuestService {

    private CustomerRepository customerRepository;

    public GuestServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> list() {
        List<Customer> guestList = new ArrayList<>();
        for (Customer customer : customerRepository.findAll()) {
            if (customer instanceof Guest) {
                guestList.add(customer);
            }
        }
        return guestList;
    }

    @Override
    public Customer add(String json) {
        Gson gson = new Gson();
        Guest guest = gson.fromJson(json, Guest.class);
        customerRepository.save(guest);
        return guest;
    }
}
