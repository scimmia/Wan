package com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event;

/**
 * Created by ASUS on 2014/12/4.
 */
public class HttpEvent {
    String tag;
    String response;

    public HttpEvent(String tag, String response) {
        this.tag = tag;
        this.response = response;
    }

    public String getTag() {
        return tag;
    }

    public String getResponse() {
        return response;
    }
}
