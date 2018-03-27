package com.mapringg.bab.jsons;

import com.mapringg.bab.models.UserType;

public class AuthenticateStatus {


    private boolean loginSuccess;
    private UserType userType;

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(boolean success) {
        this.loginSuccess = success;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
