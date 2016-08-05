package com.wanguanjinrong.mobile.wanguan.main.home.gonggao;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.listener.OnItemClickListener;

import java.util.LinkedList;

/**
 * Created by A on 2016/8/5.
 */
public class GonggaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    LinkedList<Gonggao> mItems;
    private LayoutInflater mInflater;
    Context mContext;
    private OnItemClickListener mClickListener;


    public GonggaoAdapter(Context context) {
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
        mItems = new LinkedList<>();
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public void setDatas(LinkedList<Gonggao> items) {
        if (mItems == null) {
            mItems = new LinkedList<>();
        }
        mItems.clear();
        if (items != null) {
            mItems.addAll(items);
        }
    }

    public void addDatas(LinkedList<Gonggao> items) {
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
        holder = new ItemViewHolder(mInflater.inflate(R.layout.item_gonggao, parent, false));
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

        Gonggao dingqilicai = mItems.get(position);
        ((ItemViewHolder) holder).mTvTitle.setText(dingqilicai.getTitle());
        ((ItemViewHolder) holder).mTvContent.setText(dingqilicai.getContent());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView mTvTitle;
        TextView mTvContent;
        public ItemViewHolder(View view) {
            super(view);
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            mTvContent = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
