package com.wanguanjinrong.mobile.wanguan;

import android.app.Application;
import cn.smssdk.SMSSDK;

/**
 * Created by A on 2016/7/25.
 */
public class BaseApplication  extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SMSSDK.initSDK(this, "1543694879524", "e649155554c22e99173f58d8a3fdff83");
    }
}
