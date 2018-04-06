package com.mapringg.bab.utils;

import java.util.List;

public class CheckoutWrapper {

    private String email;

    private List<Checkout> order;

    private String specialRequest;

    public String getEmail() {
        return email;
    }

    public List<Checkout> getOrder() {
        return order;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }
}
