package com.mapringg.bab.repositories;

import com.mapringg.bab.models.Customer;
import com.mapringg.bab.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    boolean existsByEmail(String email);
}
