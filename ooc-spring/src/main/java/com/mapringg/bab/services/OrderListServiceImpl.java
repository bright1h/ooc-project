package com.mapringg.bab.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mapringg.bab.models.CustomerOrder;
import com.mapringg.bab.models.OrderList;
import com.mapringg.bab.repositories.OrderListRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderListServiceImpl implements OrderListService{
    private OrderListRepository orderListRepository;

    private OrderListServiceImpl(OrderListRepository orderListRepository){this.orderListRepository = orderListRepository;}

    @Override
    public List<OrderList> getOrderLists() {
        return orderListRepository.findAll();
    }

    @Override
    public List<OrderList> getOrderListByCustomerOrderId(Long customerOrderId) {
        List<OrderList> OrderListByCustomerOrderId  = new ArrayList<>();
        for(OrderList orderList : orderListRepository.findAll()){
            if(orderList.getCustomerOrder().getId().equals(customerOrderId)){
                OrderListByCustomerOrderId.add(orderList);
            }
        }
        return OrderListByCustomerOrderId;
    }

    @Override
    public OrderList add(String json) {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier .STATIC)
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        OrderList orderList = gson.fromJson(json, OrderList.class);
        orderListRepository.save(orderList);
        return orderList;
    }
}
