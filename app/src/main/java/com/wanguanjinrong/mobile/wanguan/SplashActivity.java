package com.wanguanjinrong.mobile.wanguan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.wanguanjinrong.mobile.wanguan.login.IntroActivity;
import com.wanguanjinrong.mobile.wanguan.main.MainActivity;
import com.wanguanjinrong.mobile.wanguan.uitls.Global;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new FirstRunCheckTask().execute();
    }

    class FirstRunCheckTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            try {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SplashActivity.this);
                int savedVersion = sharedPreferences.getInt(Global.isFirstRun,0);
                int currentVersion = getPackageManager().getPackageInfo(getPackageName(),0).versionCode;
                if (savedVersion < currentVersion){
                    Intent intent = new Intent(SplashActivity.this, IntroActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                    startActivity(intent);
                    finish();
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
