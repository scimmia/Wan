package com.wanguanjinrong.mobile.wanguan.main.home.gonggao;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import com.orhanobut.logger.Logger;
import com.wanguanjinrong.mobile.wanguan.uitls.TestUtils;
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
 * Created by A on 2016/8/5.
 */
public class GonggaoListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.toolbar_my)
    Toolbar mToolbar;
    @BindView(R.id.recy)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    LinkedList<Gonggao> mItems;
    GonggaoAdapter mItemAdapter;

    protected Unbinder unbinder;
    public static BaseFragment newInstance() {
        BaseFragment fragment = new GonggaoListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mToolbar.setTitle("万贯公告");
        initToobarBack(mToolbar);
        initRefresh(mRefreshLayout,this);

        mItems = new LinkedList<>();
        mItems.add(TestUtils.generRandomGonggao());
        mItems.add(TestUtils.generRandomGonggao());
        mItemAdapter = new GonggaoAdapter(_mActivity);
        mItemAdapter.setDatas(mItems);
        mItemAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, RecyclerView.ViewHolder vh) {
                Logger.e(position +"");
//                _mActivity.start(DingqiBuyFragment.newInstance(mItems.get(position)));
            }
        });
//        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
        mRecyclerView.setAdapter(mItemAdapter);
    }

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
    public void onRefresh() {
        Logger.e("onRefresh");
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                LinkedList<Gonggao> items;
                items = new LinkedList<>();
                items.add(TestUtils.generRandomGonggao());
                mItemAdapter.addDatas(items);
                mItemAdapter.notifyDataSetChanged();
                mRefreshLayout.setRefreshing(false);

            }
        }, 1000);
    }
}
