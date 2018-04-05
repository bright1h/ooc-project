package com.mapringg.bab.models;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Date;

/**
 * @author mapring
 */
@Entity
public class CustomerOrder {



    public CustomerOrder(Customer customer, java.sql.Date date,String status){
        this.customer = customer;
        this.date = date;
        this.status = status;
    }

    public CustomerOrder(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Expose
    @ManyToOne
    private Customer customer;

    @Expose
    private java.sql.Date date;

    @Expose
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
