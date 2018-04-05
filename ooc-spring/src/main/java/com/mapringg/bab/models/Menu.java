package com.mapringg.bab.models;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

/**
 * @author mapring
 */
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Expose
    private String name;

    @Expose
    private Integer price;

    @OneToOne
    private MenuType menuType;

    @Expose
    private String imageName;

    public Menu() {}

    public Menu(String name, Integer price, MenuType menuType, String imageName) {
        this.name = name;
        this.price = price;
        this.menuType = menuType;
        this.imageName = imageName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
