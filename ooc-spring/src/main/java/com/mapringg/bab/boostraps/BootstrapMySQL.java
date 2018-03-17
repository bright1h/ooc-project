package com.mapringg.bab.boostraps;

import com.mapringg.bab.repositories.MenuRepository;
import com.mapringg.bab.repositories.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author mapring
 */
@Component
@Profile({"dev", "prod"})
public class BootstrapMySQL implements ApplicationListener<ContextRefreshedEvent> {

    private final MenuRepository menuRepository;
    private final ToppingRepository toppingRepository;

    @Autowired
    public BootstrapMySQL(MenuRepository menuRepository, ToppingRepository toppingRepository) {
        this.menuRepository = menuRepository;
        this.toppingRepository = toppingRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("There is " + menuRepository.count() + " menus.");
        System.out.println("There is " + toppingRepository.count() + " toppings.");
    }
}
