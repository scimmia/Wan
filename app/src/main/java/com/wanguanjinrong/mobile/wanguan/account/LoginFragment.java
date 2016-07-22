package com.wanguanjinrong.mobile.wanguan.account;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.BusProvider;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.LoginEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;

import static com.wanguanjinrong.mobile.wanguan.uitls.Global.LOGIN_PASSWORD;
import static com.wanguanjinrong.mobile.wanguan.uitls.Global.LOGIN_USER_NAME;

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
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
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

        // 登录成功
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(_mActivity);
        SharedPreferences.Editor spEd = sp.edit();
        spEd.putString(LOGIN_USER_NAME, mEtLoginName.getText().toString());
        spEd.putString(LOGIN_PASSWORD, mEtLoginPassword.getText().toString());
        spEd.apply();

        hideSoftInput();
        BusProvider.getInstance().post(new LoginEvent());
        pop();
    }

    @OnClick(R.id.btn_register)
    public void onRegister(){

    }
}
