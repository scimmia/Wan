package com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi;

import java.util.Random;

/**
 * Created by A on 2016/7/7.
 */
public class Dingqilicai {
    String id;
    String name;
    String moneyRate;
    int buyState;
    int days;
    double moneyStart;
    double moneyLeft;
    double moneyTotal;
    double progress;
    String itemUrl;

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public double getMoneyTotal() {
        return moneyTotal;
    }

    public void setMoneyTotal(double moneyTotal) {
        this.moneyTotal = moneyTotal;
    }

    public Dingqilicai() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoneyRate() {
        return moneyRate;
    }

    public void setMoneyRate(String moneyRate) {
        this.moneyRate = moneyRate;
    }

    public int getBuyState() {
        return buyState;
    }

    public void setBuyState(int buyState) {
        this.buyState = buyState;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getMoneyStart() {
        return moneyStart;
    }

    public void setMoneyStart(double moneyStart) {
        this.moneyStart = moneyStart;
    }

    public double getMoneyLeft() {
        return moneyLeft;
    }

    public void setMoneyLeft(double moneyLeft) {
        this.moneyLeft = moneyLeft;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public static  Dingqilicai generRandomData(){
//        String[] ids = new String[]{"","",""};
        String[] ids = new String[]{"B","C","F"};
        String[] names = new String[]{"年年万贯","新手投资","6月万贯","美丽专区","3月万贯"};
        int[] moneyStarts = new int[]{100,1000,500,10000,5000};
        Dingqilicai dingqilicai = new Dingqilicai();
        Random r = new Random();
        dingqilicai.setId(ids[r.nextInt(ids.length)]+r.nextInt(Integer.MAX_VALUE));
        dingqilicai.setName(names[r.nextInt(names.length)]);
        dingqilicai.setMoneyRate(""+(5+r.nextInt(5))+'.'+(r.nextInt(999)));
        dingqilicai.setBuyState(r.nextInt(2));
        dingqilicai.setDays(r.nextInt(360));
        dingqilicai.setMoneyStart(moneyStarts[r.nextInt(moneyStarts.length)]);
        dingqilicai.setMoneyLeft(10000+r.nextInt(36000));
        dingqilicai.setProgress(r.nextDouble());

        return dingqilicai;
    }

    @Override
    public String toString() {
        return "Dingqilicai{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", moneyRate='" + moneyRate + '\'' +
                ", days=" + days +
                ", moneyStart=" + moneyStart +
                ", moneyLeft=" + moneyLeft +
                ", progress=" + progress +
                '}';
    }
}
