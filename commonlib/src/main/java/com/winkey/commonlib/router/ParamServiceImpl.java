package com.winkey.commonlib.router;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.winkey.commonlib.constant.Const;
import com.winkey.commonlib.constant.Router;
import com.winkey.commonlib.db.DbManager;
import com.winkey.commonlib.model.po.SysParamProfile;
import com.winkey.commonlib.model.po.SysParamProfileDao;

import java.util.List;

/**
 * @author xuwenbin
 * @date 2020/2/18
 * @describe 系统参数服务实现类
 */
@Route(path = Router.PARAM_INFO)
public class ParamServiceImpl implements ParamService{
    

    @Override
    public void insertSysParamProfile(SysParamProfile profile) {
        SysParamProfileDao dao = DbManager.getInstance().getSysParamProfileDao();
        dao.detachAll(); // 清除缓存
        List<SysParamProfile> profiles = dao.queryBuilder().where(
                SysParamProfileDao.Properties.DictId.eq(profile.getDictId())).list();
        if (profiles == null || profiles.size() == 0) {
            dao.insert(profile);
        }
    }

    @Override
    public void clearSysParamProfile() {
        SysParamProfileDao dao = DbManager.getInstance().getSysParamProfileDao();
        dao.detachAll(); // 清除缓存
        dao.deleteAll();
    }

    @Override
    public List<SysParamProfile> getSysParams(String parentId) {
        SysParamProfileDao dao = DbManager.getInstance().getSysParamProfileDao();
        dao.detachAll(); // 清除缓存
        List<SysParamProfile> profiles = dao.queryBuilder()
                .where(SysParamProfileDao.Properties.DictTag.eq(parentId))
                .orderAsc(SysParamProfileDao.Properties.DictKeyId)
                .list();
        return profiles;
    }


    /**
     * 获取原收费模式
     *
     * @return
     */
    public List<SysParamProfile> getChargingModel() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.CHARGINGMODE);
        return profiles;
    }

    /**
     * 获取机房
     *
     * @return
     */
    public List<SysParamProfile> getComputerRoom() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.MACHINEROOM);
        return profiles;
    }


    /**
     * 获取升降梯品牌
     *
     * @return
     */
    public List<SysParamProfile> getElevatorBrand() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.ELEVATORBRAND);
        return profiles;
    }


    /**
     * 获取升降梯用途
     *
     * @return
     */
    public List<SysParamProfile> getElevatorOruse() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.ELEVATORUSE);
        return profiles;
    }

    /**
     * 获取控制方式
     *
     * @return
     */
    public List<SysParamProfile> getControlMode() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.CONTROLMODE);
        return profiles;
    }

    /**
     * 获取电梯速度
     *
     * @return
     */
    public List<SysParamProfile> getElevatorSpeed() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.ELEVATORSPEED);
        return profiles;
    }

    /**
     * 获取布置方式
     *
     * @return
     */
    public List<SysParamProfile> getLayoutMode() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.LAYOUTMODE);
        return profiles;
    }

    /**
     * 获取悬挂方式
     *
     * @return
     */
    public List<SysParamProfile> getHangMode() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.HANG);
        return profiles;
    }

    /**
     * 获取曳引方式
     *
     * @return
     */
    public List<SysParamProfile> getDrivingMode() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.DRIVINGMODE);
        return profiles;
    }

    /**
     * 获取电梯状态
     *
     * @return
     */
    public List<SysParamProfile> getElevatorStatus() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.ELEVATORSTATUS);
        return profiles;
    }

    /**
     * 获取手扶梯机房
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorInstalllocation() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.ESCALATORINSTALLLOCATION);
        return profiles;
    }

    /**
     * 获取手扶梯速度
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorSpeed() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.ESCALATORSPEED);
        return profiles;
    }

    /**
     * 获取手扶梯级别
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorLevel() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.LEVEL);
        return profiles;
    }

    /**
     * 获取手扶梯类型
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorType() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.ESCALATORTYPE);
        return profiles;
    }

    /**
     * 获取手扶梯使用环境
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorEnvironment() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.USEENVIRONMENT);
        return profiles;
    }

    /**
     * 获取手扶梯倾角度
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorAngle() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.DIPANGLE);
        return profiles;
    }

    /**
     * 获取手扶梯梯级宽度
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorStepWidth() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.STEPWIDTH);
        return profiles;
    }

    /**
     * 获取手扶梯运行方式
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorRunMode() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.RUNMODE);
        return profiles;
    }

    /**
     * 获取载重量
     *
     * @return
     */
    public List<SysParamProfile> getLoadWeight() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.LOADWEIGHT);
        return profiles;
    }


    /**
     * 获取载重量
     *
     * @return
     */
    public List<SysParamProfile> getWorkOrderProjectStatus() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.DEALWITHSTATUS);
        return profiles;
    }

    /**
     * 获取现象
     *
     * @return
     */
    public List<SysParamProfile> getPhenomenons() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.PHENOMENON);
        return profiles;
    }

    /**
     * 获取检查
     *
     * @return
     */
    public List<SysParamProfile> getReconditions() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.RECONDITIONS);
        return profiles;
    }
    /**
     * 获取原因
     *
     * @return
     */
    public List<SysParamProfile> getCauses() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.CAUSES);
        return profiles;
    }
    /**
     * 获取责任
     *
     * @return
     */
    public List<SysParamProfile> getFaultDuties() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.FAULTDUTYS);
        return profiles;
    }
    /**
     * 获取处理
     *
     * @return
     */
    public List<SysParamProfile> getHandles() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.HANDLE);
        return profiles;
    }

    /**
     * 获取手扶梯现象
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorPhenomenons() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.ESCALATORPHENOMENON);
        return profiles;
    }

    /**
     * 获取手扶梯检查
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorReconditions() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.ESCALATORRECONDITIONS);
        return profiles;
    }
    /**
     * 获取手扶梯原因
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorCauses() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.ESCALATORCAUSES);
        return profiles;
    }
    /**
     * 获取手扶梯责任
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorFaultDuties() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.ESCALATORFAULTDUTYS);
        return profiles;
    }
    /**
     * 获取手扶梯处理
     *
     * @return
     */
    public List<SysParamProfile> getEscalatorHandles() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.ESCALATORHANDLE);
        return profiles;
    }

    /**
     * 获取电梯运行状态
     *
     * @return
     */
    public List<SysParamProfile> getLiftStatus() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.ELEVATORSSTATUS);
        return profiles;
    }
    /**
     * 获取大修状态
     *
     * @return
     */
    public List<SysParamProfile> getOverhaulStatus() {
        List<SysParamProfile> profiles = getSysParams(Const.SystemParam.OVERHAULSTATE);
        return profiles;
    }


    @Override
    public void init(Context context) {

    }
}
