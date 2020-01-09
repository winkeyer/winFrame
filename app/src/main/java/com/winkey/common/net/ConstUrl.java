package com.winkey.common.net;


import com.winkey.winFrame.BuildConfig;

/**
 * 请求url
 * Created by xiongz on 2017/12/14.
 */
public class ConstUrl {


    // ping地址
    public static String PING_DEV = "106.12.46.79";        // 开发环境
    public static String PING_DOMAIN = "139.224.133.163";        // 正式环境
    public static String PING_JP = "192.168.1.104";        // 正式环境
    private static String HOST = ":8889";


    /*******  baseUrl *******/
    // 图片前缀
    public static String HOST_IMAGE_DEV = "http://106.12.46.79:8889/statics/";
    public static String HOST_IMAGE_DOMAIN = "http://139.224.133.163:8889/statics/";
    public static String HOST_IMAGE = BuildConfig.isDebug ? HOST_IMAGE_DEV : HOST_IMAGE_DOMAIN;

    // 登录
    public static final String APP_LOGIN = HOST + "/login";
    // 用户信息
    public static final String USER_INFO = HOST + "/users/current";
    // 更新绑定设备
    public static final String USER_DEVICE_UPDATE = HOST + "/userDevice/update";
    // 系统参数
    public static final String DICTIONARY = HOST + "/dicts/commDict";
    public static final String DICTIONARY_ALL = HOST + "/dicts/all";
    // 电梯列表
    public static final String LIFT_LIST = HOST + "/lift/list";
    // 项目列表
    public static final String PROJECT_LIST = HOST + "/projuectsInfo/list";
    // 项目详情
    public static final String PROJECT_DETAIL = HOST + "/projuectsInfo/queryProjectId";
    // 新增项目
    public static final String PROJECT_ADD = HOST + "/projuectsInfo/addProjuectsInfo";
    // 修改项目
    public static final String PROJECT_EDIT = HOST + "/projuectsInfo/editProjuectsInfo";
    // 子项目列表
    public static final String SUB_PROJECT_LIST = HOST + "/subProjuectsInfo/list";
    // 项目子详情
    public static final String SUB_PROJECT_DETAIL = HOST + "/subProjuectsInfo/querySubProjectId";
    // 新增子项目
    public static final String SUB_PROJECT_ADD = HOST + "/subProjuectsInfo/addSubProjuectsInfo";
    // 修改子项目
    public static final String SUB_PROJECT_EDIT = HOST + "/subProjuectsInfo/editSubProjuectsInfo";
    // 驳回后修改子项目
    public static final String SUB_PROJECT_EDIT_REJECT = HOST + "/subProjuectsInfo/editAllSubProjuectsInfo";
    // 维保公司列表
    public static final String MAINTENANCE_LIST = HOST + "/workOrderInformation/selectMaintenanceList";
    // 提交项目子详情
    public static final String SUB_PROJECT_SUBMIT = HOST + "/subProjuectsInfo/submitProject";
    // 升降梯详情
    public static final String LIFT_ELEVATOR_DETAIL = HOST + "/lift/elevator/info";
    // 品牌列表
    public static final String LIFT_BRAND = HOST + "/dicts/brand";
    // 升降梯新增
    public static final String LIFT_ELEVATOR_ADD = HOST + "/lift/elevator/add";
    // 升降梯修改
    public static final String LIFT_ELEVATOR_UPDATE = HOST + "/lift/elevator/update";
    // 手扶梯新增
    public static final String LIFT_ESCALATOR_ADD = HOST + "/lift/escalator/add";
    // 手扶梯修改
    public static final String LIFT_ESCALATOR_UPDATE = HOST + "/lift/escalator/update";
    // 手扶梯详情
    public static final String LIFT_ESCALATOR_DETAIL = HOST + "/lift/escalator/info";
    // 维保订单日期描点
    public static final String MAINTENANCE_DATE_LIST = HOST + "/maintenance/querAppyMaintenanceCountList";
    // 维保人员订单列表
    public static final String MAINTENANCE_ORDER_LIST = HOST + "/maintenance/maintenancePeopleOrder";
    // 物业人员查看订单列表
    public static final String MAINTENANCE_ORDER_MANAGE_LIST = HOST + "/maintenance/propertyPeopleOrder";
    // 维保小组列表
    public static final String MAINTENANCE_GROUP_LIST = HOST + "/maintenance/queryMaintenanceGroupList";
    // 维保小组订单
    public static final String MAINTENANCE_GROUP_ORDER_LIST = HOST + "/maintenance/queryMaintenanceOrder";
    // 维保人员列表
    public static final String MAINTENANCE_PERSON_LIST = HOST + "/maintenance/queryMaintenancePeople";
    // 能否进入维保
    public static final String MAINTENANCE_GOIN = HOST + "/MaintenanceCheck/ifGoIn ";
    // 更新委托单状态
    public static final String MAINTENANCE_IF_CONFIRM = HOST + "/maintenance/ifComfrim";
    // 委托维保单
    public static final String MAINTENANCE_CREATE_LEAVE_ORDER = HOST + "/maintenance/createLeaveOrder";
    // 维保单签到
    public static final String MAINTENANCE_SIGNIN_INFO = HOST + "/maintenance/getSignInAndInfo";
    // 维保单记录
    public static final String MAINTENANCE_ORDER_RECORD = HOST + "/MaintenanceCheck/getPositionListByElePara";
    // 扫码维保单维保项
    public static final String MAINTENANCE_ORDER_DETAIL = HOST + "/MaintenanceCheck/queryMainteanceDic";
    // 添加维保项信息
    public static final String MAINTENANCE_ADD_ORDER_DETAIL = HOST + "/MaintenanceCheck/add";
    // 查看维保项详情
    public static final String MAINTENANCE_RECORD_ORDER_DETAIL = HOST + "/MaintenanceCheck/queryManintenanceDetail";
    // 完成维保单
    public static final String MAINTENANCE_RECORD_ORDER_COMPLETE = HOST + "/MaintenanceCheck/updateMaintenanceCheckStatus";
    // 确定维保单
    public static final String MAINTENANCE_MANAGE_CONFIRM = HOST + "/maintenance/updatePlanOrder";
    // 委托单列表
    public static final String MAINTENANCE_LEAVE_ORDER_LIST = HOST + "/maintenance/queryLeaveOrder";
    // 委托单下订单列表
    public static final String MAINTENANCE_LEAVE_ORDER_RAPAIR_LIST = HOST + "/maintenance/queryLeaveMaintenanceOrder";
    // 更新委托单状态
    public static final String MAINTENANCE_UPDATE_LEAVE_ORDER = HOST + "/maintenance/updateLeaveOrder";
    // 委托单人某日工单列表
    public static final String MAINTENANCE_RECEIVER_REPAIR_ORDER = HOST + "/maintenance/maintenancePeopleOrder";
    // 待办项目列表
    public static final String WORK_ORDER_LIST = HOST + "/workOrderInformation/mainWorkOrderList";
    // 待办子工单列表
    public static final String SUB_WORK_ORDER_LIST = HOST + "/workOrderInformation/sonWorkOrderList";
    // 驳回待办
    public static final String REJECT_WORK_ORDER = HOST + "/workOrderInformation/rejected";
    // 录入维保公司
    public static final String ENTRY_WORK_ORDER = HOST + "/workOrderInformation/entry";
    // 驳回待办原因列表
    public static final String REJECT_WORK_ORDER_LIST = HOST + "/workOrderInformation/rejectedList";
    // 重新提交待办
    public static final String RESUBMIT_WORK_ORDER = HOST + "/workOrderInformation/submit";
    // 同意提交待办
    public static final String CONFIRM_WORK_ORDER = HOST + "/workOrderInformation/consent";
    // 采集人员列表
    public static final String COLLECT_USER_LIST = HOST + "/workOrderInformation/collectUserList";
    // 分配采集人员
    public static final String COLLECT_USER_WORK_ORDER = HOST + "/workOrderInformation/gatherSonWorkOrderInsert";
    // 结束采集
    public static final String COLLECT_END_WORK_ORDER = HOST + "/workOrderInformation/collectEnd";
    // 评估人员列表
    public static final String ALLOCATION_USER_LIST = HOST + "/workOrderInformation/allocationUserList";
    // 分配评估人员
    public static final String ALLOCATION_USER_WORK_ORDER = HOST + "/workOrderInformation/assessSonWorkOrderInsert";
    // 确定采集时间
    public static final String CONFIRM_DATE_WORK_ORDER = HOST + "/workOrderInformation/updateCollectTime";
    // 采集目标列表
    public static final String LIFT_TARGET_LIST = HOST + "/target/mobile/targetDataList";
    // 上传文件
    public static final String UPLOAD_PHOTO = HOST + "/upload/onlineupload";
    // 新增采集
    public static final String ADD_TARGET = HOST + "/target/mobile/addData";
    // 评估审核列表
    public static final String JUDGE_AUDIT_WORK_ORDER_LIST = HOST + "/workOrderAudit/auditList";
    // 评估单列表
    public static final String JUDGE_RESULT_LIST = HOST + "/assess/list";
    // 评估单结果详情
    public static final String JUDGE_RESULT_DETAIL = HOST + "/assess/mobile/info";
    // 审阅评估单
    public static final String CONFIRM_JUDGE_RESULT = HOST + "/assess/assessComfirm";
    // 同意评估
    public static final String AGREE_JUDGE_WORK_ORDER = HOST + "/workOrderAudit/auditAgreed";
    // 拒绝评估
    public static final String REFUSE_JUDGE_WORK_ORDER = HOST + "/workOrderAudit/auditRefused";
    // 一梯一档项目列表
    public static final String LIFT_DATA_PROJECT_LIST = HOST + "/ElevatorArchivesCollect/queryList";
    // 一梯一档子项目列表
    public static final String LIFT_DATA_SUB_PROJECT_LIST = HOST + "/ElevatorArchivesCollect/querySubList";
    // 一梯一档电梯列表
    public static final String LIFT_DATA_LIFT_LIST = HOST + "/ElevatorArchivesCollect/queryArchivesLiftList";
    // 电梯档案部件信息
    public static final String LIFT_PARTS_LIST = HOST + "/ElevatorArchivesCollect/queryAppAutoChooseTemplate";
    // 电梯档案部件信息 可查询
    public static final String LIFT_PARTS_SEARCH_LIST = HOST + "/ElevatorArchivesCollect/queryAppPartsList";
    // 电梯可选系统列表
    public static final String LIFT_SELECT_SYSTEM = HOST + "/TemplatePartsInformation/queryDevSystem";
    // 电梯可选部件
    public static final String LIFT_SELECT_PARTS = HOST + "/TemplatePartsInformation/queryDevPart";
    // 电梯采集标准
    public static final String LIFT_PARTS_STANDARD = HOST + "/ElevatorArchivesCollect/queryStandard";
    // 电梯可选单位
    public static final String LIFT_SELECT_UNIT = HOST + "/TemplatePartsInformation/queryComponentUnit";
    // 电梯可选采集
    public static final String LIFT_SELECT_TPI = HOST + "/TemplatePartsInformation/querySpecifitionTpiId";
    // 新增部件
    public static final String ADD_PARTS = HOST + "/ElevatorArchivesCollect/addParts";
    // 部件详情
    public static final String PARTS_DETAIL = HOST + "/ElevatorArchivesCollect/queryElevatorArchivesCollect";
    // 删除项目
    public static final String PROJECT_DELETE = HOST + "/ElevatorArchivesCollect/delParts";
    // 还原项目
    public static final String PROJECT_RESET = HOST + "/ElevatorArchivesCollect/restoreParts";
    // 修改部件
    public static final String EDIT_PARTS = HOST + "/ElevatorArchivesCollect/editorParts";
    // 替换部件
    public static final String REPLACE_PARTS = HOST + "/ElevatorArchivesCollect/appAddReplaceParts";
    // 录入部件
    public static final String CREATE_PARTS = HOST + "/workOrderElevator/submitElevatorTemp";
    // 提交一梯一档工单
    public static final String LIFT_WORK_ORDER_SUBMIT = HOST + "/workOrderElevator/insert";
    // 合同列表
    public static final String CONTRACT_LIST = HOST + "/agreement/getContractList";
    // 确认合同
    public static final String CONTRACT_CONFIRM = HOST + "/agreement/triConfirm";

