package com.mapringg.bab.repositories;

import com.mapringg.bab.models.Customer;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author mapring
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String email);

    List<Customer> findAllByEmail(String email);
}
