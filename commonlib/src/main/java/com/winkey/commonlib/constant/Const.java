package com.winkey.commonlib.constant;


/**
 * @author winkey
 * @date 2020/1/9
 * @describe 常量
 */
public class Const {



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

    // 页记录数
    public static final int PAGE_SIZE = 10;

    //
    public final static String TOKEN = "token";
    // 网络线路下标
    public final static String NET_ROUTE_INDEX = "net_route_index";
    public final static String NET_ROUTE_CUSTOM_ALL = "net_route_custom_all";
    public final static String[] NET_PING = {ConstUrl.PING_DOMAIN, ConstUrl.PING_DOMAIN};
    public final static String[] NET_ROUTES_DEV = {"测试服务  ", "正式服务  "};
    public final static String[] NET_PING_DEV = {ConstUrl.PING_DEV, ConstUrl.PING_DOMAIN};
}
