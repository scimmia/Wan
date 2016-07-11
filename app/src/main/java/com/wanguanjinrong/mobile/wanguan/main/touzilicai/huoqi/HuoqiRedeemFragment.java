package com.wanguanjinrong.mobile.wanguan.main.touzilicai.huoqi;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;

/**
 * Created by A on 2016/7/11.
 */
public class HuoqiRedeemFragment extends BaseFragment {
    protected Unbinder unbinder;
    @BindView(R.id.tb_huoqi_redeem)
    Toolbar mToolbar;
    @BindView(R.id.tv_huoqi_redeem_money)
    EditText mTvHuoqiRedeemMoney;

    public static BaseFragment newInstance() {
        BaseFragment fragment = new HuoqiRedeemFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mToolbar.setTitle("赎回申请");
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mActivity.onBackPressedSupport();
            }
        });
        mTvHuoqiRedeemMoney.setHint("最多可赎回3000.00元");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_huoqi_redeem, container, false);
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
