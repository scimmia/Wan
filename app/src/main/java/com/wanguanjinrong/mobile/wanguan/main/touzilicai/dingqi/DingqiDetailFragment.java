package com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi;

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
import com.wanguanjinrong.mobile.wanguan.uitls.Global;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;

/**
 * Created by A on 2016/8/19.
 */
public class DingqiDetailFragment extends BaseFragment {
    String title;
    String url;

    protected Unbinder unbinder;
    @BindView(R.id.tb_dingqi_detail)
    Toolbar mToolbar;
    @BindView(R.id.wv_dingqi_detail)
    WebView mWvDingqiDetail;
    @BindView(R.id.btn_dingqi_buy)
    Button mBtnDingqiBuy;
    private Dingqilicai mDingqilicai;

    public static DingqiDetailFragment newInstance(Dingqilicai dingqilicai) {
        DingqiDetailFragment fragment = new DingqiDetailFragment();
        Bundle args = new Bundle();
        args.putString("args", new Gson().toJson(dingqilicai));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null &&bundle.containsKey("args")){
            mDingqilicai = new Gson().fromJson(bundle.getString("args"),Dingqilicai.class);
            title = mDingqilicai.getName();
            url = mDingqilicai.getItemUrl();
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
        if (mDingqilicai != null && mDingqilicai.getBuyState() != 1){
            mBtnDingqiBuy.setVisibility(View.GONE);
        }
        mBtnDingqiBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(DingqiBuyFragment.newInstance(mDingqilicai));
            }
        });
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
