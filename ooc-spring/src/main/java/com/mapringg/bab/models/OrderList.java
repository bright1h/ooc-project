package com.mapringg.bab.models;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Set;

/**
 * @author mapring
 */
@Entity
public class OrderList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Expose
    @OneToOne
    private CustomerOrder customerOrder;

    @OneToOne
    private Menu menu;

    @OneToMany
    @JoinTable(
            name = "drink_order_list_topping",
            joinColumns = @JoinColumn(name = "drink_order_list_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )

    @Expose
    private Set<Topping> toppings;

    @Expose
    @Enumerated(value = EnumType.STRING)
    private Sweetness sweetness;

    @Expose
    private Integer quantity;

    @Expose
    private String specialRequest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Set<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(Set<Topping> toppings) {
        this.toppings = toppings;
    }

    public Sweetness getSweetness() {
        return sweetness;
    }

    public void setSweetness(Sweetness sweetness) {
        this.sweetness = sweetness;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

}
