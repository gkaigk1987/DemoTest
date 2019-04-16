package com.gk.model;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_order_succes
 */
public class OrderSucces {
    /**
     * Database Column Remarks:
     *   唯一标识符
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_succes.uuid
     *
     * @mbg.generated
     */
    private String uuid;

    /**
     * Database Column Remarks:
     *   公司标识
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_succes.company_id
     *
     * @mbg.generated
     */
    private String companyId;

    /**
     * Database Column Remarks:
     *   版本号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_succes.version_no
     *
     * @mbg.generated
     */
    private Integer versionNo;

    /**
     * Database Column Remarks:
     *   批次号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_succes.batch_no
     *
     * @mbg.generated
     */
    private String batchNo;

    /**
     * Database Column Remarks:
     *   行政区划代码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_succes.address
     *
     * @mbg.generated
     */
    private String address;

    /**
     * Database Column Remarks:
     *   订单编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_succes.order_id
     *
     * @mbg.generated
     */
    private String orderId;

    /**
     * Database Column Remarks:
     *   车辆经度
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_succes.longgitude
     *
     * @mbg.generated
     */
    private String longgitude;

    /**
     * Database Column Remarks:
     *   车辆纬度
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_succes.latitude
     *
     * @mbg.generated
     */
    private String latitude;

    /**
     * Database Column Remarks:
     *   坐标加密标识,1:GCJ-02 测绘局标准，2:WGS84 GPS标准，3:BD-09 百度标准，4:CGCS2000 北斗标准呢，5:其他
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_succes.encrypt
     *
     * @mbg.generated
     */
    private String encrypt;

    /**
     * Database Column Remarks:
     *   机动车驾驶证编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_succes.license_id
     *
     * @mbg.generated
     */
    private String licenseId;

    /**
     * Database Column Remarks:
     *   驾驶员手机号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_succes.driver_phone
     *
     * @mbg.generated
     */
    private String driverPhone;

    /**
     * Database Column Remarks:
     *   车辆号牌
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_succes.vehicle_no
     *
     * @mbg.generated
     */
    private String vehicleNo;

    /**
     * Database Column Remarks:
     *   派单成功时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_succes.distribute_time
     *
     * @mbg.generated
     */
    private String distributeTime;

    /**
     * Database Column Remarks:
     *   上报状态，0:待上报，1:上报中，2:上报成功，3：上报失败
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_succes.status
     *
     * @mbg.generated
     */
    private String status;

    /**
     * Database Column Remarks:
     *   添加时间，YYYYMMDDhhmmss
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_succes.create_time
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     * Database Column Remarks:
     *   修改时间，YYYYMMDDhhmmss
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_succes.update_time
     *
     * @mbg.generated
     */
    private String updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_succes.uuid
     *
     * @return the value of t_order_succes.uuid
     *
     * @mbg.generated
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_succes.uuid
     *
     * @param uuid the value for t_order_succes.uuid
     *
     * @mbg.generated
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_succes.company_id
     *
     * @return the value of t_order_succes.company_id
     *
     * @mbg.generated
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_succes.company_id
     *
     * @param companyId the value for t_order_succes.company_id
     *
     * @mbg.generated
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_succes.version_no
     *
     * @return the value of t_order_succes.version_no
     *
     * @mbg.generated
     */
    public Integer getVersionNo() {
        return versionNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_succes.version_no
     *
     * @param versionNo the value for t_order_succes.version_no
     *
     * @mbg.generated
     */
    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_succes.batch_no
     *
     * @return the value of t_order_succes.batch_no
     *
     * @mbg.generated
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_succes.batch_no
     *
     * @param batchNo the value for t_order_succes.batch_no
     *
     * @mbg.generated
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_succes.address
     *
     * @return the value of t_order_succes.address
     *
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_succes.address
     *
     * @param address the value for t_order_succes.address
     *
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_succes.order_id
     *
     * @return the value of t_order_succes.order_id
     *
     * @mbg.generated
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_succes.order_id
     *
     * @param orderId the value for t_order_succes.order_id
     *
     * @mbg.generated
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_succes.longgitude
     *
     * @return the value of t_order_succes.longgitude
     *
     * @mbg.generated
     */
    public String getLonggitude() {
        return longgitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_succes.longgitude
     *
     * @param longgitude the value for t_order_succes.longgitude
     *
     * @mbg.generated
     */
    public void setLonggitude(String longgitude) {
        this.longgitude = longgitude == null ? null : longgitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_succes.latitude
     *
     * @return the value of t_order_succes.latitude
     *
     * @mbg.generated
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_succes.latitude
     *
     * @param latitude the value for t_order_succes.latitude
     *
     * @mbg.generated
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_succes.encrypt
     *
     * @return the value of t_order_succes.encrypt
     *
     * @mbg.generated
     */
    public String getEncrypt() {
        return encrypt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_succes.encrypt
     *
     * @param encrypt the value for t_order_succes.encrypt
     *
     * @mbg.generated
     */
    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt == null ? null : encrypt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_succes.license_id
     *
     * @return the value of t_order_succes.license_id
     *
     * @mbg.generated
     */
    public String getLicenseId() {
        return licenseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_succes.license_id
     *
     * @param licenseId the value for t_order_succes.license_id
     *
     * @mbg.generated
     */
    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId == null ? null : licenseId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_succes.driver_phone
     *
     * @return the value of t_order_succes.driver_phone
     *
     * @mbg.generated
     */
    public String getDriverPhone() {
        return driverPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_succes.driver_phone
     *
     * @param driverPhone the value for t_order_succes.driver_phone
     *
     * @mbg.generated
     */
    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone == null ? null : driverPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_succes.vehicle_no
     *
     * @return the value of t_order_succes.vehicle_no
     *
     * @mbg.generated
     */
    public String getVehicleNo() {
        return vehicleNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_succes.vehicle_no
     *
     * @param vehicleNo the value for t_order_succes.vehicle_no
     *
     * @mbg.generated
     */
    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo == null ? null : vehicleNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_succes.distribute_time
     *
     * @return the value of t_order_succes.distribute_time
     *
     * @mbg.generated
     */
    public String getDistributeTime() {
        return distributeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_succes.distribute_time
     *
     * @param distributeTime the value for t_order_succes.distribute_time
     *
     * @mbg.generated
     */
    public void setDistributeTime(String distributeTime) {
        this.distributeTime = distributeTime == null ? null : distributeTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_succes.status
     *
     * @return the value of t_order_succes.status
     *
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_succes.status
     *
     * @param status the value for t_order_succes.status
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_succes.create_time
     *
     * @return the value of t_order_succes.create_time
     *
     * @mbg.generated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_succes.create_time
     *
     * @param createTime the value for t_order_succes.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_succes.update_time
     *
     * @return the value of t_order_succes.update_time
     *
     * @mbg.generated
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_succes.update_time
     *
     * @param updateTime the value for t_order_succes.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}