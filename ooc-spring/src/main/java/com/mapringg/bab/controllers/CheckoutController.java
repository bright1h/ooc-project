package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Customer;
import com.mapringg.bab.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

//    private final AdminService adminService;

//    @Autowired
//    public AdminController(AdminService adminService) {
//        this.adminService = adminService;
//    }

    @PostMapping
    public String add(@RequestBody String json) {
        System.out.println(json);
        return "Order Successfully";
    }


}