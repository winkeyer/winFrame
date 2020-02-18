package com.winkey.commonlib.router;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.winkey.commonlib.model.po.SysParamProfile;

import java.util.List;

/**
 * @author xuwenbin
 * @date 2020/2/18
 * @describe TODO
 */
public interface ParamService extends IProvider {

    void insertSysParamProfile(SysParamProfile profile);
    void clearSysParamProfile();
    List<SysParamProfile> getSysParams(String parentId);
}
