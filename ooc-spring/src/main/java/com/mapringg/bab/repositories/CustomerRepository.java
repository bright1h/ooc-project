package com.mapringg.bab.repositories;

import com.mapringg.bab.models.Customer;
import com.mapringg.bab.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mapring
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    User findByEmail(String email);
}
