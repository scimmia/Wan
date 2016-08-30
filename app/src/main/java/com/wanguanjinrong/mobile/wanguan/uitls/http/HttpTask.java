package com.wanguanjinrong.mobile.wanguan.uitls.http;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import com.orhanobut.logger.Logger;
import com.wanguanjinrong.mobile.wanguan.BaseApplication;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.BusProvider;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.HttpEvent;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * Created by ASUS on 2014/12/4.
 */
public class HttpTask extends AsyncTask<Void,Void,String>{
    public static final MediaType JSON  = MediaType.parse("application/json; charset=utf-8");
    ProgressDialog mpDialog;
    Context mContent;
    String msgToShow;

    String mUrl;
    String mTag;
    String mJson;

    HttpListener mHttpListener;

    public HttpTask(Context mContent, String msgToShow, String mAct, String json) {
        this(mContent,msgToShow,mAct,json,null);
    }

    public HttpTask(Context mContent, String msgToShow, String mAct, String json,HttpListener httpListener) {
        this.mContent = mContent;
        this.msgToShow = msgToShow;
        this.mTag = mAct;
        if (StringUtils.isNotEmpty(json)) {
            this.mJson = json;
        }else {
            this.mJson = "";
        }
        mHttpListener = httpListener;
        Logger.e(mJson);
//        this.mUrl = "http://ceshi.wanguanjinrong.com/mapi/index.php"+"?act="+mAct+"&i_type=1&r_type=1";
        this.mUrl = "http://192.168.0.167/mapi/index.php"+"?act="+mAct+"&i_type=1&r_type=1";
//        this.mUrl = "http://192.168.0.167/wanguan/mapi/index.php"+"?act="+mAct+"&i_type=1&r_type=1";
    }
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        if (StringUtils.isNotEmpty(msgToShow)){
            mpDialog = new ProgressDialog(mContent, ProgressDialog.THEME_HOLO_LIGHT);
//        mpDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);//设置风格为圆形进度条
            mpDialog.setMessage(msgToShow);
            mpDialog.setCancelable(true);

            mpDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    dialog.dismiss();
                    cancel(true);
                }
            });
            mpDialog.show();
        }
    }

    @Override
    protected String doInBackground(Void... params) {
        RequestBody formBody = RequestBody.create(JSON, mJson);
        Request request = new Request.Builder()
                .url(mUrl)
                .post(formBody)
                .build();
        if (request != null){
            OkHttpClient okHttpClient = BaseApplication.getOkHttpClient();
            try {
                Response response = okHttpClient.newCall(request).execute();
                if(response.isSuccessful()){
                    String temp = response.body().string();
                    Logger.e(temp);
                    return temp;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (mpDialog != null) {
            mpDialog.dismiss();
        }
        if (mHttpListener != null){
            mHttpListener.onSuccess(mTag,result);
        }else {
            BusProvider.getInstance().post(new HttpEvent(mTag, result));
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Logger.e("onCancelled");
        for (Call call : BaseApplication.getOkHttpClient().dispatcher().queuedCalls()) {
            if (StringUtils.equalsIgnoreCase((String)call.request().tag(),mTag))
                call.cancel();
        }
        for (Call call : BaseApplication.getOkHttpClient().dispatcher().runningCalls()) {
            if (StringUtils.equalsIgnoreCase((String)call.request().tag(),mTag))
                call.cancel();
        }
    }
}