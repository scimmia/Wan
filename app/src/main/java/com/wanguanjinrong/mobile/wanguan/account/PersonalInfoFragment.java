package com.wanguanjinrong.mobile.wanguan.account;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.wanguanjinrong.mobile.wanguan.R;
import com.wanguanjinrong.mobile.wanguan.bean.Login;
import com.wanguanjinrong.mobile.wanguan.uitls.Global;
import com.wanguanjinrong.mobile.wanguan.uitls.Utils;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.BusProvider;
import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.event.LoginEvent;
import com.wanguanjinrong.mobile.wanguan.uitls.ui.BaseFragment;
import org.apache.commons.lang3.StringUtils;


/**
 * Created by A on 2016/8/5.
 */
public class PersonalInfoFragment extends BaseFragment {

    @BindView(R.id.toolbar_personal)
    Toolbar mToolbar;

    protected Unbinder unbinder;
    @BindView(R.id.per_invitecode)
    TextView mPerInvitecode;
    @BindView(R.id.per_auth_state)
    TextView mPerAuthState;
    @BindView(R.id.per_name)
    TextView mPerName;
    @BindView(R.id.per_idno)
    TextView mPerIdno;
    @BindView(R.id.person_add_card)
    LinearLayout mPersonAddCard;
    @BindView(R.id.btn_logout)
    Button mBtnLogout;
    @BindView(R.id.per_cardno)
    TextView mPerCardno;
    @BindView(R.id.per_cardno_edit)
    TextView mPerCardnoEdit;

    Login mLogin;

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
        mToolbar.setBackgroundColor(Global.Toolbar_Color_Red);
        initToobarBack(mToolbar);
        refreshItems();
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
        BusProvider.getInstance().post(new LoginEvent(Global.LoginStateOut));
        pop();
    }

    @OnClick(R.id.per_auth_state)
    public void onAddCard() {
        if (mLogin != null && StringUtils.isEmpty(mLogin.getReal_name())) {
            startForResult(AddBankCardFragment.newInstance(), 1000);
        }
    }

    @OnClick(R.id.per_cardno_edit)
    public void onEditCard() {
        if (mLogin != null && StringUtils.isEmpty(mLogin.getBankcard())) {
            startForResult(AddBankCardFragment.newInstance(), 1000);
        }else {
//// TODO: 2016/8/25
        }
    }

    void refreshItems(){
        try {
            mLogin = Utils.getLoginInfo(_mActivity);
            if (mLogin != null) {
                mPerInvitecode.setText(mLogin.getMobile());
                if (StringUtils.isEmpty(mLogin.getReal_name())) {
                    mPerAuthState.setText("未认证");
                    mPerAuthState.setTextColor(Color.BLUE);
                    mPerName.setText("");
                    mPerIdno.setText("");
                } else {
                    mPerAuthState.setText("已认证");
                    mPerAuthState.setTextColor(Color.BLACK);
                    mPerName.setText(mLogin.getReal_name());
                    mPerIdno.setText(mLogin.getIdno());
                }
                if (StringUtils.isEmpty(mLogin.getBankcard())) {
                    mPerCardno.setText("");
                    mPerCardnoEdit.setText("未绑定");
                } else {
                    mPerCardno.setText(mLogin.getBankcard());
                    mPerCardnoEdit.setText("解绑");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        super.onFragmentResult(requestCode, resultCode, data);
        try {
            if (requestCode == 1000 && resultCode == RESULT_OK ) {
                refreshItems();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    @Subscribe
//    public void onHttpEvent(HttpEvent event){
//        if (event == null || StringUtils.isEmpty(event.getResponse())) {
//            showToast("网络连接错误，请稍后重试。");
//        } else{
//            if (StringUtils.equalsIgnoreCase(Global.LOGIN_TAG,event.getTag())){
//                Login bean = new Gson().fromJson(event.getResponse(),Login.class);
//                if (bean.getResponse_code() != 1){
//                    showToast(bean.getShow_err());
//                }else {
//                    if (bean.getUser_login_status() != 1){
//                        showToast(bean.getShow_err());
//                    }else {
//                        bean.setUser_pwd(mLogin.getUser_pwd());
//                        Utils.login(_mActivity, bean);
//                        refreshItems();
//                    }
//                }
//            }
//        }
//    }
}
