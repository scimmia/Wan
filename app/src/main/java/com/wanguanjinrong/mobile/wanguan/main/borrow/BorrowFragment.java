package com.wanguanjinrong.mobile.wanguan.main.borrow;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import butterknife.*;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.squareup.otto.Subscribe;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.bean.BaseBean;
import com.wanguanjinrong.mobile.wanguan.uitls.Global;
import com.wanguanjinrong.mobile.wanguan.uitls.Utils;
import com.wanguanjinrong.mobile.wanguan.uitls.http.HttpListener;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by A on 2016/7/8.
 */
public class BorrowFragment extends BaseFragment implements Toolbar.OnMenuItemClickListener {
    protected Unbinder unbinder;
    @BindView(R.id.toolbar_borrow)
    Toolbar mToolbar;
    @BindView(R.id.et_borrow_name)
    MaterialEditText mEtBorrowName;
    @BindView(R.id.et_borrow_phone)
    MaterialEditText mEtBorrowPhone;
    @BindView(R.id.btn_borrow_code)
    Button mBtnBorrowCode;
    @BindView(R.id.et_borrow_code)
    MaterialEditText mEtBorrowCode;
    @BindView(R.id.et_borrow_money)
    MaterialEditText mEtBorrowMoney;
    @BindView(R.id.et_borrow_house_address)
    MaterialEditText mEtBorrowHouseAddress;
    @BindView(R.id.et_borrow_house_type)
    MaterialEditText mEtBorrowHouseType;

    public static BorrowFragment newInstance() {
        BorrowFragment fragment = new BorrowFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mToolbar.setTitle("我要借款");
        mToolbar.inflateMenu(R.menu.borrow);
        mToolbar.setOnMenuItemClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_borrow, container, false);
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

    @OnClick(R.id.btn_borrow_code)
    public void sendCode() {
        if (!Utils.isMobileNumber(mEtBorrowPhone.getText().toString())) {
            showToast("请输入正确的手机号");
        } else {
            http(Global.NULL_MSG, Global.send_apply_verify_code_TAG,
                    "{\"mobile\":\"" + mEtBorrowPhone.getText().toString() + "\"}", new HttpListener() {
                        @Override
                        public void onSuccess(String tag, String content) {
                            if (StringUtils.isEmpty(content)) {
                                showToast("网络连接错误，请稍后重试。");
                            } else if (StringUtils.equalsIgnoreCase(Global.SEND_REGISTER_CODE_TAG,tag)){
                                BaseBean bean = new Gson().fromJson(content, BaseBean.class);
                                if (bean.getResponse_code() != 1) {
                                    showToast(bean.getShow_err());
                                } else {
                                    startTimer();
                                }
                            }
                        }
                    });
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
                            mBtnBorrowCode.setClickable(false);
                            mBtnBorrowCode.setText(last + "秒后重新发送");
                        }
                    });
                } else if (last == 0) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            mBtnBorrowCode.setClickable(true);
                            mBtnBorrowCode.setText(R.string.register_title_sms);
                        }
                    });
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }

    String[] houseAddressNames = {"上海", "北京",};
    String[] houseAddressIDs = {"1", "2",};
    String[] houseTypeNames = {"住宅", "商铺", "办公楼",};
    String[] houseTypeIDs = {"1", "2","3",};
    String[] youwuNames = {"无", "有",};
    String[] youwuIDs = {"0", "1",};

    @OnFocusChange(R.id.et_borrow_house_address)
    void onet_borrow_house_addressFocus(boolean focused) {
        if (focused) {
            onet_borrow_house_address();
        }
    }

    @OnClick(R.id.et_borrow_house_address)
    void onet_borrow_house_address() {
        Logger.e("onet_borrow_house_address");
        showSingleDialog("", houseAddressNames, houseAddressIDs, (String) mEtBorrowHouseAddress.getTag(), getSingleDialogListener(mEtBorrowHouseAddress));
    }

    @OnFocusChange(R.id.et_borrow_house_type)
    void onet_borrow_house_typeFocus(boolean focused) {
        if (focused) {
            onet_borrow_house_type();
        }
    }

    @OnClick(R.id.et_borrow_house_type)
    void onet_borrow_house_type() {
        Logger.e("onet_borrow_house_type");
        showSingleDialog("", houseTypeNames, houseTypeIDs, (String) mEtBorrowHouseType.getTag(), getSingleDialogListener(mEtBorrowHouseType));
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_borrow:
                Logger.e("action_borrow");
                if (StringUtils.isEmpty(mEtBorrowName.getText().toString())){
                    mEtBorrowName.setError("请输入姓名");
                    mEtBorrowName.requestFocus();
                }else if (StringUtils.isEmpty(mEtBorrowPhone.getText().toString())){
                    mEtBorrowPhone.setError("请输入手机号");
                    mEtBorrowPhone.requestFocus();
                }else if (!Utils.isMobileNumber(mEtBorrowPhone.getText().toString())){
                    mEtBorrowPhone.setError("请输入正确的手机号");
                    mEtBorrowPhone.requestFocus();
                }else if (StringUtils.isEmpty(mEtBorrowCode.getText().toString())){
                    mEtBorrowCode.setError("请输入验证码");
                    mEtBorrowCode.requestFocus();
                }else if (StringUtils.isEmpty(mEtBorrowMoney.getText().toString())){
                    mEtBorrowMoney.setError("请输入申请金额");
                    mEtBorrowMoney.requestFocus();
                }else if (StringUtils.isEmpty(mEtBorrowHouseAddress.getText().toString())){
                    mEtBorrowHouseAddress.setError("请选择抵押物所在地");
                    mEtBorrowHouseAddress.requestFocus();
                }else if (StringUtils.isEmpty(mEtBorrowHouseType.getText().toString())){
                    mEtBorrowHouseType.setError("请选择抵押物产权类型");
                    mEtBorrowHouseType.requestFocus();
                }else {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("borrow_name", mEtBorrowName.getText().toString());
                    map.put("tel", mEtBorrowPhone.getText().toString());
                    map.put("payauthcode", mEtBorrowCode.getText().toString());
                    map.put("apply_amount", mEtBorrowMoney.getText().toString());
                    map.put("pledge_area", (String)mEtBorrowHouseAddress.getTag());
                    map.put("pledge_property", (String)mEtBorrowHouseType.getTag());
                    http(Global.BORROW_MSG, Global.BORROW_TAG, new Gson().toJson(map), new HttpListener() {
                        @Override
                        public void onSuccess(String tag, String content) {
                            if (StringUtils.isEmpty(content)) {
                                showToast("网络连接错误，请稍后重试。");
                            } else if (StringUtils.equalsIgnoreCase(Global.BORROW_TAG,tag)){
                                BaseBean bean = new Gson().fromJson(content,BaseBean.class);
                                if (bean.getResponse_code() != 1){
                                    showToast(bean.getShow_err());
                                }else {
                                    showToast(bean.getShow_err());
                                }
                            }
                        }
                    });
                }
                break;
        }
        return true;
    }
}
