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
import com.wanguanjinrong.mobile.wanguan.login.DefaultFragment;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi.DingqilicaiFragment;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;

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

        pagerAdapter = new SimpleFragmentPagerAdapter(getFragmentManager());
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

    class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

        final int PAGE_COUNT = 3;
        private String tabTitles[] = new String[]{"活期理财","定期理财","tab3"};
        private int layouts[] = new int[]{R.layout.slider_a,R.layout.slider_b,R.layout.slider_c};

        public SimpleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {
                return HuoqilicaiFragment.newInstance();
            } else if (position == 1) {
                return DingqilicaiFragment.newInstance();
            } else{
                return DefaultFragment.newInstance(layouts[position]);
            }
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
