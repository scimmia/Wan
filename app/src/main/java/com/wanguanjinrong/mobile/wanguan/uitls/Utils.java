package com.wanguanjinrong.mobile.wanguan.uitls;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;

import static com.wanguanjinrong.mobile.wanguan.uitls.Global.LOGIN_PASSWORD;
import static com.wanguanjinrong.mobile.wanguan.uitls.Global.LOGIN_USER_NAME;

/**
 * Created by A on 2016/7/22.
 */
public class Utils {
    public static boolean isLogin(Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return StringUtils.isNoneEmpty(sp.getString(LOGIN_USER_NAME,""),sp.getString(LOGIN_PASSWORD,""));
    }
}
