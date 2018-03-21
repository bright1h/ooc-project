package com.mapringg.bab.repositories;

import com.mapringg.bab.models.Customer;
import com.mapringg.bab.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author bright
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findAllByEmail(String email);

}
