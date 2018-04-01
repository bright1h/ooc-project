package com.mapringg.bab.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mapringg.bab.deserializers.NonCoffeeDeserializer;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.models.NonCoffee;
import com.mapringg.bab.repositories.MenuRepository;
import com.mapringg.bab.repositories.MenuTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mapring
 */
@Service
public class NonCoffeeServiceImpl implements NonCoffeeService {

    private MenuRepository menuRepository;
    private MenuTypeRepository menuTypeRepository;

    public NonCoffeeServiceImpl(MenuRepository menuRepository, MenuTypeRepository menuTypeRepository) {
        this.menuRepository = menuRepository;
        this.menuTypeRepository = menuTypeRepository;
    }

    @Override
    public List<Menu> list() {
        List<Menu> nonCoffeeList = new ArrayList<>();
        for (Menu menu : menuRepository.findAll()) {
            if (menu.getMenuType() instanceof NonCoffee) {
                nonCoffeeList.add(menu);
            }
        }
        return nonCoffeeList;
    }

    @Override
    public Menu add(String json) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Menu.class, new NonCoffeeDeserializer(menuTypeRepository))
                .create();
        Menu menu = gson.fromJson(json, Menu.class);
        menuRepository.save(menu);
        return menu;
    }
}
