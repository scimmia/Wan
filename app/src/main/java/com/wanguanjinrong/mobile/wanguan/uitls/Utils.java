package com.wanguanjinrong.mobile.wanguan.uitls;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Locale;
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

    public static String moneyFormat(double money){
        return String.format(Locale.CHINESE,"%,.2f", money);
    }
    public static String moneyFormatWithYuan(double money){
        return String.format(Locale.CHINESE,"%,.2f元", money);
    }
}
