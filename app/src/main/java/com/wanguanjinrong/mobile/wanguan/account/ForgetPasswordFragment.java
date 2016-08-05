package com.wanguanjinrong.mobile.wanguan.account;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import com.orhanobut.logger.Logger;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.wanguanjinrong.mobile.wanguan.R;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by A on 2016/8/5.
 */
public class ForgetPasswordFragment extends BaseFragment{

    @BindView(R.id.toolbar_forget)
    Toolbar mToolbar;
    @BindView(R.id.et_register_phone)
    MaterialEditText mEtRegisterPhone;
    @BindView(R.id.btn_code)
    Button mBtnCode;
    @BindView(R.id.et_register_code)
    MaterialEditText mEtRegisterCode;
    @BindView(R.id.et_register_password)
    MaterialEditText mEtRegisterPassword;
    @BindView(R.id.et_register_password_again)
    MaterialEditText mEtRegisterPasswordAgain;

    protected Unbinder unbinder;
    public static BaseFragment newInstance() {
        BaseFragment fragment = new ForgetPasswordFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mToolbar.setTitle(R.string.forget_password);
        mToolbar.setBackgroundColor(0xFFf71e1a);
        initToobarBack(mToolbar);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forget_password, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @OnClick(R.id.btn_commit_password)
    public void commit(){
        Logger.e("commit");
        SMSSDK.submitVerificationCode("86", mEtRegisterPhone.getText().toString(),mEtRegisterCode.getText().toString());
    }

    @OnClick(R.id.btn_code)
    public void sendCode(){
        SMSSDK.getVerificationCode("86", mEtRegisterPhone.getText().toString());
    }

    EventHandler eh=new EventHandler(){
        @Override
        public void afterEvent(int event, int result, Object data) {
            Logger.e(result+"afterEvent"+event);

            if (result == SMSSDK.RESULT_COMPLETE) {
                //回调完成
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                    //提交验证码成功
                    //// TODO: 2016/7/26  register
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(_mActivity, "验证码正确", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                    //获取验证码成功
                    startTimer();
                }
            }else{
                // 根据服务器返回的网络错误，给toast提示
                try {
                    ((Throwable) data).printStackTrace();
                    Throwable throwable = (Throwable) data;

                    JSONObject object = new JSONObject(
                            throwable.getMessage());
                    final String des = object.optString("detail");
                    int status = object.optInt("status");
                    if (!TextUtils.isEmpty(des)) {
                        Logger.e(des+"----"+status);
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(_mActivity, des, Toast.LENGTH_SHORT).show();
                            }
                        });
                        return;
                    }
                } catch (Exception e) {
                    Logger.e(e.toString());
                }
            }
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        SMSSDK.initSDK(_mActivity, "1543694879524", "e649155554c22e99173f58d8a3fdff83");
        SMSSDK.registerEventHandler(eh);
    }

    @Override
    public void onPause() {
        super.onPause();
        SMSSDK.unregisterAllEventHandler();
        if (timer != null){
            timer.cancel();
        }
    }

    public static int DEFAULT_DELAY = 60;
    private Timer timer;
    private int last = 0;
    private void startTimer(){
        timer = new Timer();
        last = DEFAULT_DELAY;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                last -= 1;
                if (last > 0) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            mBtnCode.setClickable(false);
                            mBtnCode.setText(last + "秒后重新发送");
                        }
                    });
                }else if (last == 0) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            mBtnCode.setClickable(true);
                            mBtnCode.setText(R.string.register_title_sms);
                        }
                    });
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }
}
