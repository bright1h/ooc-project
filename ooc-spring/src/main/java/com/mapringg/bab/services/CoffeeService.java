package com.mapringg.bab.services;

import com.mapringg.bab.models.Menu;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author mapring
 */
public interface CoffeeService {

    Menu add(@RequestBody String json);

    List<Menu> list();
}
