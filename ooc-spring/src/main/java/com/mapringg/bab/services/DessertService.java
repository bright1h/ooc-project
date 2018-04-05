package com.mapringg.bab.services;

import com.mapringg.bab.models.Menu;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author mapring
 */
public interface DessertService {

    List<Menu> list();

    Menu add(@RequestBody String json);

    Menu update(@RequestBody String json);
}
