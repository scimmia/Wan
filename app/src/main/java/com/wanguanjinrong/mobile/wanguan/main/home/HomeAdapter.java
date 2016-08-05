package com.wanguanjinrong.mobile.wanguan.main.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sunfusheng.marqueeview.MarqueeView;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi.Dingqilicai;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi.DingqilicaiItemViewHolder;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.listener.OnItemClickListener;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.loopviewpager.LoopViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A on 2016/7/6.
 */
public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    final int headType = 0;
    final int gonggaoType = 1;
    final int detailType = 2;

    final static int space = 2;
    private ArrayList<String> mADUrls;
    private ArrayList<String> mGonggaos;
    private ArrayList<Dingqilicai> mItems;
    private Context mContext;
    private LayoutInflater mInflater;
    private OnItemClickListener mClickListener;


    public HomeAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        mContext = context;
        mADUrls = new ArrayList<>();
        mGonggaos = new ArrayList<>();
        mItems = new ArrayList<>();
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public void setDatas(List<String> ads,List<String> gonggaos,List<Dingqilicai> items) {
        mADUrls.clear();
        mGonggaos.clear();
        mItems.clear();
        mADUrls.addAll(ads);
        mGonggaos.addAll(gonggaos);
        mItems.addAll(items);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder holder;
        switch (viewType){
            case headType:
                holder = new HeaderViewHolder(mInflater.inflate(R.layout.item_home_header, parent, false));
                break;
            case gonggaoType:
                holder = new GonggaoViewHolder(mInflater.inflate(R.layout.item_home_gonggao, parent, false));
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = holder.getAdapterPosition();
                        if (mClickListener != null) {
                            mClickListener.onItemClick(position, v, holder);
                        }
                    }
                });
                break;
            case detailType:
            default:
                holder = new DingqilicaiItemViewHolder(mInflater.inflate(R.layout.item_dingqilicai, parent, false));
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = holder.getAdapterPosition();
                        if (mClickListener != null) {
                            mClickListener.onItemClick(position, v, holder);
                        }
                    }
                });
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder itemViewHolder, int position) {
        switch (getItemViewType(position)){
            case headType:
                ADPagerAdapter adPagerAdapter = new ADPagerAdapter(mContext);
                adPagerAdapter.setData(mADUrls);
                ((HeaderViewHolder)itemViewHolder).mLoopViewPager.setAdapter(adPagerAdapter);
                break;
            case gonggaoType:
                ((GonggaoViewHolder) itemViewHolder).tvTitle.startWithList(mGonggaos);
                break;
            case detailType:
            default:
                if (getItemCount() == mItems.size() +space) {
                    ((DingqilicaiItemViewHolder) itemViewHolder).setData(mItems.get(position-space));
                }else {
                    ((DingqilicaiItemViewHolder) itemViewHolder).setData(mItems.get(position));
                }
//                ((ItemViewHolder)itemViewHolder).tvTitle.setText("position"+(position));
//                ((ItemViewHolder)itemViewHolder).tvContent.setText("position----"+(position));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        int result = detailType;
        switch (position){
            case 0:
                result = headType;
                break;
            case 1:
                result = gonggaoType;
                break;
            default:
                result = detailType;
                break;
        }
        return result;
    }

    @Override
    public int getItemCount() {
        return mItems.size() + space;
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder{
        LoopViewPager mLoopViewPager;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            mLoopViewPager = (LoopViewPager) itemView.findViewById(R.id.header_pager);
        }
    }

    class GonggaoViewHolder extends RecyclerView.ViewHolder{
        private MarqueeView tvTitle;

        public GonggaoViewHolder(final View itemView) {
            super(itemView);
            tvTitle = (MarqueeView) itemView.findViewById(R.id.marqueeView);
            tvTitle.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
                @Override
                public void onItemClick(int position, TextView textView) {
                    if (mClickListener != null) {
                        mClickListener.onItemClick(1, itemView, null);
                    }
                }
            });
        }
    }
}
