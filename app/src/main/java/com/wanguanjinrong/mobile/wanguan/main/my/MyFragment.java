package com.wanguanjinrong.mobile.wanguan.main.my;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.BindView;
import com.orhanobut.logger.Logger;
import com.squareup.otto.Subscribe;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.wanguanjinrong.mobile.wanguan.account.LoginFragment;
import com.wanguanjinrong.mobile.wanguan.main.my.zijinguanli.ZijinguanliFragment;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.huoqi.HuoqiBuyFragment;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.huoqi.HuoqiRedeemFragment;
import com.wanguanjinrong.mobile.wanguan.uitls.Utils;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.BusProvider;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.LoginEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.StartBrotherEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.TabSelectedEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.listener.OnItemClickListener;

import java.util.LinkedList;

/**
 * Created by A on 2016/7/20.
 */
public class MyFragment extends BaseFragment implements Toolbar.OnMenuItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    protected Unbinder unbinder;


    @BindView(R.id.toolbar_my)
    Toolbar mToolbar;
    @BindView(R.id.recy)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    LinkedList<MyItem> mItems;
    MyAdapter mItemAdapter;
    public static BaseFragment newInstance() {
        BaseFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mToolbar.setTitle("我的财富");
        mToolbar.setBackgroundColor(0xFFf71e1a);
        mToolbar.inflateMenu(R.menu.my);
        mToolbar.setOnMenuItemClickListener(this);

        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setOnRefreshListener(this);

        mItems = new LinkedList<>();
        mItems.add(new MyItem(R.string.item_my_bought,R.drawable.my_bought));
        mItems.add(new MyItem(R.string.item_my_huoqi,R.drawable.my_huoqi));
        mItems.add(new MyItem(R.string.item_my_trade,R.drawable.my_trade));
        mItems.add(new MyItem(R.string.item_my_buy,R.drawable.my_buy));
        mItems.add(new MyItem(R.string.item_my_redeem,R.drawable.my_redeem));
        mItems.add(new MyItem(R.string.item_my_phone,R.drawable.my_phone));
        mItems.add(new MyItem(R.string.item_my_invite,R.drawable.my_invite));
//        mItems.add(MyItem.generRandomData());
        mItemAdapter = new MyAdapter(_mActivity);
        mItemAdapter.setDatas(mItems);
        mItemAdapter.setOnItemClickListener(mOnItemClickListener);
//        mRecyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(_mActivity,3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0?3:1;
            }
        });
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mItemAdapter);
    }

    OnItemClickListener mOnItemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(int position, View view, RecyclerView.ViewHolder vh) {
            Logger.e(position +"");
            if (position == 0){
                _mActivity.start(LoginFragment.newInstance());
            }else {
                if (position > 0 && position <= mItems.size()){
                    MyItem myItem = mItems.get(position -1);
                    switch (myItem.getTitleId()){
                        case R.string.item_my_bought:
                            break;
                        case R.string.item_my_huoqi:
                            BusProvider.getInstance().post(new TabSelectedEvent(1));
                            break;
                        case R.string.item_my_trade:
                            BusProvider.getInstance().post(new StartBrotherEvent(ZijinguanliFragment.newInstance()));
                            break;
                        case R.string.item_my_buy:
                            BusProvider.getInstance().post(new StartBrotherEvent(HuoqiBuyFragment.newInstance()));
                            break;
                        case R.string.item_my_redeem:
                            BusProvider.getInstance().post(new StartBrotherEvent(HuoqiRedeemFragment.newInstance()));
                            break;
                        case R.string.item_my_phone:
                            new AlertDialog.Builder(_mActivity)
                                    .setTitle("提示")
                                    .setMessage("\n\t即将拨打客服电话:\n\t400-667-8392\n")
                                    .setCancelable(true)
                                    .setNegativeButton("呼叫", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Logger.e("呼叫");
                                            Intent intent = new Intent(Intent.ACTION_DIAL);
                                            Uri data = Uri.parse("tel:4006678392" );
                                            intent.setData(data);
                                            startActivity(intent);
                                            dialog.dismiss();
                                        }
                                    })
                                    .setPositiveButton("返回", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Logger.e("返回");
                                            dialog.dismiss();
                                        }
                                    })
                                    .create()
                                    .show();
                            break;
                        case R.string.item_my_invite:
                            new AlertDialog.Builder(getActivity()).setTitle("分享万贯金融到")
                                    .setSingleChoiceItems(new String[]{"微信好友","朋友圈"}, -1, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int selectedPosition) {
                                            switch (selectedPosition){
                                                case 0:
                                                    Utils.shareToWeChatWithWebpage(_mActivity,SendMessageToWX.Req.WXSceneSession);
                                                    break;
                                                case 1:
                                                    Utils.shareToWeChatWithWebpage(_mActivity,SendMessageToWX.Req.WXSceneTimeline);
                                                    break;
                                            }
                                            dialog.dismiss();
                                        }
                                    })
                                    .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .setCancelable(true)
                                    .create()
                                    .show();
                            break;
                        default:
                            break;
                    }
                }
            }
//                _mActivity.start(DingqiBuyFragment.newInstance(mItems.get(position)));
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_login:
                Logger.e("action_borrow");
                break;
        }
        return true;
    }

    @Override
    public void onRefresh() {
        Logger.e("onRefresh");
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
//                mItems.add(MyItem.generRandomData());
//                mItems.add(MyItem.generRandomData());
//                mItems.add(MyItem.generRandomData());
//                mItems.add(MyItem.generRandomData());
//                mItems.add(MyItem.generRandomData());
//                mItemAdapter.setDatas(mItems);
//                mItemAdapter.notifyDataSetChanged();
                mItemAdapter.setMoney(MyMoney.generRandomData());
                mItemAdapter.notifyItemChanged(0);
                mRefreshLayout.setRefreshing(false);

            }
        }, 2000);
    }

    @Subscribe
    public void onLoginEvent(LoginEvent event) {
        if (event != null) {
            mItemAdapter.setMoney(MyMoney.generRandomData());
            mItemAdapter.notifyItemChanged(0);
        }
    }
}