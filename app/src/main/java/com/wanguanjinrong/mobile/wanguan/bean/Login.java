package com.wanguanjinrong.mobile.wanguan.bean;

/**
 * Created by A on 2016/8/19.
 */
public class Login extends BaseBean{
    /**
     * user_login_status : 0
     * id : 0
     * user_name :
     * user_email :
     * act_2 :
     * user_pwd : 96e79218965eb72c92a549dd5a330112
     * user_money : null
     * user_money_format : ￥0.00
     */

    private int user_login_status;
    private int id;
    private String user_name;
    private String user_email;
    private String act_2;
    private String user_pwd;
    private Object user_money;
    private String user_money_format;

    public int getUser_login_status() {
        return user_login_status;
    }

    public void setUser_login_status(int user_login_status) {
        this.user_login_status = user_login_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getAct_2() {
        return act_2;
    }

    public void setAct_2(String act_2) {
        this.act_2 = act_2;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public Object getUser_money() {
        return user_money;
    }

    public void setUser_money(Object user_money) {
        this.user_money = user_money;
    }

    public String getUser_money_format() {
        return user_money_format;
    }

    public void setUser_money_format(String user_money_format) {
        this.user_money_format = user_money_format;
    }
}
