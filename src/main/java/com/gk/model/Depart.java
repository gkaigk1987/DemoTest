package com.gk.model;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_depart
 */
public class Depart {
    /**
     * Database Column Remarks:
     *   唯一标识符
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_depart.uuid
     *
     * @mbg.generated
     */
    private String uuid;

    /**
     * Database Column Remarks:
     *   公司标识
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_depart.company_id
     *
     * @mbg.generated
     */
    private String companyId;

    /**
     * Database Column Remarks:
     *   版本号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_depart.version_no
     *
     * @mbg.generated
     */
    private Integer versionNo;

    /**
     * Database Column Remarks:
     *   批次号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_depart.batch_no
     *
     * @mbg.generated
     */
    private String batchNo;

    /**
     * Database Column Remarks:
     *   订单编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_depart.order_id
     *
     * @mbg.generated
     */
    private String orderId;

    /**
     * Database Column Remarks:
     *   机动车驾驶证编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_depart.license_id
     *
     * @mbg.generated
     */
    private String licenseId;

    /**
     * Database Column Remarks:
     *   运价类型编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_depart.fare_type
     *
     * @mbg.generated
     */
    private String fareType;

    /**
     * Database Column Remarks:
     *   车辆号牌
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_depart.vehicle_no
     *
     * @mbg.generated
     */
    private String vehicleNo;

    /**
     * Database Column Remarks:
     *   车辆出发经度
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_depart.dep_longgitude
     *
     * @mbg.generated
     */
    private String depLonggitude;

    /**
     * Database Column Remarks:
     *   车辆出发纬度
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_depart.dep_latitude
     *
     * @mbg.generated
     */
    private String depLatitude;

    /**
     * Database Column Remarks:
     *   坐标加密标识,1:GCJ-02 测绘局标准，2:WGS84 GPS标准，3:BD-09 百度标准，4:CGCS2000 北斗标准呢，5:其他
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_depart.encrypt
     *
     * @mbg.generated
     */
    private String encrypt;

    /**
     * Database Column Remarks:
     *   上车时间,YYYYMMDDhhmmss
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_depart.dep_time
     *
     * @mbg.generated
     */
    private String depTime;

    /**
     * Database Column Remarks:
     *   空使里程,单位：km
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_depart.wait_mile
     *
     * @mbg.generated
     */
    private String waitMile;

    /**
     * Database Column Remarks:
     *   等待时间,单位：秒
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_depart.wait_time
     *
     * @mbg.generated
     */
    private String waitTime;

    /**
     * Database Column Remarks:
     *   上报状态，0:待上报，1:上报中，2:上报成功，3：上报失败
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_depart.status
     *
     * @mbg.generated
     */
    private String status;

