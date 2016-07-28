package com.wanguanjinrong.mobile.wanguan.uitls.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.login.DefaultFragment;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi.DingqilicaiFragment;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.huoqi.HuoqilicaiFragment;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.tuple.MutablePair;

import java.util.LinkedList;

/**
 * Created by A on 2016/7/28.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private LinkedList<MutablePair<String,BaseFragment>> items;

    public SimpleFragmentPagerAdapter(FragmentManager fm,LinkedList<MutablePair<String,BaseFragment>> item) {
        super(fm);
        items = item;
    }

    @Override
    public Fragment getItem(int position) {
        return items.get(position).getRight();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return items.get(position).getLeft();
    }
}