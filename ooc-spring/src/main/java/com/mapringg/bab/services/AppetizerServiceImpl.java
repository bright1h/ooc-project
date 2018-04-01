package com.mapringg.bab.services;

<<<<<<< HEAD
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mapringg.bab.models.Appetizer;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.repositories.MenuRepository;
import com.mapringg.bab.repositories.MenuTypeRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Modifier;
=======
import com.mapringg.bab.models.Appetizer;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.repositories.MenuRepository;
import org.springframework.stereotype.Service;

>>>>>>> origin/register
import java.util.ArrayList;
import java.util.List;

/**
 * @author mapring
 */
@Service
public class AppetizerServiceImpl implements AppetizerService {

    private MenuRepository menuRepository;
<<<<<<< HEAD
    private MenuTypeRepository menuTypeRepository;

    public AppetizerServiceImpl(MenuRepository menuRepository, MenuTypeRepository menuTypeRepository) {
        this.menuRepository = menuRepository;
        this.menuTypeRepository = menuTypeRepository;
    }

    @Override
    public List<Menu> list() {
        List<Menu> appetizerList = new ArrayList<>();
        for (Menu menu : menuRepository.findAll()) {
            if (menu.getMenuType() instanceof Appetizer) {
                appetizerList.add(menu);
            }
        }
        return appetizerList;
    }

    @Override
    public Menu add(String json) {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.STATIC)
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        Appetizer appetizer = new Appetizer();
        menuTypeRepository.save(appetizer);
        Menu menu = gson.fromJson(json, Menu.class);
        menu.setMenuType(appetizer);
        menuRepository.save(menu);
        return menu;
=======

    public AppetizerServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> getAppetizers() {
        List<Menu> coffeeList = new ArrayList<>();
        for (Menu menu : menuRepository.findAll()) {
            if (menu.getMenuType() instanceof Appetizer) {
                coffeeList.add(menu);
            }
        }
        return coffeeList;
>>>>>>> origin/register
    }
}
