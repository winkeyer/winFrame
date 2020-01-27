package com.winkey.winFrame.main.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.winkey.commonlib.model.vo.SubmitEntity;
import com.winkey.commonlib.constant.ConstUrl;
import com.winkey.commonlib.net.NetManager;
import com.winkey.commonlib.net.NetParams;
import com.winkey.commonlib.net.ObserverProxy;
import com.winkey.winFrame.main.contract.MainContract;
import com.winkey.winFrame.main.model.vo.HomeMenuEntity;
import com.winkey.winFrame.main.model.vo.NewsBannerEntity;
import com.winkey.winlib.presenter.BasePresenter;
import com.winkey.winlib.rx.RxNetClient;
import com.winkey.winlib.util.FastjsonUtil;

import java.util.ArrayList;
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
public class HomePresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    // 上下文
    private Context mContext;

    public HomePresenter(Context context){
        this.mContext = context;
    }

    @Override
    public void requestMenu() {
        mView.showLoading();
        String url = NetManager.getInstance().getUrl(ConstUrl.HOME_MENU);
        RxNetClient.builder()
                .url(url)
                .headers(NetParams.getHeaderParams())
                .build()
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( new ObserverProxy(mContext, url, "{}", new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String result) {
                        parseMenuData(result);
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
     * 解析返回数据
     */
    private void parseMenuData(String result) {
        SubmitEntity submitEntity = FastjsonUtil.parseObject(result, SubmitEntity.class);
        try {
            if(!TextUtils.isEmpty(submitEntity.getResult().toString())){
                List<HomeMenuEntity> homeMenuEntity = FastjsonUtil.parseArray(submitEntity.getResult().toString(), HomeMenuEntity.class);
                mView.onNotifyMenu(homeMenuEntity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void requestBanner() {
        mView.onNotifyBanner(new ArrayList<NewsBannerEntity>());
    }
}
