package com.mapringg.bab.models;

import javax.persistence.Entity;

/**
 * @author mapring
 */
@Entity
public class Coffee extends MenuType {

    private Boolean isHot;

    private Boolean isBlend;

    public Coffee() {}

    public Coffee(Boolean isHot, Boolean isBlend) {
        this.isHot = isHot;
        this.isBlend = isBlend;
    }

    public Boolean isHot() {
        return isHot;
    }

    public void setHot(Boolean hot) {
        isHot = hot;
    }

    public Boolean isBlend() {
        return isBlend;
    }

    public void setBlend(Boolean blend) {
        isBlend = blend;
    }
}
