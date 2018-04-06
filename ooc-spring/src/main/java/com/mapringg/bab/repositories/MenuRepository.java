package com.mapringg.bab.repositories;

import com.mapringg.bab.models.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author mapring
 */
@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {

    Optional<Menu> findByName(String name);

    Optional<Menu> findByMenuType_Id(Long id);

    Menu findMenuByName(String name);
}
