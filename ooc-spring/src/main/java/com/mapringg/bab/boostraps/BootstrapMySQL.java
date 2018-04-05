package com.mapringg.bab.boostraps;

import com.mapringg.bab.repositories.CustomerOrderRepository;
import com.mapringg.bab.repositories.MenuRepository;
import com.mapringg.bab.repositories.MenuTypeRepository;
import com.mapringg.bab.repositories.ToppingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author mapring
 */
@Component
@Profile("dev")
public class BootstrapMySQL implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(BootstrapMySQL.class);

    private final MenuRepository menuRepository;
    private final MenuTypeRepository menuTypeRepository;
    private final ToppingRepository toppingRepository;

    @Autowired
    public BootstrapMySQL(
            MenuRepository menuRepository,
            MenuTypeRepository menuTypeRepository, ToppingRepository toppingRepository, CustomerOrderRepository customerOrderRepository
    ) {
        this.menuRepository = menuRepository;
        this.menuTypeRepository = menuTypeRepository;
        this.toppingRepository = toppingRepository;
    }

    @Override
    public void run(String... args) {
        logger.info("Number of menus in menuRepository: {}", menuRepository.count());
        logger.info("Number of toppings in toppingRepository: {}", toppingRepository.count());
        if (menuRepository.count() == 0) {
            AppetizerBootstrap appetizerBootstrap = new AppetizerBootstrap(menuTypeRepository, menuRepository);
            CoffeeBootstrap coffeeBootstrap = new CoffeeBootstrap(menuTypeRepository, menuRepository);
            DessertBootstrap dessertBootstrap = new DessertBootstrap(menuTypeRepository, menuRepository);
            MainDishBootstrap mainDishBootstrap = new MainDishBootstrap(menuTypeRepository, menuRepository);
            NonCoffeeBootstrap nonCoffeeBootstrap = new NonCoffeeBootstrap(menuTypeRepository, menuRepository);
            appetizerBootstrap.run();
            coffeeBootstrap.run();
            dessertBootstrap.run();
            mainDishBootstrap.run();
            nonCoffeeBootstrap.run();
        }
        if (toppingRepository.count() == 0) {
            ToppingBootstrap toppingBootstrap = new ToppingBootstrap(toppingRepository);
            toppingBootstrap.run();
        }
        logger.info("Number of menus in menuRepository: {}", menuRepository.count());
        logger.info("Number of toppings in toppingRepository: {}", toppingRepository.count());
    }
}
