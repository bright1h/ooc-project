package com.mapringg.bab.services;

import com.mapringg.bab.models.Coffee;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.repositories.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mapring
 */
@Service
public class CoffeeServiceImpl implements CoffeeService {

    private MenuRepository menuRepository;

    public CoffeeServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> getCoffees() {
        List<Menu> coffeeList = new ArrayList<>();
        for (Menu menu : menuRepository.findAll()) {
            if (menu.getMenuType() instanceof Coffee) {
                coffeeList.add(menu);
            }
        }
        return coffeeList;
    }
}
