package com.mapringg.bab.boostraps;

import com.mapringg.bab.models.Menu;
import com.mapringg.bab.models.NonCoffee;
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
public class NonCoffeeBootstrap implements CommandLineRunner {

    private final MenuTypeRepository menuTypeRepository;
    private final MenuRepository menuRepository;

    @Autowired
    public NonCoffeeBootstrap(MenuTypeRepository menuTypeRepository, MenuRepository menuRepository) {
        this.menuTypeRepository = menuTypeRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public void run(String... args) {
        initData();
    }

    private void initData() {

        NonCoffee belgianChocolateHot  = new NonCoffee(true, null, null, null);
        menuTypeRepository.save(belgianChocolateHot);
        Menu menu1 = new Menu("Belgian Chocolate Hot", 50, belgianChocolateHot, null);
        menuRepository.save(menu1);

        NonCoffee belgianChocolateIced = new NonCoffee(false, null, null, null);
        menuTypeRepository.save(belgianChocolateIced);
        Menu menu2 = new Menu("Belgian Chocolate Iced", 55, belgianChocolateIced, null);
        menuRepository.save(menu2);

        NonCoffee chococinoBlend = new NonCoffee(null, true, null, null);
        menuTypeRepository.save(chococinoBlend);
        Menu menu3 = new Menu("Chococino Blend", 60, chococinoBlend, null);
        menuRepository.save(menu3);

        NonCoffee vanillaMilkyShakieBlend = new NonCoffee(null, true, null, null);
        menuTypeRepository.save(vanillaMilkyShakieBlend);
        Menu menu4 = new Menu("Vanilla Milky Shakie", 60, vanillaMilkyShakieBlend, null);
        menuRepository.save(menu4);

        NonCoffee strawberryShakieBlend = new NonCoffee(null, true, null, null);
        menuTypeRepository.save(strawberryShakieBlend);
        Menu menu5 = new Menu("Strawberry Shakie Blend", 60, strawberryShakieBlend, null);
        menuRepository.save(menu5);

        NonCoffee matchaLatteHot = new NonCoffee(true, null, null, null);
        menuTypeRepository.save(matchaLatteHot);
        Menu menu6 = new Menu("Matcha Latte Hot", 50, matchaLatteHot, null);
        menuRepository.save(menu6);

        NonCoffee matchaLatteIced = new NonCoffee(false, null, null, null);
        menuTypeRepository.save(matchaLatteIced);
        Menu menu7 = new Menu("Matcha Latte Iced", 55, matchaLatteIced, null);
        menuRepository.save(menu7);

        NonCoffee matchaLatteBlend = new NonCoffee(null, true, null, null);
        menuTypeRepository.save(matchaLatteBlend);
        Menu menu8 = new Menu("Matcha Latte Blend", 60, matchaLatteBlend, null);
        menuRepository.save(menu8);

        NonCoffee bbTwisterIced = new NonCoffee(false, null, null, null);
        menuTypeRepository.save(bbTwisterIced);
        Menu menu9 = new Menu("BB Twister Iced", 50, bbTwisterIced, null);
        menuRepository.save(menu9);

        NonCoffee bbTwisterBlend = new NonCoffee(null, true, null, null);
        menuTypeRepository.save(bbTwisterBlend);
        Menu menu10 = new Menu("BB Twister Blend", 55, bbTwisterBlend, null);
        menuRepository.save(menu10);

        NonCoffee tropicalBreezeBlend = new NonCoffee(null, true, null, null);
        menuTypeRepository.save(tropicalBreezeBlend);
        Menu menu11 = new Menu("Tropical Breeze Blend", 55, tropicalBreezeBlend, null);
        menuRepository.save(menu11);

        NonCoffee teaMixedFruitIced = new NonCoffee(false, null, null, null);
        menuTypeRepository.save(teaMixedFruitIced);
        Menu menu12 = new Menu("Tea Mixed Fruit Iced", 50, teaMixedFruitIced, null);
        menuRepository.save(menu12);

        NonCoffee teaLemonIced = new NonCoffee(false, null, null, null);
        menuTypeRepository.save(teaLemonIced);
        Menu menu13 = new Menu("Tea Lemon Iced", 50, teaLemonIced, null);
        menuRepository.save(menu13);

        NonCoffee smoothiesStrawberryBlend = new NonCoffee(null, true, null, null);
        menuTypeRepository.save(smoothiesStrawberryBlend);
        Menu menu14 = new Menu("Smoothies Strawberry Blend", 55, smoothiesStrawberryBlend, null);
        menuRepository.save(menu14);

        NonCoffee smoothiesPassionFruitBlend = new NonCoffee(null, true, null, null);
        menuTypeRepository.save(smoothiesPassionFruitBlend);
        Menu menu15 = new Menu("Smoothies Passion Fruit Blend", 55, smoothiesPassionFruitBlend, null);
        menuRepository.save(menu15);

        NonCoffee sparklingCoolerAppleIced = new NonCoffee(false, null, null, null);
        menuTypeRepository.save(sparklingCoolerAppleIced);
        Menu menu16 = new Menu("Sparkling Cooler Apple Iced", 45, sparklingCoolerAppleIced, null);
        menuRepository.save(menu16);

        NonCoffee sparklingCoolerStrawberryIced = new NonCoffee(false, null, null, null);
        menuTypeRepository.save(sparklingCoolerStrawberryIced);
        Menu menu17 = new Menu("Sparkling Cooler Strawberry Iced", 45, sparklingCoolerStrawberryIced, null);
        menuRepository.save(menu17);

        NonCoffee sparklingCoolerLemonIced = new NonCoffee(false, null, null, null);
        menuTypeRepository.save(sparklingCoolerLemonIced);
        Menu menu18 = new Menu("Sparkling Cooler Lemon Iced", 45, sparklingCoolerLemonIced, null);
        menuRepository.save(menu18);

        NonCoffee twinningHot = new NonCoffee(true, null, null, null);
        menuTypeRepository.save(twinningHot);
        Menu menu19 = new Menu("Twinning Hot", 25, twinningHot, null);
        menuRepository.save(menu19);

        NonCoffee twinningIced = new NonCoffee(false, null, null, null);
        menuTypeRepository.save(twinningIced);
        Menu menu20 = new Menu("Twinning Iced", 30, twinningIced, null);
        menuRepository.save(menu20);

        NonCoffee thaiTeaIced = new NonCoffee(false, null, null, null);
        menuTypeRepository.save(thaiTeaIced);
        Menu menu21 = new Menu("Thai Tea Iced", 50, thaiTeaIced, null);
        menuRepository.save(menu21);

        NonCoffee thaiTeaBlend = new NonCoffee(null, true, null, null);
        menuTypeRepository.save(thaiTeaBlend);
        Menu menu22 = new Menu("Thai Tea Blend", 55, thaiTeaBlend, null);
        menuRepository.save(menu22);

        NonCoffee brownieBlend = new NonCoffee(null, true, null, null);
        menuTypeRepository.save(brownieBlend);
        Menu menu23 = new Menu("Brownie Blend", 65, brownieBlend, null);
        menuRepository.save(menu23);

        NonCoffee granolaBlend = new NonCoffee(null, true, null, null);
        menuTypeRepository.save(granolaBlend);
        Menu menu24 = new Menu("Granola Blend", 65, granolaBlend, null);
        menuRepository.save(menu24);
    }
}
