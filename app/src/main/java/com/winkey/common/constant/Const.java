package com.winkey.common.constant;


import com.winkey.common.net.ConstUrl;

/**
 * 相关常量
 *
 * @author xiongz
 * @date 2018/9/5
 */
public class Const {



    // 是否同意隐私政策
    public static final String SP_PRIVACY_TAG = "privacy";
    // 友盟deviceToken
    public final static String UMENG_DEVICE_TOKEN = "device_token";



    // 定位类型对照
    public static final String LOCATION_TYPE_JSON = "{" +
            "\"0\":\"定位失败\", " +
            "\"1\":\"GPS定位\", " +
            "\"2\":\"前次定位\", " +
            "\"4\":\"缓存定位\", " +
            "\"5\":\"Wifi定位\", " +
            "\"6\":\"基站定位\", " +
            "\"8\":\"离线定位\", " + "}";



    // 页记录数
    public static final int PAGE_SIZE = 10;




    public static class RoleCode {
        public static final String WBRY = "WBRY";        // 维保人员
        public static final String WBJL = "WBJL";        // 维保经理
        public static final String WYJL = "WYJL";        // 物业经理
        public static final String WYGLY = "WYGLY";        // 物业管理员
        public static final String WYEGLY = "WYEGLY";        // 物业电梯管理员
        public static final String YECWRY = "YECWRY";        // 物业财务人员
    }

    // 权限
    public static class Permission {
        public static final String PROJECT_EDIT = "project:edit";        // 修改项目
        public static final String PROJECT_ADD = "project:add";        // 新增项目
        public static final String PROJECT_SUB_ADD = "project:sub:add";        // 新增子项目
        public static final String PROJECT_SUB_EDIT = "project:sub:edit";        // 修改子项目
        public static final String PROJECT_SUB_SUBMIT = "project:sub:submit";        // 提交子项目

        public static final String WORK_ORDER_ENTRY = "workOrder:entry";        // 维保公司录入
        public static final String WORK_ORDER_REJECTED = "workOrder:rejected";        // 待办主工单驳回
        public static final String WORK_ORDER_CONSENT = "workOrder:consent";        // 待办主工单同意
        public static final String WORK_ORDER_SUBMIT = "workOrder:submit";        // 待办主工单重新提交
        public static final String WORK_ORDER_REJECTED_CAUSE = "workOrder:rejectedCause";        // 驳回原因
        public static final String WORK_ORDER_GATHER = "workOrder:gather";        // 待办主工单采集分配
        public static final String WORK_ORDER_ASSESS = "workOrder:assess";        // 待办主工单评估分配

        public static final String BASE_ADD = "elevator:add";        // 新增电梯
        public static final String BASE_EDIT = "elevator:edit";        // 修改电梯
        public static final String BASE_COMMIT = "elevator:commit";        // 采集提交
        public static final String BASE_GATHER = "elevator:gather";        // 采集
        public static final String BASE_COMFIR_DATE = "elevator:comfirDate";        // 确认时间


        public static final String ASSESS_REJECT = "assess:reject";        // 驳回评估
        public static final String ASSESS_COMFIRM = "assess:comfirm";        // 同意评估

        public static final String ARCHIVES_EDITOR = "archives:editor";        // 一梯一档采集
        public static final String ARCHIVES_SUBMIT = "archives:submit";        // 一梯一档提交

