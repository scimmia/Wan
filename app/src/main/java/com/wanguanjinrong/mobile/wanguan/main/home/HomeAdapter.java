package com.wanguanjinrong.mobile.wanguan.main.home;

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
import com.sunfusheng.marqueeview.MarqueeView;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.bean.HomeInit;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi.Dingqilicai;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi.DingqilicaiItemViewHolder;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.listener.OnItemClickListener;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.loopviewpager.LoopViewPager;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A on 2016/7/6.
 */
public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    final int headType = 0;
    final int gonggaoType = 1;
    final int detailType = 2;

    final static int space = 2;
    private ArrayList<String> mADUrls;
    private ArrayList<String> mGonggaos;
    private ArrayList<HomeInit.IndexListBean.DealListBean> mItems;
    private Context mContext;
    private LayoutInflater mInflater;
    private OnItemClickListener mClickListener;


    public HomeAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        mContext = context;
        mADUrls = new ArrayList<>();
        mGonggaos = new ArrayList<>();
        mItems = new ArrayList<>();
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public void setDatas(HomeInit homeInit) {
        mADUrls.clear();
        mGonggaos.clear();
        mItems.clear();
        if (homeInit != null){
            HomeInit.IndexListBean indexListBean = homeInit.getIndex_list();
            if (indexListBean != null){
                if (indexListBean.getAdv_list() != null){

                }
                if (indexListBean.getDeal_list() != null){
                    mItems.addAll(indexListBean.getDeal_list());
                }
            }
        }
//        mADUrls.addAll(ads);
//        mGonggaos.addAll(gonggaos);
    }

//    public void setDatas(List<String> ads,List<String> gonggaos,List<Dingqilicai> items) {
//        mADUrls.clear();
//        mGonggaos.clear();
//        mItems.clear();
//        mADUrls.addAll(ads);
//        mGonggaos.addAll(gonggaos);
//        mItems.addAll(items);
//    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder holder;
        switch (viewType){
            case headType:
                holder = new HeaderViewHolder(mInflater.inflate(R.layout.item_home_header, parent, false));
                break;
            case gonggaoType:
                holder = new GonggaoViewHolder(mInflater.inflate(R.layout.item_home_gonggao, parent, false));
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
            case detailType:
            default:
                holder = new GoodsItemViewHolder(mInflater.inflate(R.layout.item_dingqilicai, parent, false));
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
                if (mADUrls == null || mADUrls.size() == 0){
                    mADUrls.add("http://www.wanguanjinrong.com/UF/Uploads/Ad/20160608182523780.jpg");
                    mADUrls.add("http://www.wanguanjinrong.com/UF/Uploads/Ad/20160608182317357.jpg");
                    mADUrls.add("http://www.wanguanjinrong.com/UF/Uploads/Ad/20160608182152656.jpg");
                    mADUrls.add("http://www.wanguanjinrong.com/UF/Uploads/Ad/2016070417481198.jpg");
                    mADUrls.add("http://www.wanguanjinrong.com/UF/Uploads/Ad/20160704184329348.jpg");
                }
                ADPagerAdapter adPagerAdapter = new ADPagerAdapter(mContext);
                adPagerAdapter.setData(mADUrls);
                ((HeaderViewHolder)itemViewHolder).mLoopViewPager.setAdapter(adPagerAdapter);
                break;
            case gonggaoType:
                if (mGonggaos == null || mGonggaos.size() == 0){
                    itemViewHolder.itemView.setVisibility(View.GONE);
                }else {
                    ((GonggaoViewHolder) itemViewHolder).tvTitle.startWithList(mGonggaos);
                }
                break;
            case detailType:
            default:
                if (getItemCount() == mItems.size() +space) {
                    ((GoodsItemViewHolder) itemViewHolder).setData(mItems.get(position-space));
                }else {
                    ((GoodsItemViewHolder) itemViewHolder).setData(mItems.get(position));
                }
//                ((ItemViewHolder)itemViewHolder).tvTitle.setText("position"+(position));
//                ((ItemViewHolder)itemViewHolder).tvContent.setText("position----"+(position));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        int result = detailType;
        switch (position){
            case 0:
                result = headType;
                break;
            case 1:
                result = gonggaoType;
                break;
            default:
                result = detailType;
                break;
        }
        return result;
    }

    @Override
    public int getItemCount() {
        return mItems.size() + space;
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder{
        LoopViewPager mLoopViewPager;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            mLoopViewPager = (LoopViewPager) itemView.findViewById(R.id.header_pager);
        }
    }

    class GonggaoViewHolder extends RecyclerView.ViewHolder{
        private MarqueeView tvTitle;

        public GonggaoViewHolder(final View itemView) {
            super(itemView);
            tvTitle = (MarqueeView) itemView.findViewById(R.id.marqueeView);
            tvTitle.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
                @Override
                public void onItemClick(int position, TextView textView) {
                    if (mClickListener != null) {
                        mClickListener.onItemClick(1, itemView, null);
                    }
                }
            });
        }
    }

    public class GoodsItemViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_dingqi_name)
        TextView mTvDingqiName;
        @BindView(R.id.tv_dingqi_id)
        TextView mTvDingqiId;
        @BindView(R.id.tv_dingqi_moneyrate)
        TextView mTvDingqiMoneyrate;
        @BindView(R.id.tv_dingqi_buystate)
        TextView mTvDingqiBuystate;
        @BindView(R.id.tv_dingqi_days)
        TextView mTvDingqiDays;
        @BindView(R.id.tv_dingqi_moneyleft)
        TextView mTvDingqiMoneyleft;
        @BindView(R.id.pb_dingqi_progress)
        ProgressBar mPbDingqiProgress;
        @BindView(R.id.tv_dingqi_progress)
        TextView mTvDingqiProgress;

        public GoodsItemViewHolder(View view) {
            super(view);
            try {
                ButterKnife.bind(this, view);
            } catch (Exception e) {
                e.printStackTrace();
                Logger.e(e.toString());
            }
        }

        public void setData(HomeInit.IndexListBean.DealListBean dealListBean){
            mTvDingqiName.setText(dealListBean.getName());
            mTvDingqiId.setText(dealListBean.getId());
            mTvDingqiMoneyrate.setText(Html.fromHtml("<big><big>"+dealListBean.getRate()+"</big></big>%"));
            switch (NumberUtils.toInt(dealListBean.getDeal_status())){
                case 0:
                    mTvDingqiBuystate.setText("待等材料");
                    mTvDingqiBuystate.setTextColor(Color.RED);
                    break;
                case 1:
                    mTvDingqiBuystate.setText("进行中");
                    mTvDingqiBuystate.setTextColor(Color.GRAY);
                    break;
                case 2:
                    mTvDingqiBuystate.setText("满标");
                    mTvDingqiBuystate.setTextColor(Color.RED);
                    break;
                case 3:
                    mTvDingqiBuystate.setText("流标");
                    mTvDingqiBuystate.setTextColor(Color.RED);
                    break;
                case 4:
                    mTvDingqiBuystate.setText("还款中");
                    mTvDingqiBuystate.setTextColor(Color.RED);
                    break;
                case 5:
                    mTvDingqiBuystate.setText("已还清");
                    mTvDingqiBuystate.setTextColor(Color.RED);
                    break;
            }
            mTvDingqiDays.setText(dealListBean.getDay()+"天");
            mTvDingqiMoneyleft.setText(dealListBean.getBorrow_amount_format());
            mPbDingqiProgress.setProgress((int) (dealListBean.getProgress_point()*100));
            mTvDingqiProgress.setText((int) (dealListBean.getProgress_point()*100)+"%");
        }
    }
}
