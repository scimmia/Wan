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
import java.util.HashMap;
import java.util.Set;

/**
 * Created by ASUS on 2014/12/4.
 */
public class HttpTask extends AsyncTask<Void,Void,String>{

    ProgressDialog mpDialog;
    Context mContent;
    String msgToShow;

    int httpTpye;
    int mTag;
    String mUrl;
    HashMap<String,String> mBody;

    public HttpTask(Context mContent, String msgToShow, int mTag, HashMap<String,String> body) {
        this.mContent = mContent;
        this.msgToShow = msgToShow;
        this.mTag = mTag;
        this.mBody = new HashMap<>();
        mBody.put("i_type","1");
        mBody.put("r_type","1");
        if (body != null){
            mBody.putAll(body);
        }
        this.mUrl = "http://192.168.0.198/fangwei/mapi/index.php";
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
        FormBody.Builder builder = new FormBody.Builder();
        Set<String> keys = mBody.keySet();
        for (String key:keys) {
            builder.add(key, mBody.get(key));
        }
        RequestBody formBody = builder.build();
        Request request = new Request.Builder()
                .url("http://192.168.0.198/fangwei/mapi/index.php")
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
        BusProvider.getInstance().post(new HttpEvent(mTag,result));
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Logger.e("onCancelled");
        for (Call call : BaseApplication.getOkHttpClient().dispatcher().queuedCalls()) {
            if ((Integer)call.request().tag() == mTag)
                call.cancel();
        }
        for (Call call : BaseApplication.getOkHttpClient().dispatcher().runningCalls()) {
            if ((Integer)call.request().tag() == mTag)
                call.cancel();
        }
    }
}
