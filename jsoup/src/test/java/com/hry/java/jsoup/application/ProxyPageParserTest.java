package com.hry.java.jsoup.application;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxyPageParserTest {
	@Autowired
	private ProxyPageParser proxyPageParser;
	
	@Test
	public void parser() throws IOException, InterruptedException{
		proxyPageParser.parser();
	}
}
