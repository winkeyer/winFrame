package com.winkey.projectmodule.view;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.winkey.commonlib.constant.Router;
import com.winkey.projectmodule.R;
import com.winkey.winlib.activity.BaseActivity;

/**
 * @author xuwenbin
 * @date 2020/2/18
 * @describe TODO
 */
@Route(path = Router.PROJECT_ACTIVITY)
public class ProjectManageActivity extends BaseActivity {
    @Override
    protected Object getContentView() {
        return R.layout.project_activity_manage;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void parseData() {

    }
}
