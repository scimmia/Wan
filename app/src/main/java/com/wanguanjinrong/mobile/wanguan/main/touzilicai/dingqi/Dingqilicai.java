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
    int moneyStart;
    int moneyLeft;
    double progress;

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

    public int getMoneyStart() {
        return moneyStart;
    }

    public void setMoneyStart(int moneyStart) {
        this.moneyStart = moneyStart;
    }

    public int getMoneyLeft() {
        return moneyLeft;
    }

    public void setMoneyLeft(int moneyLeft) {
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
