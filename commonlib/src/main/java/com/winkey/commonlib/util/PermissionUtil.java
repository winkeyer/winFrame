package com.winkey.commonlib.util;

import com.winkey.commonlib.db.ProfileManager;
import com.winkey.commonlib.model.po.UserProfile;
import com.winkey.commonlib.model.vo.PermissionsEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author winkey
 * @date 2019/9/17
 * @describe 菜单关系映射表
 */
public class PermissionUtil {


    /**
     * @param permission 指定的权限
     * @return
     */
    public static boolean hasPermission(String permission) {
        UserProfile userProfile = ProfileManager.getCurUserProfile();
        List<PermissionsEntity> permissions = userProfile.getPermissions();
        boolean hasPermission = false;
        for (PermissionsEntity permissionsEntity : permissions) {
            if (permissionsEntity.getPermission() != null && permissionsEntity.getPermission().equals(permission)) {
                hasPermission = true;
            }
        }
        return hasPermission;
    }

    /**
     * @param id 指定的菜单id
     * @return
     */
    public static boolean hasMenu(int id) {
        UserProfile userProfile = ProfileManager.getCurUserProfile();
        List<PermissionsEntity> permissions = userProfile.getPermissions();
        boolean hasMenu = false;
        for (PermissionsEntity permissionsEntity : permissions) {
            if (permissionsEntity.getPermission() != null && permissionsEntity.getId()==id) {
                hasMenu = true;
            }
        }
        return hasMenu;
    }
}
