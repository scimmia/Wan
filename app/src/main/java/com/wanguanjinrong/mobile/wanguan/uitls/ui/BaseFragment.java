package com.wanguanjinrong.mobile.wanguan.uitls.ui;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.orhanobut.logger.Logger;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.BusProvider;
import com.wanguanjinrong.mobile.wanguan.uitls.http.HttpListener;
import com.wanguanjinrong.mobile.wanguan.uitls.http.HttpTask;
import me.yokeyword.fragmentation.SupportFragment;
import org.apache.commons.lang3.ArrayUtils;

public class BaseFragment extends SupportFragment {
   /*
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.wanguanjinrong.mobile.wanguan.R;

    protected Unbinder unbinder;
    public static BaseFragment newInstance() {
        BaseFragment fragment = new DingqilicaiFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
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



        HashMap<String,String> map = new HashMap<>();
        map.put("act","init");
        new HttpTask(_mActivity,Global.INIT_MSG, Global.INIT_TAG,map).execute();


    @Subscribe
    public void onHttpEvent(HttpEvent event){
        if (event != null){
            switch (event.getTag()){
                case Global.INIT_TAG:
//                    List<HomeInit> response = new Gson().fromJson(event.getResponse(), new TypeToken<List<HomeInit>>() {
//                    }.getType());
//                    HomeInit homeInit = response.get(0);
                    HomeInit homeInit = new Gson().fromJson(event.getResponse(),HomeInit.class);
                    if (homeInit.getResponse_code() != 1){
                        Logger.e(homeInit.getShow_err());
                    }
                    break;
            }
        }
    }
    */
   @Override
   public void onResume() {
       super.onResume();

       // Register ourselves so that we can provide the initial value.
       BusProvider.getInstance().register(this);
//       showMessageListener = new Object() {
//           @Subscribe
//           public void showMessage(final MessageEvent event) {
//               if (event!= null){
//                   BaseActivity.this.showMessage(event.getMessage());
//               }
//           }
//       };
//       BusProvider.getInstance().register(showMessageListener);
   }

    @Override
    public void onPause() {
        super.onPause();
//        cancelMessage();
//        cancelProgress();
        // Always unregister when an object no longer should be on the bus.
        BusProvider.getInstance().unregister(this);
//        BusProvider.getInstance().unregister(showMessageListener);
    }

    public void initToobarBack(Toolbar toolbar){
        if(toolbar != null){
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _mActivity.onBackPressedSupport();
                }
            });
        }
    }

    public void initRefresh(SwipeRefreshLayout refreshLayout,SwipeRefreshLayout.OnRefreshListener refreshListener){
        if(refreshLayout != null){
            refreshLayout.setColorSchemeResources(R.color.colorPrimary);
            if(refreshListener != null) {
                refreshLayout.setOnRefreshListener(refreshListener);
            }
        }
    }


    private Toast appMsg;
    public void showToast(String message){
        cancelToast();
        appMsg = Toast.makeText(_mActivity, message, Toast.LENGTH_SHORT);
        appMsg.show();

    }
    public void cancelToast(){
        if (appMsg!=null){
            appMsg.cancel();
        }
    }

    public AlertDialog mAlertDialog;

    public DialogListener getSingleDialogListener(final EditText editText) {
        return new DialogListener() {
            @Override
            public void onSelected(String name, String id) {
                Logger.e(name + "\t" + id);
                editText.setTag(id);
                editText.setText(name);
            }

            @Override
            public void onClear() {
                Logger.e("onClear");
                editText.setTag("");
                editText.setText("");
            }
        };
    }

    public void showSingleDialog(String title, final String[] itemNames, final String[] itemIDs, String itemSelected, final DialogListener dialogListener) {
        if (mAlertDialog != null) {
            mAlertDialog.dismiss();
            mAlertDialog = null;
        }
        if (itemNames != null && itemIDs != null && itemNames.length == itemIDs.length) {
            int selectedPos = ArrayUtils.indexOf(itemIDs, itemSelected);
            mAlertDialog = new AlertDialog.Builder(_mActivity).setTitle(title)
                    .setSingleChoiceItems(itemNames, selectedPos, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (dialogListener != null) {
                                dialogListener.onSelected(itemNames[which], itemIDs[which]);
                            }
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("取消选择", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (dialogListener != null) {
                                dialogListener.onClear();
                            }
                        }
                    })
                    .setNeutralButton("返回", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create();
            mAlertDialog.show();
        }
    }

    public void http(String msgToShow, String mAct, String json){
        new HttpTask(_mActivity, msgToShow, mAct, json).execute();
    }
    public void http(String msgToShow, String mAct, String json, HttpListener httpListener){
        new HttpTask(_mActivity, msgToShow, mAct, json,httpListener).execute();
    }
}
