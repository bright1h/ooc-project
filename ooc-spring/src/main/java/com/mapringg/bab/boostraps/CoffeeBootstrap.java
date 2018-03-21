package com.mapringg.bab.boostraps;

import com.mapringg.bab.models.Coffee;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.repositories.MenuRepository;
import com.mapringg.bab.repositories.MenuTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author mapring
 */
@Component
@Profile("default")
public class CoffeeBootstrap implements CommandLineRunner {

    private final MenuTypeRepository menuTypeRepository;
    private final MenuRepository menuRepository;

    @Autowired
    public CoffeeBootstrap(MenuTypeRepository menuTypeRepository, MenuRepository menuRepository) {
        this.menuTypeRepository = menuTypeRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public void run(String... args) {
        initData();
    }

    private void initData() {

        Coffee espressoHot = new Coffee(true, null);
        menuTypeRepository.save(espressoHot);
        Menu menu1 = new Menu("Espresso Hot", 40, espressoHot, null);
        menuRepository.save(menu1);

        Coffee americanoHot = new Coffee(true, null);
        menuTypeRepository.save(americanoHot);
        Menu menu2 = new Menu("Americano Hot", 40, americanoHot, null);
        menuRepository.save(menu2);

        Coffee americanoIced = new Coffee(false, null);
        menuTypeRepository.save(americanoIced);
        Menu menu3 = new Menu("Americano Iced", 45, americanoIced, null);
        menuRepository.save(menu3);

        Coffee latteHot = new Coffee(true, null);
        menuTypeRepository.save(latteHot);
        Menu menu4 = new Menu("Latte Hot", 50, latteHot, null);
        menuRepository.save(menu4);

        Coffee latteIced = new Coffee(false, null);
        menuTypeRepository.save(latteIced);
        Menu menu5 = new Menu("Latte Iced", 55, latteIced, null);
        menuRepository.save(menu5);

        Coffee cappuccinoHot = new Coffee(true, null);
        menuTypeRepository.save(cappuccinoHot);
        Menu menu6 = new Menu("Cappuccino Hot", 50, cappuccinoHot, null);
        menuRepository.save(menu6);

        Coffee cappuccinoIced = new Coffee(false, null);
        menuTypeRepository.save(cappuccinoIced);
        Menu menu7 = new Menu("Cappuccino Iced", 55, cappuccinoIced, null);
        menuRepository.save(menu7);

        Coffee mochaHot = new Coffee(true, null);
        menuTypeRepository.save(mochaHot);
        Menu menu8 = new Menu("Mocha Hot", 55, mochaHot, null);
        menuRepository.save(menu8);

        Coffee mochaIced = new Coffee(false, null);
        menuTypeRepository.save(mochaIced);
        Menu menu9 = new Menu("Mocha Iced", 60, mochaIced, null);
        menuRepository.save(menu9);

        Coffee mochaBlend = new Coffee(null, true);
        menuTypeRepository.save(mochaBlend);
        Menu menu10 = new Menu("Mocha Blend", 65, mochaBlend, null);
        menuRepository.save(menu10);

        Coffee caramelMacchiatoHot= new Coffee(true, null);
        menuTypeRepository.save(caramelMacchiatoHot);
        Menu menu11 = new Menu("Caramel Macchiato Hot", 55, caramelMacchiatoHot, null);
        menuRepository.save(menu11);

        Coffee caramelMacchiatoIced = new Coffee(false, null);
        menuTypeRepository.save(caramelMacchiatoIced);
        Menu menu12 = new Menu("Caramel Macchiato Iced", 60, caramelMacchiatoIced, null);
        menuRepository.save(menu12);

        Coffee caramelMacchiatoBlend = new Coffee(null, true);
        menuTypeRepository.save(caramelMacchiatoBlend);
        Menu menu13 = new Menu("Caramel Macchiato Blend", 65, caramelMacchiatoBlend, null);
        menuRepository.save(menu13);

        Coffee hazelnutLatteHot = new Coffee(true, null);
        menuTypeRepository.save(hazelnutLatteHot);
        Menu menu14 = new Menu("Hazelnut Latte Hot", 60, hazelnutLatteHot, null);
        menuRepository.save(menu14);

        Coffee hazelnutLatteIced = new Coffee(false, null);
        menuTypeRepository.save(hazelnutLatteIced);
        Menu menu15 = new Menu("Hazelnut Latte Iced", 65, hazelnutLatteIced, null);
        menuRepository.save(menu15);
    }
}
