package com.hry.component.httpclient.example;
 
import java.io.IOException;
import java.nio.charset.CodingErrorAction;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.conn.ssl.SSLIOSessionStrategy;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpAsyncClient {
	private static final Logger logger = LoggerFactory.getLogger(HttpAsyncClient.class);
    private static boolean AsyncHttpIgnoreVerifyCert = false;

    private static int SOC_TIME_OUT = 5000;

    /*
	 * 异步HTTP的worker数量默认是CPU线程数，一个worker里的selector处理多个conn。
	 * 与同步HTTP的每个conn要消耗一个线程相比系统开销大大降低。所以异步HTTP的conn的数量限制可以放宽。
	 * 假如所有conn都在等待5秒超时，服务器每秒创建6400个conn，每个conn上下文消耗10K。
	 * 以此推算得出内存消耗=5*6400*10K=312.5M。
	 */
    private static int asyncHttpMaxConnTotal = 32000;

    /*
	 * 考虑到不同route使用异步HTTP单例，每个route的conn限制设为最大值的一半。
	 * 如果某一route请求量确实很大，请创建并使用新的异步HTTP的实例。
	 */
    public static int asyncHttpMaxConnPerRoute = 16000; 
    
    private CloseableHttpAsyncClient client;
    
    // Connection configuration
    public ConnectionConfig defaultConnectionConfig = ConnectionConfig.custom()
        .setMalformedInputAction(CodingErrorAction.IGNORE)
        .setUnmappableInputAction(CodingErrorAction.IGNORE)
        .setCharset(Consts.UTF_8).build();

    // Global request configuration
    public RequestConfig defaultRequestConfig = RequestConfig.custom()
        .setSocketTimeout(SOC_TIME_OUT)
        .setConnectTimeout(SOC_TIME_OUT)
        .setConnectionRequestTimeout(SOC_TIME_OUT)
        .build();
	
    private HttpAsyncClient(){
		client = HttpAsyncClients.custom()
	        .setDefaultConnectionConfig(defaultConnectionConfig)
	        .setDefaultRequestConfig(defaultRequestConfig)
	        .setMaxConnTotal(asyncHttpMaxConnTotal)
	        .setMaxConnPerRoute(asyncHttpMaxConnPerRoute)
	        .setSSLStrategy(getSSLStrategy()).build();
		// 配置完毕后启动
	    this.client.start();
	    
    }
    
    private static class HttpAsyncClientSingle {
        public static final HttpAsyncClient INSTANCE = new HttpAsyncClient();
    }
    
    public static HttpAsyncClient getInstance() {
        return HttpAsyncClientSingle.INSTANCE;
    }
    public void close() throws IOException{
    	client.close();
    }
    
    /**
     * 异步调用
     * @param request
     * @param timeout
     */
    public void sendRequest(final HttpUriRequest request, int timeout) {
    	// 重新对请求进行统一包装
    	HttpUriRequest newRequest = RequestBuilder.copy(request).setConfig(
                RequestConfig.copy(defaultRequestConfig)
                        .setSocketTimeout(timeout).build()).build();

    	// 定义回调函数
    	FutureCallback<HttpResponse> futureCallback = new FutureCallback<HttpResponse>() {
            public void failed(Exception ex) {
                logger.error("http execute failed, url=" + request.getURI(), ex);
            }
            public void completed(HttpResponse result) {
                try {
                    String entity = null;
                    if (result != null) {
                        entity = EntityUtils.toString(result.getEntity(), Consts.UTF_8);
                    }
                    logger.info(
                        "http execute completed, url={}, result={}, entity={}",
                        request.getURI(), result, entity);
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
            public void cancelled() {
                logger.warn("http execute cancelled, url={}", request.getURI());
            }
    	};
    	// 执行命令
    	client.execute(newRequest, futureCallback);
    }
    
    /**
     * 异步调用变同步
     * 	
     * @param request
     * @return
     * @throws ExecutionException 
     * @throws InterruptedException 
     */
    public HttpResponse sendRequestAndWaitResponse(final HttpUriRequest request, int timeout) throws InterruptedException, ExecutionException{
    	// 重新对请求进行统一包装
    	HttpUriRequest newRequest = RequestBuilder.copy(request).setConfig(
                RequestConfig.copy(defaultRequestConfig)
                        .setSocketTimeout(timeout).build()).build();
    	// 执行命令
    	Future<HttpResponse> f = client.execute(newRequest, null);
        return f.get();
    }
    
    
    public SSLIOSessionStrategy getSSLStrategy() {
        if (AsyncHttpIgnoreVerifyCert) {
            try {
                return new SSLIOSessionStrategy(SSLContexts.custom()
                        .loadTrustMaterial(null, new TrustStrategy() {
							public boolean isTrusted(X509Certificate[] chain,
									String authType)
									throws CertificateException {
								return true;
							}
                        }).build(),
                        SSLIOSessionStrategy.ALLOW_ALL_HOSTNAME_VERIFIER);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return SSLIOSessionStrategy.getDefaultStrategy();
    }
}
