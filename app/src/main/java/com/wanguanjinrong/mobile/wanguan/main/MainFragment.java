package com.wanguanjinrong.mobile.wanguan.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.orhanobut.logger.Logger;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.login.ImageFragment;
import me.yokeyword.fragmentation.SupportFragment;

public class MainFragment extends SupportFragment {

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;

    BadgeItem numberBadgeItem;

    private SupportFragment[] mFragments = new SupportFragment[4];

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        if (savedInstanceState == null) {
            mFragments[0] = ImageFragment.newInstance(R.layout.slider_a);
            mFragments[1] = ImageFragment.newInstance(R.layout.slider_b);
            mFragments[2] = ImageFragment.newInstance(R.layout.slider_c);
            mFragments[3] = ImageFragment.newInstance(R.layout.slider_a);

            loadMultipleRootFragment(R.id.main_layout, 0,
                    mFragments[0],
                    mFragments[1],
                    mFragments[2],
                    mFragments[3]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用,也可以通过getChildFragmentManager.getFragments()自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[0] = findChildFragment(ImageFragment.class);
            mFragments[1] = findChildFragment(ImageFragment.class);
            mFragments[2] = findChildFragment(ImageFragment.class);
            mFragments[3] = findChildFragment(ImageFragment.class);
        }

        initView(view);
        return view;
    }

    private void initView(View view) {
        numberBadgeItem = new BadgeItem()
                .setBorderWidth(4)
                .setBackgroundColorResource(R.color.blue)
                .setText("67")
                .setHideOnSelect(true);

        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "首页").setActiveColorResource(R.color.orange).setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "理财产品").setActiveColorResource(R.color.teal))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "我要借款").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "我的财富").setActiveColorResource(R.color.brown))
//                .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp, "Games").setActiveColorResource(R.color.grey))
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {
                Logger.e(mBottomNavigationBar.getCurrentSelectedPosition()+"onTabSelected---"+position);
            }
            @Override
            public void onTabUnselected(int position) {
                Logger.e(mBottomNavigationBar.getCurrentSelectedPosition()+"onTabUnselected---"+position);
                showHideFragment(mFragments[mBottomNavigationBar.getCurrentSelectedPosition()], mFragments[position]);

            }
            @Override
            public void onTabReselected(int position) {
                Logger.e(mBottomNavigationBar.getCurrentSelectedPosition()+"onTabReselected---"+position);
            }
        });
    }

}
