package com.mapringg.bab.models;

import javax.persistence.Entity;

/**
 * @author mapring
 */
@Entity
public class Guest extends Customer {
    public Guest(String firstName, String email, String mobilePhone) {
        this.setFirstName(firstName);
        this.setEmail(email);
        this.setMobilePhone(mobilePhone);
    }
}
