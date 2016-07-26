package com.wanguanjinrong.mobile.wanguan.account;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import com.orhanobut.logger.Logger;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by A on 2016/7/26.
 */
public class RegisterFragment extends BaseFragment {

    protected Unbinder unbinder;

    @BindView(R.id.toolbar_register)
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
    @BindView(R.id.et_register_inviter)
    MaterialEditText mEtRegisterInviter;

    public static BaseFragment newInstance() {
        BaseFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mToolbar.setTitle(R.string.register);
        mToolbar.setBackgroundColor(0xFFf71e1a);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });
        mToolbar.inflateMenu(R.menu.menu_register);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_register:
                        Logger.e("action_register");
                        SMSSDK.submitVerificationCode("86", mEtRegisterPhone.getText().toString(),mEtRegisterCode.getText().toString());
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
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
