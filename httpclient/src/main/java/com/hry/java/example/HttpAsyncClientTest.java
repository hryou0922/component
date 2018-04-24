package com.hry.java.example;

import java.util.concurrent.ExecutionException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

/**
 * 异步http
 * 	
 * @author Administrator
 *
 */
public class HttpAsyncClientTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String url = "https://mvnrepository.com/artifact/org.eclipse.jetty/jetty-jmx/9.4.0.M0";
		
		// 设置post请求
		// RequestBuilder requestBuilder = RequestBuilder.post().setUri(url);
//		HttpUriRequest request = requestBuilder
//				.setEntity(
//						EntityBuilder
//								.create()
//								.setContentType(
//										ContentType.create("application/json",
//												"UTF-8")).setText(jsonBody)
//								.build()).build();
		// 设置get请求
		HttpUriRequest req = RequestBuilder.get().setUri(url).build();
				
		HttpAsyncClient httpAsync = HttpAsyncClient.getInstance();
		// 异步访问
		httpAsync.sendRequest(req, 20 * 1000);
		// 同步访问
		HttpResponse resp = httpAsync.sendRequestAndWaitResponse(req, 10 * 1000);
		System.out.println("------------------------------------");
		System.out.println(resp.getStatusLine());
	}

}
