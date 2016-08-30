package com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.bean.Deals;
import com.wanguanjinrong.mobile.wanguan.bean.HomeInit;
import com.wanguanjinrong.mobile.wanguan.uitls.Global;
import com.wanguanjinrong.mobile.wanguan.uitls.Utils;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.BusProvider;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.StartBrotherEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.http.HttpListener;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.listener.OnItemClickListener;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.LinkedList;

/**
 * Created by A on 2016/7/7.
 */
public class DingqilicaiFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    protected Unbinder unbinder;

    @BindView(R.id.recy)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    LinkedList<Dingqilicai> mItems;
    DingqilicaiAdapter mItemAdapter;
    int mPageTotal;
    int mPageCurrent;
    boolean isLoadingMore;

    public static DingqilicaiFragment newInstance() {
        DingqilicaiFragment fragment = new DingqilicaiFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mPageTotal = 0;
        mPageCurrent = 0;
        isLoadingMore = false;
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setOnRefreshListener(this);

        mItems = new LinkedList<>();
//        mItems.add(Dingqilicai.generRandomData());
        mItemAdapter = new DingqilicaiAdapter(_mActivity,mItems);
        mItemAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, RecyclerView.ViewHolder vh) {
                Logger.e(position +"");
                BusProvider.getInstance().post(new StartBrotherEvent(DingqiDetailFragment.newInstance(mItems.get(position))));
            }
        });
//        mRecyclerView.setHasFixedSize(true);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(_mActivity);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mItemAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
                int totalItemCount = layoutManager.getItemCount();
                //lastVisibleItem >= totalItemCount - 3 表示剩下4个item自动加载，各位自由选择
                // dy>0 表示向下滑动
                if (lastVisibleItem >= totalItemCount - 3 && dy > 0) {
                    if(!isLoadingMore && mPageTotal!= 0 && mPageCurrent < mPageTotal){
                        loadMoreData();
                    }
                }
            }
        });
        loadMoreData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dingqilicai, container, false);
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
    public void onRefresh() {
        Logger.e("onRefresh");
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPageTotal = 0;
                mPageCurrent = 0;
                loadMoreData();
                mRefreshLayout.setRefreshing(false);

            }
        }, 1000);
    }

    public void loadMoreData(){
        isLoadingMore = true;
        http("", Global.DEALS_TAG, "{\"page\":\""+(mPageCurrent+1)+"\"}", new HttpListener() {
            @Override
            public void onSuccess(String tag, String content) {
                isLoadingMore = false;
                if (StringUtils.isEmpty(content)) {
                    showToast("网络连接错误，请稍后重试。");
                } else if (StringUtils.equalsIgnoreCase(Global.DEALS_TAG,tag)){
                    Deals bean = new Gson().fromJson(content,Deals.class);
                    if (bean.getResponse_code() != 1){
                        showToast(bean.getShow_err());
                    }else {
                        mPageCurrent = NumberUtils.toInt(bean.getPage().getPage());
                        mPageTotal = bean.getPage().getPage_total();
                        if (mPageCurrent == 1){
                            mItems.clear();
                        }
                        for (HomeInit.IndexListBean.DealListBean itemBean:bean.getItem()){
                            mItems.add(Utils.homtItemToDingqilicai(itemBean));
                        }
                        mItemAdapter.notifyDataSetChanged();
                    }
                }

            }
        });
    }
}
