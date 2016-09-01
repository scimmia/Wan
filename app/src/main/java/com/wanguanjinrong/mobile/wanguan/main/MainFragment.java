package com.wanguanjinrong.mobile.wanguan.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.squareup.otto.Subscribe;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.bean.Version;
import com.wanguanjinrong.mobile.wanguan.main.borrow.BorrowFragment;
import com.wanguanjinrong.mobile.wanguan.main.home.HomeFragment;
import com.wanguanjinrong.mobile.wanguan.main.my.MyFragment;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.TouziLicaiFragment;
import com.wanguanjinrong.mobile.wanguan.uitls.Global;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.HttpEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.StartBrotherEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.TabSelectedEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.http.HttpDownloadTask;
import com.wanguanjinrong.mobile.wanguan.uitls.http.HttpListener;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import me.yokeyword.fragmentation.SupportFragment;
import org.apache.commons.lang3.StringUtils;
import java.io.File;

public class MainFragment extends BaseFragment {

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;

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
            mFragments[0] = HomeFragment.newInstance();
            mFragments[1] = TouziLicaiFragment.newInstance();
//            mFragments[1] = ImageFragment.newInstance(R.layout.slider_b);
            mFragments[2] = BorrowFragment.newInstance();
            mFragments[3] = MyFragment.newInstance();

            loadMultipleRootFragment(R.id.main_layout, 0,
                    mFragments[0],
                    mFragments[1],
                    mFragments[2],
                    mFragments[3]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用,也可以通过getChildFragmentManager.getFragments()自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[0] = findChildFragment(HomeFragment.class);
            mFragments[1] = findChildFragment(TouziLicaiFragment.class);
            mFragments[2] = findChildFragment(BorrowFragment.class);
            mFragments[3] = findChildFragment(MyFragment.class);
        }

        initView(view);
        return view;
    }

    private void initView(View view) {
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        mBottomNavigationBar.setActiveColor(R.color.orange);
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.bottom_bar_1_press, "首页").setInactiveIconResource(R.drawable.bottom_bar_1_normal))
                .addItem(new BottomNavigationItem(R.drawable.bottom_bar_2_press, "理财产品").setInactiveIconResource(R.drawable.bottom_bar_2_normal))
                .addItem(new BottomNavigationItem(R.drawable.bottom_bar_5_press, "我要借款").setInactiveIconResource(R.drawable.bottom_bar_5_normal))
                .addItem(new BottomNavigationItem(R.drawable.bottom_bar_3_press, "我的财富").setInactiveIconResource(R.drawable.bottom_bar_3_normal))
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
        checkUpdate();
    }

    @Subscribe
    public void onTabSelect(TabSelectedEvent event){
        if (event != null && event.position >= 0 && event.position < mFragments.length){
            mBottomNavigationBar.selectTab(event.position);
//            showHideFragment(mFragments[event.position],mFragments[mBottomNavigationBar.getCurrentSelectedPosition()]);
        }
    }

    @Subscribe
    public void onStartBrother(StartBrotherEvent event){
        if (event != null && event.targetFragment != null){
            start(event.targetFragment);
        }
    }

    void checkUpdate(){
        http("", Global.version_TAG, "{\"dev_type\":\"android\",\"version\":\""+Global.version+"\"}", new HttpListener() {
            @Override
            public void onSuccess(String tag, String content) {
                if (StringUtils.isNotEmpty(content)) {
                    try {
                        final Version bean = new Gson().fromJson(content, Version.class);
                        if (bean.getResponse_code() == 1) {
                            if (StringUtils.isNoneEmpty(bean.getFilename())
                                    && StringUtils.equalsIgnoreCase("1",bean.getHasfile())) {
                                new AlertDialog.Builder(_mActivity)
                                        .setTitle("升级信息提示")
                                        .setMessage("发现新版本："+bean.getServerVersion()
                                                +"\n更新内容："+bean.getAndroid_upgrade())
                                        .setNegativeButton("现在升级", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                new HttpDownloadTask(
                                                        _mActivity,Global.DownloadNewFile_MSG,Global.DownloadNewFile_TAG,
                                                        bean.getFilename(),
                                                        Global.updateFolder+"Wanguan.apk").execute();
                                            }
                                        })
                                        .setPositiveButton("以后再说",null)
                                        .setCancelable(false)
                                        .show();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    @Subscribe
    public void onHttpEvent(HttpEvent event){
        if (event == null || StringUtils.isEmpty(event.getResponse())) {
            showToast("网络连接错误，请稍后重试。");
        } else{
            if (StringUtils.equalsIgnoreCase(Global.DownloadNewFile_TAG,event.getTag())){
                try {
                    if (StringUtils.isNotEmpty(event.getResponse())) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setDataAndType(Uri.fromFile(new File(event.getResponse())), "application/vnd.android.package-archive");
                        startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
