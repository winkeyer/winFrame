package com.winkey.commonlib.view.DropDownMenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.winkey.commonlib.R;
import com.winkey.commonlib.model.po.SysParamProfile;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * DropDownMenu下拉列表适配器
 *
 * @author xiongz
 * @date 2018/9/20
 */
public class ListDropDownAdapter extends BaseAdapter {

    private Context context;
    private List<SysParamProfile> list;
    private int checkItemPosition = 0;
    // 是否是父类
    private boolean mIsParent = false;

    public void setCheckItem(int position) {
        checkItemPosition = position;
        notifyDataSetChanged();
    }

    public ListDropDownAdapter(Context context, List<SysParamProfile> list) {
        this.context = context;
        this.list = list;
    }

    /**
     * 构造函数
     *
     * @param context
     * @param list
     * @param isParent 是否有子集
     */
    public ListDropDownAdapter(Context context, List<SysParamProfile> list, boolean isParent) {
        this.context = context;
        this.list = list;
        this.mIsParent = isParent;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_drop_down, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        fillValue(position, viewHolder);
        return convertView;
    }

    private void fillValue(int position, ViewHolder viewHolder) {
        String title = list.get(position).getDictValue();
        if (checkItemPosition != -1) {
            if (checkItemPosition == position) {
                viewHolder.mText.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                if (mIsParent && position != 0) { // 父类则显示右箭头
                    viewHolder.mText.setText(title + "＞");
                } else {
                    viewHolder.mText.setText(title);
                }
            } else {
                viewHolder.mText.setTextColor(context.getResources().getColor(R.color.gray));
                viewHolder.mText.setText(title);
            }
        } else {
            viewHolder.mText.setTextColor(context.getResources().getColor(R.color.gray));
            viewHolder.mText.setText(title);
        }
    }

    static class ViewHolder {
        TextView mText;

        ViewHolder(View view) {
            mText = view.findViewById(R.id.tv_drop_down_text);
        }
    }
}
