package com.winkey.commonlib.router;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.winkey.commonlib.model.po.SysParamProfile;
import com.winkey.commonlib.model.po.UserProfile;

import java.util.List;

/**
 * @author winkey
 * @date 2020/1/26
 * @describe TODO
 */
public interface UserService extends IProvider {

    String getToken();

}
