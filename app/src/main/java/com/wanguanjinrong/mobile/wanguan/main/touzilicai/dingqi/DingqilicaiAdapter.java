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
import com.wanguanjinrong.mobile.wanguan.uitls.Utils;
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
                ((DingqilicaiItemViewHolder) holder).mTvDingqiBuystate.setText("待等材料");
                ((DingqilicaiItemViewHolder) holder).mTvDingqiBuystate.setTextColor(Color.GRAY);
                break;
            case 1:
                ((DingqilicaiItemViewHolder) holder).mTvDingqiBuystate.setText("进行中");
                ((DingqilicaiItemViewHolder) holder).mTvDingqiBuystate.setTextColor(Color.RED);
                break;
            case 2:
                ((DingqilicaiItemViewHolder) holder).mTvDingqiBuystate.setText("满标");
                ((DingqilicaiItemViewHolder) holder).mTvDingqiBuystate.setTextColor(Color.BLUE);
                break;
            case 3:
                ((DingqilicaiItemViewHolder) holder).mTvDingqiBuystate.setText("流标");
                ((DingqilicaiItemViewHolder) holder).mTvDingqiBuystate.setTextColor(Color.YELLOW);
                break;
            case 4:
                ((DingqilicaiItemViewHolder) holder).mTvDingqiBuystate.setText("还款中");
                ((DingqilicaiItemViewHolder) holder).mTvDingqiBuystate.setTextColor(Color.BLACK);
                break;
            case 5:
                ((DingqilicaiItemViewHolder) holder).mTvDingqiBuystate.setText("已还清");
                ((DingqilicaiItemViewHolder) holder).mTvDingqiBuystate.setTextColor(Color.BLUE);
                break;
        }
        int days = dingqilicai.getDays();
        if (days>0 && days%30 == 0){
            ((DingqilicaiItemViewHolder) holder).mTvDingqiDays.setText((days/30)+"月");
        }else {
            ((DingqilicaiItemViewHolder) holder).mTvDingqiDays.setText(dingqilicai.getDays()+"天");
        }
        ((DingqilicaiItemViewHolder) holder).mTvDingqiMoneyleft.setText(dingqilicai.getMoneyLeft());
        ((DingqilicaiItemViewHolder) holder).mPbDingqiProgress.setProgress((int) (dingqilicai.getProgress()));
        ((DingqilicaiItemViewHolder) holder).mTvDingqiProgress.setText(Utils.moneyFormat(dingqilicai.getProgress())+"%");

    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 :mItems.size();
    }
}
