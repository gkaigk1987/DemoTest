package com.gk.test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gk.httpclient.HttpClientUtil;
import com.gk.mapper.OrderStartMapper;
import com.gk.mapper.OrderSuccesMapper;
import com.gk.mapper.PlivateOrderMapper;
import com.gk.mapper.PlivateRouteMapper;
import com.gk.mapper.PositionGkMapper;
import com.gk.mapper.TerminalMapper;
import com.gk.model.PlivateOrder;
import com.gk.model.PlivateOrderExample;
import com.gk.model.PlivateRoute;
import com.gk.model.PlivateRouteExample;
import com.gk.model.PositionGk;
import com.gk.model.PositionGkExample;
import com.gk.model.Terminal;
import com.gk.model.TerminalExample;
import com.gk.util.AMapApi;
import com.gk.util.DateUtil;
import com.gk.util.ExcelUtil;
import com.gk.util.FileUtil;
import com.gk.util.MyBatisUtil;
import com.gk.util.SqlUtil;
import com.gk.util.StringUtil;

public class TestCase {
	
	private static Logger logger = LoggerFactory.getLogger(TestCase.class);

	@Test
	public void test001() {
//		Date date = new Date();
//		long time = date.getTime();
//		System.out.println(time);
//		String string = UUID.randomUUID().toString();
//		System.out.println(string.replaceAll("-", ""));
		
		String a = "2";
		String b = "22";
		String c = "222";
		a = "00" + a;
		a = a.substring(a.length() - 3, a.length());
		System.out.println(a);
		
		b = "00" + b;
		b = b.substring(b.length() - 3, b.length());
		System.out.println(b);
		
		c = "00" + c;
		c = c.substring(c.length() - 3, c.length());
		System.out.println(c);
	}
	
	@Test
	public void test002() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(1553675642L * 1000);
		System.out.println(date);
		String dateStr = simpleDateFormat.format(date);
		System.out.println(dateStr);
		
		Date date2 = new Date();
		long time = date2.getTime() / 1000;
		System.out.println(time);
		date2 = new Date(time * 1000);
		dateStr = simpleDateFormat.format(date2);
		System.out.println(dateStr);
	}
	
	@Test
	public void test003() {
		long time = DateUtil.randomTime("20190320", "20190410");
		System.out.println(time);
		String long2String = DateUtil.long2String(time, "yyyyMMddHHmmss");
		System.out.println(long2String);
	}
	
	/**
	 * 驾驶员处罚信息
	 * @throws IOException
	 */
	@Test
	public void test004() throws IOException {
		String[] reasonArr = new String[] {"放音乐太大声","开车打电话","车内卫生比较差"};
		List<Map<String,Object>> list = ExcelUtil.readExcel("E:/T3/交接事宜/data/t_driver.xls",18,18);
		List<String> driverIdList = list.stream().map(m -> {
			return (String)m.get("col18");
		}).distinct().collect(Collectors.toList());
		List<String> insertSqlList = new ArrayList<>();
		for(int i = 0; i < driverIdList.size(); i++) {
			StringBuffer sb = new StringBuffer();
			String uuid = UUID.randomUUID().toString();
			long time = DateUtil.randomTime("20190320", "20190410");
			String long2String = DateUtil.long2String(time, "yyyyMMddHHmmss");
			Random random = new Random();
			int nextInt = random.nextInt(227);
			String driverId = driverIdList.get(nextInt);
//			System.out.println(i + ":" + nextInt + ":" + driverId);
			String reason = reasonArr[i % 3];
			sb.append("INSERT INTO t_driver_punish (uuid,license_id,punish_time,"
					+ "punish_reason,punish_result,status,create_time) VALUES (")
				.append("'" + uuid.replaceAll("-", "") + "',").append("'").append(driverId)
				.append("','").append(long2String).append("','").append(reason).append("',")
				.append("'培训服务礼仪',").append("'0','").append(long2String).append("');");
			insertSqlList.add(sb.toString());
		}
		FileUtil.fileWrite(new File("E:/T3/交接事宜/data/t_driver_punish.sql"), insertSqlList);
	}
	
	@Test
	public void test005() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//		String time = sdf.format(new Date());
