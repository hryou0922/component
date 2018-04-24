package com.hry.java.jsoup.doc;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 生成Document方式有：
 * 	1. 字符串
 *  2. 加载网页
 *  3. 加载本地文件
 * 
 * @author hry
 *
 */
@Component
public class LoadParseDocument {
	private static final Logger logger = LoggerFactory.getLogger(LoadParseDocument.class);
	
	/**
	 * 将字符串转化为Document
	 * 
	 * html: https://jsoup.org/cookbook/input/parse-document-from-string
	 */
	public void parseDocumentFromString() {
		String html = "<html><head><title>First parse</title></head>"
				+ "<body><p>Parsed HTML into a doc.</p></body></html>";
		Document doc = Jsoup.parse(html);
		logger.info("parseDocumentFromString content={}", doc);
	}
	
	/**
	 * 将字符串转化为Document
	 * 
	 * html: https://jsoup.org/cookbook/input/parse-body-fragment
	 */
	public void parsingBodyFragment() {
		String html = "<div><p>Lorem ipsum.</p>";
		/* The parseBodyFragment method creates an empty shell document, 
		 * and inserts the parsed HTML into the body element
		 */
		Document doc = Jsoup.parseBodyFragment(html);
	//	Element body = doc.body();
		logger.info("parsingBodyFragment content={}", doc);
	}

	/**
	 * 从网络上加载网页并转化为Document
	 * 
	 * html: https://jsoup.org/cookbook/input/load-document-from-url
	 */
	public void loadDocumentFromURL() {
		Document doc;
		try {
			doc = Jsoup.connect("https://www.baidu.com/").get();
			// 从document中获取title值
			String title = doc.title();
			logger.info("LoadDocumentFromURL title={}", title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从本地加载文件并转化为Document
	 * 
	 * html: https://jsoup.org/cookbook/input/load-document-from-file
	 */
	public void loadDocumentFromFile() {
		URL fileUrl = LoadParseDocument.class.getResource("/com/hry/component/jsoup/doc/loadDocumentFromFile.html");
		File input = new File(fileUrl.getFile());
		try {
			/* The baseUri parameter is used by the parser to resolve relative URLs in the document 
			 * before a <base href> element is found. If that's not a concern for you, 
			 * you can pass an empty string instead.
			 */
			Document doc = Jsoup.parse(input, "UTF-8", "https://www.baidu.com/");
			logger.info("LoadDocumentFromFile content={}", doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
