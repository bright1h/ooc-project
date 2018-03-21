package com.mapringg.bab.services;

import com.mapringg.bab.models.Customer;

import java.util.List;

/**
 * @author mapring
 */
public interface CustomerService {

    List<Customer> getGuests();

    List<Customer> getUsers();

    List<Customer> getAdmins();

    List<Customer> getUsersByEmail(String email);

}
