package com.winkey.patrolmodule.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSONArray;
import com.winkey.commonlib.constant.ConstUrl;
import com.winkey.commonlib.model.vo.PagesEntity;
import com.winkey.commonlib.model.vo.SubmitEntity;
import com.winkey.commonlib.net.NetManager;
import com.winkey.commonlib.net.NetParams;
import com.winkey.commonlib.net.ObserverProxy;
import com.winkey.patrolmodule.constant.Url;
import com.winkey.patrolmodule.contract.PatrolContract;
import com.winkey.patrolmodule.model.vo.PatrolEntity;
import com.winkey.winlib.presenter.BasePresenter;
import com.winkey.winlib.rx.RxNetClient;
import com.winkey.winlib.util.FastjsonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author winkey
 * @date 2020/1/9
 * @describe 首页Presenter类
 */
public class PatrolPresenter extends BasePresenter<PatrolContract.View> implements PatrolContract.Presenter {

    // 上下文
    private Context mContext;

    public PatrolPresenter(Context context){
        this.mContext = context;
    }

    @Override
    public void requestPatrol(HashMap<String, Object> params) {
        String url = NetManager.getInstance().getUrl(Url.PATROL_LIST);
        String body = FastjsonUtil.toJSONString(params);
        mView.showLoading();
        RxNetClient.builder()
                .url(url)
                .params(params)
                .build()
                .postParams()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ObserverProxy(mContext, url, body, new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String result) {
                        parsePatrolData(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        mView.hideLoading();
                    }
                }));
    }


    /**
     * 解析巡检数据
     *
     * @param result
     */
    private void parsePatrolData(String result) {
        PagesEntity pagesEntity = FastjsonUtil.parseObject(result, PagesEntity.class);
        int total = pagesEntity.getTotal();
        JSONArray data = (JSONArray) pagesEntity.getRows();
        String list = data.toJSONString();
        List<PatrolEntity> patrols = FastjsonUtil.parseArray(list, PatrolEntity.class);
        mView.onNotifyPatrol(total,patrols);
    }

}
