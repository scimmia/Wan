package com.wanguanjinrong.mobile.wanguan.bean;

/**
 * Created by A on 2016/8/18.
 */
public class BaseBean {
    public int response_code;
    public String show_err;
    public String act;

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public String getShow_err() {
        return show_err;
    }

    public void setShow_err(String show_err) {
        this.show_err = show_err;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }
}
