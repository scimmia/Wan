package com.wanguanjinrong.mobile.wanguan.main.borrow;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.*;
import com.orhanobut.logger.Logger;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.DialogListener;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by A on 2016/7/8.
 */
public class BorrowFragment extends BaseFragment implements Toolbar.OnMenuItemClickListener{
    protected Unbinder unbinder;
    @BindView(R.id.toolbar_borrow)
    Toolbar mToolbar;
    @BindView(R.id.et_borrow_name)
    MaterialEditText mEtBorrowName;
    @BindView(R.id.et_borrow_idcard)
    MaterialEditText mEtBorrowIdcard;
    @BindView(R.id.et_borrow_marrystate)
    MaterialEditText mEtBorrowMarrystate;
    @BindView(R.id.xingming)
    MaterialEditText mXingming;
    @BindView(R.id.et_borrow_hometown)
    MaterialEditText mEtBorrowHometown;
    @BindView(R.id.et_borrow_address)
    MaterialEditText mEtBorrowAddress;
    @BindView(R.id.et_borrow_money)
    MaterialEditText mEtBorrowMoney;
    @BindView(R.id.et_borrow_days)
    MaterialEditText mEtBorrowDays;
    @BindView(R.id.et_borrow_hascar)
    MaterialEditText mEtBorrowHascar;
    @BindView(R.id.et_borrow_hashouse)
    MaterialEditText mEtBorrowHashouse;
    @BindView(R.id.et_borrow_houseaddress)
    MaterialEditText mEtBorrowHouseaddress;
    @BindView(R.id.et_borrow_haspolicy)
    MaterialEditText mEtBorrowHaspolicy;
    @BindView(R.id.et_borrow_wage)
    MaterialEditText mEtBorrowWage;

    public static BorrowFragment newInstance() {
        BorrowFragment fragment = new BorrowFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mToolbar.setTitle("我要借款");
        mToolbar.inflateMenu(R.menu.borrow);
        mToolbar.setOnMenuItemClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_borrow, container, false);
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

    String[] marrystateNames = { "未婚",  "已婚", };
    String[] marrystateIDs = { "0",  "1",  };
    String[] youwuHouseNames = { "无",  "有", "按揭",  };
    String[] youwuHouseIDs = { "0",  "1", "2",  };
    String[] youwuNames = { "无",  "有",   };
    String[] youwuIDs = { "0",  "1",   };
    @OnFocusChange(R.id.et_borrow_marrystate)
    void onet_borrow_marrystateFocus(boolean focused) {
        if (focused) {
            onet_borrow_marrystate();
        }
    }

    @OnClick(R.id.et_borrow_marrystate)
    void onet_borrow_marrystate() {
        Logger.e("onet_borrow_marrystate");
        showSingleDialog("", marrystateNames,marrystateIDs, (String) mEtBorrowMarrystate.getTag(), new DialogListener() {
                    @Override
                    public void onSelected(String name, String id) {
                        Logger.e(name +"\t"+ id);
                        mEtBorrowMarrystate.setTag(id);
                        mEtBorrowMarrystate.setText(name);
                    }

                    @Override
                    public void onClear() {
                        Logger.e("onClear");
                        mEtBorrowMarrystate.setTag("");
                        mEtBorrowMarrystate.setText("");
                    }
                });
    }

    @OnFocusChange(R.id.et_borrow_hascar)
    void onet_borrow_hascarFocus(boolean focused) {
        if (focused) {
            onet_borrow_hascar();
        }
    }

    @OnClick(R.id.et_borrow_hascar)
    void onet_borrow_hascar() {
        Logger.e("onet_borrow_hascar");
        showSingleDialog("", youwuNames,youwuIDs, (String) mEtBorrowHascar.getTag(),getSingleDialogListener(mEtBorrowHascar));
    }

    @OnFocusChange(R.id.et_borrow_hashouse)
    void onet_borrow_hashouseFocus(boolean focused) {
        if (focused) {
            onet_borrow_hashouse();
        }
    }

    @OnClick(R.id.et_borrow_hashouse)
    void onet_borrow_hashouse() {
        Logger.e("onet_borrow_hashouse");
        showSingleDialog("", youwuHouseNames,youwuHouseIDs, (String) mEtBorrowHashouse.getTag(), new DialogListener() {
            @Override
            public void onSelected(String name, String id) {
                Logger.e(name +"\t"+ id);
                mEtBorrowHashouse.setTag(id);
                mEtBorrowHashouse.setText(name);
                if (StringUtils.equalsIgnoreCase(name,"无")){
                    mEtBorrowHouseaddress.setText("");
                    mEtBorrowHouseaddress.setVisibility(View.GONE);
                } else {
                    mEtBorrowHouseaddress.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onClear() {
                Logger.e("onClear");
                mEtBorrowHashouse.setTag("");
                mEtBorrowHashouse.setText("");
                mEtBorrowHouseaddress.setText("");
                mEtBorrowHouseaddress.setVisibility(View.GONE);
            }
        });
    }

    @OnFocusChange(R.id.et_borrow_haspolicy)
    void onet_borrow_haspolicyFocus(boolean focused) {
        if (focused) {
            onet_borrow_haspolicy();
        }
    }

    @OnClick(R.id.et_borrow_haspolicy)
    void onet_borrow_haspolicy() {
        Logger.e("onet_borrow_haspolicy");
        showSingleDialog("", youwuNames,youwuIDs, (String) mEtBorrowHaspolicy.getTag(),getSingleDialogListener(mEtBorrowHaspolicy));
    }

    public AlertDialog mAlertDialog;
    public DialogListener getSingleDialogListener(final EditText editText){
        return new DialogListener() {
            @Override
            public void onSelected(String name, String id) {
                Logger.e(name +"\t"+ id);
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

    public void showSingleDialog(String title, final String[] itemNames, final String[] itemIDs, String itemSelected, final DialogListener dialogListener){
        if (mAlertDialog != null){
            mAlertDialog.dismiss();
            mAlertDialog = null;
        }
//        String[] itemNames = getResource(itemTpye);
//        String[] itemIDs = getResource(itemTpye);
        if (itemNames != null && itemIDs != null && itemNames.length == itemIDs.length){
            int selectedPos = ArrayUtils.indexOf(itemIDs,itemSelected);
            mAlertDialog = new AlertDialog.Builder(_mActivity).setTitle(title)
                    .setSingleChoiceItems(itemNames, selectedPos, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (dialogListener != null){
                                dialogListener.onSelected(itemNames[which],itemIDs[which]);
                            }
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("取消选择", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (dialogListener != null){
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

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_borrow:
                Logger.e("action_borrow");
                break;
        }
        return true;
    }
}
