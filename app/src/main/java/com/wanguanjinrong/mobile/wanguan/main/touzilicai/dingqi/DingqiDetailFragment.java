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
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.uitls.Global;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;

/**
 * Created by A on 2016/8/19.
 */
public class DingqiDetailFragment extends BaseFragment {
    String title;
    String url;

    static final String KEY_TITLE = "title";
    static final String KEY_URL = "url";
    protected Unbinder unbinder;
    @BindView(R.id.tb_dingqi_detail)
    Toolbar mToolbar;
    @BindView(R.id.wv_dingqi_detail)
    WebView mWvDingqiDetail;
    @BindView(R.id.btn_dingqi_buy)
    Button mBtnDingqiBuy;

    public static BaseFragment newInstance(String title, String url) {
        BaseFragment fragment = new DingqiDetailFragment();
        Bundle args = new Bundle();
        args.putString(KEY_TITLE, title);
        args.putString(KEY_URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            title = bundle.getString(KEY_TITLE, "");
            url = bundle.getString(KEY_URL, "");
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
