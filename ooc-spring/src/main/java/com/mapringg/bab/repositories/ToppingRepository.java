package com.mapringg.bab.repositories;

import com.mapringg.bab.models.Topping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mapring
 */
@Repository
public interface ToppingRepository extends CrudRepository<Topping, Long> {
}
