package com.mapringg.bab.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mapringg.bab.models.Dessert;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.repositories.MenuRepository;
import com.mapringg.bab.repositories.MenuTypeRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mapring
 */
@Service
public class DessertServiceImpl implements DessertService {

    private MenuRepository menuRepository;
    private MenuTypeRepository menuTypeRepository;

    public DessertServiceImpl(MenuRepository menuRepository, MenuTypeRepository menuTypeRepository) {
        this.menuRepository = menuRepository;
        this.menuTypeRepository = menuTypeRepository;
    }

    @Override
    public List<Menu> list() {
        List<Menu> dessertList = new ArrayList<>();
        for (Menu menu : menuRepository.findAll()) {
            if (menu.getMenuType() instanceof Dessert) {
                dessertList.add(menu);
            }
        }
        return dessertList;
    }

    @Override
    public Menu add(String json) {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.STATIC)
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        Dessert dessert = new Dessert();
        menuTypeRepository.save(dessert);
        Menu menu = gson.fromJson(json, Menu.class);
        menu.setMenuType(dessert);
        menuRepository.save(menu);
        return menu;
    }
}
