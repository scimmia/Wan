package com.wanguanjinrong.mobile.wanguan.account;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.squareup.otto.Subscribe;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.bean.Login;
import com.wanguanjinrong.mobile.wanguan.uitls.Global;
import com.wanguanjinrong.mobile.wanguan.uitls.Utils;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.BusProvider;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.HttpEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.LoginEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.StartBrotherEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.http.HttpTask;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

/**
 * Created by A on 2016/7/22.
 */
public class LoginFragment extends BaseFragment {
    protected Unbinder unbinder;

    @BindView(R.id.toolbar_login)
    Toolbar mToolbar;
    @BindView(R.id.et_login_name)
    MaterialEditText mEtLoginName;
    @BindView(R.id.et_login_password)
    MaterialEditText mEtLoginPassword;

    public static BaseFragment newInstance() {
        BaseFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mToolbar.setTitle(R.string.login);
        mToolbar.setBackgroundColor(0xFFf71e1a);
        initToobarBack(mToolbar);
        mToolbar.inflateMenu(R.menu.menu_login);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_register:
                        BusProvider.getInstance().post(new StartBrotherEvent(RegisterFragment.newInstance()));
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
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

    @OnClick(R.id.btn_login)
    public void onLogin(){
        String strAccount = mEtLoginName.getText().toString();
        String strPassword = mEtLoginPassword.getText().toString();
        if (TextUtils.isEmpty(strAccount.trim())) {
            mEtLoginName.setError("用户名不能为空!");
            return;
        }
        if (TextUtils.isEmpty(strPassword.trim())) {
            mEtLoginPassword.setError("密码不能为空!");
            return;
        }

        HashMap<String,String> map = new HashMap<>();
//        map.put("act","login");
        map.put("email",strAccount);
        map.put("pwd",strPassword);
        new HttpTask(_mActivity, Global.LOGIN_MSG, Global.LOGIN_TAG,new Gson().toJson(map)).execute();
//        // 登录成功
//        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(_mActivity);
//        SharedPreferences.Editor spEd = sp.edit();
//        spEd.putString(LOGIN_USER_NAME, mEtLoginName.getText().toString());
//        spEd.putString(LOGIN_PASSWORD, mEtLoginPassword.getText().toString());
//        spEd.apply();

    }

    @OnClick(R.id.btn_forget)
    public void onForgetPassword(){
        BusProvider.getInstance().post(new StartBrotherEvent(ForgetPasswordFragment.newInstance()));
//        SMSSDK.initSDK(_mActivity, "1543694879524", "e649155554c22e99173f58d8a3fdff83");
//        //打开注册页面
//        RegisterPage registerPage = new RegisterPage();
//        registerPage.setRegisterCallback(new EventHandler() {
//            public void afterEvent(int event, int result, Object data) {
//        // 解析注册结果
//                if (result == SMSSDK.RESULT_COMPLETE) {
//                    @SuppressWarnings("unchecked")
//                    HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
//                    String country = (String) phoneMap.get("country");
//                    String phone = (String) phoneMap.get("phone");
//
//        // 提交用户信息
//                    Logger.e(country+"----"+ phone);
////                    registerUser(country, phone);
//                }
//            }
//        });
//        registerPage.show(_mActivity);
    }


    @Subscribe
    public void onHttpEvent(HttpEvent event){
        if (event == null || StringUtils.isEmpty(event.getResponse())) {
            showToast("网络连接错误，请稍后重试。");
        } else{
            if (StringUtils.equalsIgnoreCase(Global.LOGIN_TAG,event.getTag())){
                Login bean = new Gson().fromJson(event.getResponse(),Login.class);
                if (bean.getResponse_code() != 1){
                    showToast(bean.getShow_err());
                }else {
                    if (bean.getUser_login_status() != 1){
                        showToast(bean.getShow_err());
                    }else {
                        bean.setUser_pwd(mEtLoginPassword.getText().toString());
                        Utils.login(_mActivity, bean);
                        hideSoftInput();
                        BusProvider.getInstance().post(new LoginEvent(Global.LoginStateIn));
                        pop();
                    }
                }
            }
        }
    }
}
