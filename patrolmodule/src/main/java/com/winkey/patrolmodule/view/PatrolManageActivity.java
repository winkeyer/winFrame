package com.winkey.patrolmodule.view;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.winkey.commonlib.constant.Router;
import com.winkey.commonlib.model.po.SysParamProfile;
import com.winkey.commonlib.model.vo.PagesEntity;
import com.winkey.commonlib.net.NetParams;
import com.winkey.commonlib.view.DropDownMenu.DropDownMenu;
import com.winkey.commonlib.view.DropDownMenu.ListDropDownAdapter;
import com.winkey.patrolmodule.R;
import com.winkey.patrolmodule.R2;
import com.winkey.patrolmodule.contract.PatrolContract;
import com.winkey.patrolmodule.model.vo.PatrolEntity;
import com.winkey.patrolmodule.presenter.PatrolPresenter;
import com.winkey.patrolmodule.view.adapter.PatrolAdapter;
import com.winkey.winlib.activity.BaseActivity;
import com.winkey.winlib.rx.Xz;
import com.winkey.winlib.ui.recycler.WrapContentLinearLayoutManager;
import com.winkey.winlib.ui.refresh.RefreshHandler;
import com.winkey.winlib.ui.view.ClearEditText;
import com.winkey.winlib.util.FastjsonUtil;
import com.winkey.winlib.util.OperateUtil;
import com.winkey.winlib.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

@Route(path = Router.PATROL_ACTIVITY)
public class PatrolManageActivity extends BaseActivity<PatrolPresenter> implements  SwipeRefreshLayout.OnRefreshListener , PatrolContract.View  {

    private final static String DROP_DOWN_MENU_HEADS[] = {"状态", "项目名称", "巡检员", "维保人员", "维保公司"};


    RecyclerView rvInspectionManageList;
    SwipeRefreshLayout swipeInspectionManageList;
    @BindView(R2.id.dropDownMenu_select_inspection)
    DropDownMenu dropMenu;

    // 适配器
    private PatrolAdapter mAdapter;
    // 数据列表
    private List<PatrolEntity> mPatrolEntities = new ArrayList<>();
    private RefreshHandler mRefreshHandler;



    // popupView列表
    private List<View> mPopupViews = new ArrayList<>();

    // 状态列表
    private List<SysParamProfile> mProcessStates = new ArrayList<>();
    // 状态列表适配器
    private ListDropDownAdapter mStateAdapter;
    // 被选中的状态
    private String mChooseProcessState;

    private String mSearchProject;
    private String mSearchPatrolPerson;
    private String mSearchMaintenancePerson;
    private String mSearchMaintenanceCompany;

    // 当前页数
    private int mPage = 1;

    // 总记录数
    private int mTotal;

    @Override
    protected Object getContentView() {
        return R.layout.patrol_activity_manage;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        // mIsFullScreen = true;
        super.onCreate(savedInstanceState);
        setTitle(this, "巡检管理");
    }
    @Override
    protected void initViews() {
        setTitle(this, "巡检管理");
        initDropDownMenu();
        mPresenter =new PatrolPresenter(this);
        mPresenter.register(this);
    }

