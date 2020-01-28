package com.winkey.commonlib.router;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.winkey.commonlib.model.po.SysParamProfile;
import com.winkey.commonlib.model.po.UserProfile;

import java.util.List;

/**
 * @author winkey
 * @date 2020/1/26
 * @describe TODO
 */
public interface UserService extends IProvider {

    UserProfile getUserInfo();

    String getToken();

    /**
     * 获取原收费模式
     *
     * @return
     */
    public List<SysParamProfile> getChargingModel();

    /**
     * 获取机房
     *
     * @return
     */
    public List<SysParamProfile> getComputerRoom();


    /**
     * 获取升降梯品牌
     *
     * @return
     */
    public List<SysParamProfile> getElevatorBrand();


    /**
     * 获取升降梯用途
     *
     * @return
     */
    public List<SysParamProfile> getElevatorOruse();

    /**
     * 获取控制方式
     *
     * @return
     */
    public List<SysParamProfile> getControlMode();

    /**
     * 获取电梯速度
     *
     * @return
     */
    public List<SysParamProfile> getElevatorSpeed();

    /**
     * 获取布置方式
     *
     * @return
     */
    public List<SysParamProfile> getLayoutMode();

    /**
     * 获取悬挂方式
     *
     * @return
     */
    public List<SysParamProfile> getHangMode();

    /**
     * 获取曳引方式
     *
     * @return
     */
    public List<SysParamProfile> getDrivingMode();

    /**
     * 获取电梯状态
     *
     * @return
     */
    public List<SysParamProfile> getElevatorStatus();

    /**
     * 获取手扶梯机房
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorInstalllocation();

    /**
     * 获取手扶梯速度
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorSpeed();

    /**
     * 获取手扶梯级别
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorLevel();

    /**
     * 获取手扶梯类型
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorType();

    /**
     * 获取手扶梯使用环境
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorEnvironment();

    /**
     * 获取手扶梯倾角度
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorAngle();

    /**
     * 获取手扶梯梯级宽度
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorStepWidth();

    /**
     * 获取手扶梯运行方式
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorRunMode();

    /**
     * 获取载重量
     *
     * @return
     */
    public List<SysParamProfile> getLoadWeight();


    /**
     * 获取载重量
     *
     * @return
     */
    public List<SysParamProfile> getWorkOrderProjectStatus();

    /**
     * 获取现象
     *
     * @return
     */
    public List<SysParamProfile> getPhenomenons();

    /**
     * 获取检查
     *
     * @return
     */
    public List<SysParamProfile> getReconditions();

    /**
     * 获取原因
     *
     * @return
     */
    public List<SysParamProfile> getCauses();

    /**
     * 获取责任
     *
     * @return
     */
    public List<SysParamProfile> getFaultDuties();

    /**
     * 获取处理
     *
     * @return
     */
    public List<SysParamProfile> getHandles();

    /**
     * 获取手扶梯现象
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorPhenomenons();

    /**
     * 获取手扶梯检查
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorReconditions();

    /**
     * 获取手扶梯原因
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorCauses();

    /**
     * 获取手扶梯责任
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorFaultDuties();

    /**
     * 获取手扶梯处理
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorHandles();

    /**
     * 获取电梯运行状态
     *
     * @return
     */
    public List<SysParamProfile> getLiftStatus();

    /**
     * 获取大修状态
     *
     * @return
     */
    public List<SysParamProfile> getOverhaulStatus();

}
