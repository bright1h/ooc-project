package com.mapringg.bab.deserializers;

import com.google.gson.*;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.models.NonCoffee;
import com.mapringg.bab.repositories.MenuTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

/**
 * @author mapring
 */
@Component
public class NonCoffeeDeserializer implements JsonDeserializer<Menu> {

    private final MenuTypeRepository menuTypeRepository;

    @Autowired
    public NonCoffeeDeserializer(MenuTypeRepository menuTypeRepository) {
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
        NonCoffee nonCoffee = new NonCoffee(isHot, isBlend);
        menuTypeRepository.save(nonCoffee);
        return new Menu(
                jsonObject.get("name").getAsString(),
                jsonObject.get("price").getAsInt(),
                nonCoffee,
                null
        );
    }
}
