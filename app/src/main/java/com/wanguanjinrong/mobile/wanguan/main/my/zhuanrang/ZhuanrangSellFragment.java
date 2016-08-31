package com.wanguanjinrong.mobile.wanguan.main.my.zhuanrang;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
import com.squareup.otto.Subscribe;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.account.LoginFragment;
import com.wanguanjinrong.mobile.wanguan.bean.Login;
import com.wanguanjinrong.mobile.wanguan.bean.UcTransfer;
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
 * Created by A on 2016/8/31.
 */
public class ZhuanrangSellFragment extends BaseFragment {
    private static final String ARG_Dingqilicai = "args";
    protected Unbinder unbinder;
    Login mLogin;
    @BindView(R.id.tb_zhuanrang_buy)
    Toolbar mToolbar;
    @BindView(R.id.tv_zhuanrang_buy_name)
    TextView mTvZhuanrangBuyName;
    @BindView(R.id.tv_zhuanrang_buy_benjin)
    TextView mTvZhuanrangBuyBenjin;
    @BindView(R.id.tv_zhuanrang_buy_lixi)
    TextView mTvZhuanrangBuyLixi;
    @BindView(R.id.tv_zhuanrang_buy_got_time)
    TextView mTvZhuanrangBuyGotTime;
    @BindView(R.id.tv_zhuanrang_buy_myleft)
    TextView mTvZhuanrangBuyMyleft;
    @BindView(R.id.et_dingqi_buy_money)
    EditText mEtDingqiBuyMoney;
    @BindView(R.id.et_dq_pay_password)
    EditText mEtDqPayPassword;
    @BindView(R.id.btn_zhuanrang_buy)
    Button mBtnZhuanrangBuy;


    private UcTransfer.ItemBean mItemBean;

    public static ZhuanrangSellFragment newInstance(UcTransfer.ItemBean dingqilicai) {
        ZhuanrangSellFragment fragment = new ZhuanrangSellFragment();
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
            mItemBean = new Gson().fromJson(getArguments().getString(ARG_Dingqilicai), UcTransfer.ItemBean.class);
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
            mTvZhuanrangBuyBenjin.setText(Utils.moneyFormatWithYuan(mItemBean.getLeft_benjin()));
            mTvZhuanrangBuyLixi.setText(Utils.moneyFormatWithYuan(mItemBean.getLeft_lixi()));
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
        View view = inflater.inflate(R.layout.fragment_zhuanrang_sell, container, false);
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
        } else if (StringUtils.isEmpty(mEtDingqiBuyMoney.getText().toString())) {
            mEtDingqiBuyMoney.setError("请输入转让价格");
            mEtDingqiBuyMoney.requestFocus();
        } else if (StringUtils.isEmpty(mEtDqPayPassword.getText().toString())) {
            mEtDqPayPassword.setError("请输入支付密码");
            mEtDqPayPassword.requestFocus();
        } else {
            HashMap<String, String> map = new HashMap<>();
            map.put("uid", mLogin.getId() + "");
            map.put("email", mLogin.getUser_name());
            map.put("pwd", mLogin.getUser_pwd());
            map.put("dlid", mItemBean.getDlid());
            map.put("dltid", mItemBean.getDltid());
            map.put("transfer_money", mEtDingqiBuyMoney.getText().toString());
            map.put("paypassword", mEtDqPayPassword.getText().toString());
            http(Global.DEAL_DOBID_MSG, Global.uc_do_transfer_TAG, new Gson().toJson(map), new HttpListener() {
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
                                refreshLogin(new HttpListener() {
                                    @Override
                                    public void onSuccess(String tag, String content) {
                                        if (StringUtils.isEmpty(content)) {
                                            showToast("网络连接错误，请稍后重试。");
                                        } else {
                                            Login bean = new Gson().fromJson(content, Login.class);
                                            if (bean.getResponse_code() == 1) {
                                                if (bean.getUser_login_status() == 1) {
                                                    Utils.login(_mActivity, bean);
                                                    mLogin = bean;
                                                    mTvZhuanrangBuyMyleft.setText(mLogin.getUser_money_format());
                                                }
                                            }
                                        }
                                    }
                                });
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
