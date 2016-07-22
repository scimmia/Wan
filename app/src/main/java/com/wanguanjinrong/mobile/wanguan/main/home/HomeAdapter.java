package com.wanguanjinrong.mobile.wanguan.main.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.orhanobut.logger.Logger;
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
    final int detailType = 1;

    private ArrayList<String> mADUrls;
    private ArrayList<Dingqilicai> mItems;
    private Context mContext;
    private LayoutInflater mInflater;
    private OnItemClickListener mClickListener;


    public HomeAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        mContext = context;
        mADUrls = new ArrayList<>();
        mItems = new ArrayList<>();
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public void setDatas(List<String> ads,List<Dingqilicai> items) {
        mADUrls.clear();
        mItems.clear();
        mADUrls.addAll(ads);
        mItems.addAll(items);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder holder;
        switch (viewType){
            case headType:
                holder = new HeaderViewHolder(mInflater.inflate(R.layout.item_home_header, parent, false));
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
            case detailType:
            default:
                if (getItemCount() == mItems.size() +1) {
                    ((DingqilicaiItemViewHolder) itemViewHolder).setData(mItems.get(position-1));
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
        return position==0  ? headType : detailType;
    }

    @Override
    public int getItemCount() {
        return mItems.size() + 1;
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder{
        LoopViewPager mLoopViewPager;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            mLoopViewPager = (LoopViewPager) itemView.findViewById(R.id.header_pager);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle, tvContent;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
