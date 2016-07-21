package com.wanguanjinrong.mobile.wanguan.main.my;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.listener.OnItemClickListener;

import java.util.LinkedList;

/**
 * Created by A on 2016/7/20.
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    final int headType = 0;
    final int detailType = 1;

    LinkedList<MyItem> mItems;
    private LayoutInflater mInflater;
    Context mContext;
    private OnItemClickListener mClickListener;

    public MyAdapter(Context context) {
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
        mItems = new LinkedList<>();
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public void setDatas(LinkedList<MyItem> items) {

        if (mItems == null) {
            mItems = new LinkedList<>();
        }
        mItems.clear();
        if (items != null) {
            mItems.addAll(items);
        }
    }

    public void addDatas(LinkedList<MyItem> items) {

        if (mItems == null) {
            mItems = new LinkedList<>();
        }
        if (items != null) {
            mItems.addAll(items);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder holder;
        switch (viewType){
            case headType:
                holder = new HeaderViewHolder(mInflater.inflate(R.layout.item_my_header, parent, false));
                break;
            case detailType:
            default:
                holder = new ItemViewHolder(mInflater.inflate(R.layout.item_my_square, parent, false));
                break;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (mClickListener != null) {
                    mClickListener.onItemClick(position, v, holder);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case headType:
//                ADPagerAdapter adPagerAdapter = new ADPagerAdapter(mContext);
//                adPagerAdapter.setData(mADUrls);
//                ((HeaderViewHolder)itemViewHolder).mLoopViewPager.setAdapter(adPagerAdapter);
                break;
            case detailType:
            default:
                MyItem dingqilicai = mItems.get(position-1);
                ((ItemViewHolder) holder).title.setText(dingqilicai.getTitleId());
                Drawable top = mContext.getResources().getDrawable(dingqilicai.getPicId());
                ((ItemViewHolder) holder).title.setCompoundDrawablesWithIntrinsicBounds(null, top , null, null);
//                ((ItemViewHolder)itemViewHolder).tvTitle.setText("position"+(position));
//                ((ItemViewHolder)itemViewHolder).tvContent.setText("position----"+(position));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position==0 ? headType : detailType;
    }

    @Override
    public int getItemCount() {
        return mItems.size()+1;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ItemViewHolder(View view) {
            super(view);
            title = (TextView) itemView.findViewById(R.id.item_title);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public HeaderViewHolder(View view) {
            super(view);
            title = (TextView) itemView.findViewById(R.id.item_title);
        }
    }
}

