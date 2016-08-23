package com.wanguanjinrong.mobile.wanguan.account;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import butterknife.BindView;
import butterknife.OnClick;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.squareup.otto.Subscribe;
import com.wanguanjinrong.mobile.wanguan.bean.BaseBean;
import com.wanguanjinrong.mobile.wanguan.uitls.Global;
import com.wanguanjinrong.mobile.wanguan.uitls.Utils;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.HttpEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.http.HttpTask;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.wanguanjinrong.mobile.wanguan.R;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
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
        if (StringUtils.isEmpty(mEtRegisterPhone.getText().toString())){
            mEtRegisterPhone.setError("请输入手机号");
            mEtRegisterPhone.requestFocus();
        }else if (!Utils.isMobileNumber(mEtRegisterPhone.getText().toString())){
            mEtRegisterPhone.setError("请输入正确的手机号");
            mEtRegisterPhone.requestFocus();
        }else if (StringUtils.isEmpty(mEtRegisterCode.getText().toString())){
            mEtRegisterCode.setError("请输入验证码");
            mEtRegisterCode.requestFocus();
        }else if (StringUtils.isEmpty(mEtRegisterPassword.getText().toString())){
            mEtRegisterPassword.setError("请输入密码");
            mEtRegisterPassword.requestFocus();
        }else if (!StringUtils.equalsIgnoreCase(mEtRegisterPassword.getText().toString(),mEtRegisterPasswordAgain.getText().toString())){
            mEtRegisterPasswordAgain.setError("请输入正确的密码");
            mEtRegisterPasswordAgain.requestFocus();
        }else {
            HashMap<String, String> map = new HashMap<>();
            //// TODO: 2016/8/23 zhifumima
            map.put("mobile", mEtRegisterPhone.getText().toString());
            map.put("mobile_code", mEtRegisterCode.getText().toString());
            map.put("user_pwd", mEtRegisterPassword.getText().toString());
            map.put("user_pwd_confirm", mEtRegisterPasswordAgain.getText().toString());
            new HttpTask(_mActivity, Global.SAVE_RESET_PWD_MSG, Global.SAVE_RESET_PWD_TAG, new Gson().toJson(map)).execute();
        }
    }

    @OnClick(R.id.btn_code)
    public void sendCode(){
        if (!Utils.isMobileNumber(mEtRegisterPhone.getText().toString())){
            showToast("请输入正确的手机号");
        }else {
            new HttpTask(_mActivity, Global.SEND_RESET_PWD_CODE_MSG, Global.SEND_RESET_PWD_CODE_TAG,
                    "{\"mobile\":\""+mEtRegisterPhone.getText().toString()+"\"}").execute();
        }
    }

    @Subscribe
    public void onHttpEvent(HttpEvent event){
        if (event == null || StringUtils.isEmpty(event.getResponse())) {
            showToast("网络连接错误，请稍后重试。");
        } else{
            if (StringUtils.equalsIgnoreCase(Global.SEND_RESET_PWD_CODE_TAG,event.getTag())){
                BaseBean bean = new Gson().fromJson(event.getResponse(),BaseBean.class);
                if (bean.getResponse_code() != 1){
                    showToast(bean.getShow_err());
                }else {
                    startTimer();
                }
            }else if (StringUtils.equalsIgnoreCase(Global.SAVE_RESET_PWD_TAG,event.getTag())){
                BaseBean bean = new Gson().fromJson(event.getResponse(),BaseBean.class);
                if (bean.getResponse_code() != 1){
                    showToast(bean.getShow_err());
                }else {
                    showToast("1------"+bean.getShow_err());
                }
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
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
