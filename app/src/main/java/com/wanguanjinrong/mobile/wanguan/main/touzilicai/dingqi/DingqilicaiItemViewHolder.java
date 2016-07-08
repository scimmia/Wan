package com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.orhanobut.logger.Logger;
import com.wanguanjinrong.mobile.wanguan.R;

/**
 * Created by A on 2016/7/8.
 */
public class DingqilicaiItemViewHolder extends RecyclerView.ViewHolder{
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

    public DingqilicaiItemViewHolder(View view) {
        super(view);
        try {
            ButterKnife.bind(this, view);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.e(e.toString());
        }
    }
    
    public void setData(Dingqilicai dingqilicai){
        mTvDingqiName.setText(dingqilicai.getName());
        mTvDingqiId.setText(dingqilicai.getId());
        mTvDingqiMoneyrate.setText(Html.fromHtml("<big><big>"+dingqilicai.getMoneyRate()+"</big></big>%"));
        switch (dingqilicai.getBuyState()){
            case 0:
                mTvDingqiBuystate.setText("预购");
                mTvDingqiBuystate.setTextColor(Color.RED);
                break;
            case 1:
                mTvDingqiBuystate.setText("计息中");
                mTvDingqiBuystate.setTextColor(Color.GRAY);
                break;
        }
        mTvDingqiDays.setText(dingqilicai.getDays()+"天");
        mTvDingqiMoneyleft.setText(String.format("%.2f万元",(dingqilicai.getMoneyLeft()/10000.0)));
        mPbDingqiProgress.setProgress((int) (dingqilicai.getProgress()*100));
        mTvDingqiProgress.setText((int) (dingqilicai.getProgress()*100)+"%");
    }
}
