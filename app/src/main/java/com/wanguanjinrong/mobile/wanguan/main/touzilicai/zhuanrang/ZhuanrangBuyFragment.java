package com.wanguanjinrong.mobile.wanguan.main.touzilicai.zhuanrang;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.squareup.otto.Subscribe;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.account.LoginFragment;
import com.wanguanjinrong.mobile.wanguan.bean.Login;
import com.wanguanjinrong.mobile.wanguan.bean.Transfer;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi.DingqiBuyFragment;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi.Dingqilicai;
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
 * Created by A on 2016/8/30.
 */
public class ZhuanrangBuyFragment extends BaseFragment {
    private static final String ARG_Dingqilicai = "Dingqilicai";
    protected Unbinder unbinder;
    Login mLogin;
    @BindView(R.id.tb_zhuanrang_buy)
    Toolbar mToolbar;
    @BindView(R.id.tv_zhuanrang_buy_name)
    TextView mTvZhuanrangBuyName;
    @BindView(R.id.tv_zhuanrang_buy_myleft)
    TextView mTvZhuanrangBuyMyleft;
    @BindView(R.id.et_pay_password)
    EditText mEtPayPassword;
    @BindView(R.id.tv_zhuanrang_buy_benxi)
    TextView mTvZhuanrangBuyBenxi;
    @BindView(R.id.tv_zhuanrang_buy_pay)
    TextView mTvZhuanrangBuyPay;
    @BindView(R.id.tv_zhuanrang_buy_gots)
    TextView mTvZhuanrangBuyGots;
    @BindView(R.id.tv_zhuanrang_buy_got_time)
    TextView mTvZhuanrangBuyGotTime;

    private Transfer.ItemBean mItemBean;

    public static ZhuanrangBuyFragment newInstance(Transfer.ItemBean dingqilicai) {
        ZhuanrangBuyFragment fragment = new ZhuanrangBuyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_Dingqilicai, new Gson().toJson(dingqilicai));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItemBean = null;
        if (getArguments() != null && getArguments().containsKey(ARG_Dingqilicai))
            mItemBean = new Gson().fromJson(getArguments().getString(ARG_Dingqilicai), Transfer.ItemBean.class);
    }

    private void initView(View view) {
        mLogin = Utils.getLoginInfo(_mActivity);
        mToolbar.setTitle(R.string.dingqi_buy);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mActivity.onBackPressedSupport();
            }
        });

        if (mItemBean != null) {
            mTvZhuanrangBuyName.setText(mItemBean.getName());
            mTvZhuanrangBuyBenxi.setText(Utils.moneyFormatWithYuan(mItemBean.getAll_must_repay_money()));
            mTvZhuanrangBuyPay.setText(Utils.moneyFormatWithYuan(NumberUtils.toDouble(mItemBean.getTransfer_amount())));
            mTvZhuanrangBuyGots.setText(Utils.moneyFormatWithYuan(mItemBean.getTransfer_income()));
            mTvZhuanrangBuyGotTime.setText(mItemBean.getFinal_repay_time_format());
            if (mLogin != null) {
                mTvZhuanrangBuyMyleft.setText(mLogin.getUser_money_format());
            } else {
                mTvZhuanrangBuyMyleft.setText("请先登录");
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zhuanrang_buy, container, false);
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

    @OnClick(R.id.btn_zhuanrang_buy)
    public void onBuy() {
        if (!Utils.isLogin(_mActivity)) {
            BusProvider.getInstance().post(new StartBrotherEvent(LoginFragment.newInstance()));
        } else if (StringUtils.isEmpty(mEtPayPassword.getText().toString())) {
            mEtPayPassword.setError("请输入支付密码");
            mEtPayPassword.requestFocus();
        } else {
            HashMap<String, String> map = new HashMap<>();
            map.put("uid", mLogin.getId() + "");
            map.put("email", mLogin.getUser_name());
            map.put("pwd", mLogin.getUser_pwd());
            map.put("id", mItemBean.getId());
            map.put("paypassword", mEtPayPassword.getText().toString());
            http(Global.DEAL_DOBID_MSG, Global.transfer_dobid_TAG, new Gson().toJson(map), new HttpListener() {
                @Override
                public void onSuccess(String tag, String content) {
                    if (StringUtils.isEmpty(content)) {
                        showToast("网络连接错误，请稍后重试。");
                    } else {
                        Login bean = new Gson().fromJson(content, Login.class);
                        if (bean.getResponse_code() != 1) {
                            showToast(bean.getShow_err());
                        } else {
                            if (bean.getUser_login_status() != 1) {
                                showToast(bean.getShow_err());
                            } else {
                                showToast(bean.getShow_err());
                                refreshLogin();
                                popResult(Global.popEvent.ZhuanrangBuy);
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
                mTvZhuanrangBuyMyleft.setText(mLogin.getUser_money_format());
            } else {
                showToast("请先登录");
            }
        }
    }
}

