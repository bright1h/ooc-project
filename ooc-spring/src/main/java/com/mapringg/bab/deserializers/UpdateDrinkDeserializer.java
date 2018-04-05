package com.mapringg.bab.deserializers;

import com.google.gson.*;
import com.mapringg.bab.models.Coffee;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.models.MenuType;
import com.mapringg.bab.models.NonCoffee;
import com.mapringg.bab.repositories.MenuRepository;
import com.mapringg.bab.repositories.MenuTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Optional;

/**
 * @author mapring
 */
@Component
public class UpdateDrinkDeserializer implements JsonDeserializer<Menu> {

    private final MenuTypeRepository menuTypeRepository;
    private final MenuRepository menuRepository;

    @Autowired
    public UpdateDrinkDeserializer(MenuTypeRepository menuTypeRepository, MenuRepository menuRepository) {
        this.menuTypeRepository = menuTypeRepository;
        this.menuRepository = menuRepository;
    }

    static boolean getMenuAndUpdateNameAndPrice(JsonObject jsonObject, Optional<Menu> menu, MenuRepository menuRepository) {
        if (menu.isPresent()) {
            if (jsonObject.has("name") && jsonObject.get("name") != JsonNull.INSTANCE) {
                menu.get().setName(jsonObject.get("name").getAsString());
            }
            if (jsonObject.has("price") && jsonObject.get("price") != JsonNull.INSTANCE) {
                menu.get().setPrice(jsonObject.get("price").getAsInt());
            }
            menuRepository.save(menu.get());
            return true;
        }
        return false;
    }

    @Override
    public Menu deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Long id = null;
        Coffee coffee = null;
        NonCoffee nonCoffee = null;
        if (jsonObject.has("id") && jsonObject.get("id") != JsonNull.INSTANCE) {
            id = jsonObject.get("id").getAsLong();
        }
        assert id != null;
        Optional<MenuType> menuType = menuTypeRepository.findById(id);
        if (menuType.isPresent()) {
            if (menuType.get() instanceof Coffee) {
                coffee = (Coffee) menuType.get();
            } else {
                nonCoffee = (NonCoffee) menuType.get();
            }
            JsonObject jsonObjectMenuType = jsonObject.getAsJsonObject("menuType");
            if (jsonObjectMenuType.has("blend") && jsonObjectMenuType.get("blend") != JsonNull.INSTANCE) {
                if (coffee != null) {
                    coffee.setBlend(jsonObjectMenuType.get("blend").getAsBoolean());
                } else {
                    nonCoffee.setBlend(jsonObjectMenuType.get("blend").getAsBoolean());
                }
            }
            if (jsonObjectMenuType.has("hot") && jsonObjectMenuType.get("hot") != JsonNull.INSTANCE) {
                if (coffee != null) {
                    coffee.setHot(jsonObjectMenuType.get("hot").getAsBoolean());
                } else {
                    nonCoffee.setHot(jsonObjectMenuType.get("hot").getAsBoolean());
                }
            }
            Optional<Menu> menu = menuRepository.findByMenuType_Id(menuType.get().getId());
            if (getMenuAndUpdateNameAndPrice(jsonObject, menu, menuRepository)) return menu.get();
        }
        return null;
    }
}
