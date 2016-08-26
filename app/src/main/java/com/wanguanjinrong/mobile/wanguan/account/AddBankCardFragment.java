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
import butterknife.*;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.squareup.otto.Subscribe;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.bean.BaseBean;
import com.wanguanjinrong.mobile.wanguan.bean.Login;
import com.wanguanjinrong.mobile.wanguan.bean.SupportBank;
import com.wanguanjinrong.mobile.wanguan.uitls.Global;
import com.wanguanjinrong.mobile.wanguan.uitls.Utils;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.HttpEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.http.HttpListener;
import com.wanguanjinrong.mobile.wanguan.uitls.http.HttpTask;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by A on 2016/8/24.
 */
public class AddBankCardFragment extends BaseFragment implements HttpListener{

    SupportBank mSupportBank;

    protected Unbinder unbinder;
    @BindView(R.id.toolbar_add_bank_card)
    Toolbar mToolbar;
    @BindView(R.id.et_abc_choose_bank)
    MaterialEditText mEtAbcChooseBank;
    @BindView(R.id.et_abc_bankcard_no)
    MaterialEditText mEtAbcBankcardNo;
    @BindView(R.id.et_abc_realname)
    MaterialEditText mEtAbcRealname;
    @BindView(R.id.et_abc_cardid)
    MaterialEditText mEtAbcCardid;
    @BindView(R.id.et_abc_phone)
    MaterialEditText mEtAbcPhone;
    @BindView(R.id.btn_abc_code)
    Button mBtnCode;
    @BindView(R.id.et_abc_code)
    MaterialEditText mEtAbcCode;
    Login mLogin;

    public static BaseFragment newInstance() {
        BaseFragment fragment = new AddBankCardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mSupportBank = null;
        mLogin = Utils.getLoginInfo(_mActivity);
        mToolbar.setTitle(R.string.abc_title);
        mToolbar.setBackgroundColor(Global.Toolbar_Color_Red);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressedSupport();
            }
        });
        mToolbar.inflateMenu(R.menu.menu_addbankcard);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_commit:
                        if (StringUtils.isEmpty((String) mEtAbcChooseBank.getTag())){
                            mEtAbcChooseBank.setError("请选择开户行");
                        }else if (StringUtils.isEmpty(mEtAbcBankcardNo.getText().toString())){
                            mEtAbcBankcardNo.setError("请输入银行卡号");
                            mEtAbcBankcardNo.requestFocus();
                        }else if (StringUtils.isEmpty(mEtAbcRealname.getText().toString())){
                            mEtAbcRealname.setError("请输入姓名");
                            mEtAbcRealname.requestFocus();
                        }else if (StringUtils.isEmpty(mEtAbcCardid.getText().toString())){
                            mEtAbcCardid.setError("请输入身份证号");
                            mEtAbcCardid.requestFocus();
                            //// TODO: 2016/8/26  
//                        }else if (StringUtils.isEmpty(mEtAbcCardid.getText().toString())){
//                            mEtRegisterPhone.setError("请输入手机号");
//                            mEtRegisterPhone.requestFocus();
//                        }else if (!Utils.isMobileNumber(mEtRegisterPhone.getText().toString())){
//                            mEtRegisterPhone.setError("请输入正确的手机号");
//                            mEtRegisterPhone.requestFocus();
//                        }else if (StringUtils.isEmpty(mEtRegisterCode.getText().toString())){
//                            mEtRegisterCode.setError("请输入验证码");
//                            mEtRegisterCode.requestFocus();
                        }else {
                            HashMap<String, String> map = new HashMap<>();
                            map.put("uid", mLogin.getId() + "");
                            map.put("email", mLogin.getUser_name());
                            map.put("pwd", mLogin.getUser_pwd());
                            map.put("bank_id", (String) mEtAbcChooseBank.getTag());
                            map.put("bankcard", mEtAbcBankcardNo.getText().toString());
                            map.put("idno", mEtAbcCardid.getText().toString());
                            map.put("real_name", mEtAbcRealname.getText().toString());
                            new HttpTask(_mActivity, Global.UC_SAVE_BANK_MSG, Global.UC_SAVE_BANK_TAG, new Gson().toJson(map)).execute();
                        }
