package com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.orhanobut.logger.Logger;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.bean.UcInvest;
import com.wanguanjinrong.mobile.wanguan.uitls.Utils;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.listener.OnItemClickListener;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.LinkedList;

/**
 * Created by A on 2016/8/30.
 */
public class DingqiMyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    LinkedList<UcInvest.ItemBean> mItems;
    private LayoutInflater mInflater;
    Context mContext;
    private OnItemClickListener mClickListener;

    public DingqiMyAdapter(Context context, LinkedList<UcInvest.ItemBean> items) {
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
        mItems = items;
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final MyViewHolder holder = new MyViewHolder(mInflater.inflate(R.layout.item_dingqi_my, parent, false));
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
        UcInvest.ItemBean dingqilicai = mItems.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.mTvDingqiName.setText(dingqilicai.getName());
        myViewHolder.mTvDingqiMyPay.setText(Html.fromHtml("我的投资<br><big>"+dingqilicai.getU_load_money_format()+"</big>"));
        if (NumberUtils.toInt(dingqilicai.getRepay_time_type(),0) == 1){
            myViewHolder.mTvDingqiMyDays.setText(Html.fromHtml("投资期限<br><big><big>"+dingqilicai.getRepay_time()+"</big></big>月"));
        }else {
            myViewHolder.mTvDingqiMyDays.setText(Html.fromHtml("投资期限<br><big><big>"+dingqilicai.getRepay_time()+"</big></big>天"));
        }
        myViewHolder.mTvDingqiMyGots.setText(Html.fromHtml("年化收益<br><big><big>"+dingqilicai.getRate_foramt()+"</big></big>%"));
        switch (NumberUtils.toInt(dingqilicai.getDeal_status(),0)) {
            case 0:
                myViewHolder.mTvDingqiBuystate.setText("待等材料");
                myViewHolder.mTvDingqiBuystate.setTextColor(Color.GRAY);
                break;
            case 1:
                myViewHolder.mTvDingqiBuystate.setText("进行中");
                myViewHolder.mTvDingqiBuystate.setTextColor(Color.RED);
                break;
            case 2:
                myViewHolder.mTvDingqiBuystate.setText("满标");
                myViewHolder.mTvDingqiBuystate.setTextColor(Color.BLUE);
                break;
            case 3:
                myViewHolder.mTvDingqiBuystate.setText("流标");
                myViewHolder.mTvDingqiBuystate.setTextColor(Color.YELLOW);
                break;
            case 4:
                myViewHolder.mTvDingqiBuystate.setText("还款中");
                myViewHolder.mTvDingqiBuystate.setTextColor(Color.BLACK);
                break;
            case 5:
                myViewHolder.mTvDingqiBuystate.setText("已还清");
                myViewHolder.mTvDingqiBuystate.setTextColor(Color.BLUE);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_dingqi_buystate)
        TextView mTvDingqiBuystate;
        @BindView(R.id.tv_dingqi_name)
        TextView mTvDingqiName;
        @BindView(R.id.tv_dingqi_my_pay)
        TextView mTvDingqiMyPay;
        @BindView(R.id.tv_dingqi_my_days)
        TextView mTvDingqiMyDays;
        @BindView(R.id.tv_dingqi_my_gots)
        TextView mTvDingqiMyGots;

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

