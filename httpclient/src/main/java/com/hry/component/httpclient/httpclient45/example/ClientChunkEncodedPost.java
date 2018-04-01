package com.hry.component.httpclient.httpclient45.example;

import java.io.File;
import java.io.FileInputStream;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Example how to use unbuffered chunk-encoded POST request.
 * 
 * 这个例子执行失败，返回
 * 	HTTP/1.1 411 Length Required
 */
public class ClientChunkEncodedPost {

    public static void main(String[] args) throws Exception {
        String fileFile = ClientChunkEncodedPost.class.getResource("/com/hry/tool/httpclient45/example/clientchunk.txt").getPath();
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost("http://httpbin.org/post");
            System.out.println(fileFile);
            File file = new File(fileFile);

            InputStreamEntity reqEntity = new InputStreamEntity(
                    new FileInputStream(file), -1, ContentType.APPLICATION_OCTET_STREAM);
            reqEntity.setChunked(true);
            // It may be more appropriate to use FileEntity class in this particular
            // instance but we are using a more generic InputStreamEntity to demonstrate
            // the capability to stream out data from any arbitrary source
            //
            // FileEntity entity = new FileEntity(file, "binary/octet-stream");

            httppost.setEntity(reqEntity);

            System.out.println("Executing request: " + httppost.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                System.out.println(EntityUtils.toString(response.getEntity()));
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }

}
