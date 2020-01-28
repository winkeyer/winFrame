package com.winkey.commonlib.router;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.SPUtils;
import com.winkey.commonlib.constant.Const;
import com.winkey.commonlib.db.ProfileManager;
import com.winkey.commonlib.model.po.SysParamProfile;
import com.winkey.commonlib.model.po.UserProfile;

import java.util.List;

/**
 * @author winkey
 * @date 2020/1/26
 * @describe TODO
 */
@Route(path = "/userService/userInfo")
public class UserServiceImpl implements UserService {
    @Override
    public UserProfile getUserInfo() {
        return ProfileManager.getCurUserProfile();
    }

    @Override
    public String getToken() {
        return SPUtils.getInstance().getString(Const.TOKEN, "");
    }

    @Override
    public List<SysParamProfile> getChargingModel() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.CHARGINGMODE);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getComputerRoom() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.MACHINEROOM);
        return profiles;
    }


    @Override
    public List<SysParamProfile> getElevatorBrand() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.ELEVATORBRAND);
        return profiles;
    }


    @Override
    public List<SysParamProfile> getElevatorOruse() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.ELEVATORUSE);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getControlMode() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.CONTROLMODE);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getElevatorSpeed() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.ELEVATORSPEED);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getLayoutMode() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.LAYOUTMODE);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getHangMode() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.HANG);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getDrivingMode() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.DRIVINGMODE);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getElevatorStatus() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.ELEVATORSTATUS);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getEscalatorInstalllocation() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.ESCALATORINSTALLLOCATION);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getEscalatorSpeed() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.ESCALATORSPEED);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getEscalatorLevel() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.LEVEL);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getEscalatorType() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.ESCALATORTYPE);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getEscalatorEnvironment() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.USEENVIRONMENT);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getEscalatorAngle() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.DIPANGLE);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getEscalatorStepWidth() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.STEPWIDTH);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getEscalatorRunMode() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.RUNMODE);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getLoadWeight() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.LOADWEIGHT);
        return profiles;
    }


    @Override
    public List<SysParamProfile> getWorkOrderProjectStatus() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.DEALWITHSTATUS);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getPhenomenons() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.PHENOMENON);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getReconditions() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.RECONDITIONS);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getCauses() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.CAUSES);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getFaultDuties() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.FAULTDUTYS);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getHandles() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.HANDLE);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getEscalatorPhenomenons() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.ESCALATORPHENOMENON);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getEscalatorReconditions() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.ESCALATORRECONDITIONS);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getEscalatorCauses() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.ESCALATORCAUSES);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getEscalatorFaultDuties() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.ESCALATORFAULTDUTYS);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getEscalatorHandles() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.ESCALATORHANDLE);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getLiftStatus() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.ELEVATORSSTATUS);
        return profiles;
    }

    @Override
    public List<SysParamProfile> getOverhaulStatus() {
        List<SysParamProfile> profiles = ProfileManager.getSysParams(Const.SystemParam.OVERHAULSTATE);
        return profiles;
    }

    @Override
    public void init(Context context) {

    }
}
