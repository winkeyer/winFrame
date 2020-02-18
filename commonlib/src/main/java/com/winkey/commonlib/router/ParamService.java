package com.winkey.commonlib.router;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.winkey.commonlib.model.po.SysParamProfile;

import java.util.List;

/**
 * @author xuwenbin
 * @date 2020/2/18
 * @describe  Arouter参数服务
 */
public interface ParamService extends IProvider {

    void insertSysParamProfile(SysParamProfile profile);

    void clearSysParamProfile();

    List<SysParamProfile> getSysParams(String parentId);


    /**
     * 获取原收费模式
     *
     * @return
     */
    List<SysParamProfile> getChargingModel();

    /**
     * 获取机房
     *
     * @return
     */
    List<SysParamProfile> getComputerRoom();


    /**
     * 获取升降梯品牌
     *
     * @return
     */
    List<SysParamProfile> getElevatorBrand();


    /**
     * 获取升降梯用途
     *
     * @return
     */
    List<SysParamProfile> getElevatorOruse();

    /**
     * 获取控制方式
     *
     * @return
     */
    List<SysParamProfile> getControlMode();

    /**
     * 获取电梯速度
     *
     * @return
     */
    List<SysParamProfile> getElevatorSpeed();

    /**
     * 获取布置方式
     *
     * @return
     */
    List<SysParamProfile> getLayoutMode();

    /**
     * 获取悬挂方式
     *
     * @return
     */
    List<SysParamProfile> getHangMode();

    /**
     * 获取曳引方式
     *
     * @return
     */
    List<SysParamProfile> getDrivingMode();

    /**
     * 获取电梯状态
     *
     * @return
     */
    List<SysParamProfile> getElevatorStatus();

    /**
     * 获取手扶梯机房
     *
     * @return
     */
    List<SysParamProfile> getEscalatorInstalllocation();

    /**
     * 获取手扶梯速度
     *
     * @return
     */
    List<SysParamProfile> getEscalatorSpeed();

    /**
     * 获取手扶梯级别
     *
     * @return
     */
    List<SysParamProfile> getEscalatorLevel();

    /**
     * 获取手扶梯类型
     *
     * @return
     */
    List<SysParamProfile> getEscalatorType();

    /**
     * 获取手扶梯使用环境
     *
     * @return
     */
    List<SysParamProfile> getEscalatorEnvironment();

    /**
     * 获取手扶梯倾角度
     *
     * @return
     */
    List<SysParamProfile> getEscalatorAngle();

    /**
     * 获取手扶梯梯级宽度
     *
     * @return
     */
    List<SysParamProfile> getEscalatorStepWidth();

    /**
     * 获取手扶梯运行方式
     *
     * @return
     */
    List<SysParamProfile> getEscalatorRunMode();

    /**
     * 获取载重量
     *
     * @return
     */
    List<SysParamProfile> getLoadWeight();


    /**
     * 获取载重量
     *
     * @return
     */
    List<SysParamProfile> getWorkOrderProjectStatus();

    /**
     * 获取现象
     *
     * @return
     */
    List<SysParamProfile> getPhenomenons();

    /**
     * 获取检查
     *
     * @return
     */
    List<SysParamProfile> getReconditions();

    /**
     * 获取原因
     *
     * @return
     */
    List<SysParamProfile> getCauses();

    /**
     * 获取责任
     *
     * @return
     */
    List<SysParamProfile> getFaultDuties();

    /**
     * 获取处理
     *
     * @return
     */
    List<SysParamProfile> getHandles();

    /**
     * 获取手扶梯现象
     *
     * @return
     */
    List<SysParamProfile> getEscalatorPhenomenons();

    /**
     * 获取手扶梯检查
     *
     * @return
     */
    List<SysParamProfile> getEscalatorReconditions();

    /**
     * 获取手扶梯原因
     *
     * @return
     */
    List<SysParamProfile> getEscalatorCauses();

    /**
     * 获取手扶梯责任
     *
     * @return
     */
    List<SysParamProfile> getEscalatorFaultDuties();

    /**
     * 获取手扶梯处理
     *
     * @return
     */
    List<SysParamProfile> getEscalatorHandles();

    /**
     * 获取电梯运行状态
     *
     * @return
     */
    List<SysParamProfile> getLiftStatus();

    /**
     * 获取大修状态
     *
     * @return
     */
    List<SysParamProfile> getOverhaulStatus();

}
