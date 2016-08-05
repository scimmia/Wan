package com.wanguanjinrong.mobile.wanguan.account;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.uitls.Utils;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.BusProvider;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.LoginEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;

/**
 * Created by A on 2016/8/5.
 */
public class PersonalInfoFragment extends BaseFragment {

    @BindView(R.id.toolbar_personal)
    Toolbar mToolbar;

    protected Unbinder unbinder;
    @BindView(R.id.per_bind_state)
    TextView mPerBindState;
    @BindView(R.id.per_phone)
    TextView mPerPhone;
    @BindView(R.id.per_invitecode)
    TextView mPerInvitecode;
    @BindView(R.id.per_auth_state)
    TextView mPerAuthState;
    @BindView(R.id.per_name)
    TextView mPerName;
    @BindView(R.id.per_idno)
    TextView mPerIdno;

    public static BaseFragment newInstance() {
        BaseFragment fragment = new PersonalInfoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {
        mToolbar.setTitle(R.string.personal_info);
        mToolbar.setBackgroundColor(0xFFf71e1a);
        initToobarBack(mToolbar);

        try {
            Account account = Utils.getLoginInfo(_mActivity);
            mPerBindState.setText("已绑定");
            mPerPhone.setText(account.getMobile());
            mPerInvitecode.setText(account.getUid());
            mPerAuthState.setText("已认证");
            mPerName.setText(account.getReal_name());
            mPerIdno.setText(account.getIdno());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal, container, false);
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

    @OnClick(R.id.btn_logout)
    public void onLogout() {
        Utils.logout(_mActivity);

        hideSoftInput();
        BusProvider.getInstance().post(new LoginEvent());
        pop();
    }

}
