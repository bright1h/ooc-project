package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Menu;
import com.mapringg.bab.services.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mapring
 */
@RestController
@RequestMapping("/api/desserts")
public class DessertController {

    private final DessertService dessertService;

    @Autowired
    public DessertController(DessertService dessertService) {
        this.dessertService = dessertService;
    }

    @GetMapping
    public Iterable<Menu> getAllDesserts() {
        return dessertService.getDesserts();
    }
}
