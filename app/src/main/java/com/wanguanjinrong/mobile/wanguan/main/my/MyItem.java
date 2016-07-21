package com.wanguanjinrong.mobile.wanguan.main.my;

import com.wanguanjinrong.mobile.wanguan.R;

import java.util.Random;

/**
 * Created by A on 2016/7/20.
 */
public class MyItem {
    int mPicId;
    int mTitleId;

    public int getPicId() {
        return mPicId;
    }

    public int getTitleId() {
        return mTitleId;
    }

    public MyItem( int titleId,int picId) {
        mTitleId = titleId;
        mPicId = picId;
    }

    public static  MyItem generRandomData(){
//        String[] ids = new String[]{"","",""};
        Integer[] ids = new Integer[]{R.string.app_name,R.string.borrow_address,R.string.borrow_days,R.string.borrow_hascar,R.string.borrow_hashouse};
        Integer[] icons = new Integer[]{R.drawable.bottom_bar_1_normal,R.drawable.bottom_bar_1_press,R.drawable.bottom_bar_2_normal,R.drawable.bottom_bar_2_press};
        Random r = new Random();
        return new MyItem(ids[r.nextInt(ids.length)],icons[r.nextInt(icons.length)]);
    }

}
