package com.hry.component.httpclient.httpclient45.simple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 最简单的demo
 * @author hry
 *
 */
@Component
public class FirstDemo {
	private static final Logger log = LoggerFactory.getLogger(FirstDemo.class);
	/**
	 * 简单的get请求
	 * @param url
	 * @throws IOException 
	 */
	public void simpleGet(String url) throws IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet("http://httpbin.org/get");
            CloseableHttpResponse response1 = httpclient.execute(httpGet);
            try {
                log.info("{}",response1.getStatusLine());
                HttpEntity entity1 = response1.getEntity();
            //    EntityUtils.consume(entity1);
                log.info("respons={}", EntityUtils.toString(entity1));
            } finally {
                response1.close();
            }
        } finally {
            httpclient.close();
        }
	}
	
//	public void simpleGetWithFluentAPI(String url) throws IOException{
//		Request.Get("http://targethost/homepage")
//	    .execute().returnContent();
//	}
	
	/**
	 * 简单Post请求
	 * @param url
	 * @throws IOException 
	 */
	public void simplePost(String url) throws IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost("http://httpbin.org/post");
            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
            nvps.add(new BasicNameValuePair("username", "vip"));
            nvps.add(new BasicNameValuePair("password", "secret"));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            CloseableHttpResponse response2 = httpclient.execute(httpPost);
            try {
            	log.info("{}",response2.getStatusLine());
                HttpEntity entity2 = response2.getEntity();
            //    EntityUtils.consume(entity2);
                log.info("respons={}", EntityUtils.toString(entity2));
            } finally {
                response2.close();
            }
        } finally {
            httpclient.close();
        }
	}
}
