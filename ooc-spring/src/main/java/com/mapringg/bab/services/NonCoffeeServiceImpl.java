package com.mapringg.bab.services;

import com.mapringg.bab.models.Menu;
import com.mapringg.bab.models.NonCoffee;
import com.mapringg.bab.repositories.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mapring
 */
@Service
public class NonCoffeeServiceImpl implements NonCoffeeService {

    private MenuRepository menuRepository;

    public NonCoffeeServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> getNonCoffees() {
        List<Menu> nonCoffeeList = new ArrayList<>();
        for (Menu menu : menuRepository.findAll()) {
            if (menu.getMenuType() instanceof NonCoffee) {
                nonCoffeeList.add(menu);
            }
        }
        return nonCoffeeList;
    }
}
