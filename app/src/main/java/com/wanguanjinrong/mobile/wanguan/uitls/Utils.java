package com.wanguanjinrong.mobile.wanguan.uitls;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import com.orhanobut.logger.Logger;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.*;
import com.wanguanjinrong.mobile.wanguan.R;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.util.Locale;

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
