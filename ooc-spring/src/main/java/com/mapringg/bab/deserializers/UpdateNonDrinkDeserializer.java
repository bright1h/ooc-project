package com.mapringg.bab.deserializers;

import com.google.gson.*;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.models.MenuType;
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
public class UpdateNonDrinkDeserializer implements JsonDeserializer<Menu> {

    private final MenuTypeRepository menuTypeRepository;
    private final MenuRepository menuRepository;

    @Autowired
    public UpdateNonDrinkDeserializer(MenuTypeRepository menuTypeRepository, MenuRepository menuRepository) {
        this.menuTypeRepository = menuTypeRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Long id = null;
        if (jsonObject.has("id") && jsonObject.get("id") != JsonNull.INSTANCE) {
            id = jsonObject.get("id").getAsLong();
        }
        assert id != null;
        Optional<MenuType> menuType = menuTypeRepository.findById(id);
        if (menuType.isPresent()) {
            Optional<Menu> menu = menuRepository.findByMenuType_Id(menuType.get().getId());
            if (UpdateDrinkDeserializer.getMenuAndUpdateNameAndPrice(jsonObject, menu, menuRepository))
                return menu.get();
        }
        return null;
    }
}
