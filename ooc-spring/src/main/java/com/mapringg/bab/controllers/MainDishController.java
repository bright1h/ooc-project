package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Menu;
import com.mapringg.bab.services.MainDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * @author mapring
 */
@RestController
@RequestMapping("/api/main_dish")
public class MainDishController {

    private final MainDishService mainDishService;

    @Autowired
    public MainDishController(MainDishService mainDishService) {
        this.mainDishService = mainDishService;
    }

    @PostMapping(path = "/add")
    public Menu add(@RequestBody String json) {
        return mainDishService.add(json);
    }

    @GetMapping
    @Cacheable("main_dishes")
    public Iterable<Menu> findAll() {
        return mainDishService.list();
    }
}
