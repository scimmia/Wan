package com.wanguanjinrong.mobile.wanguan.main.my;

import java.util.Random;

/**
 * Created by A on 2016/7/22.
 */
public class MyMoney {
    double mTotal;
    double mLastdayGot;
    double mUsable;

    public double getTotal() {
        return mTotal;
    }

    public void setTotal(double total) {
        mTotal = total;
    }

    public double getLastdayGot() {
        return mLastdayGot;
    }

    public void setLastdayGot(double lastdayGot) {
        mLastdayGot = lastdayGot;
    }

    public double getUsable() {
        return mUsable;
    }

    public void setUsable(double usable) {
        mUsable = usable;
    }


    public static  MyMoney generRandomData(){
//        String[] ids = new String[]{"","",""};
        MyMoney myMoney = new MyMoney();
        Random r = new Random();
        myMoney.setTotal(r.nextDouble()*1000);
        myMoney.setLastdayGot(r.nextDouble()*10);
        myMoney.setUsable(r.nextDouble()*100);
        return myMoney;
    }
}
