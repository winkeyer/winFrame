package com.winkey.commonlib.model.vo;

/**
 * @author winkey
 * @date 2019/9/24
 * @describe 提交实体
 */
public class SubmitEntity {
    /**
     * code : 200
     * message : OK
     * result : null
     */

    private int code;
    private String message;
    private Object result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
