package com.mapringg.bab.controllers;

import com.mapringg.bab.models.CustomerOrder;
import com.mapringg.bab.models.OrderList;
import com.mapringg.bab.services.AdminService;
import com.mapringg.bab.services.CustomerOrderService;
import com.mapringg.bab.services.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CustomerOrderService customerOrderService;
    private final OrderListService orderListService;

    @Autowired
    public CheckoutController(CustomerOrderService customerOrderService, OrderListService orderListService){this.customerOrderService = customerOrderService; this.orderListService = orderListService;}

//    @PostMapping(path = "/submit")
//    public CustomerOrder add()
}
