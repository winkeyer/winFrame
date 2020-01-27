package com.winkey.commonlib.db;

import com.alibaba.fastjson.JSON;
import com.winkey.commonlib.model.vo.PermissionsEntity;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

/**
 * @author winkey
 * @date 2019/9/17
 * @describe 权限数据库转换类
 */
public class PermissionsConvert implements PropertyConverter<List<PermissionsEntity>, String> {
    @Override
    public List<PermissionsEntity> convertToEntityProperty(String databaseValue) {
        return JSON.parseArray(databaseValue , PermissionsEntity.class);
    }

    @Override
    public String convertToDatabaseValue(List<PermissionsEntity> entityProperty) {
        return JSON.toJSONString(entityProperty);
    }
}
