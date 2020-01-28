package com.winkey.commonlib.view.DropDownMenu;

import android.content.Context;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.winkey.commonlib.R;
import com.winkey.commonlib.model.po.SysParamProfile;
import com.winkey.winlib.ui.recycler.ViewHolder;

import java.util.List;

/**
 * @author winkey
 * @date 2019/11/09
 * @describe DropDownMenu recyclerView下拉列表适配器
 */
public class RecyclerViewDropDownAdapter extends BaseQuickAdapter<SysParamProfile, ViewHolder> {

    private Context mContext;
    private List<SysParamProfile> mData;
    private int checkItemPosition = 0;


    public void setCheckItem(int position) {
        checkItemPosition = position;
        notifyDataSetChanged();
    }


    public RecyclerViewDropDownAdapter(Context context, int layoutResId, List<SysParamProfile> datas) {
        super(layoutResId, datas);
        mContext = context;
        mData = datas;
    }

    @Override
    protected void convert(ViewHolder helper, SysParamProfile item) {
        TextView tvItem = helper.getView(R.id.tv_drop_down_text);
        tvItem.setText(item.getDictValue());
        if (checkItemPosition == helper.getAdapterPosition()) {
            tvItem.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));

        } else {
            tvItem.setTextColor(mContext.getResources().getColor(R.color.gray));
        }
    }
}
