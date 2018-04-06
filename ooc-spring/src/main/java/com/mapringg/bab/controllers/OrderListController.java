package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Customer;
import com.mapringg.bab.models.CustomerOrder;
import com.mapringg.bab.models.OrderList;
import com.mapringg.bab.services.CustomerOrderService;
import com.mapringg.bab.services.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/orderlist")
public class OrderListController {
    private final OrderListService orderListService;

    @Autowired
    public OrderListController(OrderListService orderListService){this.orderListService = orderListService;}

    @PostMapping(path = "/add")
    public OrderList add(@RequestBody String json){return orderListService.add(json);}

    @GetMapping
    public Iterable<OrderList> findAll() {return orderListService.getOrderLists();}

    @GetMapping(path = "/search/{id}")
    public Iterable<OrderList> findListFromDate(@PathVariable Long id) {
        return orderListService.getOrderListByCustomerOrderId(id);
    }
}
