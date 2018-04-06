package com.mapringg.bab.controllers;

import com.mapringg.bab.models.OrderList;
import com.mapringg.bab.repositories.OrderListRepository;
import com.mapringg.bab.utils.Checkout;
import com.mapringg.bab.utils.CheckoutWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CheckoutController {


    private final OrderListRepository orderListRepository;

    @Autowired
    public CheckoutController(OrderListRepository orderListRepository) {
        this.orderListRepository = orderListRepository;
    }


    @PostMapping("/checkout")
    public CheckoutWrapper checkout(@RequestBody CheckoutWrapper checkoutWrapper) {
        System.out.println(checkoutWrapper.getEmail());
        for (Checkout checkout : checkoutWrapper.getOrder()) {
            OrderList orderList = new OrderList();

        }
        return checkoutWrapper;
    }
}
