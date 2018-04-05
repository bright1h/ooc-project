package com.mapringg.bab.repositories;


import com.mapringg.bab.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    User findUserById(Long id);

    boolean existsByEmail(String email);
}
