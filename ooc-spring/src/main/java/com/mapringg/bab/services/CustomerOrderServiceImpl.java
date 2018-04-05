package com.mapringg.bab.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mapringg.bab.deserializers.CustomerDeserializer;
import com.mapringg.bab.models.CustomerOrder;
import com.mapringg.bab.repositories.CustomerOrderRepository;
import com.mapringg.bab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private CustomerOrderRepository customerOrderRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerOrderServiceImpl(CustomerRepository customerRepository, CustomerOrderRepository customerOrderRepository) {
        this.customerRepository = customerRepository;
        this.customerOrderRepository = customerOrderRepository;
    }

    @Override
    public List<CustomerOrder> getCustomerOrders() {
        return customerOrderRepository.findAll();
    }

    @Override
    public List<CustomerOrder> getInQueueOrders() {
        List<CustomerOrder> InQueue = new ArrayList<>();
        for (CustomerOrder customerOrder : customerOrderRepository.findAll()) {
            if (customerOrder.getStatus().equals("In queue")) {
                InQueue.add(customerOrder);
            }
        }
        return InQueue;
    }

    @Override
    public List<CustomerOrder> getPreparingOrders() {
        List<CustomerOrder> Preparing = new ArrayList<>();
        for (CustomerOrder customerOrder : customerOrderRepository.findAll()) {
            if (customerOrder.getStatus().equals("Preparing")) {
                Preparing.add(customerOrder);
            }
        }
        return Preparing;
    }

    @Override
    public List<CustomerOrder> getCurrentOrders() {
        List<CustomerOrder> CurrentOrders = new ArrayList<>();
        for (CustomerOrder customerOrder : customerOrderRepository.findAll()) {
            if (customerOrder.getStatus().equals("Preparing") || customerOrder.getStatus().equals("In queue")) {
                CurrentOrders.add(customerOrder);
            }
        }
        return CurrentOrders;
    }

    @Override
    public List<CustomerOrder> getDoneOrders() {
        List<CustomerOrder> Done = new ArrayList<>();
        for (CustomerOrder customerOrder : customerOrderRepository.findAll()) {
            if (customerOrder.getStatus().equals("Done")) {
                Done.add(customerOrder);
            }
        }
        return Done;
    }

    @Override
    public Iterable<CustomerOrder> getListFromDate(Date date) {
        return customerOrderRepository.findAllByDate(date);
    }

    @Override
    public CustomerOrder add(String json) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(CustomerOrder.class, new CustomerDeserializer(customerRepository, customerOrderRepository))
                .create();
        CustomerOrder customerOrder = gson.fromJson(json, CustomerOrder.class);
        customerOrderRepository.save(customerOrder);
        return customerOrder;
    }
}
