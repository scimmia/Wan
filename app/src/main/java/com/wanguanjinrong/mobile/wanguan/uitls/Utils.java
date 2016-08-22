package com.wanguanjinrong.mobile.wanguan.uitls;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.*;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.bean.Login;
import com.wanguanjinrong.mobile.wanguan.bean.UcCenter;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.Locale;


/**
 * Created by A on 2016/7/22.
 */
public class Utils {
    public static boolean isLogin(Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        double loginTime = sp.getLong(Global.LOGIN_TIME,0);
        String loginInfo = sp.getString(Global.LOGIN_INFO,"");
        if (loginTime == 0 || loginInfo.equalsIgnoreCase("")){
            return false;
        }else if (new Date().getTime() - loginTime > Global.LOGIN_AVALIBAL_TIME){
            logout(context);
            return false;
        }else {
            return true;
        }
    }

    public static Login getLoginInfo(Context context){
        if (isLogin(context)){
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            String loginInfo = sp.getString(Global.LOGIN_INFO,"");
            if (StringUtils.isNoneEmpty(loginInfo)){
                try {
                    return new Gson().fromJson(loginInfo,Login.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void login(Context context, Login account){
        try {
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            editor.putLong(Global.LOGIN_TIME,new Date().getTime());
            editor.putString(Global.LOGIN_INFO,new Gson().toJson(account));
            editor.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void logout(Context context){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.remove(Global.LOGIN_TIME);
        editor.remove(Global.LOGIN_INFO);
        editor.apply();
    }

    public static UcCenter getUserInfo(Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        String loginInfo = sp.getString(Global.LOGIN_USER_INFO,"");
        if (StringUtils.isNoneEmpty(loginInfo)){
            try {
                return new Gson().fromJson(loginInfo,UcCenter.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void serUserInfo(Context context, UcCenter ucCenter){
        try {
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            editor.putString(Global.LOGIN_USER_INFO,new Gson().toJson(ucCenter));
            editor.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String moneyFormat(double money){
        return String.format(Locale.CHINESE,"%,.2f", money);
    }
    public static String moneyFormatWithYuan(double money){
        return String.format(Locale.CHINESE,"%,.2f元", money);
    }

    /**
     * 微信分享：分享网页
     * @param context
     * @param scene
     */
    public static void shareToWeChatWithWebpage(Context context, int scene){
        IWXAPI iwxapi = WXAPIFactory.createWXAPI(context, Global.INVITE_WEIXIN_API);

        if (!iwxapi.isWXAppInstalled()){
            Logger.e("您尚未安装微信客户端");
            return;
        }

        WXWebpageObject wxWebpageObject = new WXWebpageObject();
        wxWebpageObject.webpageUrl = Global.INVITE_TARGET_URL;

        WXMediaMessage wxMediaMessage = new WXMediaMessage(wxWebpageObject);
        wxMediaMessage.mediaObject = wxWebpageObject;
        wxMediaMessage.title = Global.INVITE_TITLE;
        wxMediaMessage.description = Global.INVITE_CONTENT;
        wxMediaMessage.thumbData =
                bmpToByteArray(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher), true);

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = wxMediaMessage;
        req.scene = scene;

        iwxapi.sendReq(req);
    }

    public static byte[] bmpToByteArray(final Bitmap bmp, final boolean needRecycle) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, output);
        if (needRecycle) {
            bmp.recycle();
        }

        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