        public static final String OVERHAUL_ADD = "overhaul:add";        // 大修新增
        public static final String OVERHAUL_AUDIT = "overhaul:audit";        // 大修审核通过
        public static final String OVERHAUL_REJECT = "overhaul:reject";        // 大修审核驳回
        public static final String OVERHAUL_AUDIT1 = "overhaul:audit1";        // 大修审批通过（物业）
        public static final String OVERHAUL_REJECT1 = "overhaul:reject1";        // 大修审批驳回（物业）
        public static final String OVERHAUL_CONFIRM_DATE = "overhaul:confirmDate";        // 大修确定时间
        public static final String OVERHAUL_PASS_DATE = "overhaul:passDate";        // 大修通过时间
        public static final String OVERHAUL_REJECT_DATE = "overhaul:rejectDate";        // 大修拒绝时间
        public static final String OVERHAUL_CHECK_IN = "overhaul:checkIn";        // 大修签到
        public static final String OVERHAUL_PAUSE = "overhaul:pause";        // 大修发起暂停
        public static final String OVERHAUL_FINISH = "overhaul:finish";        // 大修发起完成
        public static final String OVERHAUL_PAUSE_CONFIRM = "overhaul:pauseConfirm";        // 大修确定暂停
        public static final String OVERHAUL_FINISH_CONFIRM = "overhaul:finishConfirm";        // 大修确定完成
        public static final String OVERHAUL_PAUSE_CONFIRM1 = "overhaul:finishConfirm1";        // 大修确定暂停（物业）
        public static final String OVERHAUL_FINISH_CONFIRM1 = "overhaul:finishConfirm1";        // 大修确定完成（物业）

        public static final String TRANSFORM_ADD = "transform:add";        // 改造新增
        public static final String TRANSFORM_AUDIT = "transform:audit";        // 改造审核通过
        public static final String TRANSFORM_REJECT = "transform:reject";        // 改造审核驳回
        public static final String TRANSFORM_AUDIT1 = "transform:audit1";        // 改造审批通过（物业）
        public static final String TRANSFORM_REJECT1 = "transform:reject1";        // 改造审批驳回（物业）
        public static final String TRANSFORM_CONFIRM_DATE = "transform:confirmDate";        // 改造确定时间
        public static final String TRANSFORM_PASS_DATE = "transform:passDate";        // 改造通过时间
        public static final String TRANSFORM_REJECT_DATE = "transform:rejectDate";        // 改造拒绝时间
        public static final String TRANSFORM_CHECK_IN = "transform:checkIn";        // 改造签到
        public static final String TRANSFORM_PAUSE = "transform:pause";        // 改造发起暂停
        public static final String TRANSFORM_FINISH = "transform:finish";        // 改造发起完成
        public static final String TRANSFORM_PAUSE_CONFIRM = "transform:pauseConfirm";        // 改造确定暂停
        public static final String TRANSFORM_FINISH_CONFIRM = "transform:finishConfirm";        // 改造确定完成
        public static final String TRANSFORM_PAUSE_CONFIRM1 = "transform:finishConfirm1";        // 改造确定暂停（物业）
        public static final String TRANSFORM_FINISH_CONFIRM1 = "transform:finishConfirm1";        // 改造确定完成（物业）
        public static final String TRANSFORM_UPLOAD_CEE = "transform:uploadCEE";        // 改造上传合格证

    }


