package com.wanguanjinrong.mobile.wanguan.main.my.moneylog;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.orhanobut.logger.Logger;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.bean.UcMoneyLog;
import com.wanguanjinrong.mobile.wanguan.uitls.Utils;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.listener.OnItemClickListener;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.LinkedList;
import java.util.Locale;

/**
 * Created by A on 2016/8/31.
 */
public class MoneyLogAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    LinkedList<UcMoneyLog.ItemBean> mItems;
    private LayoutInflater mInflater;
    Context mContext;
    private OnItemClickListener mClickListener;

    public MoneyLogAdapter(Context context, LinkedList<UcMoneyLog.ItemBean> items) {
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
        mItems = items;
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final MyViewHolder holder = new MyViewHolder(mInflater.inflate(R.layout.item_money_log, parent, false));
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
        UcMoneyLog.ItemBean dingqilicai = mItems.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.mTvLogName.setText(dingqilicai.getLog_info());
        myViewHolder.mTvLogDate.setText(dingqilicai.getLog_time_format());
        double money = NumberUtils.toDouble(dingqilicai.getMoney());
        if (money > 0){
            myViewHolder.mTvLogMoney.setTextColor(Color.RED);
            myViewHolder.mTvLogMoney.setText(String.format(Locale.CHINESE,"+%,.2f元", money));
        }else {
            myViewHolder.mTvLogMoney.setTextColor(Color.GRAY);
            myViewHolder.mTvLogMoney.setText(Utils.moneyFormatWithYuan(money));
        }
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_log_name)
        TextView mTvLogName;
        @BindView(R.id.tv_log_money)
        TextView mTvLogMoney;
        @BindView(R.id.tv_log_date)
        TextView mTvLogDate;

        MyViewHolder(View view) {
            super(view);
            try {
                ButterKnife.bind(this, view);
            } catch (Exception e) {
                e.printStackTrace();
                Logger.e(e.toString());
            }
        }
    }

}

