package com.mapringg.bab.deserializers;

import com.google.gson.*;
import com.mapringg.bab.models.Coffee;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.repositories.MenuTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

/**
 * @author mapring
 */
@Component
public class CoffeeDeserializer implements JsonDeserializer<Menu> {

    private final MenuTypeRepository menuTypeRepository;

    @Autowired
    public CoffeeDeserializer(MenuTypeRepository menuTypeRepository) {
        this.menuTypeRepository = menuTypeRepository;
    }

    @Override
    public Menu deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Boolean isHot = null;
        Boolean isBlend = null;
        JsonObject menuType = jsonObject.getAsJsonObject("menuType");
        if (menuType.get("blend") != JsonNull.INSTANCE) {
            isBlend = menuType.get("blend").getAsBoolean();
        }
        if (menuType.get("hot") != JsonNull.INSTANCE) {
            isHot = menuType.get("hot").getAsBoolean();
        }
        Coffee coffee = new Coffee(isHot, isBlend);
        menuTypeRepository.save(coffee);
        return new Menu(
                jsonObject.get("name").getAsString(),
                jsonObject.get("price").getAsInt(),
                coffee,
                null
        );
    }
}
