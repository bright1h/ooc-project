package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Menu;
import com.mapringg.bab.services.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * @author mapring
 */
@RestController
@RequestMapping("/api/dessert")
public class DessertController {

    private final DessertService dessertService;

    @Autowired
    public DessertController(DessertService dessertService) {
        this.dessertService = dessertService;
    }

    @PostMapping(path = "/add")
    public Menu add(@RequestBody String json) {
        return dessertService.add(json);
    }

    @GetMapping
    @Cacheable("desserts")
    public Iterable<Menu> findAll() {
        return dessertService.list();
    }
}
