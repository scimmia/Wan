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
import com.wanguanjinrong.mobile.wanguan.bean.*;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi.Dingqilicai;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
            Login login = getLoginInfo(context);
            if (login != null && StringUtils.isEmpty(account.getRealPassword())){
                account.setRealPassword(login.getRealPassword());
            }
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

    /**
     * 正则表达式：验证手机号
     */
    private static final String REG_PHONE_NUMBER = "^((1[3,5,8][0-9])|(14[5,7])|(17[0,1,6,7,8]))\\d{8}$";
    /**
     * 正则表达式：验证邮箱
     */
    private static final String REG_EMAIL = "^[a-zA-Z][\\\\w\\\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\\\w\\\\.-]*[a-zA-Z0-9]\\\\.[a-zA-Z][a-zA-Z\\\\.]*[a-zA-Z]$";
    /**
     * 正则表达式：验证账号
     */
    private static final String REG_ACCOUNT = "^[a-zA-Z]\\w{5,17}$";
    /**
     * 正则表达式：验证密码
     */
    private static final String REG_PWD = "^[a-zA-Z0-9_]{6,16}$";
    /**
     * 正则表达式：验证汉字
     */
    public static final String REG_CHINESE = "^[\u4e00-\u9fa5],{0,}$";
    /**
     * 正则表达式：验证身份证
     */
    public static final String REG_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";
    /**
     * 正则表达式：验证URL
     */
    public static final String REG_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
    /**
     * 正则表达式：验证IP地址
     */
    public static final String REG_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

    /**
     * 验证手机号是否合法
     *
     * @param phoneNumber
     * @return
     */
    public static boolean isMobileNumber(String phoneNumber) {
        return isValid(REG_PHONE_NUMBER, phoneNumber);
    }

    /**
     * 验证邮箱是否合法
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        return isValid(REG_EMAIL, email);
    }

    /**
     * 验证账号是否合法
     * @param account
     * @return
     */
    public static boolean isAccount(String account) {
        return isValid(REG_ACCOUNT, account);
    }

    /**
     * 验证密码是否合法
     * @param pwd
     * @return
     */
    public static boolean isPwd(String pwd) {
        return isValid(REG_PWD, pwd);
    }

    /**
     * 校验汉字
     *
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        return isValid(REG_CHINESE, chinese);
    }

    /**
     * 校验身份证
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        return isValid(REG_ID_CARD, idCard);
    }

    /**
     * 校验URL
     *
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        return isValid(REG_URL, url);
    }

    /**
     * 校验IP地址
     *
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return isValid(REG_IP_ADDR, ipAddr);
    }

    /**
     * 正则校验
     *
     * @param pattern 正则表达式
     * @param str     需要校验的字符串
     * @return 验证通过返回true
     */
    public static boolean isValid(String pattern, String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        } else {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(str);
            return m.matches();
        }
    }


    public static Dingqilicai homtItemToDingqilicai(HomeInit.IndexListBean.DealListBean dealListBean){
        try {
            Dingqilicai dingqilicai = new Dingqilicai();
            dingqilicai.setId(dealListBean.getId());
            dingqilicai.setName(dealListBean.getName());
            dingqilicai.setMoneyRate(dealListBean.getRate());
            dingqilicai.setBuyState(NumberUtils.toInt(dealListBean.getDeal_status()));
            dingqilicai.setDays(NumberUtils.toInt(dealListBean.getDay()));
            dingqilicai.setMoneyStart(NumberUtils.toDouble(dealListBean.getMin_loan_money()));
            dingqilicai.setMoneyTotal(NumberUtils.toDouble(dealListBean.getBorrow_amount()));
            dingqilicai.setMoneyLeft(dealListBean.getNeed_money());
            dingqilicai.setProgress(dealListBean.getProgress_point());
            dingqilicai.setItemUrl(dealListBean.getApp_url());
            return dingqilicai;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Dingqilicai ucInvestItemToDingqilicai(UcInvest.ItemBean dealListBean){
        try {
            Dingqilicai dingqilicai = new Dingqilicai();
            dingqilicai.setId(dealListBean.getId());
            dingqilicai.setName(dealListBean.getName());
            dingqilicai.setMoneyRate(dealListBean.getRate());
            dingqilicai.setBuyState(NumberUtils.toInt(dealListBean.getDeal_status()));
            dingqilicai.setDays(NumberUtils.toInt(dealListBean.getDay()));
            dingqilicai.setMoneyStart(NumberUtils.toDouble(dealListBean.getMin_loan_money()));
            dingqilicai.setMoneyTotal(NumberUtils.toDouble(dealListBean.getBorrow_amount()));
            dingqilicai.setMoneyLeft(dealListBean.getNeed_money());
            dingqilicai.setProgress(dealListBean.getProgress_point());
            dingqilicai.setItemUrl(dealListBean.getApp_url());
            return dingqilicai;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
