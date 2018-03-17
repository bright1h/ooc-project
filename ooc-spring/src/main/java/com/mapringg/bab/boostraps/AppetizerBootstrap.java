package com.mapringg.bab.boostraps;

import com.mapringg.bab.models.Appetizer;
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
public class AppetizerBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final MenuTypeRepository menuTypeRepository;
    private final MenuRepository menuRepository;

    @Autowired
    public AppetizerBootstrap(MenuTypeRepository menuTypeRepository, MenuRepository menuRepository) {
        this.menuTypeRepository = menuTypeRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Appetizer fishAndChips = new Appetizer();
        menuTypeRepository.save(fishAndChips);
        Menu menu1 = new Menu("Fish and Chips", 65, fishAndChips, null);
        menuRepository.save(menu1);

        Appetizer sausageStick = new Appetizer();
        menuTypeRepository.save(sausageStick);
        Menu menu2 = new Menu("Sausage Stick", 50, sausageStick, null);
        menuRepository.save(menu2);

        Appetizer holyChick = new Appetizer();
        menuTypeRepository.save(holyChick);
        Menu menu3 = new Menu("Holy Chick", 55, holyChick, null);
        menuRepository.save(menu3);

        Appetizer saladCaesar = new Appetizer();
        menuTypeRepository.save(saladCaesar);
        Menu menu4 = new Menu("Salad  Caesar", 59, saladCaesar, null);
        menuRepository.save(menu4);

        Appetizer saladTuna = new Appetizer();
        menuTypeRepository.save(saladTuna);
        Menu menu5 = new Menu("Salad Tuna", 59, saladTuna, null);
        menuRepository.save(menu5);

        Appetizer saladGarden = new Appetizer();
        menuTypeRepository.save(saladGarden);
        Menu menu6= new Menu("Salad Garden", 59, saladGarden, null);
        menuRepository.save(menu6);

        Appetizer seasoningFrenchFries = new Appetizer();
        menuTypeRepository.save(seasoningFrenchFries);
        Menu menu7 = new Menu("Seasoning French Fries", 60, seasoningFrenchFries, null);
        menuRepository.save(menu7);

        Appetizer chickenCaesarWrap = new Appetizer();
        menuTypeRepository.save(chickenCaesarWrap);
        Menu menu8 = new Menu("Chicken Caesar Wrap", 49, chickenCaesarWrap, null);
        menuRepository.save(menu8);

        Appetizer superbowl = new Appetizer();
        menuTypeRepository.save(superbowl);
        Menu menu9 = new Menu("Superbowl", 99, superbowl, null);
        menuRepository.save(menu9);

        Appetizer normalFries = new Appetizer();
        menuTypeRepository.save(normalFries);
        Menu menu10 = new Menu("Normal Fries", 55, normalFries, null);
        menuRepository.save(menu10);

        Appetizer cheesyFries = new Appetizer();
        menuTypeRepository.save(cheesyFries);
        Menu menu11 = new Menu("Cheesy Fries", 65, cheesyFries, null);
        menuRepository.save(menu11);
    }

}
