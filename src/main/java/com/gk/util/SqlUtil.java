package com.gk.util;

import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqlUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SqlUtil.class);
	
	/**
	 * 生成t_driver_position insert sql 语句
	 * @param map
	 * @return
	 */
	public static String genDriverPositionInsert(Map<String, String> map) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO t_driver_position (uuid,company_id,license_id,address,vehicle_no,position_time,"
				+ "longgitude,latitude,encrypt,biz_status,order_id,status,create_time) VALUES ('").append(uuid)
			.append("',\'\','").append(map.get("licenseId")).append("','").append(map.get("address")).append("','")
			.append(map.get("carNo")).append("','").append(map.get("positionTime")).append("','").append(map.get("lon"))
			.append("','").append(map.get("lat")).append("','").append(map.get("encrypt")).append("','").append(map.get("bizStatus"))
			.append("','").append(map.get("orderId")).append("','").append(map.get("status")).append("','").append(map.get("createTime"))
			.append("');");
		LOGGER.info("生成t_driver_position插入语句：{}",sb.toString());
		return sb.toString();
	}
	
	/**
	 * 生成t_vehicle_position insert sql 语句
	 * @param map
	 * @return
	 */
	public static String genCarPositionInsert(Map<String, String> map) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO t_vehicle_position (uuid,company_id,vehicle_no,address,position_time,longgitude,"
				+ "latitude,encrypt,biz_status,order_id,status,create_time) VALUES ('").append(uuid).append("',\'\','")
			.append(map.get("carNo")).append("','").append(map.get("address")).append("','").append(map.get("positionTime"))
			.append("','").append(map.get("lon")).append("','").append(map.get("lat")).append("','")
			.append(map.get("encrypt")).append("','").append(map.get("bizStatus")).append("','").append(map.get("orderId"))
			.append("','").append(map.get("status")).append("','").append(map.get("createTime")).append("');");
		LOGGER.info("生成t_vehicle_position插入语句：{}",sb.toString());
		return sb.toString();
	}
	
	/**
	 * 生成t_plivate_order insert sql 语句
	 * @param map
	 * @return
	 */
	public static String genPrivateOrderInsert(Map<String, String> map) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO t_plivate_order (uuid,company_id,address,route_id,order_id,book_depart_time,"
				+ "departure,dep_longgitude,dep_latitude,destination,dest_longgitude,dest_latitude,encrypt,"
				+ "order_ensure_time,passenger_num,status,create_time) VALUES ('").append(uuid).append("',\'\','")
			.append("320100").append("','").append(map.get("routeId")).append("','").append(map.get("orderId"))
			.append("','").append(map.get("bookDepartTime")).append("','").append(map.get("departure")).append("','")
			.append(map.get("depLon")).append("','").append(map.get("depLat")).append("','").append(map.get("destination"))
			.append("','").append(map.get("destLon")).append("','").append(map.get("destLat")).append("','1','")
			.append(map.get("orderEnsureTime")).append("',1,'0','").append(map.get("createTime")).append("');");
		LOGGER.info("生成t_plivate_order插入语句：{}",sb.toString());
		return sb.toString();
	}
	
	/**
	 * 生成t_plivate_order_pay insert sql 语句
	 * @param map
	 * @return
	 */
	public static String genPrivateOrderPayInsert(Map<String, String> map) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO t_plivate_order_pay (uuid,company_id,address,route_id,order_id,driver_phone,"
				+ "license_id,vehicle_no,fare_type,book_depart_time,depart_time,departure,dep_longgitude,dep_latitude,"
				+ "dest_time,destination,dest_longgitude,dest_latitude,encrypt,driver_mile,driver_time,fact_price,"
				+ "price,cash_price,line_name,line_price,pay_state,passenger_num,pay_time,order_match_time,status,"
				+ "create_time) VALUES ('").append(uuid).append("',\'\','").append(map.get("routeId")).append("','")
			.append(map.get("orderId")).append("','").append(map.get("driverPhone")).append("','").append(map.get("licenseId"))
			.append("','").append(map.get("carNo")).append("','T32019040101','").append(map.get("bookDepartTime")).append("','")
			.append(map.get("depTime")).append("','").append(map.get("departure")).append("','").append(map.get("depLon"))
			.append("','").append(map.get("depLat")).append("','").append(map.get("destTime")).append("','").append(map.get("destination"))
			.append("','").append(map.get("destLon")).append("','").append(map.get("destLat")).append("','1','").append(map.get("driveDistance"))
			.append("','").append(map.get("partDuration")).append("','").append(map.get("cost")).append("','").append(map.get("cost"))
			.append("','0','深圳市财付通科技有限公司','").append(map.get("cost")).append("','1','1','").append(map.get("payTime"))
			.append("','").append(map.get("payTime")).append("','0','").append(map.get("createTime")).append("');");
		LOGGER.info("生成t_plivate_order_pay插入语句：{}",sb.toString());
		return sb.toString();
	}
	
}
