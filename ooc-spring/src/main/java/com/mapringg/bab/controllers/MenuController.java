package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Menu;
import com.mapringg.bab.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author mapring
 */
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }


    @GetMapping(path = "/search")
    public Menu get(@RequestParam(required = false, defaultValue = "Mocha Hot") String name) {
        Optional<Menu> menuOptional =  menuRepository.findByName(name);
        if (!menuOptional.isPresent()) {
            throw new RuntimeException("Expected Menu Not Found");
        }
        return menuOptional.get();
    }

    @GetMapping
    public Iterable<Menu> findAll() {
        return menuRepository.findAll();
    }
}
