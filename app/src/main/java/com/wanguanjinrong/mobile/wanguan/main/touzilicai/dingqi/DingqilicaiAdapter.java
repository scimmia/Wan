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

    public DingqilicaiAdapter(Context context) {
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
        mItems = new LinkedList<>();
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public void setDatas(LinkedList<Dingqilicai> items) {

        if (mItems == null) {
            mItems = new LinkedList<>();
        }
        mItems.clear();
        if (items != null) {
            mItems.addAll(items);
        }
    }

    public void addDatas(LinkedList<Dingqilicai> items) {

        if (mItems == null) {
            mItems = new LinkedList<>();
        }
        if (items != null) {
            mItems.addAll(items);
        }
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
        return mItems.size();
    }

//    class ItemViewHolder extends RecyclerView.ViewHolder {
////        private TextView tvTitle, tvContent;
////
////        public ItemViewHolder(View itemView) {
////            super(itemView);
////            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
////            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
////        }
//        TextView mTvDingqiName;
//        TextView mTvDingqiId;
//        TextView mTvDingqiMoneyrate;
//        TextView mTvDingqiBuystate;
//        TextView mTvDingqiDays;
//        TextView mTvDingqiMoneyleft;
//        ProgressBar mPbDingqiProgress;
//        TextView mTvDingqiProgress;
//
//        public ItemViewHolder(View view) {
//            super(view);
//            mTvDingqiName = (TextView) itemView.findViewById(R.id.tv_dingqi_name);
//            mTvDingqiId = (TextView) itemView.findViewById(R.id.tv_dingqi_id);
//            mTvDingqiMoneyrate = (TextView) itemView.findViewById(R.id.tv_dingqi_moneyrate);
//            mTvDingqiBuystate = (TextView) itemView.findViewById(R.id.tv_dingqi_buystate);
//            mTvDingqiDays = (TextView) itemView.findViewById(R.id.tv_dingqi_days);
//            mTvDingqiMoneyleft = (TextView) itemView.findViewById(R.id.tv_dingqi_moneyleft);
//            mPbDingqiProgress = (ProgressBar) itemView.findViewById(R.id.pb_dingqi_progress);
//            mTvDingqiProgress = (TextView) itemView.findViewById(R.id.tv_dingqi_progress);
//        }
//    }

//    class ItemViewHolder extends RecyclerView.ViewHolder{
//        @BindView(R.id.tv_dingqi_name)
//        TextView mTvDingqiName;
//        @BindView(R.id.tv_dingqi_id)
//        TextView mTvDingqiId;
//        @BindView(R.id.tv_dingqi_moneyrate)
//        TextView mTvDingqiMoneyrate;
//        @BindView(R.id.tv_dingqi_buystate)
//        TextView mTvDingqiBuystate;
//        @BindView(R.id.tv_dingqi_days)
//        TextView mTvDingqiDays;
//        @BindView(R.id.tv_dingqi_moneyleft)
//        TextView mTvDingqiMoneyleft;
//        @BindView(R.id.pb_dingqi_progress)
//        ProgressBar mPbDingqiProgress;
//        @BindView(R.id.tv_dingqi_progress)
//        TextView mTvDingqiProgress;
//
//        public ItemViewHolder(View view) {
//            super(view);
//            try {
//                ButterKnife.bind(this, view);
//            } catch (Exception e) {
//                e.printStackTrace();
//                Logger.e(e.toString());
//            }
//        }
//    }
}
