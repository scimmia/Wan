package com.wanguanjinrong.mobile.wanguan.main.my.zhuanrang;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.bean.Login;
import com.wanguanjinrong.mobile.wanguan.bean.UcTransfer;
import com.wanguanjinrong.mobile.wanguan.uitls.Global;
import com.wanguanjinrong.mobile.wanguan.uitls.Utils;
import com.wanguanjinrong.mobile.wanguan.uitls.http.HttpListener;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

/**
 * Created by A on 2016/8/31.
 */
public class ZhuanrangDetailFragment extends BaseFragment {
    String title;
    String url;

    protected Unbinder unbinder;
    @BindView(R.id.tb_dingqi_detail)
    Toolbar mToolbar;
    @BindView(R.id.wv_dingqi_detail)
    WebView mWvDingqiDetail;
    @BindView(R.id.btn_dingqi_buy)
    Button mBtnDingqiBuy;
    private UcTransfer.ItemBean mItemBean;
    int mFragmentType;

    public static ZhuanrangDetailFragment newInstance(UcTransfer.ItemBean itemBean,int fragmentType) {
        ZhuanrangDetailFragment fragment = new ZhuanrangDetailFragment();
        Bundle args = new Bundle();
        args.putString("args", new Gson().toJson(itemBean));
        args.putInt("fragmenttype",fragmentType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null &&bundle.containsKey("args")){
            mItemBean = new Gson().fromJson(bundle.getString("args"),UcTransfer.ItemBean.class);
            title = mItemBean.getName();
            url = mItemBean.getApp_url();
        }
        if (bundle != null &&bundle.containsKey("fragmenttype")){
            mFragmentType = bundle.getInt("fragmenttype",Global.typeTransferMyList);
        }
    }

    private void initView(View view) {
        mToolbar.setTitle(title);
        mToolbar.setBackgroundColor(Global.Toolbar_Color_Red);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });
        mWvDingqiDetail.loadUrl(url);
        mBtnDingqiBuy.setVisibility(View.GONE);
        if (mFragmentType == Global.typeTransferMyList){
            switch (mItemBean.getTras_status_op()){
                case 1:
                    mBtnDingqiBuy.setText("转让");
                    mBtnDingqiBuy.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    mBtnDingqiBuy.setText("还款完毕");
                    break;
                case 3:
                    mBtnDingqiBuy.setText("逾期还款");
                    break;
                case 4:
                    mBtnDingqiBuy.setText("重转让");
                    mBtnDingqiBuy.setVisibility(View.VISIBLE);
                    break;
                case 5:
                    mBtnDingqiBuy.setText("完成");
                    break;
                case 6:
                    mBtnDingqiBuy.setText("撤销");
                    mBtnDingqiBuy.setVisibility(View.VISIBLE);
                    break;
            }
            mBtnDingqiBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (mItemBean.getTras_status_op()){
                        case 1:
                        case 4:
                            start(ZhuanrangSellFragment.newInstance(mItemBean));
                            break;
                        case 6:
                            Login login = Utils.getLoginInfo(_mActivity);
                            if (login != null) {
                                HashMap<String, String> map = new HashMap<>();
                                map.put("uid", login.getId() + "");
                                map.put("email", login.getUser_name());
                                map.put("pwd", login.getUser_pwd());
                                map.put("dltid", mItemBean.getDltid());
                                http(Global.DEAL_DOBID_MSG, Global.uc_do_reback_TAG, new Gson().toJson(map), new HttpListener() {
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
                                                }
                                            }
                                        }
                                    }
                                });
                            }
                            break;
                    }
                }
            });
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dingqi_detail, container, false);
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
}
