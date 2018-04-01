package com.mapringg.bab.models;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;

/**
 * @author mapring
 */
@Entity
public class NonCoffee extends MenuType {

    @Expose
    private Boolean isHot;

    @Expose
    private Boolean isBlend;

    public NonCoffee() {}

    public NonCoffee(Boolean isHot, Boolean isBlend) {
        this.isHot = isHot;
        this.isBlend = isBlend;
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
}
