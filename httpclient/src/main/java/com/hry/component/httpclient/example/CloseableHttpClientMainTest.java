package com.hry.component.httpclient.example;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.net.ssl.SSLException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

/**
 * 主要同步Http的主要配置
 * 	配置重推
 * 		RequestConfig：配置请求参数
 * 		HttpClients：配置参数
 * 
 * @author Administrator
 *
 */
public class CloseableHttpClientMainTest {
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		// CloseableHttpClient可以被多线程同时调用
		CloseableHttpClient httpClient = HttpClients.custom()
				.setRetryHandler(new HttpRetryHandler(3)).build();
		
		String notify = "http://news.baidu.com/";
		HttpPost post = new HttpPost(notify);
		
		// 设置请求参数
        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("id", "id"));
        params.add(new BasicNameValuePair("cmd", "1"));
        params.add(new BasicNameValuePair("fromUid", "url" ));
        params.add(new BasicNameValuePair("time", String.valueOf(System.currentTimeMillis())));
        params.add(new BasicNameValuePair("entry", "entry"));
        post.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
        
		// encapsulating request configuration items.
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(3000).build();//设置请求和传输超时时间
		post.setConfig(requestConfig);
		
        CloseableHttpResponse response = httpClient.execute(post);
		int code = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String buffer = null;
		if (entity != null){
			buffer = EntityUtils.toString(entity, "utf-8");
		}
		System.out.println("code=" + code + " , buffer = " + buffer);
		response.close();
	}
}

/**
 * 创建重推函数
 * 
 * @author Administrator
 *
 */
class HttpRetryHandler extends DefaultHttpRequestRetryHandler {
	// retry count
	private int times = 0;

	public HttpRetryHandler(int times) {
		super();
		this.times = times;
	}

	/**
	 * 如果返回true，则进行重推，否则不重推
	 */
	@Override
	public boolean retryRequest(IOException exception, int executionCount,
			HttpContext context) {
		// Do not retry if over max retry count
		if (executionCount >= times)
			return false;
		// Timeout
		if (exception instanceof InterruptedIOException)
			return false;
		// Unknown host
		if (exception instanceof UnknownHostException)
			return false;
		// Connection refused
		if (exception instanceof ConnectTimeoutException)
			return false;
		// SSL handshake exception
		if (exception instanceof SSLException)
			return false;

		HttpClientContext clientContext = HttpClientContext.adapt(context);
		HttpRequest request = clientContext.getRequest();
		boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
		// Retry if the request is considered idempotent
		if (idempotent)
			return true;

		return false;
	}
}