    // 巡检列表
    public static final String PATROL_LIST = HOST + "/patrol/planList";
    // 巡检详情
    public static final String PATROL_DETAIL = HOST + "/patrol/getPlan";
    // 巡检电梯列表
    public static final String PATROL_LIFT_LIST = HOST + "/patrolTask/list";
    // 巡检项目模板
    public static final String PATROL_LIFT_DETAIL = HOST + "/patrolIndicant/template";
    // 维保小组接口
    public static final String PATROL_MAINTENANCE_GROUP_LIST = HOST + "/maintenance/maintenanceGroupList";
    // 采购列表
    public static final String PURCHASE_LIST = HOST + "/procurement/page";
    // 采购单详情
    public static final String PURCHASE_DETAIL = HOST + "/procurement/flowchart";
    // 采购单部件详情
    public static final String PURCHASE_DETAIL_PARTS = HOST + "/procurementPart/getInfo";
    // 故障选择项目
    public static final String MALFUNCTION_SELECT_PROJECT = HOST + "/malfunction/getProjectListByUserId";
    // 故障选择电梯
    public static final String MALFUNCTION_SELECT_LIFT = HOST + "/malfunction/getElevatorList";
    // 创建故障
    public static final String ADD_MALFUNCTION = HOST + "/malfunction/createMalfunctionOrder";
    // 故障列表
    public static final String MALFUNCTION_LIST = HOST + "/malfunction/malfunctionOrderList";
    // 故障详情
    public static final String MALFUNCTION_DETAIL = HOST + "/malfunction/getMalfunctionAllInfo";
    // 故障接单
    public static final String MALFUNCTION_ACCEPT = HOST + "/malfunction/getOrderConfirm";
    // 故障签到
    public static final String MALFUNCTION_SIGNIN_INFO = HOST + "/malfunction/makeLive";
    // 调整故障
    public static final String EDIT_MALFUNCTION = HOST + "/malfunction/addMalfunctionAllInfo";
    // 更新故障状态
    public static final String MALFUCTION_UPDATE = HOST + "/malfunction/updateOrder";
    // 暂停记录
    public static final String MALFUNCTION_PAUSE_LIST = HOST + "/malfunction/queryStopList";
    // 委托故障单
    public static final String MALFUNCTION_LEAVE_APPLY = HOST + "/malfunction/createLeaveOrder";
    // 委托单列表
    public static final String MALFUNCTION_LEAVE_LIST = HOST + "/malfunction/queryLeaveOrder";
    // 委托单下订单列表
    public static final String MALFUNCTION_LEAVE_DETAIL = HOST + "/malfunction/queryLeaveMaintenanceOrder";
    // 更新委托单状态
    public static final String MALFUNCTION_UPDATE_LEAVE = HOST + "/malfunction/updateLeaveOrder";
    // 能否进入维保
    public static final String MALFUNCTION_GOIN = HOST + "/malfunction/ifGoIn ";
    // 维保人员列表
    public static final String MALFUNCTION_PERSON_LIST = HOST + "/malfunction/queryMaintenancePeople";
    // 大修选择项目
    public static final String OVERHAUL_SELECT_PROJECT = HOST + "/overhaul/projectList";
    // 大修选择电梯
    public static final String OVERHAUL_SELECT_LIFT = HOST + "/overhaul/elevatorList";
    // 创建大修
    public static final String ADD_OVERHAUL = HOST + "/overhaul/addPlan";
    // 大修列表
    public static final String OVERHAUL_LIST = HOST + "/overhaul/planList";
    // 大修详情
    public static final String OVERHAUL_DETAIL = HOST + "/overhaul/overhaulInfo";
    // 维保人员列表
    public static final String OVERHAUL_PERSON_LIST = HOST + "/overhaul/queryMaintenancePeople";
    // 维保经理同意大修
    public static final String AGREE_OVERHAUL = HOST + "/overhaul/passPlanSP";
    // 驳回大修
    public static final String REFUSE_OVERHAUL = HOST + "/overhaul/rejectPlan";
    // 重新提交大修
    public static final String RESUBMIT_OVERHAUL = HOST + "/overhaul/reSubmit";
    // 维保经理协同提交大修
    public static final String SUBMIT_OVERHAUL = HOST + "/overhaul/updatePlan";
    // 通过大修
    public static final String PASS_OVERHAUL = HOST + "/overhaul/passPlan";
    // 关闭大修
    public static final String CLOSE_OVERHAUL = HOST + "/overhaul/close";
    // 提交时间
    public static final String CHECK_TIME_OVERHAUL = HOST + "/overhaul/confirmDate";
    // 通过时间
    public static final String AGREE_DATE_OVERHAUL = HOST + "/overhaul/passDate";
    // 驳回时间
    public static final String REFUSE_TIME_OVERHAUL = HOST + "/overhaul/rejectDate";
    // 大修签到
    public static final String OVERHAUL_SIGNIN = HOST + "/overhaul/getSignInAndInfo";
    // 大修签到记录
    public static final String OVERHAUL_SIGNIN_INFO = HOST + "/overhaul/signInfo";
    // 确定完成部件
    public static final String OVERHAUL_CONFIRM_PART = HOST + "/overhaul/confirmPart";
    // 暂停
    public static final String PAUSE_OVERHAUL = HOST + "/overhaul/pause";
    // 拒绝记录
    public static final String OVERHAUL_REJECT_LIST = HOST + "/overhaul/rejectList ";
    // 确定暂停
    public static final String CONFIRM_PAUSE_OVERHAUL = HOST + "/overhaul/pauseConfirm";
    // 完成
    public static final String FINISH_OVERHAUL = HOST + "/overhaul/finish";
    // 确定完成
    public static final String CONFIRM_FINISH_OVERHAUL = HOST + "/overhaul/finishConfirm";
    // 改造选择项目
    public static final String TRANSFORM_SELECT_PROJECT = HOST + "/transform/projectList";
    // 改造选择电梯
    public static final String TRANSFORM_SELECT_LIFT = HOST + "/transform/elevatorList";
    // 创建改造
    public static final String ADD_TRANSFORM = HOST + "/transform/addPlan";
    // 改造列表
    public static final String TRANSFORM_LIST = HOST + "/transform/planList";
    // 改造详情
    public static final String TRANSFORM_DETAIL = HOST + "/transform/overhaulInfo";
    // 维保人员列表
    public static final String TRANSFORM_PERSON_LIST = HOST + "/transform/queryMaintenancePeople";
    // 维保经理同意大修
    public static final String AGREE_TRANSFORM = HOST + "/transform/passPlanSP";
    // 驳回改造
    public static final String REFUSE_TRANSFORM = HOST + "/transform/rejectPlan";
    // 重新提交改造
    public static final String RESUBMIT_TRANSFORM = HOST + "/transform/reSubmit";
    // 同意改造
    public static final String SUBMIT_TRANSFORM = HOST + "/transform/updatePlan";
    // 通过改造
    public static final String PASS_TRANSFORM = HOST + "/transform/passPlan";
    // 关闭改造
    public static final String CLOSE_TRANSFORM = HOST + "/transform/close";
    // 提交改造时间
    public static final String CHECK_TIME_TRANSFORM = HOST + "/transform/confirmDate";
    // 通过改造时间
    public static final String AGREE_DATE_TRANSFORM = HOST + "/transform/passDate";
    // 驳回改造时间
    public static final String REFUSE_TIME_TRANSFORM = HOST + "/transform/rejectDate";
    // 改造签到
    public static final String TRANSFORM_SIGNIN = HOST + "/transform/getSignInAndInfo";
    // 改造签到
    public static final String TRANSFORM_SIGNIN_INFO = HOST + "/transform/signInfo";
    // 确定完成部件
    public static final String TRANSFORM_CONFIRM_PART = HOST + "/transform/confirmPart";
    // 暂停
    public static final String PAUSE_TRANSFORM = HOST + "/transform/pause";
    // 确定暂停
    public static final String CONFIRM_PAUSE_TRANSFORM = HOST + "/transform/pauseConfirm";
    // 拒绝记录
    public static final String TRANSFORM_REJECT_LIST = HOST + "/transform/rejectList ";
    // 完成
    public static final String FINISH_TRANSFORM = HOST + "/transform/finish";
    // 确定完成
    public static final String CONFIRM_FINISH_TRANSFORM = HOST + "/transform/finishConfirm";
    // 暂停
    public static final String UPLOAD_OCC_TRANSFORM = HOST + "/transform/uploadOCC";
    // 培训列表
    public static final String TRAIN_LIST = HOST + "/train/queryTrainList";
    // 项目详情
    public static final String TRAIN_DETAIL = HOST + "/train/assigns";
    // 培训签到
    public static final String SIGN_TRAIN = HOST + "/train/saveTrainAttendance";
    // 确定采集时间
    public static final String FINISH_TRAIN = HOST + "/train/saveImage";

}
