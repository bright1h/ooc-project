package com.mapringg.bab.controllers;

import com.mapringg.bab.models.CustomerOrder;
import com.mapringg.bab.services.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderhistory")
public class OrderHistoryController {

    private final CustomerOrderService customerOrderService;

    @Autowired
    public OrderHistoryController(CustomerOrderService customerOrderService){this.customerOrderService = customerOrderService;}

    @GetMapping
    public Iterable<CustomerOrder> findAll(){return customerOrderService.getDoneOrders();}

    @GetMapping(path = "/search/{date}")
    public Iterable<CustomerOrder> findListFromDate(@PathVariable java.sql.Date date) {
        return customerOrderService.getListFromDate(date);
    }

}
