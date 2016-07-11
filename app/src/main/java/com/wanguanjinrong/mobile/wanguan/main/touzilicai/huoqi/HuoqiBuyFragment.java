package com.wanguanjinrong.mobile.wanguan.main.touzilicai.huoqi;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;

/**
 * Created by A on 2016/7/8.
 */
public class HuoqiBuyFragment extends BaseFragment {
    protected Unbinder unbinder;
    @BindView(R.id.tb_huoqi_buy)
    Toolbar mToolbar;
    @BindView(R.id.tv_huoqi_buy_total)
    TextView mTvHuoqiBuyTotal;
    @BindView(R.id.tv_huoqi_buy_myleft)
    TextView mTvHuoqiBuyMyleft;
    @BindView(R.id.btn_huoqi_buy)
    Button mBtnHuoqiBuy;

    public static BaseFragment newInstance() {
        BaseFragment fragment = new HuoqiBuyFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mToolbar.setTitle("加入活期");

        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mActivity.onBackPressedSupport();
            }
        });
        mTvHuoqiBuyTotal.setText("50000.00元");
        mTvHuoqiBuyMyleft.setText("3000.00元");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_huoqi_buy, container, false);
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
