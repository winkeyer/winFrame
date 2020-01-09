package com.winkey.common.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * 拜访照片信息
 *
 * @author xiongz
 * @date 2018/10/11
 */
@Entity(nameInDb = "visit_img_profile")
public class VisitImgProfile {

    @Id(autoincrement = true)
    private Long id;
    private int createId;
    private String createName;
    private String customerAddress;
    private int customerId;
    private double customerLatitude;
    private double customerLongitude;
    private String customerName;
    private String locAddress;
    private long locDistance;
    private double locLatitude;
    private String locLbsType;
    private double locLongitude;
    private String photoPath; // 图片线上url
    private String localPath; // 图片本地路径
    private boolean isCommit; // 图片是否已提交
    private int photoType;
    private int visitId;
    // 预留字段
    private String reservedText;
    @Generated(hash = 879152621)
    public VisitImgProfile(Long id, int createId, String createName,
                           String customerAddress, int customerId, double customerLatitude,
                           double customerLongitude, String customerName, String locAddress,
                           long locDistance, double locLatitude, String locLbsType,
                           double locLongitude, String photoPath, String localPath,
                           boolean isCommit, int photoType, int visitId, String reservedText) {
        this.id = id;
        this.createId = createId;
        this.createName = createName;
        this.customerAddress = customerAddress;
        this.customerId = customerId;
        this.customerLatitude = customerLatitude;
        this.customerLongitude = customerLongitude;
        this.customerName = customerName;
        this.locAddress = locAddress;
        this.locDistance = locDistance;
        this.locLatitude = locLatitude;
        this.locLbsType = locLbsType;
        this.locLongitude = locLongitude;
        this.photoPath = photoPath;
        this.localPath = localPath;
        this.isCommit = isCommit;
        this.photoType = photoType;
        this.visitId = visitId;
        this.reservedText = reservedText;
    }
    @Generated(hash = 2143869202)
    public VisitImgProfile() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getCreateId() {
        return this.createId;
    }
    public void setCreateId(int createId) {
        this.createId = createId;
    }
    public String getCreateName() {
        return this.createName;
    }
    public void setCreateName(String createName) {
        this.createName = createName;
    }
    public String getCustomerAddress() {
        return this.customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public int getCustomerId() {
        return this.customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public double getCustomerLatitude() {
        return this.customerLatitude;
    }
    public void setCustomerLatitude(double customerLatitude) {
        this.customerLatitude = customerLatitude;
    }
    public double getCustomerLongitude() {
        return this.customerLongitude;
    }
    public void setCustomerLongitude(double customerLongitude) {
        this.customerLongitude = customerLongitude;
    }
    public String getCustomerName() {
        return this.customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getLocAddress() {
        return this.locAddress;
    }
    public void setLocAddress(String locAddress) {
        this.locAddress = locAddress;
    }
    public long getLocDistance() {
        return this.locDistance;
    }
    public void setLocDistance(long locDistance) {
        this.locDistance = locDistance;
    }
    public double getLocLatitude() {
        return this.locLatitude;
    }
    public void setLocLatitude(double locLatitude) {
        this.locLatitude = locLatitude;
    }
    public String getLocLbsType() {
        return this.locLbsType;
    }
    public void setLocLbsType(String locLbsType) {
        this.locLbsType = locLbsType;
    }
    public double getLocLongitude() {
        return this.locLongitude;
    }
    public void setLocLongitude(double locLongitude) {
        this.locLongitude = locLongitude;
    }
    public String getPhotoPath() {
        return this.photoPath;
    }
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    public String getLocalPath() {
        return this.localPath;
    }
    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }
    public boolean getIsCommit() {
        return this.isCommit;
    }
    public void setIsCommit(boolean isCommit) {
        this.isCommit = isCommit;
    }
    public int getPhotoType() {
        return this.photoType;
    }
    public void setPhotoType(int photoType) {
        this.photoType = photoType;
    }
    public int getVisitId() {
        return this.visitId;
    }
    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }
    public String getReservedText() {
        return this.reservedText;
    }
    public void setReservedText(String reservedText) {
        this.reservedText = reservedText;
    }

}
