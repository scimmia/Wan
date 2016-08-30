package com.wanguanjinrong.mobile.wanguan.account;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

/**
 * Created by A on 2016/8/25.
 */
public class ResetPasswordFragment extends BaseFragment {

    protected Unbinder unbinder;
    @BindView(R.id.toolbar_reset_password)
    Toolbar mToolbar;
    @BindView(R.id.et_rp_old_password)
    MaterialEditText mEtRpOldPassword;
    @BindView(R.id.et_rp_password)
    MaterialEditText mEtRpPassword;
    @BindView(R.id.et_rp_password_again)
    MaterialEditText mEtRpPasswordAgain;

    public static BaseFragment newInstance() {
        BaseFragment fragment = new ResetPasswordFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mToolbar.setTitle(R.string.rp_title);
        mToolbar.setBackgroundColor(Global.Toolbar_Color_Red);
        initToobarBack(mToolbar);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reset_password, container, false);
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

    @OnClick(R.id.btn_rp_commit)
    public void commit(){
        Logger.e("commit");
        if (StringUtils.isEmpty(mEtRpOldPassword.getText().toString())){
            mEtRpOldPassword.setError("请输入原密码");
            mEtRpOldPassword.requestFocus();
        }else if (StringUtils.isEmpty(mEtRpPassword.getText().toString())){
            mEtRpPassword.setError("请输入密码");
            mEtRpPassword.requestFocus();
        }else if (!StringUtils.equalsIgnoreCase(mEtRpPassword.getText().toString(),mEtRpPasswordAgain.getText().toString())){
            mEtRpPasswordAgain.setError("请输入正确的密码");
            mEtRpPasswordAgain.requestFocus();
        }else {
            hideSoftInput();
            HashMap<String, String> map = new HashMap<>();
            Login login = Utils.getLoginInfo(_mActivity);
            map.put("uid",login.getId()+"");
            map.put("email", login.getUser_name());
            map.put("pwd", mEtRpOldPassword.getText().toString());
            map.put("user_pwd", mEtRpPassword.getText().toString());
            map.put("user_pwd_confirm", mEtRpPasswordAgain.getText().toString());
            http(Global.UC_SAVE_PWD_MSG, Global.UC_SAVE_PWD_TAG, new Gson().toJson(map));
        }
    }
    @Subscribe
    public void onHttpEvent(HttpEvent event){
        if (event == null || StringUtils.isEmpty(event.getResponse())) {
            showToast("网络连接错误，请稍后重试。");
        } else{
            if (StringUtils.equalsIgnoreCase(Global.UC_SAVE_PWD_TAG,event.getTag())){
                BaseBean bean = new Gson().fromJson(event.getResponse(),BaseBean.class);
                if (bean.getResponse_code() != 1){
                    showToast(bean.getShow_err());
                }else {
                    showToast(bean.getShow_err());
                    Login login = Utils.getLoginInfo(_mActivity);
                    login.setRealPassword(mEtRpPassword.getText().toString());
                    Utils.login(_mActivity,login);
                }
            }
        }
    }

}
