package com.wanguanjinrong.mobile.wanguan.account;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.squareup.otto.Subscribe;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.bean.BaseBean;
import com.wanguanjinrong.mobile.wanguan.bean.Login;
import com.wanguanjinrong.mobile.wanguan.uitls.Global;
import com.wanguanjinrong.mobile.wanguan.uitls.Utils;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.HttpEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.http.HttpTask;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
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
    @BindView(R.id.et_register_pay_password)
    MaterialEditText mEtRegisterPayPassword;
    @BindView(R.id.et_register_pay_password_again)
    MaterialEditText mEtRegisterPayPasswordAgain;

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
                    case R.id.action_next:
                        Logger.e("action_register");
//                        new HttpTask(_mActivity, Global.REGISTER_MSG, Global.REGISTER_TAG, " {\"pay_pwd\":\"111111\",\"user_pwd\":\"123321\",\"user_pwd_confirm\":\"123321\",\"referer\":\"\",\"mobile_code\":\"787082\",\"pay_pwd_confirm\":\"111111\",\"mobile\":\"18660187425\"}").execute();
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
                        }else if (StringUtils.isEmpty(mEtRegisterPayPassword.getText().toString())){
                            mEtRegisterPayPassword.setError("请输入支付密码");
                            mEtRegisterPayPassword.requestFocus();
                        }else if (!StringUtils.equalsIgnoreCase(mEtRegisterPayPassword.getText().toString(),mEtRegisterPayPasswordAgain.getText().toString())){
                            mEtRegisterPayPasswordAgain.setError("请输入正确的支付密码");
                            mEtRegisterPayPasswordAgain.requestFocus();
                        }else {
                            HashMap<String, String> map = new HashMap<>();
                            map.put("mobile", mEtRegisterPhone.getText().toString());
                            map.put("mobile_code", mEtRegisterCode.getText().toString());
                            map.put("user_pwd", mEtRegisterPassword.getText().toString());
                            map.put("user_pwd_confirm", mEtRegisterPasswordAgain.getText().toString());
                            map.put("pay_pwd", mEtRegisterPayPassword.getText().toString());
                            map.put("pay_pwd_confirm", mEtRegisterPayPasswordAgain.getText().toString());
                            map.put("referer", mEtRegisterInviter.getText().toString());
                            new HttpTask(_mActivity, Global.REGISTER_MSG, Global.REGISTER_TAG, new Gson().toJson(map)).execute();
                        }
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
    public void sendCode() {
        if (!Utils.isMobileNumber(mEtRegisterPhone.getText().toString())) {
            showToast("请输入正确的手机号");
        } else {
            new HttpTask(_mActivity, Global.SEND_REGISTER_CODE_MSG, Global.SEND_REGISTER_CODE_TAG,
                    "{\"mobile\":\"" + mEtRegisterPhone.getText().toString() + "\"}").execute();
        }
    }

    @Subscribe
    public void onHttpEvent(HttpEvent event) {
        if (event == null || StringUtils.isEmpty(event.getResponse())) {
            showToast("网络连接错误，请稍后重试。");
        } else {
            if (StringUtils.equalsIgnoreCase(Global.SEND_REGISTER_CODE_TAG, event.getTag())) {
                BaseBean bean = new Gson().fromJson(event.getResponse(), BaseBean.class);
                if (bean.getResponse_code() != 1) {
                    showToast(bean.getShow_err());
                } else {
                    startTimer();
                }
            }else if (StringUtils.equalsIgnoreCase(Global.REGISTER_TAG, event.getTag())) {
                Login bean = new Gson().fromJson(event.getResponse(), Login.class);
                if (bean.getResponse_code() != 1) {
                    showToast(bean.getShow_err());
                } else {
                    showToast(bean.getShow_err());
//                    bean.setUser_pwd("123321");
                    bean.setRealPassword(mEtRegisterPassword.getText().toString());
                    Utils.login(_mActivity,bean);
                    startForResult(AddBankCardFragment.newInstance(), 1000);
                }
            }
        }
    }
    @Override
    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        super.onFragmentResult(requestCode, resultCode, data);
        try {
            if (requestCode == 1000){
                switch (resultCode){
                    case RESULT_OK:
                    case Global.ResultCancel:
                        Bundle bundle = new Bundle();
                        setFramgentResult(RESULT_OK, bundle);
                        pop();
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        if (timer != null) {
            timer.cancel();
        }
    }

    public static int DEFAULT_DELAY = 60;
    private Timer timer;
    private int last = 0;

    private void startTimer() {
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
                } else if (last == 0) {
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