    // 系统参数
    public static class SystemParam {
        public static final String CHARGINGMODE = "CHARGINGMODE";     // 原收费模式
        public static final String ELEVATORBRAND = "ELEVATORBRAND";     // 电梯品牌
        public static final String ELEVATORUSE = "ELEVATORUSE";     // 电梯用途
        public static final String MACHINEROOM = "MACHINEROOM";     // 机房
        public static final String CONTROLMODE = "CONTROLMODE";     // 控制方式
        public static final String ELEVATORSPEED = "ELEVATORSPEED";     // 速度
        public static final String LAYOUTMODE = "LAYOUTMODE";     // 布置方式
        public static final String HANG = "HANG";     // 悬挂方式
        public static final String DRIVINGMODE = "DRIVINGMODE";     // 曳引方式
        public static final String ELEVATORSTATUS = "ELEVATORSTATUS";     // 电梯状态
        public static final String ESCALATORINSTALLLOCATION = "ESCALATORINSTALLLOCATION";     // 手扶梯机房
        public static final String ESCALATORSPEED = "ESCALATORSPEED";     // 手扶梯速度
        public static final String LEVEL = "LEVEL";     // 手扶梯级别
        public static final String ESCALATORTYPE = "ESCALATORTYPE";     // 手扶梯类型
        public static final String USEENVIRONMENT = "USEENVIRONMENT";     // 手扶梯使用环境
        public static final String DIPANGLE = "DIPANGLE";     // 手扶梯倾角度
        public static final String STEPWIDTH = "STEPWIDTH";     // 手扶梯梯级宽度
        public static final String RUNMODE = "RUNMODE";     // 手扶梯运行方式
        public static final String LOADWEIGHT = "LOADWEIGHT";     // 载重量
        public static final String DEALWITHSTATUS = "DEALWITHSTATUS";     // 待办项目主工单状态
        public static final String PHENOMENON = "PHENOMENON";     // 现象
        public static final String RECONDITIONS = "RECONDITIONS";     // 检查
        public static final String CAUSES = "CAUSES";     // 原因
        public static final String HANDLE = "HANDLE";     // 处理
        public static final String FAULTDUTYS = "FAULTDUTYS";     // 责任
        public static final String ESCALATORPHENOMENON = "ESCALATORPHENOMENON";     // 现象
        public static final String ESCALATORRECONDITIONS = "ESCALATORRECONDITIONS";     // 检查
        public static final String ESCALATORCAUSES = "ESCALATORCAUSES";     // 原因
        public static final String ESCALATORHANDLE = "ESCALATORHANDLE";     // 处理
        public static final String ESCALATORFAULTDUTYS = "ESCALATORFAULTDUTYS";     // 责任
        public static final String ELEVATORSSTATUS = "ELEVATORSSTATUS";     // 电梯运行状态
        public static final String OVERHAULSTATE = "OVERHAULSTATE";     // 大修状态

        // 获取APP需要的所有系统参数
        public static final String[] SYSTEM_PARAMS = {CHARGINGMODE, ELEVATORBRAND, ELEVATORUSE,
                MACHINEROOM, CONTROLMODE, ELEVATORSPEED, LAYOUTMODE, HANG, DRIVINGMODE, ELEVATORSTATUS,
                ESCALATORINSTALLLOCATION, ESCALATORSPEED, LEVEL, ESCALATORTYPE, USEENVIRONMENT, DIPANGLE,
                STEPWIDTH, RUNMODE, LOADWEIGHT, DEALWITHSTATUS,PHENOMENON,RECONDITIONS,CAUSES,HANDLE,FAULTDUTYS,
                ESCALATORPHENOMENON,ESCALATORRECONDITIONS,ESCALATORCAUSES,ESCALATORHANDLE,ESCALATORFAULTDUTYS,
                ELEVATORSSTATUS,OVERHAULSTATE
        };
    }



    // 上传图片类型
    public static class UploadImgType {
        public static final String ALL = "onlinefilename";                     // 拜访图片
    }

    // 网络线路下标
    public final static String NET_ROUTE_INDEX = "net_route_index";
    // 自定义ip地址
    public final static String NET_ROUTE_CUSTOM_1 = "net_route_custom_1";
    public final static String NET_ROUTE_CUSTOM_2 = "net_route_custom_2";
    public final static String NET_ROUTE_CUSTOM_3 = "net_route_custom_3";
    public final static String NET_ROUTE_CUSTOM_4 = "net_route_custom_4";
    public final static String NET_ROUTE_CUSTOM_ALL = "net_route_custom_all";
    // 网络线路列表
    public final static String[] NET_ROUTES = {"正式服务1  ", "正式服务2  "};
    public final static String[] NET_PING = {ConstUrl.PING_DOMAIN, ConstUrl.PING_DOMAIN};
    public final static String[] NET_ROUTES_DEV = {"测试服务  ", "正式服务  ", "崔佳鹏服务器  "};
    public final static String[] NET_PING_DEV = {ConstUrl.PING_DEV, ConstUrl.PING_DOMAIN, ConstUrl.PING_JP};
}
