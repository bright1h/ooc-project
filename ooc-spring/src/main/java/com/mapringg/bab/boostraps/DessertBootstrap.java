package com.mapringg.bab.boostraps;

import com.mapringg.bab.models.Dessert;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.repositories.MenuRepository;
import com.mapringg.bab.repositories.MenuTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author mapring
 */
@Component
@Profile("default")
public class DessertBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final MenuTypeRepository menuTypeRepository;
    private final MenuRepository menuRepository;

    @Autowired
    public DessertBootstrap(MenuTypeRepository menuTypeRepository, MenuRepository menuRepository) {
        this.menuTypeRepository = menuTypeRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Dessert banoffee = new Dessert();
        menuTypeRepository.save(banoffee);
        Menu menu1 = new Menu("Banoffee", 55, banoffee, null);
        menuRepository.save(menu1);

        Dessert chocolateBananaRoti = new Dessert();
        menuTypeRepository.save(chocolateBananaRoti);
        Menu menu2 = new Menu("Chocolate Banana Roti", 75, chocolateBananaRoti, null);
        menuRepository.save(menu2);

        Dessert cookies = new Dessert();
        menuTypeRepository.save(cookies);
        Menu menu3 = new Menu("Cookies", 25, cookies, null);
        menuRepository.save(menu3);

        Dessert brownies = new Dessert();
        menuTypeRepository.save(brownies);
        Menu menu4 = new Menu("Brownies", 55, brownies, null);
        menuRepository.save(menu4);

        Dessert chocolateLava = new Dessert();
        menuTypeRepository.save(chocolateLava);
        Menu menu5 = new Menu("Chocolate Lava", 65, chocolateLava, null);
        menuRepository.save(menu5);

        Dessert panaCotta = new Dessert();
        menuTypeRepository.save(panaCotta);
        Menu menu6 = new Menu("Pana Cotta", 45, panaCotta, null);
        menuRepository.save(menu6);

        Dessert blueberryCheesePie = new Dessert();
        menuTypeRepository.save(blueberryCheesePie);
        Menu menu7 = new Menu("Blueberry Cheese Pie", 55, blueberryCheesePie, null);
        menuRepository.save(menu7);

        Dessert chocolatePie = new Dessert();
        menuTypeRepository.save(chocolatePie);
        Menu menu8 = new Menu("Chocolate Pie", 55, chocolatePie, null);
        menuRepository.save(menu8);
    }
}
