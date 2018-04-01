package com.mapringg.bab.services;

<<<<<<< HEAD
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mapringg.bab.deserializers.CoffeeDeserializer;
import com.mapringg.bab.models.Coffee;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.repositories.MenuRepository;
import com.mapringg.bab.repositories.MenuTypeRepository;
=======
import com.mapringg.bab.models.Coffee;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.repositories.MenuRepository;
>>>>>>> origin/register
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mapring
 */
@Service
public class CoffeeServiceImpl implements CoffeeService {

    private MenuRepository menuRepository;
<<<<<<< HEAD
    private MenuTypeRepository menuTypeRepository;

    public CoffeeServiceImpl(MenuRepository menuRepository, MenuTypeRepository menuTypeRepository) {
        this.menuRepository = menuRepository;
        this.menuTypeRepository = menuTypeRepository;
    }

    @Override
    public List<Menu> list() {
=======

    public CoffeeServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> getCoffees() {
>>>>>>> origin/register
        List<Menu> coffeeList = new ArrayList<>();
        for (Menu menu : menuRepository.findAll()) {
            if (menu.getMenuType() instanceof Coffee) {
                coffeeList.add(menu);
            }
        }
        return coffeeList;
    }
<<<<<<< HEAD

    @Override
    public Menu add(String json) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Menu.class, new CoffeeDeserializer(menuTypeRepository))
                .create();
        Menu menu = gson.fromJson(json, Menu.class);
        menuRepository.save(menu);
        return menu;
    }
=======
>>>>>>> origin/register
}
