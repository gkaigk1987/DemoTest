package com.gk.model;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_position_gk
 */
public class PositionGk {
    /**
     * Database Column Remarks:
     *   主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_position_gk.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_position_gk.order_id
     *
     * @mbg.generated
     */
    private String orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_position_gk.start_lon
     *
     * @mbg.generated
     */
    private String startLon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_position_gk.start_lat
     *
     * @mbg.generated
     */
    private String startLat;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_position_gk.end_lon
     *
     * @mbg.generated
     */
    private String endLon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_position_gk.end_lat
     *
     * @mbg.generated
     */
    private String endLat;

    /**
     * Database Column Remarks:
     *   瞬时经度
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_position_gk.instant_lon
     *
     * @mbg.generated
     */
    private String instantLon;

    /**
     * Database Column Remarks:
     *   瞬时纬度
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_position_gk.instant_lat
     *
     * @mbg.generated
     */
    private String instantLat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_position_gk.id
     *
     * @return the value of t_position_gk.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_position_gk.id
     *
     * @param id the value for t_position_gk.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_position_gk.order_id
     *
     * @return the value of t_position_gk.order_id
     *
     * @mbg.generated
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_position_gk.order_id
     *
     * @param orderId the value for t_position_gk.order_id
     *
     * @mbg.generated
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_position_gk.start_lon
     *
     * @return the value of t_position_gk.start_lon
     *
     * @mbg.generated
     */
    public String getStartLon() {
        return startLon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_position_gk.start_lon
     *
     * @param startLon the value for t_position_gk.start_lon
     *
     * @mbg.generated
     */
    public void setStartLon(String startLon) {
        this.startLon = startLon == null ? null : startLon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_position_gk.start_lat
     *
     * @return the value of t_position_gk.start_lat
     *
     * @mbg.generated
     */
    public String getStartLat() {
        return startLat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_position_gk.start_lat
     *
     * @param startLat the value for t_position_gk.start_lat
     *
     * @mbg.generated
     */
    public void setStartLat(String startLat) {
        this.startLat = startLat == null ? null : startLat.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_position_gk.end_lon
     *
     * @return the value of t_position_gk.end_lon
     *
     * @mbg.generated
     */
    public String getEndLon() {
        return endLon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_position_gk.end_lon
     *
     * @param endLon the value for t_position_gk.end_lon
     *
     * @mbg.generated
     */
    public void setEndLon(String endLon) {
        this.endLon = endLon == null ? null : endLon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_position_gk.end_lat
     *
     * @return the value of t_position_gk.end_lat
     *
     * @mbg.generated
     */
    public String getEndLat() {
        return endLat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_position_gk.end_lat
     *
     * @param endLat the value for t_position_gk.end_lat
     *
     * @mbg.generated
     */
    public void setEndLat(String endLat) {
        this.endLat = endLat == null ? null : endLat.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_position_gk.instant_lon
     *
     * @return the value of t_position_gk.instant_lon
     *
     * @mbg.generated
     */
    public String getInstantLon() {
        return instantLon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_position_gk.instant_lon
     *
     * @param instantLon the value for t_position_gk.instant_lon
     *
     * @mbg.generated
     */
    public void setInstantLon(String instantLon) {
        this.instantLon = instantLon == null ? null : instantLon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_position_gk.instant_lat
     *
     * @return the value of t_position_gk.instant_lat
     *
     * @mbg.generated
     */
    public String getInstantLat() {
        return instantLat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_position_gk.instant_lat
     *
     * @param instantLat the value for t_position_gk.instant_lat
     *
     * @mbg.generated
     */
    public void setInstantLat(String instantLat) {
        this.instantLat = instantLat == null ? null : instantLat.trim();
    }
}