    /**
     * 初始化查询条件
     */
    private void initDropDownMenu() {
        mProcessStates.clear();
        // 默认构建第一个为全部
        SysParamProfile sysParamProfile = new SysParamProfile();
        sysParamProfile.setDictValue("全部");
        sysParamProfile.setDictId("-1");
        mProcessStates.add(sysParamProfile);
        //获取assets目录下的json文件数据
        String json = StringUtil.getJsonFromAsset(Xz.getApplicationContext(), "patrol.json");
        List<SysParamProfile> statusList = FastjsonUtil.parseArray(json, SysParamProfile.class);
        mProcessStates.addAll(statusList);
        // 状态筛选页
        ListView levelView = new ListView(this);
        levelView.setDividerHeight(0);
        mStateAdapter = new ListDropDownAdapter(this, mProcessStates);
        levelView.setAdapter(mStateAdapter);
        levelView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mStateAdapter.setCheckItem(position);
                SysParamProfile entity = mProcessStates.get(position);
                if (position == 0) {
                    mChooseProcessState = "";
                } else {
                    mChooseProcessState = entity.getDictId();
                }
                dropMenu.setTabText(position == 0 ? DROP_DOWN_MENU_HEADS[0] : entity.getDictValue());
                dropMenu.closeMenu();
                onRefresh();
            }
        });
        // 搜索条件页
        View projectView = LayoutInflater.from(this).inflate(R.layout.drop_down_search, null);
        final ClearEditText etProjectSearch = projectView.findViewById(R.id.et_search_name);
        Button btnProjectSearch = projectView.findViewById(R.id.btn_search);
        btnProjectSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchProject = etProjectSearch.getText().toString().trim();
                dropMenu.setTabText(TextUtils.isEmpty(mSearchProject) ? DROP_DOWN_MENU_HEADS[1] : mSearchProject);
                dropMenu.closeMenu();
                onRefresh();
            }
        });
        // 搜索条件页
        View patrolPersonView = LayoutInflater.from(this).inflate(R.layout.drop_down_search, null);
        final ClearEditText etPatrolPersonSearch = patrolPersonView.findViewById(R.id.et_search_name);
        Button btnPatrolPersonSearch = patrolPersonView.findViewById(R.id.btn_search);
        btnPatrolPersonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchPatrolPerson = etPatrolPersonSearch.getText().toString().trim();
                dropMenu.setTabText(TextUtils.isEmpty(mSearchPatrolPerson) ? DROP_DOWN_MENU_HEADS[2] : mSearchPatrolPerson);
                dropMenu.closeMenu();
                onRefresh();
            }
        });
        View maintenancePersonView = LayoutInflater.from(this).inflate(R.layout.drop_down_search, null);
        final ClearEditText etMaintenancePersonSearch = maintenancePersonView.findViewById(R.id.et_search_name);
        Button btnMaintenancePersonSearch = maintenancePersonView.findViewById(R.id.btn_search);
        btnMaintenancePersonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchMaintenancePerson = etMaintenancePersonSearch.getText().toString().trim();
                dropMenu.setTabText(TextUtils.isEmpty(mSearchMaintenancePerson) ? DROP_DOWN_MENU_HEADS[3] : mSearchMaintenancePerson);
                dropMenu.closeMenu();
                onRefresh();
            }
        });
        View maintenanceCompanyView = LayoutInflater.from(this).inflate(R.layout.drop_down_search, null);
        final ClearEditText etMaintenanceCompanySearch = maintenanceCompanyView.findViewById(R.id.et_search_name);
        Button btnMaintenanceCompanySearch = maintenanceCompanyView.findViewById(R.id.btn_search);
        btnMaintenanceCompanySearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchMaintenanceCompany = etMaintenanceCompanySearch.getText().toString().trim();
                dropMenu.setTabText(TextUtils.isEmpty(mSearchMaintenanceCompany) ? DROP_DOWN_MENU_HEADS[4] : mSearchMaintenanceCompany);
                dropMenu.closeMenu();
                onRefresh();
            }
        });
        mPopupViews.clear();
        mPopupViews.add(levelView);
        mPopupViews.add(projectView);
        mPopupViews.add(patrolPersonView);
        mPopupViews.add(maintenancePersonView);
        mPopupViews.add(maintenanceCompanyView);

        // 主页面
        View contentView = LayoutInflater.from(this).inflate(R.layout.popup_drop_down_content, null);
        contentView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        swipeInspectionManageList = contentView.findViewById(R.id.swipe_work_order_manage_list);
        mRefreshHandler = new RefreshHandler(swipeInspectionManageList, this, R.color.colorPrimary);
        rvInspectionManageList = contentView.findViewById(R.id.rv_work_order_manage_list);
        dropMenu.setDropDownMenu(Arrays.asList(DROP_DOWN_MENU_HEADS), mPopupViews, contentView);
        initRecyclerView();
    }

    private void initRecyclerView() {
        rvInspectionManageList.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        final WrapContentLinearLayoutManager manager = new WrapContentLinearLayoutManager(this);
        rvInspectionManageList.setLayoutManager(manager);
        View emptyView = LayoutInflater.from(this).inflate(R.layout.view_empty_data, null);
        mAdapter = new PatrolAdapter(this, R.layout.patrol_recycler_item, mPatrolEntities);
        mAdapter.setEmptyView(emptyView);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        mAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                mPage++;
                // requestPatrolData();
            }
        });

        rvInspectionManageList.setAdapter(mAdapter);
    }

    @Override
    protected void parseData() {

        HashMap<String, Object> params = NetParams.getPageHashMap(mPage);
        if (!TextUtils.isEmpty(mSearchProject))
            params.put("queryObj[projectName]", mSearchProject);
        if (!TextUtils.isEmpty(mChooseProcessState)) {
            params.put("queryObj[status]", mChooseProcessState);
        }
        if (!TextUtils.isEmpty(mSearchPatrolPerson))
            params.put("queryObj[patrolPerson]", mSearchPatrolPerson);
        if (!TextUtils.isEmpty(mSearchMaintenancePerson))
            params.put("queryObj[maintenanceName]", mSearchMaintenancePerson);
        if (!TextUtils.isEmpty(mSearchMaintenanceCompany))
            params.put("queryObj[maintenanceCompanyName]", mSearchMaintenanceCompany);

        mPresenter.requestPatrol(params);
    }


    @Override
    public void onRefresh() {
        mPage = 1;
        parseData();
    }

    @Override
    public void onNotifyPatrol(int total,List<PatrolEntity> datas) {
        mRefreshHandler.stopRefresh();
        mTotal = total;
        if (mPage == 1) mAdapter.getData().clear();
        int size = mAdapter.getData().size() + datas.size();
        if (size >= mTotal) {
            mAdapter.addData(datas);
            mAdapter.getLoadMoreModule().loadMoreEnd();
            mAdapter.notifyDataSetChanged();
        } else {
            mAdapter.addData(datas);
            mAdapter.getLoadMoreModule().loadMoreComplete();
        }
    }
}
