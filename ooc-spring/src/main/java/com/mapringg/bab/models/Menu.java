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

    @Lob
    @Expose
    private Byte[] image;

    public Menu() {}

    public Menu(String name, Integer price, MenuType menuType, Byte[] image) {
        this.name = name;
        this.price = price;
        this.menuType = menuType;
        this.image = image;
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

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

}
