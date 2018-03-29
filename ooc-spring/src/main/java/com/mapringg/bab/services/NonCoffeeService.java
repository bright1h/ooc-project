package com.mapringg.bab.services;

import com.mapringg.bab.models.Menu;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author mapring
 */
public interface NonCoffeeService {

    List<Menu> list();

    Menu add(@RequestBody String json);
}
