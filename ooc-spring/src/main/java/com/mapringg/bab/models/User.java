package com.mapringg.bab.models;

import javax.persistence.*;

/**
 * @author mapring
 */
@Entity
public class User extends Customer {

    private String lastName;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
