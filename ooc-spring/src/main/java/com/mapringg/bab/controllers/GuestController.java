package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Customer;
import com.mapringg.bab.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author mapring
 */
@RestController
@RequestMapping("/api/guest")
public class GuestController {

    private GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping(path = "/add")
    public void add(@RequestBody String json) {
        guestService.add(json);
    }

    @GetMapping
    public Iterable<Customer> findAll() {
        return guestService.list();
    }
}
