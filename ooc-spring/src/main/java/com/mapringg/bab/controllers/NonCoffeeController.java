package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Menu;
import com.mapringg.bab.services.NonCoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mapring
 */
@RestController
@RequestMapping("/api/non_coffees")
public class NonCoffeeController {

    private final NonCoffeeService nonCoffeeService;

    @Autowired
    public NonCoffeeController(NonCoffeeService nonCoffeeService) {
        this.nonCoffeeService = nonCoffeeService;
    }

    @GetMapping
    public Iterable<Menu> getAllNonCoffees() {
        return nonCoffeeService.getNonCoffees();
    }
}
