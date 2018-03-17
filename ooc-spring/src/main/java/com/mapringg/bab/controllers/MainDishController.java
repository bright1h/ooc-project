package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Menu;
import com.mapringg.bab.services.MainDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mapring
 */
@RestController
@RequestMapping("/api/main_dishes")
public class MainDishController {

    private final MainDishService mainDishService;

    @Autowired
    public MainDishController(MainDishService mainDishService) {
        this.mainDishService = mainDishService;
    }

    @GetMapping
    public Iterable<Menu> getAllMainDishes() {
        return mainDishService.getMainDishes();
    }
}
