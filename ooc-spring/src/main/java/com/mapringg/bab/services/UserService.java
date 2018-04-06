package com.mapringg.bab.services;

import com.mapringg.bab.models.Customer;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author mapring
 */
public interface UserService {

    List<Customer> list();

    Customer add(@RequestBody String json);

    Customer getUser(String json);

    Customer findByEmail(String email);
}