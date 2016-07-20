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
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import org.apache.commons.lang3.math.NumberUtils;

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
    @BindView(R.id.tv_dingqi_buy_sellway)
    TextView mTvDingqiBuySellway;
    @BindView(R.id.tv_dingqi_buy_moneyleft)
    TextView mTvDingqiBuyMoneyleft;
    @BindView(R.id.et_dingqi_buy_money)
    EditText mEtDingqiBuyMoney;
    @BindView(R.id.tv_dingqi_buy_myleft)
    TextView mTvDingqiBuyMyleft;
    @BindView(R.id.tv_dingqi_buy_myearn)
    TextView mTvDingqiBuyMyearn;
    @BindView(R.id.btn_dingqi_buy)
    Button mBtnDingqiBuy;

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
        if(getArguments() != null && getArguments().containsKey(ARG_Dingqilicai))
            mDingqilicai = new Gson().fromJson(getArguments().getString(ARG_Dingqilicai),Dingqilicai.class);
    }

    private void initView(View view) {
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

        if (mDingqilicai != null){
            mTvDingqiBuyName.setText(mDingqilicai.getName());
//            mTvDingqiId.setText(mDingqilicai.getId());
            mTvDingqiBuyMoneyrate.setText(Html.fromHtml("<big><big>"+mDingqilicai.getMoneyRate()+"</big></big>%"));
//            switch (mDingqilicai.getBuyState()){
//                case 0:
//                    mTvDingqiBuystate.setText("预购");
//                    mTvDingqiBuystate.setTextColor(Color.RED);
//                    break;
//                case 1:
//                    mTvDingqiBuystate.setText("计息中");
//                    mTvDingqiBuystate.setTextColor(Color.GRAY);
//                    break;
//            }
            mTvDingqiBuyDays.setText(mDingqilicai.getDays()+"天");
            mTvDingqiBuyMoneyleft.setText(String.format("%.2f万元",(mDingqilicai.getMoneyLeft()/10000.0)));
            mTvDingqiBuyMyleft.setText(String.format("%.2f万元",(54412.35/10000.0)));
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
}
