package com.wanguanjinrong.mobile.wanguan.login;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class DefaultFragment extends Fragment {

    private static final String ARG_LAYOUT_RES_ID = "layoutResId";

    public static DefaultFragment newInstance(int layoutResId) {
        DefaultFragment defaultFragment = new DefaultFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT_RES_ID, layoutResId);
        defaultFragment.setArguments(args);

        return defaultFragment;
    }

    private int layoutResId;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null && getArguments().containsKey(ARG_LAYOUT_RES_ID))
            layoutResId = getArguments().getInt(ARG_LAYOUT_RES_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layoutResId, container, false);
    }

    public DefaultFragment() {
        // Required empty public constructor
    }

}
