package com.winkey.winFrame.main.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.winkey.commonlib.constant.GlideOptions;
import com.winkey.winFrame.R;
import com.winkey.winFrame.main.model.vo.NewsBannerEntity;
import com.winkey.winlib.ui.image.GlideUtil;

import java.util.List;

/**
 * 图片适配器
 *
 * @author xiongz
 * @date 2019-06-26
 */
public class BannerAdapter extends PagerAdapter {

    private Context mContext;
    private List<NewsBannerEntity> mDataList;

    public BannerAdapter(Context context, List<NewsBannerEntity> dataList) {
        mContext = context;
        mDataList = dataList;
    }

    @Override
    public int getCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.banner_image_item, container, false);
        ImageView ivImage = view.findViewById(R.id.iv_image);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        NewsBannerEntity entity = mDataList.get(position);
        switch(position%3){
            case 1:
                GlideUtil.withOption(mContext, "http://pic1.win4000.com/wallpaper/c/53cdd1f7c1f21.jpg",
                        ivImage, GlideOptions.getInstance().getDefaultOption());
                tvTitle.setText("亿梯登记电梯数量突破1000亿");
                break;
            case 2:
                GlideUtil.withOption(mContext, "http://bpic.588ku.com/element_origin_min_pic/16/12/25/99208df471416af4c1ba4a9428a2e4ce.jpg",
                        ivImage, GlideOptions.getInstance().getDefaultOption());
                tvTitle.setText("亿梯App即将震撼上限，此处撒花");
                break;
            case 3:
                GlideUtil.withOption(mContext, "http://up.enterdesk.com/edpic_source/fe/5a/cb/fe5acbcd8ba116f1a00e6bbd8697ec36.jpg",
                        ivImage, GlideOptions.getInstance().getDefaultOption());
                tvTitle.setText("亿梯携手小黄人，给员工送福利");
                break;
            default:
                GlideUtil.withOption(mContext, "http://up.enterdesk.com/edpic_source/fe/5a/cb/fe5acbcd8ba116f1a00e6bbd8697ec36.jpg",
                        ivImage, GlideOptions.getInstance().getDefaultOption());
                tvTitle.setText("亿梯携手小黄人，给员工送福利");
                break;
        }

        container.addView(view);
        return view;
    }
}
