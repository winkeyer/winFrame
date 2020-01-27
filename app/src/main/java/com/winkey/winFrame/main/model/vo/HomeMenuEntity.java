package com.winkey.winFrame.main.model.vo;

/**
 * @描述 首页菜单项
 * @创建人 winkey
 * @创建日期 2018/11/13
 */
public class HomeMenuEntity {


    /**
     * itemId : 463
     * itemName : 大修执行
     * iconType : 1
     * labelFlag : true
     * num : 0
     */

    private int itemId;
    private String itemName;
    private String iconType;
    private boolean labelFlag;
    private int num;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getIconType() {
        return iconType;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    public boolean isLabelFlag() {
        return labelFlag;
    }

    public void setLabelFlag(boolean labelFlag) {
        this.labelFlag = labelFlag;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
