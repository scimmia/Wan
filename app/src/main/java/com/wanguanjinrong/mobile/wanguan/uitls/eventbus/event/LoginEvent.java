package com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event;

/**
 * Created by A on 2016/7/22.
 */
public class LoginEvent {
    int loginState;

    public int getLoginState() {
        return loginState;
    }

    public LoginEvent(int loginState) {
        this.loginState = loginState;
    }
}
