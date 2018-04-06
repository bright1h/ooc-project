package com.mapringg.bab.services;


import com.mapringg.bab.models.CustomerOrder;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.util.List;

public interface CustomerOrderService {

    CustomerOrder add (@RequestBody String json);

    CustomerOrder update (@RequestBody String json);

    List<CustomerOrder> getCustomerOrders();

    List<CustomerOrder> getCurrentOrders();

    List<CustomerOrder> getInQueueOrders();

    List<CustomerOrder> getPreparingOrders();

    List<CustomerOrder> getDoneOrders();

    Iterable<CustomerOrder> getListFromDate(java.sql.Date date);

    CustomerOrder add(CustomerOrder customerOrder);
}
