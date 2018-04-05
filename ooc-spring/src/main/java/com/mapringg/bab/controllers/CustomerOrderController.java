package com.mapringg.bab.controllers;

import com.mapringg.bab.models.CustomerOrder;
import com.mapringg.bab.services.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/customerorder")
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;

    @Autowired
    public CustomerOrderController(CustomerOrderService customerOrderService){this.customerOrderService = customerOrderService;}

    @PostMapping(path = "/add")
    public CustomerOrder add(@RequestBody String json) {return customerOrderService.add(json);}


    @PostMapping(path = "/update")
    public CustomerOrder update(@RequestBody String json) {
        System.out.println(json);
        return customerOrderService.update(json);}


    @GetMapping
    public Iterable<CustomerOrder> findAll() {return customerOrderService.getCurrentOrders();}
}
