package com.mapringg.bab.repositories;

import com.mapringg.bab.models.MenuType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mapring
 */
@Repository
public interface MenuTypeRepository extends CrudRepository<MenuType, Long> {
}
