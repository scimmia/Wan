package com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event;

import com.wanguanjinrong.mobile.wanguan.uitls.Global;

/**
 * Created by Hi on 2016-1-17.
 */
public class FragmentFinishEvent {
    Global.popEvent mPopEvent;

    public FragmentFinishEvent(Global.popEvent popEvent) {
        mPopEvent = popEvent;
    }

    public Global.popEvent getPopEvent() {
        return mPopEvent;
    }
}
