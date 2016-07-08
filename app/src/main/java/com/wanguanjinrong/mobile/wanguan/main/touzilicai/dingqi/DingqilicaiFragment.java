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
import com.orhanobut.logger.Logger;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.listener.OnItemClickListener;

import java.util.LinkedList;
import java.util.Random;

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
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setOnRefreshListener(this);

        mItems = new LinkedList<>();
        mItems.add(Dingqilicai.generRandomData());
        mItems.add(Dingqilicai.generRandomData());
        mItems.add(Dingqilicai.generRandomData());
        mItems.add(Dingqilicai.generRandomData());
        mItems.add(Dingqilicai.generRandomData());
        mItems.add(Dingqilicai.generRandomData());
        mItems.add(Dingqilicai.generRandomData());
        mItemAdapter = new DingqilicaiAdapter(_mActivity);
        mItemAdapter.setDatas(mItems);
        mItemAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, RecyclerView.ViewHolder vh) {
                Logger.e(position +"");
            }
        });
//        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
        mRecyclerView.setAdapter(mItemAdapter);
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
                mItems.add(Dingqilicai.generRandomData());
                mItems.add(Dingqilicai.generRandomData());
                mItems.add(Dingqilicai.generRandomData());
                mItems.add(Dingqilicai.generRandomData());
                mItems.add(Dingqilicai.generRandomData());
                mItemAdapter.setDatas(mItems);
                mItemAdapter.notifyDataSetChanged();
                mRefreshLayout.setRefreshing(false);

            }
        }, 2000);
    }
}
