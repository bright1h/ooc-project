package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Topping;
import com.mapringg.bab.services.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mapring
 */
@RestController
@RequestMapping("/api/topping")
public class ToppingController {

    private final ToppingService toppingService;

    @Autowired
    public ToppingController(ToppingService toppingService) {
        this.toppingService = toppingService;
    }

    @GetMapping
    @CachePut("toppings")
    public Iterable<Topping> findAll() {
        return toppingService.getToppings();
    }
}
