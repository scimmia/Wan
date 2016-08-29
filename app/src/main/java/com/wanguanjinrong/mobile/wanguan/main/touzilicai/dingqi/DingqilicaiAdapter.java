package com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.orhanobut.logger.Logger;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.listener.OnItemClickListener;

import java.util.LinkedList;

/**
 * Created by A on 2016/7/7.
 */
public class DingqilicaiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    LinkedList<Dingqilicai> mItems;
    private LayoutInflater mInflater;
    Context mContext;
    private OnItemClickListener mClickListener;

    public DingqilicaiAdapter(Context context,LinkedList<Dingqilicai> items) {
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
        mItems = items;
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder holder = new DingqilicaiItemViewHolder(mInflater.inflate(R.layout.item_dingqilicai, parent, false));
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
//        ((ItemViewHolder) holder).tvTitle.setText("position" + (position));
//        ((ItemViewHolder) holder).tvContent.setText(mItems.get(position).toString());
        Dingqilicai dingqilicai = mItems.get(position);
        ((DingqilicaiItemViewHolder) holder).mTvDingqiName.setText(dingqilicai.getName());
        ((DingqilicaiItemViewHolder) holder).mTvDingqiId.setText(dingqilicai.getId());
        ((DingqilicaiItemViewHolder) holder).mTvDingqiMoneyrate.setText(Html.fromHtml("<big><big>"+dingqilicai.getMoneyRate()+"</big></big>%"));
        switch (dingqilicai.getBuyState()){
            case 0:
                ((DingqilicaiItemViewHolder) holder).mTvDingqiBuystate.setText("预购");
                ((DingqilicaiItemViewHolder) holder).mTvDingqiBuystate.setTextColor(Color.RED);
                break;
            case 1:
                ((DingqilicaiItemViewHolder) holder).mTvDingqiBuystate.setText("计息中");
                ((DingqilicaiItemViewHolder) holder).mTvDingqiBuystate.setTextColor(Color.GRAY);
                break;
        }
        ((DingqilicaiItemViewHolder) holder).mTvDingqiDays.setText(dingqilicai.getDays()+"天");
        ((DingqilicaiItemViewHolder) holder).mTvDingqiMoneyleft.setText(String.format("%.2f万元",(dingqilicai.getMoneyLeft()/10000.0)));
        ((DingqilicaiItemViewHolder) holder).mPbDingqiProgress.setProgress((int) (dingqilicai.getProgress()*100));
        ((DingqilicaiItemViewHolder) holder).mTvDingqiProgress.setText((int) (dingqilicai.getProgress()*100)+"%");

    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 :mItems.size();
    }
}
