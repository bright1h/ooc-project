package com.mapringg.bab.controllers;

import com.mapringg.bab.models.*;
import com.mapringg.bab.repositories.MenuRepository;
import com.mapringg.bab.services.CustomerOrderService;
import com.mapringg.bab.services.OrderListService;
import com.mapringg.bab.services.UserService;
import com.mapringg.bab.utils.Checkout;
import com.mapringg.bab.utils.CheckoutWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@RestController
@RequestMapping("/api")
public class CheckoutController {


    private final CustomerOrderService customerOrderService;

    private final UserService userService;

    private final MenuRepository menuRepository;

    private final OrderListService orderListService;

    @Autowired
    public CheckoutController(CustomerOrderService customerOrderService,
                              UserService userService,
                              MenuRepository menuRepository,
                              OrderListService orderListService) {
        this.customerOrderService = customerOrderService;
        this.userService = userService;
        this.menuRepository = menuRepository;
        this.orderListService = orderListService;
    }


    @PostMapping("/checkout")
    public CheckoutWrapper checkout(@RequestBody CheckoutWrapper checkoutWrapper) {
        System.out.println(checkoutWrapper.getEmail());

        User user = (User) userService.findByEmail(checkoutWrapper.getEmail());

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomer(user);
        customerOrder.setSpecialRequest(checkoutWrapper.getSpecialRequest());
        System.out.println(checkoutWrapper.getSpecialRequest());
        customerOrder.setTotalPrice(checkoutWrapper.getTotalPrice());
        customerOrder.setStatus("In queue");
        java.sql.Date curDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        customerOrder.setDate(curDate);
        customerOrderService.add(customerOrder);

        for (Checkout checkout : checkoutWrapper.getOrder()) {
            OrderList orderList = new OrderList();
            Menu menu = menuRepository.findMenuByName(checkout.getName());

            orderList.setMenu(menu);
            orderList.setCustomerOrder(customerOrder);
            orderList.setQuantity(checkout.getQuantity());
            if (checkout.getSweetness() != null) {
                orderList.setSweetness(Sweetness.valueOf(checkout.getSweetness()));
            }

            orderListService.add(orderList);
        }
        return checkoutWrapper;
    }
}