//                        new HttpTask(_mActivity, Global.UC_SAVE_BANK_MSG, Global.UC_SAVE_BANK_TAG, "{\"bank_id\":\"2\",\"uid\":\"2041\",\"pwd\":\"1\",\"idno\":\"444445\",\"email\":\"18660187425qu\",\"real_name\":\"急急急\",\"bankcard\":\"666888859888885555\"}").execute();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_bank_card, container, false);
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

    @OnFocusChange(R.id.et_abc_choose_bank)
    void onet_abc_choose_bank(boolean focused) {
        if (focused) {
            onet_abc_choose_bank();
        }
    }

    @OnClick(R.id.et_abc_choose_bank)
    void onet_abc_choose_bank() {
        Logger.e("onet_borrow_house_type");
        if (mSupportBank == null){
            new HttpTask(_mActivity, Global.UC_ADD_BANK_MSG, Global.UC_ADD_BANK_TAG,"").execute();
        }else {
            selectBank();
        }
    }

    void selectBank(){
        int size = mSupportBank.getItem().size();
        String[] names = new String[size];
        String[] ids = new String[size];
        for (int i=0;i<size;i++){
            SupportBank.ItemBean itemBean = mSupportBank.getItem().get(i);
            names[i] = itemBean.getName();
            ids[i] = itemBean.getId();
        }
        showSingleDialog("", names, ids, (String) mEtAbcChooseBank.getTag(), getSingleDialogListener(mEtAbcChooseBank));
    }

    @OnClick(R.id.btn_abc_code)
    public void sendCode() {
        if (!Utils.isMobileNumber(mEtAbcPhone.getText().toString())) {
            showToast("请输入正确的手机号");
        } else {
            new HttpTask(_mActivity, Global.SEND_REGISTER_CODE_MSG, Global.SEND_REGISTER_CODE_TAG,
                    "{\"mobile\":\"" + mEtAbcPhone.getText().toString() + "\"}").execute();
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
            }else if (StringUtils.equalsIgnoreCase(Global.UC_ADD_BANK_TAG, event.getTag())) {
                mSupportBank = new Gson().fromJson(event.getResponse(), SupportBank.class);
                selectBank();
            }else if (StringUtils.equalsIgnoreCase(Global.UC_SAVE_BANK_TAG, event.getTag())) {
                BaseBean bean = new Gson().fromJson(event.getResponse(), BaseBean.class);
                if (bean.getResponse_code() != 1) {
                    showToast(bean.getShow_err());
                } else {
                    showToast(bean.getShow_err());
                    HashMap<String,String> map = new HashMap<>();
                    map.put("email",mLogin.getUser_name());
                    map.put("pwd",mLogin.getUser_pwd());
                    http(Global.LOGIN_REFRESH_MSG, Global.LOGIN_TAG,new Gson().toJson(map),this);
                }
            }
        }
    }

    @Override
    public boolean onBackPressedSupport() {
        // 默认flase，继续向上传递
        Bundle bundle = new Bundle();
        setFramgentResult(Global.ResultCancel, bundle);
        pop();
        return true;
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

    @Override
    public void onSuccess(String tag, String content) {
        if (StringUtils.equalsIgnoreCase(Global.LOGIN_TAG,tag)){
            Login bean = new Gson().fromJson(content,Login.class);
            if (bean.getResponse_code() != 1){
                showToast(bean.getShow_err());
            }else {
                if (bean.getUser_login_status() != 1){
                    showToast(bean.getShow_err());
                }else {
                    bean.setUser_pwd(mLogin.getUser_pwd());
                    Utils.login(_mActivity, bean);
                    Bundle bundle = new Bundle();
                    setFramgentResult(RESULT_OK, bundle);
                    pop();
                }
            }
        }
    }
}
