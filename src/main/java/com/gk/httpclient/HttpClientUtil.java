package com.gk.httpclient;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 	HttpClient工具类
 * @author gk
 * 2019年3月20日 下午1:40:07
 */
public class HttpClientUtil {
	
	private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	
	/**
	 * httpclient的post方法，一般参数
	 * @param url
	 * @return
	 */
	public static JSONObject doPost(String url,List<NameValuePair> formparams) {
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        JSONObject response = null;
        try {
        	UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
            post.setEntity(entity);
            HttpResponse res = httpclient.execute(post);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String result = EntityUtils.toString(res.getEntity());
                response = JSONObject.parseObject(result);
            }
        } catch (Exception e) {
        	if(e instanceof HttpHostConnectException) {
        		logger.error("远程数据库获取服务关闭，无法获取数据！");
        	}
            throw new RuntimeException(e);
        } finally {
        	if(null != httpclient) {
        		try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
        return response;
	}
	
	/**
	 * httpclient的post方法，json格式参数
	 * 注：该方法测试有问题
	 * @param url
	 * @return
	 */
	public static JSONObject doPost(String url,JSONObject json) {
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        JSONObject response = null;
        try {
        	StringEntity s = new StringEntity(json.toJSONString());
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            post.setHeader("Content-Type", "application/json;charset=UTF-8");
            post.setEntity(s);
            HttpResponse res = httpclient.execute(post);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String result = EntityUtils.toString(res.getEntity());
                response = JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        	if(null != httpclient) {
        		try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
        return response;
	}
	
	/**
	 * post传入JSON字符串，此方法需要服务端使用@RequestBody String XXX来接收参数
	 * @param url
	 * @param json
	 * @return
	 */
	public static JSONObject doPost(String url,String json) {
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        JSONObject response = null;
        try {
        	StringEntity s = new StringEntity(json, Consts.UTF_8);
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            post.setHeader("Content-Type", "application/json;charset=UTF-8");
            post.setEntity(s);
            HttpResponse res = httpclient.execute(post);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String result = EntityUtils.toString(res.getEntity());
                response = JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        	if(null != httpclient) {
        		try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
        return response;
	}
	
	/**
	 * httpclient的get方法
	 * @param url
	 * @return
	 */
	public static JSONObject doGet(String url) {
		CloseableHttpClient httpclient = HttpClientBuilder.create().setRetryHandler(new MyHttpRequestRetryHandler()).build();
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectionRequestTimeout(5000)	//设置连接超时5秒
				.setSocketTimeout(5000)	//设置读取超时5秒
				.build();
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(requestConfig);
		JSONObject response = null;
		try {
            HttpResponse res = httpclient.execute(httpGet);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String result = EntityUtils.toString(res.getEntity());
                response = JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        	if(null != httpclient) {
        		try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
        return response;
	}
	
	/**
	 * httpclient get 带参数
	 * @param url
	 * @param paramMap
	 * @return
	 */
	public static JSONObject doGet(String url,Map<String, Object> paramMap) {
		CloseableHttpClient httpclient = HttpClientBuilder.create().setRetryHandler(new MyHttpRequestRetryHandler()).build();
		RequestConfig requestConfig = RequestConfig.custom()
			.setConnectionRequestTimeout(5000)	//设置连接超时5秒
			.setSocketTimeout(5000)	//设置读取超时5秒
			.build();
		StringBuffer sb = new StringBuffer("?");
		for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
			String key = entry.getKey();
			sb.append(key).append("=");
			String value = (String)entry.getValue();
			sb.append(value).append("&");
		}
		String paramString = sb.substring(0, sb.length() - 1);
		url = url + paramString;
		logger.info("HttpGet whole url is : {}",url);
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(requestConfig);
		//模拟浏览器访问
		httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
		JSONObject response = null;
		try {
            HttpResponse res = httpclient.execute(httpGet);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String result = EntityUtils.toString(res.getEntity());
                response = JSONObject.parseObject(result);
            }
        } catch (Exception e) {
        	logger.error("Http get method error : {}", e.getMessage());
            throw new RuntimeException(e);
        } finally {
        	if(null != httpclient) {
        		try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
        return response;
	}
	
//	public static void doPut(String url,String json) {
//		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
//		HttpPut httpPut = new HttpPut(url);
//		JSONObject response = null;
//		StringEntity s = new StringEntity(json, Consts.UTF_8);
//		httpPut.setEntity(s);
//		try {
//			HttpResponse res = httpclient.execute(httpPut);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) {
//		String eurekaClientRegistParams = "{\"instanceId\":\"192.168.10.37:cloud-service:8001\",\""
//				+ "hostName\":\"192.168.10.37\"}";
//		Message message = new Message();
//		message.setId(1);
//		message.setMsg("gk_test");
//		User user = new User();
//		user.setId(1);
//		user.setUsername("gk");
//		message.setUser(user);
//		String jsonString = JSON.toJSONString(message);
//		JSONObject doPost = HttpClientUtil.doPost("http://localhost:9898/rwd/getMessage", jsonString);
//		System.out.println(doPost);
		
		//Eureka 注册
		Map<String, Object> basicMap = new HashMap<>();
		basicMap.put("instanceId", "192.168.10.37:cloud-service:8003");
		basicMap.put("hostName", "192.168.10.37");
		basicMap.put("app", "CLOUD-SERVICE");
		basicMap.put("ipAddr", "192.168.10.37");
		basicMap.put("status", "UP");
		basicMap.put("overriddenStatus", "UNKNOWN");
		basicMap.put("countryId", 1);
		basicMap.put("homePageUrl", "http://192.168.10.37:8003/");
		basicMap.put("statusPageUrl", "http://192.168.10.37:8003/actuator/info");
		basicMap.put("healthCheckUrl", "http://192.168.10.37:8003/actuator/health");
		basicMap.put("vipAddress", "cloud-service");
		basicMap.put("secureVipAddress", "cloud-service");
		basicMap.put("isCoordinatingDiscoveryServer", "false");
		basicMap.put("lastUpdatedTimestamp", new Date().getTime());
		basicMap.put("lastDirtyTimestamp", new Date().getTime());
		
		Map<String, Object> portMap = new HashMap<>();
		portMap.put("$", 8002);
		portMap.put("@enabled", true);
		basicMap.put("port", portMap);
		
		Map<String, Object> securePortMap = new HashMap<>();
		securePortMap.put("$", 443);
		securePortMap.put("@enabled", false);
		basicMap.put("securePort", securePortMap);
		
		Map<String, Object> dataCenterInfoMap = new HashMap<>();
		dataCenterInfoMap.put("@class", "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo");
		dataCenterInfoMap.put("name", "MyOwn");
		basicMap.put("dataCenterInfo", dataCenterInfoMap);
		
		Map<String, Object> leaseInfoMap = new HashMap<>();
		leaseInfoMap.put("renewalIntervalInSecs", 30);
		leaseInfoMap.put("durationInSecs", 90);
		leaseInfoMap.put("registrationTimestamp", 0);
		leaseInfoMap.put("lastRenewalTimestamp", 0);
		leaseInfoMap.put("evictionTimestamp", 0);
		leaseInfoMap.put("serviceUpTimestamp", 0);
		basicMap.put("leaseInfo", leaseInfoMap);
		
		Map<String, Object> metadataMap = new HashMap<>();
		metadataMap.put("management.port", 8003);
		basicMap.put("metadata", metadataMap);
		
		Map<String, Object> instanceMap = new HashMap<>();
		instanceMap.put("instance", basicMap);
		
		String jsonString = JSON.toJSONString(instanceMap);
//		System.out.println(jsonString);
		JSONObject doPost = HttpClientUtil.doPost("http://192.168.10.87:7001/eureka/apps/CLOUD-SERVICE", jsonString);
		System.out.println(doPost);
	}
	
}
 