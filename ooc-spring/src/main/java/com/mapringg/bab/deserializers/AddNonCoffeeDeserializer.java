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
public class AddNonCoffeeDeserializer implements JsonDeserializer<Menu> {

    private final MenuTypeRepository menuTypeRepository;

    @Autowired
    public AddNonCoffeeDeserializer(MenuTypeRepository menuTypeRepository) {
        this.menuTypeRepository = menuTypeRepository;
    }

    @Override
    public Menu deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Boolean isHot = null;
        Boolean isBlend = null;
        String imageName = null;
        JsonObject menuType = jsonObject.getAsJsonObject("menuType");
        if (menuType.has("blend") && menuType.get("blend") != JsonNull.INSTANCE) {
            isBlend = menuType.get("blend").getAsBoolean();
        }
        if (menuType.has("hot") && menuType.get("hot") != JsonNull.INSTANCE) {
            isHot = menuType.get("hot").getAsBoolean();
        }
        NonCoffee nonCoffee = new NonCoffee(isHot, isBlend);
        menuTypeRepository.save(nonCoffee);
        if (jsonObject.has("imageName") && jsonObject.get("imageName") != JsonNull.INSTANCE) {
            imageName = jsonObject.get("imageName").getAsString();
        }
        return new Menu(
                jsonObject.get("name").getAsString(),
                jsonObject.get("price").getAsInt(),
                nonCoffee,
                imageName
        );
    }
}
