package com.hry.component.httpclient.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpPostTest {
	public static void main(String[] args) throws ClientProtocolException, IOException{
		String charset = "utf-8";
		String url = "http://www.iteye.com/login";
		// 创建httpclient
		CloseableHttpClient httpClient = HttpClients.custom().build();
		
		HttpPost httpPost = new HttpPost(url);
		// 设置请求和传输超时时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(3000).build();
		httpPost.setConfig(requestConfig);
		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
		
		// 设置form值
		List<NameValuePair> list = new ArrayList<NameValuePair>();  
		list.add(new BasicNameValuePair("authenticity_token","Lxy3r1M00yeETbRreWFpAvGo7BXQaEjfB547rBCC6AQ="));
		list.add(new BasicNameValuePair("name", "***@126.com"));
		list.add(new BasicNameValuePair("password", "****aaaa"));
	//	list.add(new BasicNameValuePair("button", "登　录"));
		UrlEncodedFormEntity postEntity = new UrlEncodedFormEntity(list,charset);  
        httpPost.setEntity(postEntity); 
		
		CloseableHttpResponse response = null;
		try {
            response = httpClient.execute(httpPost);
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
