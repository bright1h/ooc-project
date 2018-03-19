package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Menu;
import com.mapringg.bab.services.AppetizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mapring
 */
@RestController
@RequestMapping("/api/appetizers")
public class AppetizerController {

    private final AppetizerService appetizerService;

    @Autowired
    public AppetizerController(AppetizerService appetizerService) {
        this.appetizerService = appetizerService;
    }

    @GetMapping
    @Cacheable("appetizers")
    public Iterable<Menu> getAllAppetizers() {
        return appetizerService.getAppetizers();
    }
}
