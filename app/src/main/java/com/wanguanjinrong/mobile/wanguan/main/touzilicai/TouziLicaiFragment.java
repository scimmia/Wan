package com.wanguanjinrong.mobile.wanguan.main.touzilicai;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi.DingqilicaiFragment;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.huoqi.HuoqilicaiFragment;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.zhuanrang.ZhuanrangListFragment;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.SimpleFragmentPagerAdapter;
import org.apache.commons.lang3.tuple.MutablePair;

import java.util.LinkedList;

public class TouziLicaiFragment extends BaseFragment {

    private Toolbar mToolbar;
    TabLayout mTabLayout;
    ViewPager mViewPager;

    private SimpleFragmentPagerAdapter pagerAdapter;

    public static TouziLicaiFragment newInstance() {
        TouziLicaiFragment fragment = new TouziLicaiFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar_touzi);

        mToolbar.setTitle("理财产品");
//        initToolbarMenu(mToolbar);
        mTabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);

        LinkedList<MutablePair<String,BaseFragment>> items = new LinkedList<>();
        items.add(new MutablePair<String, BaseFragment>("活期理财", HuoqilicaiFragment.newInstance()));
        items.add(new MutablePair<String, BaseFragment>("定期理财", DingqilicaiFragment.newInstance()));
        items.add(new MutablePair<String, BaseFragment>("转让专区", ZhuanrangListFragment.newInstance()));
        pagerAdapter = new SimpleFragmentPagerAdapter(getChildFragmentManager(),items);

//        pagerAdapter = new SimpleFragmentPagerAdapter(getFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_touzi_licai, container, false);
        initView(view);
        return view;
    }

}
