package com.mapringg.bab.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mapringg.bab.deserializers.UpdateNonDrinkDeserializer;
import com.mapringg.bab.models.MainDish;
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
public class MainDishServiceImpl implements MainDishService {

    private MenuRepository menuRepository;
    private MenuTypeRepository menuTypeRepository;

    public MainDishServiceImpl(MenuRepository menuRepository, MenuTypeRepository menuTypeRepository) {
        this.menuRepository = menuRepository;
        this.menuTypeRepository = menuTypeRepository;
    }

    @Override
    public List<Menu> list() {
        List<Menu> mainDishList = new ArrayList<>();
        for (Menu menu : menuRepository.findAll()) {
            if (menu.getMenuType() instanceof MainDish) {
                mainDishList.add(menu);
            }
        }
        return mainDishList;
    }

    @Override
    public Menu add(String json) {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.STATIC)
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        MainDish mainDish = new MainDish();
        menuTypeRepository.save(mainDish);
        Menu menu = gson.fromJson(json, Menu.class);
        menu.setMenuType(mainDish);
        menuRepository.save(menu);
        return menu;
    }

    @Override
    public Menu update(String json) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Menu.class, new UpdateNonDrinkDeserializer(menuTypeRepository, menuRepository))
                .create();
        return gson.fromJson(json, Menu.class);
    }
}
