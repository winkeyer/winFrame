package com.winkey.common.db;

/**
 * 系统参数实体
 *
 * @author xiongz
 * @date 2018/9/29
 */
public class SysParamEntity {


    /**
     * type : null
     * k : 0
     * val : 全包
     * id : 178
     */

    private String type;
    private String k;
    private String val;
    private String id;

    private String imageName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
