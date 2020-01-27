package com.winkey.commonlib.model.po;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * 登录用户信息
 *
 * @author xiongz
 * @date 2017/12/14
 */
@Entity(nameInDb = "system_param_profile")
public class SysParamProfile {

    @Id(autoincrement = true)
    private Long id;

    // 系统参数key
    private int dictKeyId;
    // 系统参数key
    private String dictKey;
    // 系统参数value
    private String dictValue;
    // 系统参数id
    private String dictId;
    // 系统参数类别
    private String dictType;
    // 系统参数标识
    private String dictTag;
    private String imageName;
    @Generated(hash = 648001239)
    public SysParamProfile(Long id, int dictKeyId, String dictKey, String dictValue,
                           String dictId, String dictType, String dictTag, String imageName) {
        this.id = id;
        this.dictKeyId = dictKeyId;
        this.dictKey = dictKey;
        this.dictValue = dictValue;
        this.dictId = dictId;
        this.dictType = dictType;
        this.dictTag = dictTag;
        this.imageName = imageName;
    }
    @Generated(hash = 2002904431)
    public SysParamProfile() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDictKey() {
        return this.dictKey;
    }
    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }
    public String getDictValue() {
        return this.dictValue;
    }
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }
    public String getDictId() {
        return this.dictId;
    }
    public void setDictId(String dictId) {
        this.dictId = dictId;
    }
    public String getDictType() {
        return this.dictType;
    }
    public void setDictType(String dictType) {
        this.dictType = dictType;
    }
    public String getDictTag() {
        return this.dictTag;
    }
    public void setDictTag(String dictTag) {
        this.dictTag = dictTag;
    }
    public int getDictKeyId() {
        return this.dictKeyId;
    }
    public void setDictKeyId(int dictKeyId) {
        this.dictKeyId = dictKeyId;
    }
    public String getImageName() {
        return this.imageName;
    }
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }


}
