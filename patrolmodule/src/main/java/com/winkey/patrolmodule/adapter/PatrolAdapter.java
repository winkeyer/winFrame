package com.winkey.patrolmodule.adapter;

import android.content.Context;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.winkey.patrolmodule.R;
import com.winkey.patrolmodule.model.vo.PatrolEntity;
import com.winkey.winlib.ui.recycler.ViewHolder;

import java.util.List;

/**
 * @author winkey
 * @date 2019/11/09
 * @describe 巡检适配器
 */
public class PatrolAdapter extends BaseQuickAdapter<PatrolEntity, ViewHolder> implements LoadMoreModule {

    private Context mContext;
    private List<PatrolEntity> mData;

    public PatrolAdapter(Context context, int layoutResId, List<PatrolEntity> datas) {
        super(layoutResId, datas);
        mContext = context;
        mData = datas;
    }

    @Override
    protected void convert(ViewHolder helper, PatrolEntity item) {
        helper.setText(R.id.view_project_name, item.getProjectName());
        helper.setText(R.id.view_maintenace_company, item.getMaintenanceCompanyName());
        helper.setText(R.id.view_user_name, item.getPropertyCompanyName());
        helper.setText(R.id.view_address, item.getProjectDetailAddress());
        TextView tvStatus = helper.getView(R.id.tv_status);
        int tempre = item.getStatus();

        switch (tempre) {
            case 0:
                tvStatus.setText("待认领");
                tvStatus.setTextColor(mContext.getResources().getColor(R.color.blue));
                break;
            case 1:
                tvStatus.setText("待指派");
                tvStatus.setTextColor(mContext.getResources().getColor(R.color.darker_green));
                break;
            case 2:
                tvStatus.setText("待接单");
                tvStatus.setTextColor(mContext.getResources().getColor(R.color.orange));
                break;
            case 3:
                tvStatus.setText("巡检中");
                tvStatus.setTextColor(mContext.getResources().getColor(R.color.orange));
                break;

            case 4:
                tvStatus.setText("完成");
                tvStatus.setTextColor(mContext.getResources().getColor(R.color.green));
                break;
        }
    }
}
