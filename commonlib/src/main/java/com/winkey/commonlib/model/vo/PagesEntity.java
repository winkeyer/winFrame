package com.winkey.commonlib.model.vo;

/**
 * @author winkey
 * @date 2019/9/18
 * @describe 分页器实体
 */
public class PagesEntity<T> {
    /**
     * pageNumber : 1
     * pageSize : 10
     * startRow : 0
     * total : 8
     * rows : [{"elevatorId":"21","buildingNumber":"A栋","stairNumber":"3#","elevatorBrand":"10","elevatorModel":"2","elevatorBrandName":"蒂森克虏伯","elevatorModelName":"K200","elevatorType":"1","elevatorTypeName":"手扶梯","cProjectCode":null},{"elevatorId":"22","buildingNumber":"B栋","stairNumber":"3#","elevatorBrand":"10","elevatorModel":"2","elevatorBrandName":"蒂森克虏伯","elevatorModelName":"K200","elevatorType":"1","elevatorTypeName":"手扶梯","cProjectCode":null},{"elevatorId":"23","buildingNumber":"C栋","stairNumber":"3#","elevatorBrand":"10","elevatorModel":"2","elevatorBrandName":"蒂森克虏伯","elevatorModelName":"K200","elevatorType":"1","elevatorTypeName":"手扶梯","cProjectCode":null},{"elevatorId":"28bbde3b-cff4-4508-92d8-66250c2f132a","buildingNumber":"3栋","stairNumber":"1#","elevatorBrand":"10","elevatorModel":"2","elevatorBrandName":"蒂森克虏伯","elevatorModelName":"K200","elevatorType":"0","elevatorTypeName":"升降梯","cProjectCode":null},{"elevatorId":"89ae6dfe-3f3c-4ed2-881f-9b5e8939deee","buildingNumber":"123","stairNumber":"123","elevatorBrand":"10","elevatorModel":"2","elevatorBrandName":"蒂森克虏伯","elevatorModelName":"K200","elevatorType":"0","elevatorTypeName":"升降梯","cProjectCode":null},{"elevatorId":"11","buildingNumber":"1","stairNumber":"1","elevatorBrand":"10","elevatorModel":"2","elevatorBrandName":"蒂森克虏伯","elevatorModelName":"K200","elevatorType":"1","elevatorTypeName":"手扶梯","cProjectCode":null},{"elevatorId":"12","buildingNumber":"B栋","stairNumber":"3#","elevatorBrand":"10","elevatorModel":"2","elevatorBrandName":"蒂森克虏伯","elevatorModelName":"K200","elevatorType":"1","elevatorTypeName":"手扶梯","cProjectCode":null},{"elevatorId":"8be2a75f-4f69-42f1-b4f5-b1689a2a7e05","buildingNumber":"A栋","stairNumber":"3#","elevatorBrand":"10","elevatorModel":"2","elevatorBrandName":"蒂森克虏伯","elevatorModelName":"K200","elevatorType":"1","elevatorTypeName":"手扶梯","cProjectCode":null}]
     * queryObj : {"elevatorBrandName":"森"}
     */

    private int pageNumber;
    private int pageSize;
    private int startRow;
    private int total;
    private T rows;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

}
