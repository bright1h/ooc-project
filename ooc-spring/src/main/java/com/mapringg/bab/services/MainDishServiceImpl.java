package com.mapringg.bab.services;

import com.mapringg.bab.models.MainDish;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.repositories.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mapring
 */
@Service
public class MainDishServiceImpl implements MainDishService {

    private MenuRepository menuRepository;

    public MainDishServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> getMainDishes() {
        List<Menu> mainDishList = new ArrayList<>();
        for (Menu menu : menuRepository.findAll()) {
            if (menu.getMenuType() instanceof MainDish) {
                mainDishList.add(menu);
            }
        }
        return mainDishList;
    }
}
