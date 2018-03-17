package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Menu;
import com.mapringg.bab.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author mapring
 */
@RestController
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping(path = "/search")
    public Menu getMenu(@RequestParam(required = false, defaultValue = "Mocha Hot") String name) {
        Optional<Menu> menuOptional =  menuRepository.findByName(name);
        if (!menuOptional.isPresent()) {
            throw new RuntimeException("Expected Menu Not Found");
        }
        return menuOptional.get();
    }

    @GetMapping
    public Iterable<Menu> getAllMenus() {
        return menuRepository.findAll();
    }
}
