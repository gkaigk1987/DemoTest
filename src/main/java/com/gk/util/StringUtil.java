package com.gk.util;

import java.math.BigDecimal;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

	/**
	 * 获取某一时间段内的订单编号
	 * @param start
	 * @param end
	 * @param type
	 * @return
	 */
	public static String genOrderNo(String start,String end,String type) {
		long randomTime = DateUtil.randomTime(start, end);
		String long2String = DateUtil.long2String(randomTime, "yyyyMMddHHmmss");
		if(StringUtils.isEmpty(long2String)) {
			return null;
		}
		Random random = new Random();
		int nextInt = random.nextInt(1000);
		String suffix = "00" + String.valueOf(nextInt);
		suffix = suffix.substring(suffix.length() - 3,suffix.length());
		return type + long2String + suffix;
	}
	
	/**
	 * 获取某个时间点的订单编号
	 * @param time
	 * @param type
	 * @return
	 */
	public static String genOrderNo(String time,String type) {
		Random random = new Random();
		int nextInt = random.nextInt(1000);
		String suffix = "00" + String.valueOf(nextInt);
		suffix = suffix.substring(suffix.length() - 3,suffix.length());
		return type + time + suffix;
	}
	
	/**
	 * 范围内随机坐标
	 * @param minLon
	 * @param maxLon
	 * @param minLat
	 * @param maxLat
	 * @return
	 */
	public static String getRandomLonAndLat(double minLon,double maxLon,double minLat,double maxLat) {
	    BigDecimal db = new BigDecimal(Math.random() * (maxLon - minLon) + minLon);
	    String lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();// 小数后6位
	    db = new BigDecimal(Math.random() * (maxLat - minLat) + minLat);
	    String lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
	    return lon + "," + lat;
	}
	
	/**
	 * 
	 * @param lon
	 * @param lat
	 * @param range
	 * @return
	 */
	public static String genNeighPosition(double lon,double lat, double range) {
		double r = 6371;// 地球半径千米
		double dis = range;// range千米距离
		double dlng = 2 * Math.asin(Math.sin(dis / (2 * r)) / Math.cos(lat * Math.PI / 180));
		dlng = dlng * 180 / Math.PI;// 角度转为弧度
		double dlat = dis / r;
		dlat = dlat * 180 / Math.PI;
		double minlat =lat - dlat;
        double maxlat = lat + dlat;
        double minlng = lon - dlng;
        double maxlng = lon + dlng;
        return getRandomLonAndLat(minlng,maxlng,minlat,maxlat);
	}
	
	public static String divide(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		BigDecimal divide = b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP);
		return divide.toString();
	}
}
 