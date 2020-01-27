package com.winkey.commonlib.model.po;


import com.winkey.commonlib.db.PermissionsConvert;
import com.winkey.commonlib.model.vo.PermissionsEntity;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;

/**
 * 登录用户信息
 *
 * @author xiongz
 * @date 2017/12/14
 */
@Entity(nameInDb = "user_profile")
public class UserProfile {

    @Id(autoincrement = true)
    private Long id;
    private String createTime;
    private String updateTime;
    private String createBy;
    private String updateBy;
    private String username;
    private String nickname;
    private String headImgUrl;
    private int phone;
    private String telephone;
    private String email;
    private String birthday;
    private int sex;
    private int status;
    private String intro;
    private String password;
    private String token;
    private int role;
    private String roleCode;
    @Convert(converter = PermissionsConvert.class , columnType = String.class)
    private List<PermissionsEntity> permissions;
    @Generated(hash = 650729175)
    public UserProfile(Long id, String createTime, String updateTime,
                       String createBy, String updateBy, String username, String nickname,
                       String headImgUrl, int phone, String telephone, String email,
                       String birthday, int sex, int status, String intro, String password,
                       String token, int role, String roleCode,
                       List<PermissionsEntity> permissions) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.username = username;
        this.nickname = nickname;
        this.headImgUrl = headImgUrl;
        this.phone = phone;
        this.telephone = telephone;
        this.email = email;
        this.birthday = birthday;
        this.sex = sex;
        this.status = status;
        this.intro = intro;
        this.password = password;
        this.token = token;
        this.role = role;
        this.roleCode = roleCode;
        this.permissions = permissions;
    }
    @Generated(hash = 968487393)
    public UserProfile() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return this.token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getUpdateTime() {
        return this.updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public String getCreateBy() {
        return this.createBy;
    }
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public String getUpdateBy() {
        return this.updateBy;
    }
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getHeadImgUrl() {
        return this.headImgUrl;
    }
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }
    public int getPhone() {
        return this.phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public String getTelephone() {
        return this.telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getBirthday() {
        return this.birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public int getSex() {
        return this.sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public int getStatus() {
        return this.status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getIntro() {
        return this.intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public List<PermissionsEntity> getPermissions() {
        return this.permissions;
    }
    public void setPermissions(List<PermissionsEntity> permissions) {
        this.permissions = permissions;
    }
    public int getRole() {
        return this.role;
    }
    public void setRole(int role) {
        this.role = role;
    }
    public String getRoleCode() {
        return this.roleCode;
    }
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}