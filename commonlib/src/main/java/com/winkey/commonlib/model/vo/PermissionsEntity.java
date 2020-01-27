package com.winkey.commonlib.model.vo;

import java.io.Serializable;

/**
 * @author winkey
 * @date 2019/9/17
 * @describe 权限获取内容实体
 */
public class PermissionsEntity implements Serializable {
    /**
     * id : 44
     * createTime : 2019-09-17 20:57:57
     * updateTime : 2019-09-17 20:57:57
     * createBy : null
     * updateBy : null
     * parentId : 43
     * name : 维保计划
     * css : fa-graduation-cap
     * href : pages/maintenance/planList.html
     * type : 1
     * permission :
     * sort : 1
     * child : null
     */

    private int id;
    private String createTime;
    private String updateTime;
    private Object createBy;
    private Object updateBy;
    private int parentId;
    private String name;
    private String css;
    private String href;
    private int type;
    private String permission;
    private int sort;
    private Object child;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Object getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Object createBy) {
        this.createBy = createBy;
    }

    public Object getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Object updateBy) {
        this.updateBy = updateBy;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public Object getChild() {
        return child;
    }

    public void setChild(Object child) {
        this.child = child;
    }
}
