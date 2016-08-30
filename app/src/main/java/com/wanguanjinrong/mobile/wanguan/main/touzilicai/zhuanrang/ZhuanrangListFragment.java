package com.wanguanjinrong.mobile.wanguan.main.touzilicai.zhuanrang;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.bean.Login;
import com.wanguanjinrong.mobile.wanguan.bean.Transfer;
import com.wanguanjinrong.mobile.wanguan.bean.UcInvest;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi.DingqiDetailFragment;
import com.wanguanjinrong.mobile.wanguan.main.touzilicai.dingqi.DingqiMyAdapter;
import com.wanguanjinrong.mobile.wanguan.uitls.Global;
import com.wanguanjinrong.mobile.wanguan.uitls.Utils;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.BusProvider;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.StartBrotherEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.http.HttpListener;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.listener.OnItemClickListener;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by A on 2016/8/30.
 */
public class ZhuanrangListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recy)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;


    LinkedList<Transfer.ItemBean> mItems;
    ZhuanrangAdapter mItemAdapter;
    int mPageTotal;
    int mPageCurrent;
    boolean isLoadingMore;

    protected Unbinder unbinder;
    public static ZhuanrangListFragment newInstance() {
        ZhuanrangListFragment fragment = new ZhuanrangListFragment();
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
        mItemAdapter = new ZhuanrangAdapter(_mActivity,mItems);
        mItemAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, RecyclerView.ViewHolder vh) {
                Logger.e(position +"");
                BusProvider.getInstance().post(new StartBrotherEvent(ZhuanrangDetailFragment.newInstance(mItems.get(position))));
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
                try {
                    mPageTotal = 0;
                    mPageCurrent = 0;
                    loadMoreData();
                    mRefreshLayout.setRefreshing(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, 1000);
    }


    public void loadMoreData(){
        isLoadingMore = true;
        HashMap<String,String> map = new HashMap<>();
        map.put("page",(mPageCurrent+1)+"");
        map.put("cid","0");
        http("", Global.transfer_TAG, new Gson().toJson(map), new HttpListener() {
            @Override
            public void onSuccess(String tag, String content) {
                isLoadingMore = false;
                if (StringUtils.isEmpty(content)) {
                    showToast("网络连接错误，请稍后重试。");
                } else {
                    Transfer bean = new Gson().fromJson(content,Transfer.class);
                    if (bean.getResponse_code() != 1){
                        showToast(bean.getShow_err());
                    }else {
                        mPageCurrent = bean.getPage().getPage();
                        mPageTotal = bean.getPage().getPage_total();
                        if (mPageCurrent == 1){
                            mItems.clear();
                        }
                        mItems.addAll(bean.getItem());
                        mItemAdapter.notifyDataSetChanged();
                    }
                }

            }
        });
    }
}
