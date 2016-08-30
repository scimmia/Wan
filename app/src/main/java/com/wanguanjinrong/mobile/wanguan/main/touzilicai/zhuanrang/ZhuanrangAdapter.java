package com.wanguanjinrong.mobile.wanguan.main.touzilicai.zhuanrang;

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
import com.wanguanjinrong.mobile.wanguan.bean.Transfer;
import com.wanguanjinrong.mobile.wanguan.uitls.Utils;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.listener.OnItemClickListener;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.LinkedList;

/**
 * Created by A on 2016/8/30.
 */
public class ZhuanrangAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    LinkedList<Transfer.ItemBean> mItems;
    private LayoutInflater mInflater;
    Context mContext;
    private OnItemClickListener mClickListener;

    public ZhuanrangAdapter(Context context, LinkedList<Transfer.ItemBean> items) {
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
        mItems = items;
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final MyViewHolder holder = new MyViewHolder(mInflater.inflate(R.layout.item_zhuanrang, parent, false));
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
        Transfer.ItemBean itemBean = mItems.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.mTvTransferName.setText(itemBean.getName());
        myViewHolder.mTvTransferBenxi.setText(Html.fromHtml("本息合计<br><big>" + Utils.moneyFormat(itemBean.getAll_must_repay_money()) + "</big>元"));
        myViewHolder.mTvTransferPay.setText(Html.fromHtml("转让价<br><font color=\"red\"><big>" + Utils.moneyFormat(NumberUtils.toDouble(itemBean.getTransfer_amount())) + "</big></font>元"));
        myViewHolder.mTvTransferGots.setText(Html.fromHtml("收益<br><font color=\"red\"><big>" + Utils.moneyFormat(itemBean.getTransfer_income()) + "</big></font>元"));
        myViewHolder.mTvTransferGotTime.setText(Html.fromHtml("到期时间:" + itemBean.getFinal_repay_time_format() + ""));

        myViewHolder.mTvTransferState.setText("");
        myViewHolder.mTvTransferState.setTextColor(Color.GRAY);
        if (StringUtils.equalsIgnoreCase(itemBean.getT_user_id(),"0")){
            if (StringUtils.equalsIgnoreCase(itemBean.getStatus(),"1")){
                myViewHolder.mTvTransferState.setText("可转让");
                myViewHolder.mTvTransferState.setTextColor(Color.RED);
            }else if (StringUtils.equalsIgnoreCase(itemBean.getStatus(),"0")){
                myViewHolder.mTvTransferState.setText("已撤销");
            }
        }else {
            myViewHolder.mTvTransferState.setText("已转让");
        }
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_transfer_state)
        TextView mTvTransferState;
        @BindView(R.id.tv_transfer_name)
        TextView mTvTransferName;
        @BindView(R.id.tv_transfer_benxi)
        TextView mTvTransferBenxi;
        @BindView(R.id.tv_transfer_pay)
        TextView mTvTransferPay;
        @BindView(R.id.tv_transfer_gots)
        TextView mTvTransferGots;
        @BindView(R.id.tv_transfer_got_time)
        TextView mTvTransferGotTime;

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
