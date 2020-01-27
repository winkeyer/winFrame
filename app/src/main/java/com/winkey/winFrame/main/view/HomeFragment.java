package com.winkey.winFrame.main.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.joanzapata.iconify.widget.IconTextView;
import com.winkey.commonlib.constant.GlideOptions;
import com.winkey.commonlib.model.po.UserProfile;
import com.winkey.commonlib.router.UserService;
import com.winkey.commonlib.util.PermissionUtil;
import com.winkey.winFrame.R;
import com.winkey.winFrame.main.contract.MainContract;
import com.winkey.winFrame.main.model.vo.HomeMenuEntity;
import com.winkey.winFrame.main.model.vo.NewsBannerEntity;
import com.winkey.winFrame.main.presenter.HomePresenter;
import com.winkey.winFrame.main.view.adapter.BannerAdapter;
import com.winkey.winlib.fragments.BaseFragment;
import com.winkey.winlib.ui.image.GlideUtil;
import com.winkey.winlib.ui.refresh.RefreshHandler;
import com.winkey.winlib.util.timer.BaseTimerTask;
import com.winkey.winlib.util.timer.ITimerListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

/**
 * @author winkey
 * @date 2019/9/5
 * @describe 物业、维保端首页
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements SwipeRefreshLayout.OnRefreshListener , MainContract.View {


    @BindView(R.id.tv_mine_avatar)
    IconTextView tvMineAvatar;
    @BindView(R.id.iv_mine_avatar)
    CircleImageView ivMineAvatar;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_zone)
    TextView tvZone;
    @BindView(R.id.tv_weather)
    TextView tvWeather;
    @BindView(R.id.tv_scan)
    IconTextView tvScan;
    @BindView(R.id.banner)
    ViewPager banner;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;
    @BindView(R.id.view_rescue)
    LinearLayout viewRescue;
    @BindView(R.id.view_patrol)
    LinearLayout viewPatrol;
    @BindView(R.id.view_train)
    LinearLayout viewTrain;
    @BindView(R.id.view_overhaul)
    LinearLayout viewOverhaul;
    @BindView(R.id.view_transform)
    LinearLayout viewTransform;
    @BindView(R.id.iv_overhaul)
    ImageView ivOverhaul;
    @BindView(R.id.view_overhaul_badge)
    LinearLayout viewOverhaulBadge;
    @BindView(R.id.view_overhaul_data)
    LinearLayout viewOverhaulData;
    @BindView(R.id.iv_rescue)
    ImageView ivRescue;
    @BindView(R.id.view_rescue_badge)
    LinearLayout viewRescueBadge;
    @BindView(R.id.iv_patrol)
    ImageView ivPatrol;
    @BindView(R.id.view_patrol_badge)
    LinearLayout viewPatrolBadge;
    @BindView(R.id.iv_train)
    ImageView ivTrain;
    @BindView(R.id.view_train_badge)
    LinearLayout viewTrainBadge;
    @BindView(R.id.iv_plan)
    ImageView ivPlan;
    @BindView(R.id.view_plan_badge)
    LinearLayout viewPlanBadge;
    @BindView(R.id.view_plan)
    LinearLayout viewPlan;
    @BindView(R.id.iv_repair)
    ImageView ivRepair;
    @BindView(R.id.view_repair_badge)
    LinearLayout viewRepairBadge;
    @BindView(R.id.view_repair)
    LinearLayout viewRepair;
    @BindView(R.id.iv_repair_leave)
    ImageView ivRepairLeave;
    @BindView(R.id.view_repair_leave_badge)
    LinearLayout viewRepairLeaveBadge;
    @BindView(R.id.view_repair_leave)
    LinearLayout viewRepairLeave;
    @BindView(R.id.iv_malfunction)
    ImageView ivMalfunction;
    @BindView(R.id.view_malfunction_badge)
    LinearLayout viewMalfunctionBadge;
    @BindView(R.id.view_malfunction)
    LinearLayout viewMalfunction;
    @BindView(R.id.iv_malfunction_leave)
    ImageView ivMalfunctionLeave;
    @BindView(R.id.view_malfunction_leave_badge)
    LinearLayout viewMalfunctionLeaveBadge;
    @BindView(R.id.view_malfunction_leave)
    LinearLayout viewMalfunctionLeave;
    @BindView(R.id.iv_malfunction_data)
    ImageView ivMalfunctionData;
    @BindView(R.id.view_malfunction_data_badge)
    LinearLayout viewMalfunctionDataBadge;
    @BindView(R.id.view_malfunction_data)
    LinearLayout viewMalfunctionData;
    @BindView(R.id.iv_overhaul_data)
    ImageView ivOverhaulData;
    @BindView(R.id.view_overhaul_data_badge)
    LinearLayout viewOverhaulDataBadge;
    @BindView(R.id.iv_transform)
    ImageView ivTransform;
    @BindView(R.id.view_transform_badge)
    LinearLayout viewTransformBadge;
    @BindView(R.id.iv_transform_data)
    ImageView ivTransformData;
    @BindView(R.id.view_transform_data_badge)
    LinearLayout viewTransformDataBadge;
    @BindView(R.id.iv_report1)
    ImageView ivReport1;
    @BindView(R.id.view_report1_badge)
    LinearLayout viewReport1Badge;
    @BindView(R.id.view_report1)
    LinearLayout viewReport1;
    @BindView(R.id.iv_report2)
    ImageView ivReport2;
    @BindView(R.id.view_report2_badge)
    LinearLayout viewReport2Badge;
    @BindView(R.id.view_report2)
    LinearLayout viewReport2;
    @BindView(R.id.iv_report3)
    ImageView ivReport3;
    @BindView(R.id.view_report3_badge)
    LinearLayout viewReport3Badge;
    @BindView(R.id.view_report3)
    LinearLayout viewReport3;
    @BindView(R.id.iv_report4)
    ImageView ivReport4;
    @BindView(R.id.view_report4_badge)
    LinearLayout viewReport4Badge;
    @BindView(R.id.view_report4)
    LinearLayout viewReport4;


    @Autowired
    UserService userService;

    // 刷新
    private RefreshHandler mRefreshHandler;



    // 图片适配器
    private BannerAdapter mBannerAdapter;
    // 卡片tab
    private int mCardTab;
    // 计时器
    private Timer mTimer;
    // 通栏新闻列表
    private List<NewsBannerEntity> mBannerNews = new ArrayList<>();
    private Badge repairBadge;
    private Badge repairLeaveBadge;
    private Badge malfunctionBadge;
    private Badge malfunctionLeaveBadge;
    private Badge overhaulBadge;
    private Badge transformBradge;



    @Override
    public Object setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

        SimpleDateFormat format = new SimpleDateFormat("MM月dd日 EEEE");
        tvDate.setText(format.format(new Date()));

        mRefreshHandler = new RefreshHandler(swipe, this, R.color.colorPrimary);
        // mHomeModel = new HomeModel(getContext(), this);

        UserProfile userProfile = userService.getUserInfo();
        if (userProfile != null) {
            String avatarUrl = userProfile.getHeadImgUrl();
            GlideUtil.withOption(getProxyActivity(), avatarUrl,
                    ivMineAvatar, GlideOptions.getInstance().getDefaultAvatarOption());
        }
        repairBadge = new QBadgeView(getProxyActivity()).bindTarget(viewRepairBadge);
        repairLeaveBadge = new QBadgeView(getProxyActivity()).bindTarget(viewRepairLeaveBadge);
        malfunctionBadge = new QBadgeView(getProxyActivity()).bindTarget(viewMalfunctionBadge);
        malfunctionLeaveBadge = new QBadgeView(getProxyActivity()).bindTarget(viewMalfunctionLeaveBadge);
        overhaulBadge = new QBadgeView(getProxyActivity()).bindTarget(viewOverhaulBadge);
        transformBradge = new QBadgeView(getProxyActivity()).bindTarget(viewTransformBadge);
    }

    @Override
    protected void initViews() {
        mPresenter = new HomePresenter(getProxyActivity());
        mPresenter.register(this);
    }

    @Override
    protected void parseData() {
        mPresenter.requestBanner();
        mPresenter.requestMenu();
    }

    @Override
    public void onResume() {
        super.onResume();
        mRefreshHandler.startRefresh();
    }

    @Override
    public void onRefresh() {
        mPresenter.requestMenu();
    }


    @Override
    public void onNotifyBanner(List<NewsBannerEntity> datas) {
        mBannerNews.clear();
        mBannerNews.addAll(datas);
        mBannerNews.add(new NewsBannerEntity());
        mBannerNews.add(new NewsBannerEntity());
        mBannerNews.add(new NewsBannerEntity());
        mBannerAdapter = new BannerAdapter(getProxyActivity(), mBannerNews);
        banner.setAdapter(mBannerAdapter);
        banner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                resetTimer(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        startTimer();
    }

    @Override
    public void onNotifyMenu(List<HomeMenuEntity> datas) {
        try {
            mRefreshHandler.stopRefresh(0);
            for (HomeMenuEntity entity : datas) {
                switch (entity.getItemId()) {
                    case 464:
                        break;
                    case 465:
                        break;
                    case 44:
                        break;
                    case 45:
                        repairBadge.setBadgeNumber(entity.getNum());
                        break;
                    case 711:
                        repairLeaveBadge.setBadgeNumber(entity.getNum());
                        break;
                    case 462:
                        malfunctionBadge.setBadgeNumber(entity.getNum());
                        break;
                    case 713:
                        malfunctionLeaveBadge.setBadgeNumber(entity.getNum());
                        break;
                    case 714:
                        break;
                    case 463:
                        overhaulBadge.setBadgeNumber(entity.getNum());
                        break;
                    case 715:
                        break;
                    case 492:
                        transformBradge.setBadgeNumber(entity.getNum());
                        break;
                    case 716:
                        break;
                }
            }
            ivRescue.setImageResource(PermissionUtil.hasMenu(464) ? R.mipmap.ic_urgent_task : R.mipmap.ic_urgent_task_error);
            ivPatrol.setImageResource(PermissionUtil.hasMenu(465) ? R.mipmap.ic_patrol : R.mipmap.ic_patrol_error);
            ivTrain.setImageResource(PermissionUtil.hasMenu(461) ? R.mipmap.ic_train : R.mipmap.ic_train_error);
            ivPlan.setImageResource(PermissionUtil.hasMenu(44) ? R.mipmap.ic_plan : R.mipmap.ic_plan_error);
            ivRepair.setImageResource(PermissionUtil.hasMenu(45) ? R.mipmap.ic_repair : R.mipmap.ic_repair_error);
            ivRepairLeave.setImageResource(PermissionUtil.hasMenu(711) ? R.mipmap.ic_repair_leave : R.mipmap.ic_repair_leave_error);
            ivMalfunction.setImageResource(PermissionUtil.hasMenu(462) ? R.mipmap.ic_malfunction : R.mipmap.ic_malfunction_error);
            ivMalfunctionLeave.setImageResource(PermissionUtil.hasMenu(713) ? R.mipmap.ic_malfunction_leave : R.mipmap.ic_malfunction_leave_error);
            ivMalfunctionData.setImageResource(PermissionUtil.hasMenu(714) ? R.mipmap.ic_malfunction_data : R.mipmap.ic_malfunction_data_error);
            ivOverhaul.setImageResource(PermissionUtil.hasMenu(463) ? R.mipmap.ic_overhaul : R.mipmap.ic_overhaul_error);
            ivOverhaulData.setImageResource(PermissionUtil.hasMenu(715) ? R.mipmap.ic_overhaul_data : R.mipmap.ic_overhaul_data_error);
            ivTransform.setImageResource(PermissionUtil.hasMenu(492) ? R.mipmap.ic_transform : R.mipmap.ic_transform_error);
            ivTransformData.setImageResource(PermissionUtil.hasMenu(716) ? R.mipmap.ic_transform_data : R.mipmap.ic_transform_data_error);
            // 尚未配置权限
            ivReport1.setImageResource(PermissionUtil.hasMenu(11111) ? R.mipmap.ic_report1 : R.mipmap.ic_report1_error);
            ivReport2.setImageResource(PermissionUtil.hasMenu(11111) ? R.mipmap.ic_report2 : R.mipmap.ic_report2_error);
            ivReport3.setImageResource(PermissionUtil.hasMenu(11111) ? R.mipmap.ic_report3 : R.mipmap.ic_report3_error);
            ivReport4.setImageResource(PermissionUtil.hasMenu(11111) ? R.mipmap.ic_report4 : R.mipmap.ic_report4_error);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    /**
     * 开始计时自动滑动卡片
     */
    private void startTimer() {
        mTimer = new Timer();
        BaseTimerTask task = new BaseTimerTask(new ITimerListener() {
            @Override
            public void onTimer() {
                getProxyActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (mCardTab == mBannerNews.size() - 1) {
                                banner.setCurrentItem(0);
                            } else {
                                banner.setCurrentItem(++mCardTab);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        mTimer.schedule(task, 5000);
    }

    /**
     * 重置计时器
     */
    private void resetTimer(int position) {
        try {
            mCardTab = position;
            mTimer.cancel();
            mTimer = null;
            startTimer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void showDialog() {
        final Dialog dialog = new Dialog(getProxyActivity(), R.style.input_dialog);
        dialog.setContentView(R.layout.dialog_no_permission);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        ImageView mColseTips = dialog.findViewById(R.id.view_closetips);
        mColseTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        LinearLayout mLinColse = dialog.findViewById(R.id.view_lin_close);
        mLinColse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @OnClick({R.id.tv_scan, R.id.view_rescue, R.id.view_patrol, R.id.view_train, R.id.view_plan, R.id.view_repair, R.id.view_repair_leave,
            R.id.view_malfunction, R.id.view_malfunction_leave, R.id.view_malfunction_data, R.id.view_overhaul, R.id.view_overhaul_data,
            R.id.view_transform, R.id.view_transform_data})
    public void onViewClicked(View view) {
        mRefreshHandler.stopRefresh();
        /*switch (view.getId()) {
            case R.id.tv_scan:
                ActivityUtils.startActivity(TrainScanActivity.class);
                break;
            case R.id.view_rescue:
                if (!PermissionUtil.hasMenu(464)) {
                    showDialog();
                }
                break;
            case R.id.view_patrol:
                if (!PermissionUtil.hasMenu(465)) {
                    showDialog();
                }
                break;
            case R.id.view_train:
                if (!PermissionUtil.hasMenu(461)) {
                    showDialog();
                }
                break;
            case R.id.view_plan:
                UserProfile userProfile = ProfileManager.getCurUserProfile();
                String roleCode = userProfile.getRoleCode();
                if (!PermissionUtil.hasMenu(44)) {
                    showDialog();
                } else if (roleCode.equals(Const.RoleCode.WBRY) || roleCode.equals(Const.RoleCode.WBGLRY)) {
                    ActivityUtils.startActivity(PlanManageActivity.class);
                } else if (roleCode.equals(Const.RoleCode.WBJL)) {
                    ActivityUtils.startActivity(PlanGroupActivity.class);
                } else {
                    ActivityUtils.startActivity(PlanWYManageActivity.class);
                }
                break;
            case R.id.view_repair:
                if (!PermissionUtil.hasMenu(45)) {
                    showDialog();
                } else {
                    ActivityUtils.startActivity(OrderManageActivity.class);
                }

                break;
            case R.id.view_repair_leave:
                if (!PermissionUtil.hasMenu(711)) {
                    showDialog();
                } else {
                    ActivityUtils.startActivity(RepairOrderLeaveActivity.class);
                }
                break;
            case R.id.view_malfunction:
                if (!PermissionUtil.hasMenu(462)) {
                    showDialog();
                } else {
                    ActivityUtils.startActivity(MalfunctionManageActivity.class);
                }
                break;
            case R.id.view_malfunction_leave:
                if (!PermissionUtil.hasMenu(713)) {
                    showDialog();
                } else {
                    ActivityUtils.startActivity(MalfunctionLeaveActivity.class);
                }
                break;
            case R.id.view_malfunction_data:
                if (!PermissionUtil.hasMenu(714)) {
                    showDialog();
                }
                break;
            case R.id.view_overhaul:
                if (!PermissionUtil.hasMenu(463)) {
                    showDialog();
                } else {
                    ActivityUtils.startActivity(OverhaulManageActivity.class);
                }
                break;
            case R.id.view_overhaul_data:
                if (!PermissionUtil.hasMenu(715)) {
                    showDialog();
                } else {
                    ActivityUtils.startActivity(OverhaulDataActivity.class);
                }
                break;
            case R.id.view_transform:
                if (!PermissionUtil.hasMenu(492)) {
                    showDialog();
                } else {
                    ActivityUtils.startActivity(TransformManageActivity.class);
                }
                break;
            case R.id.view_transform_data:
                if (!PermissionUtil.hasMenu(716)) {
                    showDialog();
                } else {
                    ActivityUtils.startActivity(TransformDataActivity.class);
                }
                break;
        }*/
    }

}