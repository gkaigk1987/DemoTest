package com.gk.model;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_plivate_order
 */
public class PlivateOrder {
    /**
     * Database Column Remarks:
     *   唯一标识符
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.uuid
     *
     * @mbg.generated
     */
    private String uuid;

    /**
     * Database Column Remarks:
     *   公司标识
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.company_id
     *
     * @mbg.generated
     */
    private String companyId;

    /**
     * Database Column Remarks:
     *   版本号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.version_no
     *
     * @mbg.generated
     */
    private Integer versionNo;

    /**
     * Database Column Remarks:
     *   批次号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.batch_no
     *
     * @mbg.generated
     */
    private String batchNo;

    /**
     * Database Column Remarks:
     *   行政区划代码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.address
     *
     * @mbg.generated
     */
    private String address;

    /**
     * Database Column Remarks:
     *   驾驶员发起行程编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.route_id
     *
     * @mbg.generated
     */
    private String routeId;

    /**
     * Database Column Remarks:
     *   订单编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.order_id
     *
     * @mbg.generated
     */
    private String orderId;

    /**
     * Database Column Remarks:
     *   预计上车时间,YYYYMMDDhhmmss
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.book_depart_time
     *
     * @mbg.generated
     */
    private String bookDepartTime;

    /**
     * Database Column Remarks:
     *   预计上车地点
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.departure
     *
     * @mbg.generated
     */
    private String departure;

    /**
     * Database Column Remarks:
     *   预计上车地点经度
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.dep_longgitude
     *
     * @mbg.generated
     */
    private String depLonggitude;

    /**
     * Database Column Remarks:
     *   预计上车地点纬度
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.dep_latitude
     *
     * @mbg.generated
     */
    private String depLatitude;

    /**
     * Database Column Remarks:
     *   预计下车地点
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.destination
     *
     * @mbg.generated
     */
    private String destination;

    /**
     * Database Column Remarks:
     *   预计下车地点经度
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.dest_longgitude
     *
     * @mbg.generated
     */
    private String destLonggitude;

    /**
     * Database Column Remarks:
     *   预计下车地点纬度
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.dest_latitude
     *
     * @mbg.generated
     */
    private String destLatitude;

    /**
     * Database Column Remarks:
     *   坐标加密标识,1:GCJ-02 测绘局标准，2:WGS84 GPS标准，3:BD-09 百度标准，4:CGCS2000 北斗标准呢，5:其他
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.encrypt
     *
     * @mbg.generated
     */
    private String encrypt;

    /**
     * Database Column Remarks:
     *   订单确认时间,YYYYMMDDhhmmss
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.order_ensure_time
     *
     * @mbg.generated
     */
    private String orderEnsureTime;

    /**
     * Database Column Remarks:
     *   乘客人数
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.passenger_num
     *
     * @mbg.generated
     */
    private Integer passengerNum;

    /**
     * Database Column Remarks:
     *   乘客备注
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.passenger_note
     *
     * @mbg.generated
     */
    private String passengerNote;

    /**
     * Database Column Remarks:
     *   上报状态，0:待上报，1:上报中，2:上报成功，3：上报失败
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.status
     *
     * @mbg.generated
     */
    private String status;

