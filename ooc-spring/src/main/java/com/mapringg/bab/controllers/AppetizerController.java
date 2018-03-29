package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Menu;
import com.mapringg.bab.services.AppetizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * @author mapring
 */
@RestController
@RequestMapping("/api/appetizer")
public class AppetizerController {

    private final AppetizerService appetizerService;

    @Autowired
    public AppetizerController(AppetizerService appetizerService) {
        this.appetizerService = appetizerService;
    }

    @PostMapping(path = "/add")
    public Menu add(@RequestBody String json) {
        return appetizerService.add(json);
    }

    @GetMapping
    @Cacheable("appetizers")
    public Iterable<Menu> findAll() {
        return appetizerService.list();
    }
}