//		System.out.println(time);
		String genOrderNo = StringUtil.genOrderNo("20190320", "20190410", "KC011");
		System.out.println(genOrderNo);
		
		String genOrderNo2 = StringUtil.genOrderNo("20190328203533", "KC011");
		System.out.println(genOrderNo2);
		
		String time = "20190328203533";
		long a = Long.parseLong(time) + new Random().nextInt(100);
		System.out.println(a);
	}
	
	/**
	 * 订单撤销信息
	 * @throws IOException
	 * @throws ParseException 
	 */
	@Test
	public void test006() throws IOException, ParseException {
		List<String> orderNoList = new ArrayList<>();
		List<String> insertSqlList = new ArrayList<>();
		while(orderNoList.size() <= 200) {
			
			long randomTime = DateUtil.randomTime("20190320", "20190410");
			String timeString = DateUtil.long2String(randomTime, "yyyyMMddHHmmss");
			String orderNo = StringUtil.genOrderNo(timeString, "KC011");
			if(orderNoList.contains(orderNo)) {
				continue;
			}
			orderNoList.add(orderNo);
			String cancelTimeString = DateUtil.timePlusRandomSeconds(timeString);
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO t_order_cancel (uuid,address,order_id,order_time,cancel_time,"
					+ "operator,cancel_type_code,status,create_time) VALUES (")
				.append("'"+uuid+"',").append("'320100','").append(orderNo).append("','")
				.append(timeString).append("','").append(String.valueOf(cancelTimeString)).append("','")
				.append("1',").append("'1',").append("'0','").append(String.valueOf(cancelTimeString))
				.append("');");
			insertSqlList.add(sb.toString());
		}
		
		FileUtil.fileWrite(new File("E:/T3/交接事宜/data/t_order_cancel.sql"), insertSqlList);
	}
	
	@Test
	public void test007() throws ParseException {
		Date date = new Date();
		String date2String = DateUtil.date2String(date, "yyyyMMddHHmmss");
		System.out.println(date2String);
//		for(int i = 0; i < 100; i++) {
//			String timePlusRandomSeconds = DateUtil.timePlusRandomSeconds(date2String);
//			System.out.println(timePlusRandomSeconds);
//		}
		
		for(int i = 0; i < 100; i++) {
			String timePlusRandomSeconds = DateUtil.timePlusRandomMinites(date2String);
			System.out.println(timePlusRandomSeconds);
		}
	}
	
	/**
	 * 随机坐标地址转换，并生成excel
	 * @throws IOException
	 */
	@SuppressWarnings("serial")
	@Test
	public void test008() throws IOException {
		double minLon = 118.675013;
		double maxLon = 119.073628;
		double minLat = 31.600461;
		double maxLat = 32.032447;
		List<String> lonlatList = new ArrayList<>();
		while(lonlatList.size() < 200) {
			String randomLonAndLat = StringUtil.getRandomLonAndLat(minLon, maxLon, minLat, maxLat);
			if(!lonlatList.contains(randomLonAndLat)) {
				lonlatList.add(randomLonAndLat);
			}
		}
		List<Map<String, Object>> dataList = new ArrayList<>();
		List<String> locationList = new ArrayList<>();
		for (String lonlat : lonlatList) {
			String address = AMapApi.regeo(lonlat, "base");
			if(StringUtils.isNotEmpty(address)) {
				String location = AMapApi.geo(address, "025");
				if(StringUtils.isNotEmpty(location) && !locationList.contains(location)) {
					Map<String, Object> map = new HashMap<>();
					map.put("address", address);
					map.put("location", location);
					dataList.add(map);
					locationList.add(location);
				}else {
					logger.info("============================地址：{}未获取到坐标信息===========================",address);
				}
			}else {
				logger.info("========================坐标：{}未获取到地址信息========================",lonlat);
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				//ignore
			}
		}
		if(dataList.size() > 0) {
			List<String> headerList = new ArrayList<String>() {
				{
					add("地址");
					add("坐标");
				}
			};
			ExcelUtil.genLocationExcel(headerList, dataList,"E:/address_location_v4.xlsx");
		}
	}
	
	/**
	 * 测试生成excel
	 * @throws IOException
	 */
	@SuppressWarnings("serial")
	@Test
	public void test009() throws IOException {
		List<String> headerList = new ArrayList<String>() {
			{
				add("地址");
				add("坐标");
			}
		};
		List<Map<String, Object>> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			Map<String, Object> map = new HashMap<>();
			map.put("address", "江苏省南京市江宁区横溪街道古柏路");
			map.put("location", "118.815039,31.703916");
			list.add(map);
		}
		ExcelUtil.genLocationExcel(headerList, list,"E:/address_location.xlsx");
	}
	
	@Test
	public void test010() {
		String geo = AMapApi.geo("江苏省南京市溧水区永阳镇永阳街道", "025");
		System.out.println(geo);
	}
	
	@Test
	public void test011() {
		List<Map<String,Object>> list = ExcelUtil.readXmlExcel("E:/address_location_v2.xlsx");
		List<String> posList = new ArrayList<>();
		List<String> addrList = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);
			String addr = (String) map.get("col0");
			addrList.add(addr);
			String lonlat = (String) map.get("col1");
			posList.add(lonlat);
			if(i > 0 && i % 2 == 0) {
				Map<String, Object> driveInfo = AMapApi.driveInfo(posList.get(0), posList.get(1), "all");
				System.out.println("出发地："+addrList.get(0)+",目的地："+addrList.get(1)+",距离：" + (String)driveInfo.get("distance") + "米");
				posList.clear();
				addrList.clear();
			}
			if(i > 10) {
				break;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test012() {
//		String regeo = AMapApi.regeo("119.044331,31.659977", "base");
//		System.out.println(regeo);
		Map<String, Object> driveInfo = AMapApi.driveInfo("118.720597,31.747501", "118.810909,31.911754", "base");
		System.out.println(driveInfo.get("trafficLights"));
		List<String> positionList = (List<String>) driveInfo.get("positionList");
		System.out.println(positionList);
		positionList.stream().forEach(System.out::println);
	}
	
	/**
	 * 生成t_order_start,t_order_succes,t_order_cancel表插入语句
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@Test
	public void test013() throws IOException, ParseException {
		List<String> start_end_list = new ArrayList<>();
		List<Map<String,Object>> list = ExcelUtil.readXmlExcel("E:/address_location_v4_修正.xlsx");
		List<Map<String, Object>> driverInfoList = ExcelUtil.readXmlExcel("E:/T3/交接事宜/车对应司机.xlsx");
		List<String> insertSqlList = new ArrayList<>();
		List<String> succList = new ArrayList<>();
		List<String> cancelList = new ArrayList<>();
 		Random random = new Random();
		for(int i = 0; i < 800; i++) {
			int nextInt = random.nextInt(160);
			int nextInt2 = random.nextInt(160);
			if(nextInt != nextInt2) {
				Map<String, Object> map = list.get(nextInt);	//出发地
				String start = (String) map.get("col0");	//出发地详细地址
				String start_lonLat = (String) map.get("col1");
				String[] split = start_lonLat.split(",");
				String startLon = split[0];
				String startLat = split[1];
				
				Map<String, Object> map2 = list.get(nextInt2);  //目的地
				String end = (String)map2.get("col0");	//目的地详细地址
				String end_lonlat = (String) map2.get("col1");
				String[] split2 = end_lonlat.split(",");
				String endLon = split2[0];
				String endLat = split2[1];
				String start_end = start_lonLat + "-" + end_lonlat;
				if(!start_end_list.contains(start_end)) {
					long randomTime = DateUtil.randomTime("20190320", "20190410");
					String orderTime = DateUtil.long2String(randomTime, "yyyyMMddHHmmss");	//orderTime
					String orderNo = StringUtil.genOrderNo(orderTime, "KC011");	//订单编号
					String departTime = DateUtil.timePlusRandomMinites(orderTime);	//预计用车时间
					String uuid = UUID.randomUUID().toString().replaceAll("-", "");
					StringBuffer sb = new StringBuffer();
					sb.append("INSERT INTO t_order_start(uuid,company_id,address,order_id,depart_time,order_time,departure,"
							+ "dep_longgitude,dep_latitude,destination,dest_longgitude,dest_latitude,encrypt,fare_type,"
							+ "status,create_time) VALUES ('").append(uuid).append("',\'\','").append("320100").append("','")
					.append(orderNo).append("','").append(departTime).append("','").append(orderTime).append("','")
					.append(start).append("','").append(startLon).append("','").append(startLat).append("','")
					.append(end).append("','").append(endLon).append("','").append(endLat).append("','1','")
					.append("T32019040101','0','").append(orderTime).append("');");
					insertSqlList.add(sb.toString());
					if(i < 600) {
						//t_order_succes
						int driverIndex = random.nextInt(220);
						Map<String, Object> driverMap = driverInfoList.get(driverIndex);
						String licenseId = (String) driverMap.get("col3");
						String driverPhone = (String) driverMap.get("col2");
						String carNo = (String) driverMap.get("col0");
						String distributeTime = DateUtil.timePlusRandomSeconds(orderTime);
						String succUuid = UUID.randomUUID().toString().replaceAll("-", "");
						StringBuffer succBuffer = new StringBuffer();
						succBuffer.append("INSERT INTO t_order_succes(uuid,company_id,address,order_id,longgitude,latitude,encrypt,"
								+ "license_id,driver_phone,vehicle_no,distribute_time,status,create_time) VALUES ('")
							.append(succUuid).append("',\'\','").append("320100','").append(orderNo).append("','").append(startLon)
							.append("','").append(startLat).append("','").append("1").append("','").append(licenseId).append("','")
							.append(driverPhone).append("','").append(carNo).append("','").append(distributeTime).append("','0','")
							.append(distributeTime).append("');");
						succList.add(succBuffer.toString());
					}else {
						//t_order_cancel
						String cancelUuid = UUID.randomUUID().toString().replaceAll("-", "");
						String cancelTime = DateUtil.timePlusRandomSeconds(orderTime);
						StringBuffer cancelBuffer = new StringBuffer();
						cancelBuffer.append("INSERT INTO t_order_cancel (uuid,company_id,address,order_id,order_time,cancel_time,"
								+ "operator,cancel_type_code,status,create_time) VALUES ('")
							.append(cancelUuid).append("',\'\','").append("320100','").append(orderNo).append("','")
							.append(orderTime).append("','").append(cancelTime).append("','")
							.append("1',").append("'1',").append("'0','").append(String.valueOf(cancelTime))
							.append("');");
						cancelList.add(cancelBuffer.toString());
					}
				}
			}else {
				if(i > 0) {
					i--;
				}
			}
		}
		if(insertSqlList.size() > 0) {
			FileUtil.fileWrite(new File("E:/T3/交接事宜/data/t_order_start.sql"), insertSqlList);
		}
		if(succList.size() > 0) {
			FileUtil.fileWrite(new File("E:/T3/交接事宜/data/t_order_succes.sql"), succList);
		}
		if(cancelList.size() > 0) {
			FileUtil.fileWrite(new File("E:/T3/交接事宜/data/t_order_cancel.sql"), cancelList);
		}
	}
	
	@Test
	public void test014() {
		String genNeighPosition = StringUtil.genNeighPosition(119.009514, 31.939013, 3);
		System.out.println(genNeighPosition);
	}
	
	/**
	 * t_depart
	 * @throws IOException 
	 */
	@Test
	public void test015() throws IOException {
		List<Map<String, Object>> succList = ExcelUtil.readXmlExcel("E:/t_order_succes.xlsx");
		List<String> insertList = new ArrayList<>();
		for(int i = 0; i < succList.size(); i++) {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			Map<String, Object> map = succList.get(i);
			String orderNo = (String) map.get("col5");
			String licenseId = (String) map.get("col9");
			String fareType = "T32019040101";
			String carNo = (String) map.get("col11");
			String lon = (String) map.get("col6");
			String lat = (String) map.get("col7");
			String encrypt = "1";
			String orderTime = (String) map.get("col12");
			String depTime = DateUtil.timePlusRandomMinites(orderTime);
			String status = "0";
			String createTime = depTime;
			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO t_depart (uuid,company_id,order_id,license_id,fare_type,vehicle_no,"
					+ "dep_longgitude,dep_latitude,encrypt,dep_time,status,create_time) VALUES ('")
				.append(uuid).append("',\'\','").append(orderNo).append("','").append(licenseId).append("','")
				.append(fareType).append("','").append(carNo).append("','").append(lon).append("','").append(lat)
				.append("','").append(encrypt).append("','").append(depTime).append("','").append(status)
				.append("','").append(createTime).append("');");
			insertList.add(sb.toString());
		}
		if(insertList.size() > 0) {
			FileUtil.fileWrite(new File("E:/T3/交接事宜/data/t_depart.sql"), insertList);
		}
	}
	
	@Test
	public void test016() throws IOException {
		List<Map<String, Object>> driverInfoList = ExcelUtil.readXmlExcel("E:/T3/交接事宜/车对应司机.xlsx");
		Map<String, String> driverMap = new HashMap<>();
		for(int i = 0; i < driverInfoList.size(); i++) {
			Map<String, Object> map = driverInfoList.get(i);
			String licenseId = (String) map.get("col3");
			String driverName = (String) map.get("col1");
			driverMap.put(licenseId, driverName);
		}
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		OrderStartMapper orderStartMapper = sqlSession.getMapper(OrderStartMapper.class);
		List<Map<String,Object>> list = orderStartMapper.getOrderInfoList();
		sqlSession.close();
		List<String> arriveList = new ArrayList<>();
		List<String> engagePayList = new ArrayList<>();
		list.stream().forEach(m -> {
			String orderNo = (String) m.get("order_id");	//订单编码
			String depart_time = (String) m.get("depart_time");	//预计上车时间
			String depTime = (String) m.get("dep_time");	//实际上车时间
			String orderTime = (String) m.get("order_time");	//下单时间
			String departure = (String) m.get("departure");	//出发地
			String dep_longgitude = (String) m.get("dep_longgitude");	//出发地经度
			String dep_latitude = (String) m.get("dep_latitude");	//出发地纬度
			String destination = (String) m.get("destination");	//目的地
			String dest_longgitude = (String) m.get("dest_longgitude");	//目的地经度
			String dest_latitude = (String) m.get("dest_latitude");	//目的地纬度
			Map<String, Object> driveInfo = AMapApi.driveInfo(dep_longgitude+","+dep_latitude, dest_longgitude + "," + dest_latitude, "all");
			String distance = (String) driveInfo.get("distance");
			String distanceKm = StringUtil.divide(distance, "1000");	//实际行驶距离
			String duration = (String) driveInfo.get("duration");	//行驶时长
			String taxiCost = (String) driveInfo.get("taxiCost");	//费用
			String arriveTime = DateUtil.timePlus(depTime, Long.valueOf(duration), "SEC");	//下车时间
			String licenseId = (String) m.get("license_id");
			String driverName = driverMap.get(licenseId);	//司机姓名
			String fareType = "T32019040101";
			String address = "320100";
			String carNo = (String) m.get("vehicle_no");
			long waitTime = DateUtil.timeDuration(orderTime, depTime, ChronoUnit.SECONDS);	//等待时间
			StringBuffer arrive = new StringBuffer();
			String arriveUuid = UUID.randomUUID().toString().replaceAll("-", "");
			arrive.append("INSERT INTO t_arrive (uuid,company_id,order_id,dest_longgitude,dest_latitude,"
					+ "encrypt,dep_time,driver_mile,driver_time,status,create_time) VALUES ('")
				.append(arriveUuid).append("',\'\','").append(orderNo).append("','").append(dest_longgitude)
				.append("','").append(dest_latitude).append("','1','").append(arriveTime).append("','")
				.append(distanceKm).append("','").append(duration).append("','0','").append(arriveTime)
				.append("');");
			arriveList.add(arrive.toString());
			
			StringBuffer engagePay = new StringBuffer();
			String egagePayUuid = UUID.randomUUID().toString().replaceAll("-", "");
			engagePay.append("INSERT INTO t_engage_pay (uuid,company_id,order_id,address,driver_name,license_id,"
					+ "fare_type,vehicle_no,book_dep_time,wait_time,dep_longgitude,dep_latitude,dep_area,dep_time,"
					+ "dest_longgitude,dest_latitude,dest_area,dest_time,book_model,model,driver_mile,driver_time,"
					+ "fact_price,price,cash_price,line_name,line_price,benfit_price,book_tip,passenger_tip,peak_up_price,"
					+ "night_up_price,far_up_price,other_price,pay_state,pay_time,order_match_time,invoice_status,status,"
					+ "create_time) VALUES ('").append(egagePayUuid).append("',\'\','").append(orderNo).append("','")
				.append(address).append("','").append(driverName).append("','").append(licenseId).append("','").append(fareType)
				.append("','").append(carNo).append("','").append(depart_time).append("','").append(waitTime).append("','")
				.append(dep_longgitude).append("','").append(dep_latitude).append("','").append(departure).append("','")
				.append(depTime).append("','").append(dest_longgitude).append("','").append(dest_latitude).append("','")
				.append(destination).append("','").append(arriveTime).append("','舒适型','舒适型','").append(distanceKm).append("','")
				.append(duration).append("','").append(taxiCost).append("','").append(taxiCost).append("','0','深圳市财付通科技有限公司','")
				.append(taxiCost).append("','0','0','0','0','0','0','0','1','").append(arriveTime).append("','1','0','")
				.append(arriveTime).append("');");
			engagePayList.add(engagePay.toString());
		});
		if(arriveList.size() > 0) {
			FileUtil.fileWrite(new File("E:/T3/交接事宜/data/t_arrive.sql"), arriveList);
		}
		if(engagePayList.size() > 0) {
			FileUtil.fileWrite(new File("E:/T3/交接事宜/data/t_engage_pay.sql"), engagePayList);
		}
	}
	
	@Test
	public void test017() {
		String a = "114584";
		String b = "1000";
		System.out.println(StringUtil.divide(a, b));
		
		String time = "20190325095632";
		String timePlus = DateUtil.timePlus(time, 3600, "SEC");
		System.out.println(timePlus);
		
		long timeDuration = DateUtil.timeDuration("20190325094619", "20190325095632", ChronoUnit.SECONDS);
		System.out.println(timeDuration);
	}
	
	/**
	 * t_plivate_route
	 * @throws IOException
	 */
	@Test
	public void test018() throws IOException {
		List<Map<String,Object>> list = ExcelUtil.readXmlExcel("E:/address_location_v4_修正.xlsx");
		List<Map<String, Object>> driverInfoList = ExcelUtil.readXmlExcel("E:/T3/交接事宜/车对应司机.xlsx");
		List<String> insertSqlList = new ArrayList<>();
		Random random = new Random();
		for(int i = 0; i < 200; i++) {
			int startInt = random.nextInt(160);
			int endInt = random.nextInt(160);
			if(startInt != endInt) {
				Map<String, Object> startMap = list.get(startInt);
				String startAddr = (String) startMap.get("col0");	//出发地
				String start_lonlat = (String) startMap.get("col1");
				String[] lonlatArr = start_lonlat.split(",");
				String startLon = lonlatArr[0];		//出发地经度
				String startLat = lonlatArr[1];		//出发地纬度
				
				Map<String, Object> endMap = list.get(endInt);
				String endAddr = (String) endMap.get("col0");	//目的地
				String end_lonlat = (String) endMap.get("col1");
				lonlatArr = end_lonlat.split(",");
				String endLon = lonlatArr[0];	//目的地经度
				String endLat = lonlatArr[1];	//目的地纬度
				
				int driverInt = random.nextInt(220);
				Map<String, Object> driverMap = driverInfoList.get(driverInt);
				String driverName = (String) driverMap.get("col1");
				String driverPhone = (String) driverMap.get("col2");
				String lisenceId = (String) driverMap.get("col3");
				String carNo = (String) driverMap.get("col0");
				long randomTime = DateUtil.randomTime("20190320", "20190410");
				String startTime = DateUtil.long2String(randomTime, "yyyyMMddHHmmss");
				String address = "320100";
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				Map<String, Object> driveInfo = AMapApi.driveInfo(start_lonlat, end_lonlat, "base");
				String distance = (String) driveInfo.get("distance");
				distance = StringUtil.divide(distance, "1000");
				StringBuffer sb = new StringBuffer();
				sb.append("INSERT INTO t_plivate_route (uuid,company_id,address,route_id,driver_name,driver_phone,"
						+ "license_id,vehicle_no,departure,dep_longgitude,dep_latitude,destination,dest_longgitude,"
						+ "dest_latitude,encrypt,route_create_time,route_mile,status,create_time) VALUES ('")
					.append(uuid).append("',\'\','").append(address).append("','").append(uuid).append("','")
					.append(driverName).append("','").append(driverPhone).append("','").append(lisenceId).append("','")
					.append(carNo).append("','").append(startAddr).append("','").append(startLon).append("','")
					.append(startLat).append("','").append(endAddr).append("','").append(endLon).append("','")
					.append(endLat).append("','1','").append(startTime).append("','").append(distance).append("','0','")
					.append(startTime).append("');");
				insertSqlList.add(sb.toString());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				if(i > 0) {
					i--;
				}
			}
		}
		if(insertSqlList.size() > 0) {
			FileUtil.fileWrite(new File("E:/T3/交接事宜/data/t_plivate_route.sql"), insertSqlList);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test019() throws IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		OrderStartMapper orderStartMapper = sqlSession.getMapper(OrderStartMapper.class);
		List<Map<String,Object>> list = orderStartMapper.getOrderInfoList();
		sqlSession.close();
		List<String> insertSqlList = new ArrayList<>();
		try {
			for (Map<String, Object> map : list) {
				String orderId = (String) map.get("order_id");	//订单编号
				String address = (String) map.get("address");	//行政区代码
				String depTime = (String) map.get("dep_time");	//乘客上传时间
				String carNo = (String) map.get("vehicle_no");	//车辆号牌
				String licenseId = (String) map.get("license_id");	//机动车驾驶证号
				String startLon = (String) map.get("dep_longgitude");
				String startLat = (String) map.get("dep_latitude");
				String start_lon_lat = startLon + "," + startLat;
				String endLon = (String) map.get("dest_longgitude");
				String endLat = (String) map.get("dest_latitude");
				String end_lon_lat = endLon + "," + endLat;
				Map<String, Object> driveInfo = AMapApi.driveInfo(start_lon_lat, end_lon_lat, "base");
				List<String> positionList = (List<String>) driveInfo.get("positionList");
				for (String position : positionList) {
					String[] pArr = position.split(",");
					String lon = pArr[0];
					String lat = pArr[1];
					StringBuffer sb = new StringBuffer();
					sb.append("INSERT INTO t_position_gk(order_id,start_lon,start_lat,end_lon,end_lat,instant_lon,instant_lat)")
						.append(" VALUES ('").append(orderId).append("','").append(startLon).append("','").append(startLat)
						.append("','").append(endLon).append("','").append(endLat).append("','").append(lon).append("','")
						.append(lat).append("');");
					insertSqlList.add(sb.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(insertSqlList.size() > 0) {
			FileUtil.fileWrite(new File("E:/t_position_gk.sql"), insertSqlList);
		}
	}
	
	/**
	 * 车辆模拟途中行驶
	 * @throws IOException
	 */
	@Test
	public void test020() throws IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		OrderSuccesMapper orderSuccesMapper = sqlSession.getMapper(OrderSuccesMapper.class);
		List<Map<String,Object>> list = orderSuccesMapper.getRouteInfoList(null);
		
		PositionGkMapper positionGkMapper = sqlSession.getMapper(PositionGkMapper.class);
		PositionGkExample example = new PositionGkExample();
		
		List<String> driverPositionList = new ArrayList<>();
		List<String> carPositionList = new ArrayList<>();
		for(Map<String, Object> map : list) {
			String orderId = (String) map.get("order_id");
			//根据订单查询路程所有坐标定位
			example.clear();
			example.createCriteria().andOrderIdEqualTo(orderId);
			List<PositionGk> positionGkList = positionGkMapper.selectByExample(example);
			if(null != positionGkList && positionGkList.size() > 0) {
				String licenseId = (String) map.get("license_id");
				String address = "320100";
				String carNo = (String) map.get("vehicle_no");
				String encrypt = "1";
				String bizStatus = "1";
				PositionGk positionGk2 = positionGkList.get(0);
				String startLon = positionGk2.getStartLon();
				String startLat = positionGk2.getStartLat();
				String endLon = positionGk2.getEndLon();
				String endLat = positionGk2.getEndLat();
				
				String startTime = (String) map.get("park_time");	//乘客上车时间
//				String endTime = (String) map.get("arrive_time");	
				String driveTime = (String) map.get("driver_time");	//车辆行驶时间
				int driveTimeInt = Integer.valueOf(driveTime);
//				System.out.println("driveTimeInt : " + driveTimeInt);
				int positionNum = ((Long) map.get("positionNum")).intValue();	//多少个定位
//				System.out.println("positionNum : " + positionNum);
				int assumeLights = driveTimeInt / 100;	//虚拟红绿灯数
//				System.out.println("assumeLights : " + assumeLights);
				int movingPositions = positionNum - assumeLights;	//移动中的坐标数
//				System.out.println("movingPositions : " + movingPositions);
				int movingTime = movingPositions * 3;	//车辆行驶中的坐标所花的时间
//				System.out.println("movingTime : " + movingTime);
				int totalWaitTime = 0;	//模拟的所有等红绿灯的时间，随机出来的
				List<Integer> pointWaitTimeList = new ArrayList<>();	//每次等红绿灯的时间列表
				while(true) {
					for(int i = 0; i < assumeLights; i++) {
						int randomWaitTime = (new Random().nextInt(20) + 7) * 3;
						pointWaitTimeList.add(randomWaitTime);
						totalWaitTime += randomWaitTime;
					}
					if(driveTimeInt - totalWaitTime - movingTime > 30) {
						break;
					}
					totalWaitTime = 0;
					pointWaitTimeList.clear();
				}
				List<Integer> positionIndexList = new ArrayList<>();	//随机的需要等红绿灯坐标索引列表
				Random random = new Random();
				for(int i = 0; i < assumeLights; i++) {
					int index = random.nextInt(positionNum - 1);
					if(!positionIndexList.contains(index)) {
						positionIndexList.add(index);
					}else {
						i--;
					}
				}
				positionIndexList.sort((l1,l2) -> l1.compareTo(l2));	//随机数列表排序
//				positionIndexList = positionIndexList.stream().sorted().collect(Collectors.toList());
				
				int totalTime = 0;	//模拟所有情况所花的时间
				int randomStartTime = random.nextInt(10) + 10;	//起始坐标默认静止
				for(int i = 0; i < randomStartTime; i++) {
					String timePlus = DateUtil.timePlus(startTime, totalTime, "SEC");
					Map<String, String> driverMap = new HashMap<>();
					driverMap.put("licenseId", licenseId);
					driverMap.put("address", address);
					driverMap.put("carNo", carNo);
					driverMap.put("positionTime", timePlus);
					driverMap.put("lon", startLon);
					driverMap.put("lat", startLat);
					driverMap.put("encrypt", encrypt);
					driverMap.put("bizStatus", bizStatus);
					driverMap.put("orderId", orderId);
					driverMap.put("status", "0");
					driverMap.put("createTime", timePlus);
					String genDriverPositionInsert = SqlUtil.genDriverPositionInsert(driverMap);
					driverPositionList.add(genDriverPositionInsert);
					
					Map<String, String> carMap = new HashMap<>();
					carMap.put("carNo", carNo);
					carMap.put("address", address);
					carMap.put("positionTime", timePlus);
					carMap.put("lon", startLon);
					carMap.put("lat", startLat);
					carMap.put("encrypt", encrypt);
					carMap.put("bizStatus", bizStatus);
					carMap.put("orderId", orderId);
					carMap.put("status", "0");
					carMap.put("createTime", timePlus);
					String genCarPositionInsert = SqlUtil.genCarPositionInsert(carMap);
					carPositionList.add(genCarPositionInsert);
					
					totalTime += 3;
				}
				int k = 0;
				for(int i = 0; i < positionGkList.size(); i++) {
					PositionGk positionGk = positionGkList.get(i);
					String instantLon = positionGk.getInstantLon();
					String instantLat = positionGk.getInstantLat();
					//停止等待的坐标
					if(positionIndexList.contains(i)) {
						Integer waitTime = pointWaitTimeList.get(k);
						int times = waitTime / 3;
						for(int j = 0; j < times; j++) {
							totalTime += 3;
							String timePlus = DateUtil.timePlus(startTime, totalTime, "SEC");
							Map<String, String> driverMap = new HashMap<>();
							driverMap.put("licenseId", licenseId);
							driverMap.put("address", address);
							driverMap.put("carNo", carNo);
							driverMap.put("positionTime", timePlus);
							driverMap.put("lon", instantLon);
							driverMap.put("lat", instantLat);
							driverMap.put("encrypt", encrypt);
							driverMap.put("bizStatus", bizStatus);
							driverMap.put("orderId", orderId);
							driverMap.put("status", "0");
							driverMap.put("createTime", timePlus);
							String genDriverPositionInsert = SqlUtil.genDriverPositionInsert(driverMap);
							driverPositionList.add(genDriverPositionInsert);
							
							Map<String, String> carMap = new HashMap<>();
							carMap.put("carNo", carNo);
							carMap.put("address", address);
							carMap.put("positionTime", timePlus);
							carMap.put("lon", instantLon);
							carMap.put("lat", instantLat);
							carMap.put("encrypt", encrypt);
							carMap.put("bizStatus", bizStatus);
							carMap.put("orderId", orderId);
							carMap.put("status", "0");
							carMap.put("createTime", timePlus);
							String genCarPositionInsert = SqlUtil.genCarPositionInsert(carMap);
							carPositionList.add(genCarPositionInsert);
						}
						k++;
					}else {
						totalTime += 3;
						String timePlus = DateUtil.timePlus(startTime, totalTime, "SEC");
						Map<String, String> driverMap = new HashMap<>();
						driverMap.put("licenseId", licenseId);
						driverMap.put("address", address);
						driverMap.put("carNo", carNo);
						driverMap.put("positionTime", timePlus);
						driverMap.put("lon", instantLon);
						driverMap.put("lat", instantLat);
						driverMap.put("encrypt", encrypt);
						driverMap.put("bizStatus", bizStatus);
						driverMap.put("orderId", orderId);
						driverMap.put("status", "0");
						driverMap.put("createTime", timePlus);
						String genDriverPositionInsert = SqlUtil.genDriverPositionInsert(driverMap);
						driverPositionList.add(genDriverPositionInsert);
						
						Map<String, String> carMap = new HashMap<>();
						carMap.put("carNo", carNo);
						carMap.put("address", address);
						carMap.put("positionTime", timePlus);
						carMap.put("lon", instantLon);
						carMap.put("lat", instantLat);
						carMap.put("encrypt", encrypt);
						carMap.put("bizStatus", bizStatus);
						carMap.put("orderId", orderId);
						carMap.put("status", "0");
						carMap.put("createTime", timePlus);
						String genCarPositionInsert = SqlUtil.genCarPositionInsert(carMap);
						carPositionList.add(genCarPositionInsert);
					}
				}
				int endWaitTime = driveTimeInt - totalTime;
				int endTimes = endWaitTime / 3;
				//目的地点坐标静止时间
				if(endWaitTime % 3 > 0) {
					endTimes += 1;
				}
				for(int i = 0; i < endTimes; i++) {
					totalTime += 3;
					String timePlus = DateUtil.timePlus(startTime, totalTime, "SEC");
					Map<String, String> driverMap = new HashMap<>();
					driverMap.put("licenseId", licenseId);
					driverMap.put("address", address);
					driverMap.put("carNo", carNo);
					driverMap.put("positionTime", timePlus);
					driverMap.put("lon", endLon);
					driverMap.put("lat", endLat);
					driverMap.put("encrypt", encrypt);
					driverMap.put("bizStatus", bizStatus);
					driverMap.put("orderId", orderId);
					driverMap.put("status", "0");
					driverMap.put("createTime", timePlus);
					String genDriverPositionInsert = SqlUtil.genDriverPositionInsert(driverMap);
					driverPositionList.add(genDriverPositionInsert);
					
					Map<String, String> carMap = new HashMap<>();
					carMap.put("carNo", carNo);
					carMap.put("address", address);
					carMap.put("positionTime", timePlus);
					carMap.put("lon", endLon);
					carMap.put("lat", endLat);
					carMap.put("encrypt", encrypt);
					carMap.put("bizStatus", bizStatus);
					carMap.put("orderId", orderId);
					carMap.put("status", "0");
					carMap.put("createTime", timePlus);
					String genCarPositionInsert = SqlUtil.genCarPositionInsert(carMap);
					carPositionList.add(genCarPositionInsert);
				}
			}
		}
		sqlSession.close();
		if(driverPositionList.size() > 0) {
			FileUtil.fileWrite(new File("E:/T3/交接事宜/data/t_driver_position.sql"), driverPositionList);
		}
		if(carPositionList.size() > 0) {
			FileUtil.fileWrite(new File("E:/T3/交接事宜/data/t_vehicle_position.sql"), carPositionList);
		}
	}
	
	@Test
	public void test021() {
		for(int i = 0; i < 30; i++) {
			int randomWaitTime = (new Random().nextInt(20) + 5) * 3;
			System.out.println(randomWaitTime);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test022() throws ParseException, IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		PlivateRouteMapper plivateRouteMapper = sqlSession.getMapper(PlivateRouteMapper.class);
		PlivateRouteExample example = new PlivateRouteExample();
		example.createCriteria().andUuidNotEqualTo("1");
		List<PlivateRoute> orderList = plivateRouteMapper.selectByExample(example);
		sqlSession.close();
		List<String> orderInsertList = new ArrayList<>();
		List<String> orderPayInsertList = new ArrayList<>();
		for(int i = 0; i < orderList.size(); i++) {
			PlivateRoute plivateRoute = orderList.get(i);
			String routeId = plivateRoute.getRouteId();		//行程ID
			String driverName = plivateRoute.getDriverName();	//驾驶员姓名
			String driverPhone = plivateRoute.getDriverPhone();	//驾驶员手机号
			String licenseId = plivateRoute.getLicenseId();	//机动车驾驶证编号
			String vehicleNo = plivateRoute.getVehicleNo();	//机动车号牌
			String depLonggitude = plivateRoute.getDepLonggitude();
			String depLatitude = plivateRoute.getDepLatitude();
			String start_lon_lat = depLonggitude + "," + depLatitude;
			String destLonggitude = plivateRoute.getDestLonggitude();
			String destLatitude = plivateRoute.getDestLatitude();
			String end_lon_lat = destLonggitude + "," + destLatitude;
			
			String routeCreateTime = plivateRoute.getRouteCreateTime();
			Map<String, Object> driveInfo = AMapApi.driveInfo(start_lon_lat, end_lon_lat, "base");
			String distance = (String) driveInfo.get("driveInfo");
			Random random = new Random();
			int randomPassengerNum = random.nextInt(4);	//随机载客人数
			String duration = (String) driveInfo.get("duration");	//行程所花时间
			List<String> positionList = (List<String>) driveInfo.get("positionList");	//行程所有坐标
			int positionSize = positionList.size();
			List<Integer> positionIndexList = new ArrayList<>();
			for(int j = 0; j < randomPassengerNum * 2; j++) {
				int positionIndex = random.nextInt(positionSize);
				if(!positionIndexList.contains(positionIndex)) {
					positionIndexList.add(positionIndex);
				}else {
					j--;
				}
			}
			positionIndexList.sort((v1,v2) -> v1.compareTo(v2));
			for(int j = 0; j < randomPassengerNum; j++) {
				String startPosition = positionList.get(positionIndexList.get(j));
				String startLon = startPosition.split(",")[0];
				String startLat = startPosition.split(",")[1];
				String endPosition = positionList.get(positionIndexList.get(j + randomPassengerNum));
				String endLon = endPosition.split(",")[0];
				String endLat = endPosition.split(",")[1];
				Map<String, Object> partPassengerMap = AMapApi.driveInfo(start_lon_lat, startPosition, "base");
				String partPassengerDuration = (String) partPassengerMap.get("duration");	//接客所花时间
				String expectTime = DateUtil.timePlus(routeCreateTime, Long.valueOf(partPassengerDuration), "SEC");	//预计上车时间
				String orderEnsureTime = DateUtil.timeMinusRandomSeconds(expectTime);	//订单确认时间
				String orderId = StringUtil.genOrderNo(expectTime, "HC001");
				String actTime = DateUtil.timePlusRandomSeconds(expectTime);	//实际上车时间
				String startAddr = AMapApi.regeo(startPosition, "base");
				String endAddr = AMapApi.regeo(endPosition, "base");
				Map<String, Object> partDriverMap = AMapApi.driveInfo(startPosition, endPosition, "all");
				String driveDistance = (String) partDriverMap.get("distance");	//载客里程
				driveDistance = StringUtil.divide(driveDistance, "1000");
				String partDuration = (String) partDriverMap.get("duration");	//载客时间
				String destTime = DateUtil.timePlus(actTime, Long.valueOf(partDuration), "SEC");	//实际下车时间
				String cost = (String) partDriverMap.get("taxiCost");	//路费
				//拼装order插入map
				Map<String, String> orderMap = new HashMap<>();
				orderMap.put("routeId", routeId);
				orderMap.put("orderId", orderId);
				orderMap.put("bookDepartTime", expectTime);
				orderMap.put("departure", startAddr);
				orderMap.put("depLon", startLon);
				orderMap.put("depLat", startLat);
				orderMap.put("destination", endAddr);
				orderMap.put("destLon", endLon);
				orderMap.put("destLat", endLat);
				orderMap.put("orderEnsureTime", orderEnsureTime);
				orderMap.put("createTime", orderEnsureTime);
				String genPrivateOrderInsert = SqlUtil.genPrivateOrderInsert(orderMap);
				orderInsertList.add(genPrivateOrderInsert);
				
				//拼装orderPay插入map
				Map<String, String> orderPayMap = new HashMap<>();
				orderPayMap.put("routeId", routeId);
				orderPayMap.put("orderId", orderId);
				orderPayMap.put("driverPhone", driverPhone);
				orderPayMap.put("licenseId", licenseId);
				orderPayMap.put("carNo", vehicleNo);
				orderPayMap.put("bookDepartTime", expectTime);
				orderPayMap.put("depTime", actTime);
				orderPayMap.put("departure", startAddr);
				orderPayMap.put("depLon", startLon);
				orderPayMap.put("depLat", startLat);
				orderPayMap.put("destTime", destTime);
				orderPayMap.put("destination", endAddr);
				orderPayMap.put("destLon", endLon);
				orderPayMap.put("destLat", endLat);
				orderPayMap.put("driveDistance", driveDistance);
				orderPayMap.put("partDuration", partDuration);
				orderPayMap.put("cost", cost);
				orderPayMap.put("payTime", destTime);
				orderPayMap.put("createTime", actTime);
				String genPrivateOrderPayInsert = SqlUtil.genPrivateOrderPayInsert(orderPayMap);
				orderPayInsertList.add(genPrivateOrderPayInsert);
			}
		}
		if(orderInsertList.size() > 0) {
			FileUtil.fileWrite(new File("E:/T3/交接事宜/data/t_plivate_order.sql"), orderInsertList);
		}
		if(orderPayInsertList.size() > 0) {
			FileUtil.fileWrite(new File("E:/T3/交接事宜/data/t_plivate_order_pay.sql"), orderPayInsertList);
		}
	}
	
	@Test
	public void test023() {
		String time = "20190408140433";
		String timeMinusRandomSeconds = DateUtil.timeMinusRandomSeconds(time);
		System.out.println(timeMinusRandomSeconds);
	}
	
	@Test
	public void test024() {
		long randomTime = DateUtil.randomTime("20190325050000", "20190325090000", "yyyyMMddHHmmss");
		String long2String = DateUtil.long2String(randomTime, "yyyyMMddHHmmss");
		System.out.println(long2String);
		
		String startDay = "20190325";
		String dayPlus = DateUtil.dayPlus(startDay, 4);
		System.out.println(dayPlus);
	}
	
	@Test
	public void test025() throws IOException {
		Random random = new Random();
		String startDay = "20190325";
		List<Integer> randomList = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			int nextInt = random.nextInt(20);
			if(!randomList.contains(nextInt)) {
				randomList.add(nextInt);
			}else {
				i--;
			}
		}
		randomList.sort((v1,v2) -> v1.compareTo(v2));
		List<String> onlineList = new ArrayList<>();
		List<String> offlineList = new ArrayList<>();
		for(int i = 0; i < randomList.size(); i++) {
			String newDay = DateUtil.dayPlus(startDay, randomList.get(i));
			for(int j = 0; j < 220; j++) {
				String onlineStart = newDay + "050000";
				String onlineEnd = newDay + "090000";
				long randomOnlineTime = DateUtil.randomTime(onlineStart, onlineEnd, "yyyyMMddHHmmss");
				String onlineTime = DateUtil.long2String(randomOnlineTime, "yyyyMMddHHmmss");
				onlineList.add(onlineTime);
				
				String offlineStart = newDay + "220000";
				String offlineEnd = newDay + "235959";
				long randomOfflineTime = DateUtil.randomTime(offlineStart, offlineEnd, "yyyyMMddHHmmss");
				String offlineTime = DateUtil.long2String(randomOfflineTime, "yyyyMMddHHmmss");
				offlineList.add(offlineTime);
			}
		}
		if(onlineList.size() > 0) {
			FileUtil.fileWrite(new File("E:/online.txt"), onlineList);
		}
		if(offlineList.size() > 0) {
			FileUtil.fileWrite(new File("E:/offline.txt"), offlineList);
		}
		
	}
	
	@Test
	public void test026() throws IOException {
		List<String> uuidList = new ArrayList<>();
		for(int i = 0; i < 600; i++) {
			uuidList.add(UUID.randomUUID().toString().replaceAll("-", ""));
		}
		if(uuidList.size() > 0) {
			FileUtil.fileWrite(new File("E:/uuid.txt"), uuidList);
		}
	}
	
	/**
	 * 每小时只能调用50次
	 * @throws IOException
	 */
	@Test
	public void test027() throws IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		TerminalMapper terminalMapper = sqlSession.getMapper(TerminalMapper.class);
		List<String> updateList = new ArrayList<>();
		List<Terminal> list = terminalMapper.selectByExample(new TerminalExample());
		for (Terminal terminal : list) {
			String uuid = terminal.getUuid();
			String phone = terminal.getDriverPhone();
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("app", "phone.get");
			paramMap.put("phone", phone);
			paramMap.put("appkey", "10003");
			paramMap.put("sign", "b59bc3ef6191eb9f747dd4e83c99f2a4");
			paramMap.put("format", "json");
			JSONObject json = HttpClientUtil.doGet("http://api.k780.com:88/", paramMap);
			Object object = json.get("result");
			if(null != object) {
				String jsonString = JSONObject.toJSONString(object);
				JSONObject parseObject = JSON.parseObject(jsonString);
				Object object2 = parseObject.get("operators");
				if(null != object2) {
					String netType = (String) object2;
					StringBuffer sb = new StringBuffer();
					sb.append("UPDATE t_terminal SET net_type = '").append(netType).append("' WHERE uuid = '")
					.append(uuid).append("';");
					updateList.add(sb.toString());
				}else {
					logger.warn("{}未获取到运营商",phone);
				}
			}else {
				logger.warn("{}未获取到运营商",phone);
			}
			
		}
		if(updateList.size() > 0) {
			FileUtil.fileWrite(new File("E:/update_terminal.sql"), updateList);
		}
	}
	
	@Test
	public void test028() throws IOException {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		TerminalMapper terminalMapper = sqlSession.getMapper(TerminalMapper.class);
		List<String> updateList = new ArrayList<>();
		List<Terminal> list = terminalMapper.selectByExample(new TerminalExample());
		for (Terminal terminal : list) {
			String uuid = terminal.getUuid();
			String phone = terminal.getDriverPhone();
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("mobile", phone);
			JSONObject json = HttpClientUtil.doGet("https://www.iteblog.com/api/mobile.php", paramMap);
			String netType = (String) json.get("operator");
			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE t_terminal SET net_type = '").append(netType).append("' WHERE uuid = '")
			.append(uuid).append("';");
			updateList.add(sb.toString());
		}
		if(updateList.size() > 0) {
			FileUtil.fileWrite(new File("E:/update_terminal.sql"), updateList);
		}
	}
	
	@Test
	public void test029() throws IOException {
		List<Map<String,Object>> list = ExcelUtil.readXmlExcel("E:/T3/交接事宜/手机号对应运营商信息.xlsx");
		List<String> updateList = new ArrayList<>();
		for (Map<String, Object> map : list) {
			String phone = (String) map.get("col0");
			String type = (String) map.get("col1");
			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE t_terminal SET net_type = '").append(type).append("' WHERE driver_phone = '")
				.append(phone).append("';");
			updateList.add(sb.toString());
		}
		if(updateList.size() > 0) {
			FileUtil.fileWrite(new File("E:/update_terminal.sql"), updateList);
		}
	}
}