    /**
     * Database Column Remarks:
     *   添加时间，YYYYMMDDhhmmss
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.create_time
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     * Database Column Remarks:
     *   修改时间，YYYYMMDDhhmmss
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plivate_order.update_time
     *
     * @mbg.generated
     */
    private String updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.uuid
     *
     * @return the value of t_plivate_order.uuid
     *
     * @mbg.generated
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.uuid
     *
     * @param uuid the value for t_plivate_order.uuid
     *
     * @mbg.generated
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.company_id
     *
     * @return the value of t_plivate_order.company_id
     *
     * @mbg.generated
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.company_id
     *
     * @param companyId the value for t_plivate_order.company_id
     *
     * @mbg.generated
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.version_no
     *
     * @return the value of t_plivate_order.version_no
     *
     * @mbg.generated
     */
    public Integer getVersionNo() {
        return versionNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.version_no
     *
     * @param versionNo the value for t_plivate_order.version_no
     *
     * @mbg.generated
     */
    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.batch_no
     *
     * @return the value of t_plivate_order.batch_no
     *
     * @mbg.generated
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.batch_no
     *
     * @param batchNo the value for t_plivate_order.batch_no
     *
     * @mbg.generated
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.address
     *
     * @return the value of t_plivate_order.address
     *
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.address
     *
     * @param address the value for t_plivate_order.address
     *
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.route_id
     *
     * @return the value of t_plivate_order.route_id
     *
     * @mbg.generated
     */
    public String getRouteId() {
        return routeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.route_id
     *
     * @param routeId the value for t_plivate_order.route_id
     *
     * @mbg.generated
     */
    public void setRouteId(String routeId) {
        this.routeId = routeId == null ? null : routeId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.order_id
     *
     * @return the value of t_plivate_order.order_id
     *
     * @mbg.generated
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.order_id
     *
     * @param orderId the value for t_plivate_order.order_id
     *
     * @mbg.generated
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.book_depart_time
     *
     * @return the value of t_plivate_order.book_depart_time
     *
     * @mbg.generated
     */
    public String getBookDepartTime() {
        return bookDepartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.book_depart_time
     *
     * @param bookDepartTime the value for t_plivate_order.book_depart_time
     *
     * @mbg.generated
     */
    public void setBookDepartTime(String bookDepartTime) {
        this.bookDepartTime = bookDepartTime == null ? null : bookDepartTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.departure
     *
     * @return the value of t_plivate_order.departure
     *
     * @mbg.generated
     */
    public String getDeparture() {
        return departure;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.departure
     *
     * @param departure the value for t_plivate_order.departure
     *
     * @mbg.generated
     */
    public void setDeparture(String departure) {
        this.departure = departure == null ? null : departure.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.dep_longgitude
     *
     * @return the value of t_plivate_order.dep_longgitude
     *
     * @mbg.generated
     */
    public String getDepLonggitude() {
        return depLonggitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.dep_longgitude
     *
     * @param depLonggitude the value for t_plivate_order.dep_longgitude
     *
     * @mbg.generated
     */
    public void setDepLonggitude(String depLonggitude) {
        this.depLonggitude = depLonggitude == null ? null : depLonggitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.dep_latitude
     *
     * @return the value of t_plivate_order.dep_latitude
     *
     * @mbg.generated
     */
    public String getDepLatitude() {
        return depLatitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.dep_latitude
     *
     * @param depLatitude the value for t_plivate_order.dep_latitude
     *
     * @mbg.generated
     */
    public void setDepLatitude(String depLatitude) {
        this.depLatitude = depLatitude == null ? null : depLatitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.destination
     *
     * @return the value of t_plivate_order.destination
     *
     * @mbg.generated
     */
    public String getDestination() {
        return destination;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.destination
     *
     * @param destination the value for t_plivate_order.destination
     *
     * @mbg.generated
     */
    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.dest_longgitude
     *
     * @return the value of t_plivate_order.dest_longgitude
     *
     * @mbg.generated
     */
    public String getDestLonggitude() {
        return destLonggitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.dest_longgitude
     *
     * @param destLonggitude the value for t_plivate_order.dest_longgitude
     *
     * @mbg.generated
     */
    public void setDestLonggitude(String destLonggitude) {
        this.destLonggitude = destLonggitude == null ? null : destLonggitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.dest_latitude
     *
     * @return the value of t_plivate_order.dest_latitude
     *
     * @mbg.generated
     */
    public String getDestLatitude() {
        return destLatitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.dest_latitude
     *
     * @param destLatitude the value for t_plivate_order.dest_latitude
     *
     * @mbg.generated
     */
    public void setDestLatitude(String destLatitude) {
        this.destLatitude = destLatitude == null ? null : destLatitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.encrypt
     *
     * @return the value of t_plivate_order.encrypt
     *
     * @mbg.generated
     */
    public String getEncrypt() {
        return encrypt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.encrypt
     *
     * @param encrypt the value for t_plivate_order.encrypt
     *
     * @mbg.generated
     */
    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt == null ? null : encrypt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.order_ensure_time
     *
     * @return the value of t_plivate_order.order_ensure_time
     *
     * @mbg.generated
     */
    public String getOrderEnsureTime() {
        return orderEnsureTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.order_ensure_time
     *
     * @param orderEnsureTime the value for t_plivate_order.order_ensure_time
     *
     * @mbg.generated
     */
    public void setOrderEnsureTime(String orderEnsureTime) {
        this.orderEnsureTime = orderEnsureTime == null ? null : orderEnsureTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.passenger_num
     *
     * @return the value of t_plivate_order.passenger_num
     *
     * @mbg.generated
     */
    public Integer getPassengerNum() {
        return passengerNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.passenger_num
     *
     * @param passengerNum the value for t_plivate_order.passenger_num
     *
     * @mbg.generated
     */
    public void setPassengerNum(Integer passengerNum) {
        this.passengerNum = passengerNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.passenger_note
     *
     * @return the value of t_plivate_order.passenger_note
     *
     * @mbg.generated
     */
    public String getPassengerNote() {
        return passengerNote;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.passenger_note
     *
     * @param passengerNote the value for t_plivate_order.passenger_note
     *
     * @mbg.generated
     */
    public void setPassengerNote(String passengerNote) {
        this.passengerNote = passengerNote == null ? null : passengerNote.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.status
     *
     * @return the value of t_plivate_order.status
     *
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.status
     *
     * @param status the value for t_plivate_order.status
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.create_time
     *
     * @return the value of t_plivate_order.create_time
     *
     * @mbg.generated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.create_time
     *
     * @param createTime the value for t_plivate_order.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plivate_order.update_time
     *
     * @return the value of t_plivate_order.update_time
     *
     * @mbg.generated
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plivate_order.update_time
     *
     * @param updateTime the value for t_plivate_order.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}