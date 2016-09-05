package com.wanguanjinrong.mobile.wanguan.main.my.zhuanrang;

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
import com.wanguanjinrong.mobile.wanguan.bean.UcTransfer;
import com.wanguanjinrong.mobile.wanguan.uitls.Global;
import com.wanguanjinrong.mobile.wanguan.uitls.Utils;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.listener.OnItemClickListener;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.LinkedList;

/**
 * Created by A on 2016/8/31.
 */
public class ZhuanrangMyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    LinkedList<UcTransfer.ItemBean> mItems;
    private LayoutInflater mInflater;
    Context mContext;
    private OnItemClickListener mClickListener;
    int mFragmentType;

    public ZhuanrangMyAdapter(Context context, LinkedList<UcTransfer.ItemBean> items,int fragmentType) {
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
        mItems = items;
        mFragmentType = fragmentType;
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final MyViewHolder holder = new MyViewHolder(mInflater.inflate(R.layout.item_my_zhuanrang, parent, false));
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
        UcTransfer.ItemBean itemBean = mItems.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.mTvTransferName.setText(itemBean.getName());
        myViewHolder.mTvTransferBenjin.setText(Html.fromHtml("本金(元)<br><big>" + Utils.moneyFormat(itemBean.getLeft_benjin()) + "</big>"));
        myViewHolder.mTvTransferGots.setText(Html.fromHtml("收益(元)<br><font color=\"red\"><big>" + Utils.moneyFormat(itemBean.getLeft_lixi()) + "</big></font>"));
        if (mFragmentType == Global.typeTransferMyBought){
            double boughtPrice = NumberUtils.toDouble(itemBean.getTransfer_amount());
            double gots = itemBean.getAll_must_repay_money() - boughtPrice;
            myViewHolder.mTvTransferBenjin.setText(Html.fromHtml("购入价格(元)<br><big>" + Utils.moneyFormat(boughtPrice) + "</big>"));
            myViewHolder.mTvTransferGots.setText(Html.fromHtml("收益(元)<br><font color=\"red\"><big>" + Utils.moneyFormat(gots) + "</big></font>"));
        }
        myViewHolder.mTvTransferGotTime.setText("到期时间\n" + itemBean.getFinal_repay_time_format());

        myViewHolder.mTvTransferState.setText(itemBean.getTras_status_format());
        myViewHolder.mTvTransferState.setTextColor(Color.GRAY);
        myViewHolder.mTvTransferSell.setVisibility(View.GONE);
        if (StringUtils.equalsIgnoreCase("转让中",itemBean.getTras_status_format())){
            myViewHolder.mTvTransferState.setTextColor(Color.GRAY);
            myViewHolder.mTvTransferSell.setVisibility(View.VISIBLE);
            myViewHolder.mTvTransferSell.setText("转让价格:"+Utils.moneyFormatWithYuan(NumberUtils.toDouble(itemBean.getTransfer_amount())));
        }else if (StringUtils.equalsIgnoreCase("已撤销",itemBean.getTras_status_format())){
            myViewHolder.mTvTransferState.setTextColor(Color.RED);
        }else if (StringUtils.equalsIgnoreCase("可转让",itemBean.getTras_status_format())){
            myViewHolder.mTvTransferState.setTextColor(Color.RED);
        }else if (StringUtils.equalsIgnoreCase("已转让",itemBean.getTras_status_format())){
            myViewHolder.mTvTransferState.setTextColor(Color.BLUE);
            myViewHolder.mTvTransferSell.setVisibility(View.VISIBLE);
            myViewHolder.mTvTransferSell.setText("转让价格:"+Utils.moneyFormatWithYuan(NumberUtils.toDouble(itemBean.getTransfer_amount())));
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
        @BindView(R.id.tv_transfer_benjin)
        TextView mTvTransferBenjin;
        @BindView(R.id.tv_transfer_gots)
        TextView mTvTransferGots;
        @BindView(R.id.tv_transfer_got_time)
        TextView mTvTransferGotTime;
       @BindView(R.id.tv_transfer_sell)
        TextView mTvTransferSell;

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

