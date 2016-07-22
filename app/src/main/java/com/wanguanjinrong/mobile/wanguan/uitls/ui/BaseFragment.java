package com.wanguanjinrong.mobile.wanguan.uitls.ui;


import com.wanguanjinrong.mobile.wanguan.uitls.eventbus.BusProvider;
import me.yokeyword.fragmentation.SupportFragment;

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
}
