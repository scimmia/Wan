package com.wanguanjinrong.mobile.wanguan.main.my.zijinguanli;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi.DingqilicaiFragment;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.huoqi.HuoqiBuyFragment;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.huoqi.HuoqiRedeemFragment;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.huoqi.HuoqilicaiFragment;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.SimpleFragmentPagerAdapter;
import org.apache.commons.lang3.tuple.MutablePair;

import java.util.LinkedList;

/**
 * Created by A on 2016/7/28.
 */
public class ZijinguanliFragment extends BaseFragment {
    protected Unbinder unbinder;
    @BindView(R.id.toolbar_touzi)
    Toolbar mToolbar;
    @BindView(R.id.sliding_tabs)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    private SimpleFragmentPagerAdapter pagerAdapter;

    public static BaseFragment newInstance() {
        BaseFragment fragment = new ZijinguanliFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mToolbar.setTitle("资金管理");
//        initToolbarMenu(mToolbar);

//        mTabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
//        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);

        LinkedList<MutablePair<String,BaseFragment>> items = new LinkedList<>();
        items.add(new MutablePair<String, BaseFragment>("资金统计", ZijintongjiFragment.newInstance()));
        items.add(new MutablePair<String, BaseFragment>("历史明细", HuoqiRedeemFragment.newInstance()));
        pagerAdapter = new SimpleFragmentPagerAdapter(getChildFragmentManager(),items);
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_touzi_licai, container, false);
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
