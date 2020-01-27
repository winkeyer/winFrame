package com.winkey.loginmodule.model.vo;

/**
 * @author winkey
 * @date 2020/1/9
 * @describe 登录实体
 */
public class LoginEntity {

    // 登录时间戳
    private long loginTime;
    // 登录token
    private String token;

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
