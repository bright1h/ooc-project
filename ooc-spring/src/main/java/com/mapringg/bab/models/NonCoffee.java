package com.mapringg.bab.models;

import javax.persistence.*;
import java.util.Set;

/**
 * @author mapring
 */
@Entity
public class NonCoffee extends MenuType {

    private Boolean isHot;

    private Boolean isBlend;

    @OneToMany
    @JoinTable(
            name = "non_coffee_topping",
            joinColumns = @JoinColumn(name = "non_coffee_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private Set<Topping> toppings;

    @Enumerated(value = EnumType.STRING)
    private Sweetness sweetness;

    public NonCoffee() {}

    public NonCoffee(Boolean isHot, Boolean isBlend, Set<Topping> toppings, Sweetness sweetness) {
        this.isHot = isHot;
        this.isBlend = isBlend;
        this.toppings = toppings;
        this.sweetness = sweetness;
    }

    public Boolean getHot() {
        return isHot;
    }

    public void setHot(Boolean hot) {
        isHot = hot;
    }

    public Boolean getBlend() {
        return isBlend;
    }

    public void setBlend(Boolean blend) {
        isBlend = blend;
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
}
