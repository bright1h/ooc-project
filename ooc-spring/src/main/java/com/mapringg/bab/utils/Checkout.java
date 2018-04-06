package com.mapringg.bab.utils;

import com.mapringg.bab.models.MenuType;

public class Checkout {


    private long id;

    private String name;

    private int price;

    private MenuType menuType;

    private String imageName;

    private int quantity;

    private int sumPrice;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public String getImageName() {
        return imageName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSumPrice() {
        return sumPrice;
    }
}