    /**
     * Database Column Remarks:
     *   添加时间，YYYYMMDDhhmmss
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_depart.create_time
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     * Database Column Remarks:
     *   修改时间，YYYYMMDDhhmmss
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_depart.update_time
     *
     * @mbg.generated
     */
    private String updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_depart.uuid
     *
     * @return the value of t_depart.uuid
     *
     * @mbg.generated
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_depart.uuid
     *
     * @param uuid the value for t_depart.uuid
     *
     * @mbg.generated
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_depart.company_id
     *
     * @return the value of t_depart.company_id
     *
     * @mbg.generated
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_depart.company_id
     *
     * @param companyId the value for t_depart.company_id
     *
     * @mbg.generated
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_depart.version_no
     *
     * @return the value of t_depart.version_no
     *
     * @mbg.generated
     */
    public Integer getVersionNo() {
        return versionNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_depart.version_no
     *
     * @param versionNo the value for t_depart.version_no
     *
     * @mbg.generated
     */
    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_depart.batch_no
     *
     * @return the value of t_depart.batch_no
     *
     * @mbg.generated
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_depart.batch_no
     *
     * @param batchNo the value for t_depart.batch_no
     *
     * @mbg.generated
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_depart.order_id
     *
     * @return the value of t_depart.order_id
     *
     * @mbg.generated
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_depart.order_id
     *
     * @param orderId the value for t_depart.order_id
     *
     * @mbg.generated
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_depart.license_id
     *
     * @return the value of t_depart.license_id
     *
     * @mbg.generated
     */
    public String getLicenseId() {
        return licenseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_depart.license_id
     *
     * @param licenseId the value for t_depart.license_id
     *
     * @mbg.generated
     */
    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId == null ? null : licenseId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_depart.fare_type
     *
     * @return the value of t_depart.fare_type
     *
     * @mbg.generated
     */
    public String getFareType() {
        return fareType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_depart.fare_type
     *
     * @param fareType the value for t_depart.fare_type
     *
     * @mbg.generated
     */
    public void setFareType(String fareType) {
        this.fareType = fareType == null ? null : fareType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_depart.vehicle_no
     *
     * @return the value of t_depart.vehicle_no
     *
     * @mbg.generated
     */
    public String getVehicleNo() {
        return vehicleNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_depart.vehicle_no
     *
     * @param vehicleNo the value for t_depart.vehicle_no
     *
     * @mbg.generated
     */
    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo == null ? null : vehicleNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_depart.dep_longgitude
     *
     * @return the value of t_depart.dep_longgitude
     *
     * @mbg.generated
     */
    public String getDepLonggitude() {
        return depLonggitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_depart.dep_longgitude
     *
     * @param depLonggitude the value for t_depart.dep_longgitude
     *
     * @mbg.generated
     */
    public void setDepLonggitude(String depLonggitude) {
        this.depLonggitude = depLonggitude == null ? null : depLonggitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_depart.dep_latitude
     *
     * @return the value of t_depart.dep_latitude
     *
     * @mbg.generated
     */
    public String getDepLatitude() {
        return depLatitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_depart.dep_latitude
     *
     * @param depLatitude the value for t_depart.dep_latitude
     *
     * @mbg.generated
     */
    public void setDepLatitude(String depLatitude) {
        this.depLatitude = depLatitude == null ? null : depLatitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_depart.encrypt
     *
     * @return the value of t_depart.encrypt
     *
     * @mbg.generated
     */
    public String getEncrypt() {
        return encrypt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_depart.encrypt
     *
     * @param encrypt the value for t_depart.encrypt
     *
     * @mbg.generated
     */
    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt == null ? null : encrypt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_depart.dep_time
     *
     * @return the value of t_depart.dep_time
     *
     * @mbg.generated
     */
    public String getDepTime() {
        return depTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_depart.dep_time
     *
     * @param depTime the value for t_depart.dep_time
     *
     * @mbg.generated
     */
    public void setDepTime(String depTime) {
        this.depTime = depTime == null ? null : depTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_depart.wait_mile
     *
     * @return the value of t_depart.wait_mile
     *
     * @mbg.generated
     */
    public String getWaitMile() {
        return waitMile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_depart.wait_mile
     *
     * @param waitMile the value for t_depart.wait_mile
     *
     * @mbg.generated
     */
    public void setWaitMile(String waitMile) {
        this.waitMile = waitMile == null ? null : waitMile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_depart.wait_time
     *
     * @return the value of t_depart.wait_time
     *
     * @mbg.generated
     */
    public String getWaitTime() {
        return waitTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_depart.wait_time
     *
     * @param waitTime the value for t_depart.wait_time
     *
     * @mbg.generated
     */
    public void setWaitTime(String waitTime) {
        this.waitTime = waitTime == null ? null : waitTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_depart.status
     *
     * @return the value of t_depart.status
     *
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_depart.status
     *
     * @param status the value for t_depart.status
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_depart.create_time
     *
     * @return the value of t_depart.create_time
     *
     * @mbg.generated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_depart.create_time
     *
     * @param createTime the value for t_depart.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_depart.update_time
     *
     * @return the value of t_depart.update_time
     *
     * @mbg.generated
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_depart.update_time
     *
     * @param updateTime the value for t_depart.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}