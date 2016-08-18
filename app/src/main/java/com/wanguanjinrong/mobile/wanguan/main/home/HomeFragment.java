package com.wanguanjinrong.mobile.wanguan.main.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.main.home.gonggao.GonggaoListFragment;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi.DingqiBuyFragment;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi.Dingqilicai;
import com.wanguanjinrong.mobile.wanguan.uitls.TestUtils;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.BusProvider;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.StartBrotherEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.listener.OnItemClickListener;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment {
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    HomeAdapter mItemAdapter;
    ArrayList<Dingqilicai> mItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar_home);

        mToolbar.setTitle("首页推荐");
//        initToolbarMenu(mToolbar);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recy);
        mItemAdapter = new HomeAdapter(_mActivity);
        ArrayList<String> mADUrls = new ArrayList<>();
        mADUrls.add("http://www.wanguanjinrong.com/UF/Uploads/Ad/20160608182523780.jpg");
        mADUrls.add("http://www.wanguanjinrong.com/UF/Uploads/Ad/20160608182317357.jpg");
        mADUrls.add("http://www.wanguanjinrong.com/UF/Uploads/Ad/20160608182152656.jpg");
        mADUrls.add("http://www.wanguanjinrong.com/UF/Uploads/Ad/2016070417481198.jpg");
        mADUrls.add("http://www.wanguanjinrong.com/UF/Uploads/Ad/20160704184329348.jpg");
        ArrayList<String> mGonggaos = new ArrayList<>();
        mGonggaos.add(TestUtils.generRandomGonggao().getTitle());
        mGonggaos.add(TestUtils.generRandomGonggao().getTitle());
        mGonggaos.add(TestUtils.generRandomGonggao().getTitle());
        mGonggaos.add(TestUtils.generRandomGonggao().getTitle());
        mGonggaos.add(TestUtils.generRandomGonggao().getTitle());
        mItems = new ArrayList<>();
        mItems.add(Dingqilicai.generRandomData());
        mItems.add(Dingqilicai.generRandomData());
        mItems.add(Dingqilicai.generRandomData());
        mItems.add(Dingqilicai.generRandomData());
        mItems.add(Dingqilicai.generRandomData());
        mItems.add(Dingqilicai.generRandomData());
        mItems.add(Dingqilicai.generRandomData());
        mItemAdapter.setDatas(mADUrls,mGonggaos,mItems);
        mItemAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, RecyclerView.ViewHolder vh) {
                Logger.e(position +"");
                if (position == 0){
                    Logger.e("banner clicked");
                }else if (position == 1){
                    Logger.e("gonggao clicked");
                    BusProvider.getInstance().post(new StartBrotherEvent(GonggaoListFragment.newInstance()));
                }else {
                    int temp = position - HomeAdapter.space;
                    if (temp >= 0 && temp < mItems.size()) {
                        BusProvider.getInstance().post(new StartBrotherEvent(DingqiBuyFragment.newInstance(mItems.get(temp))));
                    }
                }
            }
        });
//        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
        mRecyclerView.setAdapter(mItemAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }
}
//public class HomeFragment extends BaseFragment {
//    public static HomeFragment newInstance() {
//        HomeFragment fragment = new HomeFragment();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    private Toolbar mToolbar;
//    private RecyclerView mRecyclerView;
//    ItemAdapter mItemAdapter;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    private void initView(View view) {
//        mToolbar = (Toolbar) view.findViewById(R.id.toolbar_home);
//
//        mToolbar.setTitle("理财产品");
////        initToolbarMenu(mToolbar);
//        mRecyclerView = (RecyclerView) view.findViewById(R.id.recy);
//        mItemAdapter = new ItemAdapter();
////        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
//        mRecyclerView.setAdapter(mItemAdapter);
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        initView(view);
//        return view;
//    }
//
//    final int headType = 0;
//    final int detailType = 1;
//    class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
//        @Override
//        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//            switch (i){
//                case headType:
//                    return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(
//                            R.layout.item_home_header, null));
//                case detailType:
//                default:
//                    return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(
//                            R.layout.item_home_detail, null));
//            }
//        }
//
//        @Override
//        public void onBindViewHolder(RecyclerView.ViewHolder itemViewHolder, int position) {
//            switch (getItemViewType(position)){
//                case headType:
//                    String[] logoNames = {
//                            "http://www.wanguanjinrong.com/UF/Uploads/Ad/20160608182523780.jpg",
//                            "http://www.wanguanjinrong.com/UF/Uploads/Ad/20160608182317357.jpg",
//                            "http://www.wanguanjinrong.com/UF/Uploads/Ad/20160608182152656.jpg",
//                            "http://www.wanguanjinrong.com/UF/Uploads/Ad/2016070417481198.jpg",
//                            "http://www.wanguanjinrong.com/UF/Uploads/Ad/20160704180033924.jpg",
//                            "http://www.wanguanjinrong.com/UF/Uploads/Ad/20160704184329348.jpg",
//                    };
//
//                    ((HeaderViewHolder)itemViewHolder).mLoopViewPager.setAdapter(new SamplePagerAdapter(logoNames));
//                    break;
//                case detailType:
//                default:
//                    ((ItemViewHolder)itemViewHolder).mDeccribe.setText("position"+(position));
//                    ((ItemViewHolder)itemViewHolder).mNumber.setText("position----"+(position));
//                    break;
//            }
//        }
//        @Override
//        public int getItemViewType(int position) {
//            return position==0 ? headType : detailType;
//        }
//        @Override
//        public int getItemCount() {
//            return 8;
//        }
//    }
//
//    class SamplePagerAdapter extends PagerAdapter {
//        String[] mItemsUrlList;
//
//        public SamplePagerAdapter(String[] urls) {
//            mItemsUrlList = urls;
//        }
//
//        @Override
//        public int getCount() {
//            return mItemsUrlList.length;
//        }
//
//        @Override
//        public View instantiateItem(ViewGroup container, int position) {
//            ImageView photoView = new ImageView(container.getContext());
//            photoView.setScaleType(ImageView.ScaleType.FIT_XY);
//
//            String url = mItemsUrlList[position];
//            Picasso.with(getContext())
//                    .load(url)
//                    .error(android.R.drawable.stat_notify_error)
//                    .into(photoView);
//            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//
//            return photoView;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            container.removeView((View) object);
//        }
//
//        @Override
//        public boolean isViewFromObject(View view, Object object) {
//            return view == object;
//        }
//
//    }
//
//    class HeaderViewHolder extends RecyclerView.ViewHolder{
//        LoopViewPager mLoopViewPager;
//
//        public HeaderViewHolder(View itemView) {
//            super(itemView);
//            mLoopViewPager = (LoopViewPager) itemView.findViewById(R.id.header_pager);
//        }
//    }
//
//    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//        TextView mDeccribe;
//        TextView mNumber;
//
//        public ItemViewHolder(View itemView) {
//            super(itemView);
//            mDeccribe = (TextView) itemView.findViewById(R.id.item_title_tv);
//            mNumber = (TextView) itemView.findViewById(R.id.item_content_tv);
//            itemView.setOnClickListener(this);
//        }
//
//        @SuppressWarnings("deprecation")
//        @Override
//        public void onClick(View view) {
//            Logger.e("onClick" + getLayoutPosition());
//            Logger.e("onClick" + getAdapterPosition());
////            Logger.e(mTongxunlus.get(getAdapterPosition()).toString());
//        }
//    }
//}
