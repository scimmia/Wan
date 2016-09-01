package com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.squareup.otto.Subscribe;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.account.LoginFragment;
import com.wanguanjinrong.mobile.wanguan.bean.Login;
import com.wanguanjinrong.mobile.wanguan.uitls.Global;
import com.wanguanjinrong.mobile.wanguan.uitls.Utils;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.BusProvider;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.LoginEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.StartBrotherEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.http.HttpListener;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.HashMap;

/**
 * Created by A on 2016/7/11.
 */
public class DingqiBuyFragment extends BaseFragment {
    private static final String ARG_Dingqilicai = "Dingqilicai";
    protected Unbinder unbinder;
    @BindView(R.id.tb_dingqi_buy)
    Toolbar mToolbar;
    @BindView(R.id.tv_dingqi_buy_name)
    TextView mTvDingqiBuyName;
    @BindView(R.id.tv_dingqi_buy_moneyrate)
    TextView mTvDingqiBuyMoneyrate;
    @BindView(R.id.tv_dingqi_buy_days)
    TextView mTvDingqiBuyDays;
    @BindView(R.id.tv_dingqi_buy_moneymin)
    TextView mTvDingqiBuyMoneymin;
    @BindView(R.id.tv_dingqi_buy_needmoney)
    TextView mTvDingqiBuyNeedmoney;
    @BindView(R.id.et_dingqi_buy_money)
    EditText mEtDingqiBuyMoney;
    @BindView(R.id.tv_dingqi_buy_myleft)
    TextView mTvDingqiBuyMyleft;
    @BindView(R.id.tv_dingqi_buy_myearn)
    TextView mTvDingqiBuyMyearn;
    @BindView(R.id.btn_dingqi_buy)
    Button mBtnDingqiBuy;
    @BindView(R.id.et_dq_pay_password)
    TextView mEtDqPayPassword;
    Login mLogin;

    private Dingqilicai mDingqilicai;

    public static BaseFragment newInstance(Dingqilicai dingqilicai) {
        BaseFragment fragment = new DingqiBuyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_Dingqilicai, new Gson().toJson(dingqilicai));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDingqilicai = null;
        if (getArguments() != null && getArguments().containsKey(ARG_Dingqilicai))
            mDingqilicai = new Gson().fromJson(getArguments().getString(ARG_Dingqilicai), Dingqilicai.class);
    }

    private void initView(View view) {
        mLogin = Utils.getLoginInfo(_mActivity);
        mToolbar.setTitle("加入");
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mActivity.onBackPressedSupport();
            }
        });

        mEtDingqiBuyMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                Logger.e(s.toString());
                if (mDingqilicai != null) {
                    double buy = NumberUtils.toDouble(s.toString()) * NumberUtils.toDouble(mDingqilicai.getMoneyRate()) / 100
                            * mDingqilicai.getDays() / 360;
                    mTvDingqiBuyMyearn.setText(String.format("%.2f元", buy));
                }
            }
        });

        if (mDingqilicai != null) {
            mTvDingqiBuyName.setText(mDingqilicai.getName());
            mTvDingqiBuyMoneyrate.setText(Html.fromHtml("<big><big>" + mDingqilicai.getMoneyRate() + "</big></big>%"));
            mTvDingqiBuyDays.setText(mDingqilicai.getDays() + "天");
            mTvDingqiBuyNeedmoney.setText(mDingqilicai.getMoneyLeft());
            mTvDingqiBuyMoneymin.setText(Utils.moneyFormatWithYuan(mDingqilicai.getMoneyStart()));
            if (mLogin != null) {
                mTvDingqiBuyMyleft.setText(mLogin.getUser_money_format());
            } else {
                mTvDingqiBuyMyleft.setText("请先登录");
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dingqi_buy, container, false);
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

    @OnClick(R.id.btn_dingqi_buy)
    public void onBuy() {
        if (!Utils.isLogin(_mActivity)) {
            BusProvider.getInstance().post(new StartBrotherEvent(LoginFragment.newInstance()));
        } else if (StringUtils.isEmpty(mEtDingqiBuyMoney.getText().toString())) {
            mEtDingqiBuyMoney.setError("请输入投资金额");
            mEtDingqiBuyMoney.requestFocus();
//        }else if (StringUtils.isEmpty(mEtAbcBankcardNo.getText().toString())){
//            mEtAbcBankcardNo.setError("请输入银行卡号");
//            mEtAbcBankcardNo.requestFocus();
//        }else if (StringUtils.isEmpty(mEtAbcRealname.getText().toString())){
//            mEtAbcRealname.setError("请输入姓名");
//            mEtAbcRealname.requestFocus();
        } else if (StringUtils.isEmpty(mEtDqPayPassword.getText().toString())) {
            mEtDqPayPassword.setError("请输入支付密码");
            mEtDqPayPassword.requestFocus();
        } else {
            HashMap<String, String> map = new HashMap<>();
            map.put("uid", mLogin.getId() + "");
            map.put("email", mLogin.getUser_name());
            map.put("pwd", mLogin.getUser_pwd());
            map.put("id", mDingqilicai.getId());
            map.put("bid_money", mEtDingqiBuyMoney.getText().toString());
            map.put("bid_paypassword", mEtDqPayPassword.getText().toString());
            http(Global.DEAL_DOBID_MSG, Global.DEAL_DOBID_TAG, new Gson().toJson(map), new HttpListener() {
                @Override
                public void onSuccess(String tag, String content) {
                    if (StringUtils.isEmpty(content)) {
                        showToast("网络连接错误，请稍后重试。");
                    } else if (StringUtils.equalsIgnoreCase(Global.DEAL_DOBID_TAG, tag)) {
                        Login bean = new Gson().fromJson(content, Login.class);
                        if (bean.getResponse_code() != 1) {
                            showToast(bean.getShow_err());
                        } else {
                            if (bean.getUser_login_status() != 1) {
                                showToast(bean.getShow_err());
                            } else {
                                showToast(bean.getShow_err());
                                refreshLogin();
                                popResult(Global.popEvent.DingqiBuy);
                            }
                        }
                    }
                }
            });
        }
    }

    @Subscribe
    public void onLoginEvent(LoginEvent event) {
        if (event != null) {
            mLogin = Utils.getLoginInfo(_mActivity);
            if (mLogin != null) {
                mTvDingqiBuyMyleft.setText(mLogin.getUser_money_format());
            } else {
                showToast("请先登录");
            }
        }
    }
}
