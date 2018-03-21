package com.mapringg.bab.services;

import com.mapringg.bab.models.Dessert;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.repositories.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mapring
 */
@Service
public class DessertServiceImpl implements DessertService {
    private MenuRepository menuRepository;

    public DessertServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> getDesserts() {
        List<Menu> dessertList = new ArrayList<>();
        for (Menu menu : menuRepository.findAll()) {
            if (menu.getMenuType() instanceof Dessert) {
                dessertList.add(menu);
            }
        }
        return dessertList;
    }
}
