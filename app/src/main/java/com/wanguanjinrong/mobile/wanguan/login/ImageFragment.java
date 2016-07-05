package com.wanguanjinrong.mobile.wanguan.login;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wanguanjinrong.mobile.wanguan.R;
import me.yokeyword.fragmentation.SupportFragment;

public class ImageFragment extends SupportFragment {

    private static final String ARG_LAYOUT_RES_ID = "layoutResId";

    public static ImageFragment newInstance(int layoutResId) {
        ImageFragment defaultFragment = new ImageFragment();

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

}
