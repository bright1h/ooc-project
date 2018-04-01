package com.mapringg.bab.repositories;

import com.mapringg.bab.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author mapring
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByEmail(String email);

    List<Customer> findAllByEmail(String email);
}
