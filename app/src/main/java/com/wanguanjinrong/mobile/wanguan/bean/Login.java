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
     * lock_money : 3210.00
     * lock_money_format : ￥3,210.00
     * total_money : 103210
     * total_money_format : ￥103,210.00
     * real_name :
     * bankcard : 11111111111
     * idno :
     * mobile : 18660187425
     */

    private int user_login_status;
    private int id;
    private String user_name;
    private String user_email;
    private String act_2;
    private String user_pwd;
    private String user_money;
    private String user_money_format;
    private String real_name;
    private String bankcard;
    private String idno;
    private String mobile;
    private String lock_money;
    private String lock_money_format;
    private double total_money;
    private String total_money_format;
    private String realPassword;

    public String getRealPassword() {
        return realPassword;
    }

    public void setRealPassword(String realPassword) {
        this.realPassword = realPassword;
    }

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
        return realPassword;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_money() {
        return user_money;
    }

    public void setUser_money(String user_money) {
        this.user_money = user_money;
    }

    public String getUser_money_format() {
        return user_money_format;
    }

    public void setUser_money_format(String user_money_format) {
        this.user_money_format = user_money_format;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLock_money() {
        return lock_money;
    }

    public void setLock_money(String lock_money) {
        this.lock_money = lock_money;
    }

    public String getLock_money_format() {
        return lock_money_format;
    }

    public void setLock_money_format(String lock_money_format) {
        this.lock_money_format = lock_money_format;
    }

    public double getTotal_money() {
        return total_money;
    }

    public void setTotal_money(double total_money) {
        this.total_money = total_money;
    }

    public String getTotal_money_format() {
        return total_money_format;
    }

    public void setTotal_money_format(String total_money_format) {
        this.total_money_format = total_money_format;
    }
}
