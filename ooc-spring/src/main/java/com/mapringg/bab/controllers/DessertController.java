package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Menu;
import com.mapringg.bab.services.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
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
    @CachePut("desserts")
    public Iterable<Menu> findAll() {
        return dessertService.list();
    }

    @PutMapping(path = "/update")
    public Menu update(@RequestBody String json) {
        return dessertService.update(json);
    }
}
