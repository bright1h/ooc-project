package com.mapringg.bab.boostraps;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.mapringg.bab.deserializers.AddNonCoffeeDeserializer;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.repositories.MenuRepository;
import com.mapringg.bab.repositories.MenuTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * @author mapring
 */
@Component
@Profile("default")
public class NonCoffeeBootstrap implements CommandLineRunner {

    private final MenuTypeRepository menuTypeRepository;
    private final MenuRepository menuRepository;

    @Autowired
    public NonCoffeeBootstrap(MenuTypeRepository menuTypeRepository, MenuRepository menuRepository) {
        this.menuTypeRepository = menuTypeRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public void run(String... args) {
        initData();
    }

    private void initData() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Menu.class, new AddNonCoffeeDeserializer(menuTypeRepository))
                .create();
        try {
            JsonReader jsonReader = new JsonReader(new FileReader("non_coffees.json"));
            List<Menu> menus = gson.fromJson(jsonReader, new TypeToken<List<Menu>>() {
            }.getType());
            for (Menu menu :
                    menus) {
                menuRepository.save(menu);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
