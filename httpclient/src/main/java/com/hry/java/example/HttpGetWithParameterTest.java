package com.hry.java.example;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpGetWithParameterTest {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "http://www.baidu.com/a?id=2&number=33";
		// 创建httpclient
		CloseableHttpClient httpClient = HttpClients.custom().build();
		// 设置请求和传输超时时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(3000).build();
		HttpGet get = new HttpGet(url);
		get.setConfig(requestConfig);
		// 设置header
		get.setHeader("X-3GPP-Intended-Identity", "uid");
		
		CloseableHttpResponse response = null;
		try {
            response = httpClient.execute(get);
            int code = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            if (entity != null){
            	String buffer = EntityUtils.toString(entity, "utf-8");
            	System.out.println("code = " + code + " , buffer = " + buffer);
            }
            
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException ignored) {
                }
            }
        }
	}

}
