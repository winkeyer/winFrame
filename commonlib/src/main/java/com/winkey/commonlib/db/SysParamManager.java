package com.winkey.commonlib.db;

import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.winkey.commonlib.constant.Const;
import com.winkey.commonlib.model.po.SysParamProfile;
import com.winkey.commonlib.model.vo.SysParamEntity;
import com.winkey.commonlib.constant.ConstUrl;
import com.winkey.commonlib.net.NetManager;
import com.winkey.commonlib.net.NetParams;
import com.winkey.commonlib.net.ObserverProxy;
import com.winkey.commonlib.router.ParamService;
import com.winkey.winlib.rx.RxNetClient;
import com.winkey.winlib.util.FastjsonUtil;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

;

/**
 * 系统参数网络请求模块
 *
 * @author xiongz
 * @date 2018/9/29
 */
public class SysParamManager {


    // 完成回调
    private OnCompleteRequest mOnCompleteRequest;
    // 是否获取到所有的系统参数数据
    private boolean mIsSysParams;
    // 是否获取到所有的数据
    private boolean mIsCompleted;
    private ParamService paramService;

    private static final class Holder {
        private static final SysParamManager INSTANCE = new SysParamManager();
    }

    public static SysParamManager getInstance() {
        return SysParamManager.Holder.INSTANCE;
    }

    public SysParamManager setOnCompleteRequest(OnCompleteRequest onCompleteRequest) {
        mOnCompleteRequest = onCompleteRequest;
        return this;
    }

    public interface OnCompleteRequest {
        void onComplete();
    }



    /**
     * 获取系统参数
     */
    public void getSysParams(Context context) {
        mIsSysParams = false;
        mIsCompleted = false;

        // 删除系统参数所有数据
        paramService = ARouter.getInstance().navigation(ParamService.class);
        paramService.clearSysParamProfile();
        // 获取系统参数
        requestSysParams(context);
    }

    /**
     * 设置所有的系统配置参数为空
     */
    public void setNull() {
        mIsSysParams = false;
        mIsCompleted = false;
        setListenerNull();
    }

    /**
     * 设置监听为空，避免内存泄漏
     */
    public void setListenerNull() {
        if (mOnCompleteRequest != null) {
            mOnCompleteRequest = null;
        }
    }

    /**
     * 获取所有的系统参数数据
     */
    private void requestSysParams(Context context) {
        String[] systemParams = Const.SystemParam.SYSTEM_PARAMS;
        String typeStr = "";
        for (int i = 0; i < systemParams.length; i++) {
            if (i == 0) {
                typeStr += systemParams[i];
            } else {
                typeStr += "," + systemParams[i];
            }
        }
        HashMap<String, Object> params = new HashMap<>();
        params.put("typeStr",typeStr);
        String url = NetManager.getInstance().getUrl(ConstUrl.DICTIONARY_ALL);
        String body = FastjsonUtil.toJSONString(params);
        RxNetClient.builder()
                .url(url)
                .headers(NetParams.getHeaderParams())
                .params(params)
                .build()
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ObserverProxy(context, url, body, new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String result) {
                        parseSysParam(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        // ActivityUtils.startActivity(MainActivity.class);
                    }

                    @Override
                    public void onComplete() {
                    }
                }));;

    }

    /**
     * 解析系统参数返回数据
     */
    private void parseSysParam(String result) {
        List<SysParamEntity> list = FastjsonUtil.parseArray(result, SysParamEntity.class);
        for (SysParamEntity sysParamEntity:list) {
            SysParamProfile sysParamProfile = new SysParamProfile();
            sysParamProfile.setDictTag(sysParamEntity.getType());
            sysParamProfile.setDictId(sysParamEntity.getId());
            sysParamProfile.setDictKey(sysParamEntity.getK());
            sysParamProfile.setDictKeyId(Integer.parseInt(sysParamEntity.getK()));
            sysParamProfile.setDictValue(sysParamEntity.getVal());
            sysParamProfile.setDictType(sysParamEntity.getType());
            sysParamProfile.setImageName(sysParamEntity.getImageName());

            paramService = ARouter.getInstance().navigation(ParamService.class);
            paramService.clearSysParamProfile();
            paramService.insertSysParamProfile(sysParamProfile);
        }
        mIsSysParams = true;
        check();
    }

    /**
     * 是否获取到所有的系统参数
     */
    private void check() {
        if (mIsSysParams && !mIsCompleted) {
            mIsCompleted = true;
            if (mOnCompleteRequest != null) mOnCompleteRequest.onComplete();
        }
    }
}