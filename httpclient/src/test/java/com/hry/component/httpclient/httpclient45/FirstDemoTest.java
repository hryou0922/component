package com.hry.component.httpclient.httpclient45;

import java.io.IOException;

import com.hry.component.httpclient.httpclient45.simple.FirstDemo;
import com.hry.component.httpclient.httpclient45.simple.HttpClientApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=HttpClientApplication.class)
public class FirstDemoTest {
	@Autowired
	private FirstDemo firstDemo;
	
	@Test
	public void simpleGet() throws IOException{
		String url = "";
		firstDemo.simpleGet(url);
	}
	
	@Test
	public void simplePost() throws IOException{
		String url = "";
		firstDemo.simplePost(url);
	}
}