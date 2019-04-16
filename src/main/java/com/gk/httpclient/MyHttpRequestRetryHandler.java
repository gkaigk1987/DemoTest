package com.gk.httpclient;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyHttpRequestRetryHandler implements HttpRequestRetryHandler {
	
	private static Logger logger = LoggerFactory.getLogger(MyHttpRequestRetryHandler.class);
	
	private int retryCount;
	
	public MyHttpRequestRetryHandler() {
		this(3);
	}
	
	public MyHttpRequestRetryHandler(int retryCount) {
		this.retryCount = retryCount;
	}

	@Override
	public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
		logger.info("进入重试流程。。。。。。。。。");
		HttpClientContext clientContext = HttpClientContext.adapt(context);
		HttpRequest request = clientContext.getRequest();
//		String path = null;
//		if(request instanceof HttpUriRequest) {
//			path = ((HttpUriRequest)request).getURI().getPath();
//		}
		if(executionCount > retryCount) {
			//超过重试次数就不再重试
			logger.warn("重试已超设置次数，放弃重试！");
			return false;
		}
		if (exception instanceof NoHttpResponseException) {
			// 没有响应，重试
			logger.warn("服务器没有相应，重试！");
			return true;
		} else if (exception instanceof ConnectTimeoutException) {
			// 连接超时，重试
			logger.warn("连接超时，重试！");
			return true;
		} else if (exception instanceof SocketTimeoutException) {
			// 连接或读取超时，重试
			logger.warn("连接或读取超时，重试！");
			return true;
		} else if (exception instanceof SSLHandshakeException) {
			// 本地证书异常
			return false;
		} else if (exception instanceof InterruptedIOException) {
			// 被中断
			return false;
		} else if (exception instanceof UnknownHostException) {
			// 找不到服务器
			return false;
		} else if (exception instanceof SSLException) {
			// SSL异常
			return false;
		} else {
			logger.error("未记录的请求异常：{}",exception.getClass());
		}
		// 如果请求是幂等的，则重试
		if (!(request instanceof HttpEntityEnclosingRequest)) {
			logger.info("幂等请求，重试！");
			return true;
		}
		return false;
	}

}
