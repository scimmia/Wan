package com.wanguanjinrong.mobile.wanguan.main.touzilicai.huoqi;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.orhanobut.logger.Logger;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.BusProvider;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.StartBrotherEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;

import java.util.Random;

/**
 * Created by A on 2016/7/7.
 */
public class HuoqilicaiFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.tv_huoqi_lilv)
    TextView mTvHuoqiLilv;
    @BindView(R.id.tv_huoqi_shouyi)
    TextView mTvHuoqiShouyi;
    @BindView(R.id.btn_huoqi_buy)
    Button mBtnHuoqiBuy;
    @BindView(R.id.btn_huoqi_sell)
    Button mBtnHuoqiSell;

    public static HuoqilicaiFragment newInstance() {
        HuoqilicaiFragment fragment = new HuoqilicaiFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setOnRefreshListener(this);

        mTvHuoqiLilv.setText(Html.fromHtml("<big><big>6.105</big></big>%"));
        mTvHuoqiShouyi.setText(Html.fromHtml("<big><big>1.59</big></big>元"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_huoqilicai, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    @Override
    public void onRefresh() {
        Logger.e("onRefresh");
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);

                Random r = new Random();
                mTvHuoqiLilv.setText(Html.fromHtml("<big><big>"+(5+r.nextInt(5))+'.'+(r.nextInt(999))+"</big></big>%"));
                mTvHuoqiShouyi.setText(Html.fromHtml("<big><big>"+(1+r.nextInt(3))+'.'+(r.nextInt(99))+"</big></big>元"));
            }
        }, 1000);
    }

    @OnClick(R.id.btn_huoqi_buy)
    public void onBuy(){
//        start(HuoqiBuyFragment.newInstance());
        BusProvider.getInstance().post(new StartBrotherEvent(HuoqiBuyFragment.newInstance()));
    }
    @OnClick(R.id.btn_huoqi_sell)
    public void onSell(){
//        start(HuoqiBuyFragment.newInstance());
        BusProvider.getInstance().post(new StartBrotherEvent(HuoqiRedeemFragment.newInstance()));
    }
}
