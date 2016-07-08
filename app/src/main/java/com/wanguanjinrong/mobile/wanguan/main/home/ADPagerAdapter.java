package com.wanguanjinrong.mobile.wanguan.main.home;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by A on 2016/7/6.
 */
public class ADPagerAdapter extends PagerAdapter{
    ArrayList<String> mItemsUrlList;
    Context mContext;
    public ADPagerAdapter(Context context) {
        this(context,null);
    }

    public ADPagerAdapter(Context context,ArrayList<String> urls) {
        mContext = context;
        setData(urls);
    }

    public void setData(ArrayList<String> urls){
        if (mItemsUrlList == null){
            mItemsUrlList = new ArrayList<>();
        }
        mItemsUrlList.clear();
        if (urls != null){
            mItemsUrlList.addAll(urls);
        }
    }

    @Override
    public int getCount() {
        return mItemsUrlList.size();
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        ImageView photoView = new ImageView(container.getContext());
        photoView.setScaleType(ImageView.ScaleType.FIT_XY);

        String url = mItemsUrlList.get(position);
        Picasso.with(mContext)
                .load(url)
                .error(android.R.drawable.stat_notify_error)
                .into(photoView);
        container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        return photoView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
