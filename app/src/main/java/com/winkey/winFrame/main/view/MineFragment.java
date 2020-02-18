package com.winkey.winFrame.main.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.widget.IconTextView;
import com.winkey.commonlib.constant.GlideOptions;
import com.winkey.commonlib.icon.AppIcons;
import com.winkey.commonlib.constant.ConstUrl;
import com.winkey.commonlib.router.UserService;
import com.winkey.winFrame.R;
import com.winkey.winlib.fragments.BaseFragment;
import com.winkey.winlib.ui.image.GlideUtil;
import com.winkey.winlib.util.OperateUtil;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 我的
 *
 * @author xiongz
 * @date 2018/9/5
 */
public class MineFragment extends BaseFragment {

    @BindView(R.id.tv_mine_avatar)
    IconTextView tvAvatar;
    @BindView(R.id.iv_mine_avatar)
    CircleImageView ivAvatar;
    @BindView(R.id.tv_mine_name)
    TextView tvName;
    @BindView(R.id.tv_mine_dept)
    TextView tvDept;

    @Autowired
    UserService userService;

    @Override
    public Object setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        Drawable avatarDrawable = new IconDrawable(getProxyActivity(), AppIcons.bg_circle)
                .colorRes(R.color.orange).actionBarSize();
        tvAvatar.setBackground(avatarDrawable);

        String name = userService.getUserProfile().getNickname();
        tvName.setText(name);

        String avatarUrl = userService.getUserProfile().getHeadImgUrl();
        if (TextUtils.isEmpty(avatarUrl)) {
            tvAvatar.setVisibility(View.VISIBLE);
            ivAvatar.setVisibility(View.GONE);
            int length = name.length();
            tvAvatar.setText(name.substring(length - 1, length));
        } else {
            Drawable drawable = new IconDrawable(getProxyActivity(), AppIcons.bg_circle)
                    .colorRes(R.color.white).actionBarSize();
            tvAvatar.setVisibility(View.VISIBLE);
            tvAvatar.setBackground(drawable);
            ivAvatar.setVisibility(View.VISIBLE);
            GlideUtil.withOption(getProxyActivity(), ConstUrl.HOST_IMAGE + avatarUrl,
                    ivAvatar, GlideOptions.getInstance().getDefaultAvatarOption());
        }
    }
    @Override
    protected void initViews() {

    }

    @Override
    protected void parseData() {

    }


    @OnClick({R.id.ll_repair_plan, R.id.ll_mine_pwd, R.id.ll_mine_setting})
    public void onViewClicked(View view) {
        if (OperateUtil.isFastClick()) return;
        switch (view.getId()) {

            // 我的维修计划
            case R.id.ll_repair_plan:
//                Bundle signInBundle = new Bundle();
//                signInBundle.putBoolean(SignInRecordActivity.IS_MINE, true);
//                ActivityUtils.startActivity(signInBundle, SignInRecordActivity.class);
                break;

            // 修改密码
            case R.id.ll_mine_pwd:
//                ActivityUtils.startActivity(ChangePwdActivity.class);
                break;
            // 系统设置
            case R.id.ll_mine_setting:
                // ActivityUtils.startActivity(SettingActivity.class);
                break;
        }
    }
}
