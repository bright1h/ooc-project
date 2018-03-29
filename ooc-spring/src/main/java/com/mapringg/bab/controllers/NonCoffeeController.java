package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Menu;
import com.mapringg.bab.services.NonCoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * @author mapring
 */
@RestController
@RequestMapping("/api/non_coffee")
public class NonCoffeeController {

    private final NonCoffeeService nonCoffeeService;

    @Autowired
    public NonCoffeeController(NonCoffeeService nonCoffeeService) {
        this.nonCoffeeService = nonCoffeeService;
    }

    @PostMapping(path = "/add")
    public Menu add(@RequestBody String json) {
        return nonCoffeeService.add(json);
    }

    @GetMapping
    @Cacheable("non_coffees")
    public Iterable<Menu> findAll() {
        return nonCoffeeService.list();
    }
}
