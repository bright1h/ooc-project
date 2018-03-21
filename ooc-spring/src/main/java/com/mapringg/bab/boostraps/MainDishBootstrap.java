package com.mapringg.bab.boostraps;

import com.mapringg.bab.models.MainDish;
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
public class MainDishBootstrap implements CommandLineRunner {

    private final MenuTypeRepository menuTypeRepository;
    private final MenuRepository menuRepository;

    @Autowired
    public MainDishBootstrap(MenuTypeRepository menuTypeRepository, MenuRepository menuRepository) {
        this.menuTypeRepository = menuTypeRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public void run(String... args) {
        initData();
    }

    private void initData() {

        MainDish allDayBreakfast = new MainDish();
        menuTypeRepository.save(allDayBreakfast);
        Menu menu1 = new Menu("All Day Breakfast", 75, allDayBreakfast, null);
        menuRepository.save(menu1);

        MainDish grilledSandwichChicken = new MainDish();
        menuTypeRepository.save(grilledSandwichChicken);
        Menu menu2 = new Menu("Grilled Sandwich Chicken", 65, grilledSandwichChicken, null);
        menuRepository.save(menu2);

        MainDish grilledSandwichTuna = new MainDish();
        menuTypeRepository.save(grilledSandwichTuna);
        Menu menu3 = new Menu("Grilled Sandwich Tuna", 65, grilledSandwichTuna, null);
        menuRepository.save(menu3);

        MainDish grilledSandwichHamCheese = new MainDish();
        menuTypeRepository.save(grilledSandwichHamCheese);
        Menu menu4 = new Menu("Grilled Sandwich Ham Cheese", 65, grilledSandwichHamCheese, null);
        menuRepository.save(menu4);

        MainDish grilledSausage = new MainDish();
        menuTypeRepository.save(grilledSausage);
        Menu menu5 = new Menu("Grilled Sausage", 75, grilledSausage, null);
        menuRepository.save(menu5);

        MainDish houseSandwich = new MainDish();
        menuTypeRepository.save(houseSandwich);
        Menu menu6 = new Menu("House Sandwich", 70, houseSandwich, null);
        menuRepository.save(menu6);

        MainDish spaghettiCarbonara = new MainDish();
        menuTypeRepository.save(spaghettiCarbonara);
        Menu menu7 = new Menu("Spaghetti Carbonara", 70, spaghettiCarbonara, null);
        menuRepository.save(menu7);

        MainDish spaghettiMeatBall = new MainDish();
        menuTypeRepository.save(spaghettiMeatBall);
        Menu menu8 = new Menu("Spaghetti Meat Ball", 70, spaghettiMeatBall, null);
        menuRepository.save(menu8);

        MainDish spaghettiDryChili = new MainDish();
        menuTypeRepository.save(spaghettiDryChili);
        Menu menu9 = new Menu("Spaghetti Dry Chili", 70, spaghettiDryChili, null);
        menuRepository.save(menu9);

        MainDish bbFriedRice = new MainDish();
        menuTypeRepository.save(bbFriedRice);
        Menu menu10 = new Menu("BB Fried Rice", 69, bbFriedRice, null);
        menuRepository.save(menu10);

        MainDish omuRice = new MainDish();
        menuTypeRepository.save(omuRice);
        Menu menu11= new Menu("Omu Rice", 59, omuRice, null);
        menuRepository.save(menu11);

        MainDish bbqBurger = new MainDish();
        menuTypeRepository.save(bbqBurger);
        Menu menu12 = new Menu("BBQ Burger", 99, bbqBurger, null);
        menuRepository.save(menu12);

        MainDish teriyakiSalmonRice = new MainDish();
        menuTypeRepository.save(teriyakiSalmonRice);
        Menu menu13 = new Menu("Teriyaki Salmon Rice", 99, teriyakiSalmonRice, null);
        menuRepository.save(menu13);

        MainDish dryChiliRice = new MainDish();
        menuTypeRepository.save(dryChiliRice);
        Menu menu14 = new Menu("Dry Chili Rice", 59, dryChiliRice, null);
        menuRepository.save(menu14);
    }
}
