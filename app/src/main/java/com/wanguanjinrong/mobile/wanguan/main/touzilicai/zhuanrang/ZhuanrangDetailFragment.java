package com.wanguanjinrong.mobile.wanguan.main.touzilicai.zhuanrang;

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
import com.squareup.otto.Subscribe;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.bean.Transfer;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi.DingqiDetailFragment;
import com.wanguanjinrong.mobile.wanguan.uitls.Global;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.FragmentFinishEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by A on 2016/8/30.
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
    private Transfer.ItemBean mItemBean;

    public static ZhuanrangDetailFragment newInstance(Transfer.ItemBean itemBean) {
        ZhuanrangDetailFragment fragment = new ZhuanrangDetailFragment();
        Bundle args = new Bundle();
        args.putString("args", new Gson().toJson(itemBean));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null &&bundle.containsKey("args")){
            mItemBean = new Gson().fromJson(bundle.getString("args"),Transfer.ItemBean.class);
            title = mItemBean.getName();
            url = mItemBean.getApp_url();
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
        if (mItemBean != null){
            if (StringUtils.equalsIgnoreCase(mItemBean.getT_user_id(),"0")){
                if (StringUtils.equalsIgnoreCase(mItemBean.getStatus(),"1")) {
                    mBtnDingqiBuy.setVisibility(View.VISIBLE);
                }
            }
        }
        mBtnDingqiBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(ZhuanrangBuyFragment.newInstance(mItemBean));
            }
        });
    }
    @Subscribe
    public void onPopEvent(FragmentFinishEvent event) {
        if (event != null) {
            switch (event.getPopEvent()){
                case ZhuanrangBuy:
                    popResult(Global.popEvent.ZhuanrangDetail);
                    break;
            }
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
