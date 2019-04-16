package com.gk.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gk.httpclient.HttpClientUtil;

public class HttpClientTest {

	/**
	 * 高德地图起始点与结束点路线规划测试
	 */
	@Test
	public void test001() {
		String url = "https://restapi.amap.com/v3/direction/driving";
		Map<String, Object> map = new HashMap<>();
		map.put("key", "df13db4f416440c35a8da58cf20082d3");
//		map.put("origin", "118.805588,31.845021");
		map.put("origin", "118.714139,31.808483");
//		map.put("destination", "118.779989,31.823956");
		map.put("destination", "118.811128,31.911901");
		map.put("extensions", "base");
		JSONObject json = HttpClientUtil.doGet(url, map);
		System.out.println(json);
		JSONObject routeJSON = JSON.parseObject(JSONObject.toJSONString(json.get("route")));
		String taxiCost = (String) routeJSON.get("taxi_cost");	//打车所需费用
		System.out.println("打车费用：" + taxiCost);
		JSONArray pathsJSONArray = JSONArray.parseArray(JSONObject.toJSONString(routeJSON.get("paths")));
		Object object = pathsJSONArray.get(0);
		JSONObject pathsJSON = JSON.parseObject(JSONObject.toJSONString(object));
		String distance = (String) pathsJSON.get("distance"); //路程
		System.out.println("路程距离：" + distance);
		
		String duration = (String) pathsJSON.get("duration"); //大致所需时间
		System.out.println("大致所需时间：" + duration + "秒");
		
		String trafficLights = (String)pathsJSON.get("traffic_lights");
		System.out.println("红绿灯个数：" + trafficLights + "个");
		
		JSONArray stepsArray = JSONArray.parseArray(JSONObject.toJSONString(pathsJSON.get("steps")));
		List<String> positionList = new ArrayList<>();
		int i = 0;
		for (Object stepO : stepsArray) {
			JSONObject stepJSON = JSON.parseObject(JSONObject.toJSONString(stepO));
			String positions = (String)stepJSON.get("polyline");
			if(StringUtils.isNotEmpty(positions)) {
				String[] split = positions.split(";");
				for (int k = 0; k < split.length; k++) {
					if(k == 0 && i > 0) {
						continue;
					}
					positionList.add(split[k]);
				}
			}
			i++;
		}
		System.out.println(positionList.size() + " : " + positionList);
	}
	
	/**
	 * http://restapi.amap.com/v3/geocode/regeo?output=xml&location=116.310003,39.991957&key=<用户的key>&radius=1000&extensions=all
	 * 高德地图坐标转具体地址
	 */
	@Test
	public void test002() {
		String url = "http://restapi.amap.com/v3/geocode/regeo";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("key", "df13db4f416440c35a8da58cf20082d3");
//		paramMap.put("location", "118.887353,31.737631");
		paramMap.put("location", "118.826607,31.559002");
		paramMap.put("radius", "500");
		paramMap.put("extensions", "all");
		paramMap.put("roadlevel", "0");
		JSONObject json = HttpClientUtil.doGet(url, paramMap);
		System.out.println(json);
		String addr = (String)JSON.parseObject(JSONObject.toJSONString(json.get("regeocode"))).get("formatted_address");
		System.out.println(addr);
	}
	
	/**
	 * 测试httpclient get 超时
	 */
	@Test
	public void test003() {
		String url = "http://localhost:9001/helloCloud/gk";
		JSONObject jsonObject = HttpClientUtil.doGet(url);
		System.out.println(jsonObject);
	}
	
}