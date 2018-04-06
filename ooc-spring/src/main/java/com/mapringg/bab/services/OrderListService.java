package com.mapringg.bab.services;

import com.mapringg.bab.models.CustomerOrder;
import com.mapringg.bab.models.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

public interface OrderListService {
    List<OrderList> getOrderListByCustomerOrderId(Long customerOrderId);

    List<OrderList> getOrderLists();

    OrderList add(@RequestBody String json);

    OrderList add(OrderList orderList);
}
