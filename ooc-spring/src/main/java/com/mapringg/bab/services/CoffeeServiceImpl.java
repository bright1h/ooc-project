package com.mapringg.bab.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mapringg.bab.deserializers.AddCoffeeDeserializer;
import com.mapringg.bab.deserializers.UpdateDrinkDeserializer;
import com.mapringg.bab.models.Coffee;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.repositories.MenuRepository;
import com.mapringg.bab.repositories.MenuTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mapring
 */
@Service
public class CoffeeServiceImpl implements CoffeeService {

    private MenuRepository menuRepository;
    private MenuTypeRepository menuTypeRepository;

    public CoffeeServiceImpl(MenuRepository menuRepository, MenuTypeRepository menuTypeRepository) {
        this.menuRepository = menuRepository;
        this.menuTypeRepository = menuTypeRepository;
    }

    @Override
    public List<Menu> list() {
        List<Menu> coffeeList = new ArrayList<>();
        for (Menu menu : menuRepository.findAll()) {
            if (menu.getMenuType() instanceof Coffee) {
                coffeeList.add(menu);
            }
        }
        return coffeeList;
    }

    @Override
    public Menu add(String json) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Menu.class, new AddCoffeeDeserializer(menuTypeRepository))
                .create();
        Menu menu = gson.fromJson(json, Menu.class);
        menuRepository.save(menu);
        return menu;
    }

    @Override
    public Menu update(String json) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Menu.class, new UpdateDrinkDeserializer(menuTypeRepository, menuRepository))
                .create();
        return gson.fromJson(json, Menu.class);
    }
}
