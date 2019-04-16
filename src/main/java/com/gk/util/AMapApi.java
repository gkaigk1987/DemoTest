package com.gk.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gk.httpclient.HttpClientUtil;

/**
 * 高德地图接口调用相关
 * @author gk
 * 2019年3月30日 下午1:48:16
 */
public class AMapApi {
	
	/**
	 * 高德开发KEY值
	 */
	private final static String KEY = "df13db4f416440c35a8da58cf20082d3";
	
	/**
	 * 详细地址转坐标location的调用url
	 */
	private final static String GEO_URL = "http://restapi.amap.com/v3/geocode/geo";
	
	/**
	 * location坐标转详细地址的调用url
	 */
	private final static String REGEO_URL = "http://restapi.amap.com/v3/geocode/regeo";
	
	/**
	 * 驾车路径规划调用的url
	 */
	private final static String DRIVE_URL = "https://restapi.amap.com/v3/direction/driving";
	
	/**
	 * 地址转坐标
	 * @param address
	 * @param cityCode
	 * @return
	 */
	public static String geo(String address,String cityCode) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("key", KEY);
		paramMap.put("address", address);
		paramMap.put("city", cityCode);
		JSONObject json = HttpClientUtil.doGet(GEO_URL, paramMap);
		try {
			Object geocodes = json.get("geocodes");
			JSONArray geocodesArray = JSONArray.parseArray(JSONObject.toJSONString(geocodes));
			if(geocodesArray.size() > 0) {
				return  (String)JSON.parseObject(JSONObject.toJSONString(geocodesArray.get(0))).get("location");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 坐标转地址
	 * @param location
	 * @param extensionsType base/all
	 * @return
	 */
	public static String regeo(String location, String extensionsType) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("key", KEY);
		paramMap.put("location", location);
		paramMap.put("radius", "500");
		paramMap.put("extensions", extensionsType);
		paramMap.put("roadlevel", "0");
		JSONObject json = HttpClientUtil.doGet(REGEO_URL, paramMap);
		try {
			return (String)JSON.parseObject(JSONObject.toJSONString(json.get("regeocode"))).get("formatted_address");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 驾车路线
	 * @param origin
	 * @param destination
	 * @param extensionType
	 * @return
	 */
	public static Map<String, Object> driveInfo(String origin,String destination,String extensionType) {
		Map<String, Object> map = new HashMap<>();
		map.put("key", KEY);
		map.put("origin", origin);
		map.put("destination", destination);
		map.put("extensions", extensionType);
		JSONObject json = HttpClientUtil.doGet(DRIVE_URL, map);
		try {
			Map<String, Object> reMap = new HashMap<>();
			JSONObject routeJSON = JSON.parseObject(JSONObject.toJSONString(json.get("route")));
			if(extensionType.equals("all")) {
				String taxiCost = (String) routeJSON.get("taxi_cost");
				reMap.put("taxiCost", taxiCost);
			}
			JSONArray pathsJSONArray = JSONArray.parseArray(JSONObject.toJSONString(routeJSON.get("paths")));
			Object object = pathsJSONArray.get(0);
			JSONObject pathsJSON = JSON.parseObject(JSONObject.toJSONString(object));
			String distance = (String) pathsJSON.get("distance"); //路程
			reMap.put("distance", distance);
			
			String duration = (String) pathsJSON.get("duration"); //大致所需时间
			reMap.put("duration", duration);
			
			String trafficLights = (String)pathsJSON.get("traffic_lights");
			reMap.put("trafficLights", trafficLights);
			
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
			reMap.put("positionList", positionList);
			return reMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
