package com.hry.java.jsoup.application;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 下载代理信息
 * 
 * @author hry
 *
 */
@Component
public class ProxyPageParser {
	private static final Logger logger = LoggerFactory.getLogger(ProxyPageParser.class);
	private int index = 1;

	public void parser()throws IOException, InterruptedException{
		int num = 100;
		for(int i = 1; i <= num; i++){
			String url = "http://www.kuaidaili.com/free/inha/"+i+"/";
			parser(url);
			Thread.sleep(1000 * 2);
		}
	}
	
	public void parser(String url) throws IOException {
	//	String url = "http://www.kuaidaili.com/free/outtr/1/";
		logger.info("request={}", url);
		Document doc = Jsoup.connect(url).get();
		// 从document中获取title值
		String title = doc.title();
		logger.info("LoadDocumentFromURL title={}", title);
		Elements trList = doc.select("tbody tr");
		for (Element ele : trList) {
			/**
			 * <tr>
			 * <td data-title="IP">190.211.129.92</td>
			 * <td data-title="PORT">8080</td>
			 * <td data-title="匿名度">透明</td>
			 * <td data-title="类型">HTTP</td>
			 * <td data-title="位置">阿根廷</td>
			 * <td data-title="响应速度">3秒</td>
			 * <td data-title="最后验证时间">2017-06-04 22:38:20</td>
			 * </tr>
			 */
			Elements tdList = ele.select("td");
			String ip = tdList.get(0).text();
			String port = tdList.get(1).text();
			String anonymity = tdList.get(2).text();
			String type = tdList.get(3).text();
			String country = tdList.get(4).text();
			String respondingSpeed = tdList.get(5).text();
			String lastVerifyTime = tdList.get(6).text();

			logger.info("index={}, ip={},port={},anonymity={},type={},country={},respondingSpeed={},lastVerifyTime={}", 
					index++, ip, port,
					anonymity, type, country, respondingSpeed, lastVerifyTime);
		}
	}
}
