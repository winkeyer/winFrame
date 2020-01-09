package com.winkey.winFrame;

import com.winkey.common.constant.Event;
import com.winkey.winFrame.contract.MainContract;
import com.winkey.winFrame.model.vo.LoginEntity;
import com.winkey.winFrame.model.vo.MainEntity;
import com.winkey.winFrame.presenter.MainPresenter;
import com.winkey.winlib.activity.BaseActivity;
import com.winkey.winlib.event.EventManage;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {


    @Override
    protected Object getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        mPresenter = new MainPresenter(this);
        mPresenter.register(this);
    }

    @Override
    protected void parseData() {
        HashMap<String,Object> requestMap = new HashMap<>();

        HashMap<String, Object> loginParams = new HashMap<>();
        loginParams.put("username", "admin");
        loginParams.put("password", "admin");
        mPresenter.login(loginParams);
        mPresenter.main(loginParams);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventReceived(EventManage eventManage){
        if(Event.EVENT_LOGIN .equals(eventManage.event)){

        }
    }



    @Override
    public void onMain(MainEntity mainEntity) {

    }

}
