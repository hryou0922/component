package com.hry.java.jsoup.extractingdata;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.hry.java.jsoup.doc.LoadParseDocument;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 获取Element的方式：
 * 	1. DOM
 *  2. 通过css或类似jquery的selector语法
 * 获取节点属性、文本、html
 * 
 * @author hry
 *
 */
@Component
public class ExtractingData {
	private static final Logger logger = LoggerFactory.getLogger(ExtractingData.class);
	
	/**
	 * 	调用document的类似DOM的方法获取Element
	 * 
	 * html: https://jsoup.org/cookbook/extracting-data/dom-navigation
	 * @throws IOException
	 */
	public void extractDataByDOM() throws IOException{
		Document doc = Jsoup.connect("https://www.baidu.com/").get();
		Element lg = doc.getElementById("lg");
		logger.info("getElementById lg = {}", lg);
		Elements links = doc.getElementsByTag("a");
		for (Element link : links) {
		  String linkHref = link.attr("href");
		  String linkText = link.text();
		  logger.info("linkHref={}, linkText={}",linkHref, linkText);
		}
	}
	
	/**
	 * 通过css或类似jquery的selector语法
	 * 
	 * html: https://jsoup.org/cookbook/extracting-data/selector-syntax
	 * @throws IOException 
	 */
	public void extractDataByCSSOrJqueryLikeSelectorSyntax() throws IOException{
		URL fileUrl = LoadParseDocument.class.getResource("/com/hry/component/jsoup/extractingdata/extractDataByCSSOrJqueryLikeSelectorSyntax.html");
		File input = new File(fileUrl.getFile());
		Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

		// 获取所有的a节点
		Elements links = doc.select("a[href]"); 
		logger.info("links = {}", links);
		
		// 获取img的src以.png结果结尾
		Elements pngs = doc.select("img[src$=.png]");
		logger.info("pngs = {}", pngs);
		
		// 获取class=masthead的div节点
		Element masthead = doc.select("div.masthead").first();
		logger.info("masthead = {}", masthead);
		
		// 获取class=r的h3节点下面的a节点
		Elements resultLinks = doc.select("h3.r > a"); // direct a after h3
		logger.info("resultLinks = {}", resultLinks);
	}
	
	/**
	 * 获取节点属性、文本、html
	 * 
	 * html: https://jsoup.org/cookbook/extracting-data/attributes-text-html
	 */
	public void extractAttributesTextAndHTML(){
		String html = "<p>An <a href='/abc'><b>example</b></a> link.</p>";
		// 指定baseUri的值，在使用abs:attr会使用到
		Document doc = Jsoup.parse(html, "http://example.com/");
		Element link = doc.select("a").first();

		/**
		 * text获取所有子节点的文本并组合在一一起
		 * 如：HTML <p>Hello <b>there</b> now! </p>, --》 调用p.text() --》输出： "Hello there now!"
		 */
		String text = doc.body().text(); // "An example link"
		logger.info("text={}", text);
		
		// 获取link的href属性值
		String linkHref = link.attr("href"); // /abc
		// 在href前面加上abs，会在现有的href(如/abc)的前面别上Jsoup.parse(html, "http://example.com/")里指定的baseUri值
		String absLinkHref = link.attr("abs:href"); // http://example.com/abc
		logger.info("linkHref={}, absLinkHref={}",linkHref, absLinkHref);
		
		// 获取link里所有字节点的内容组合在一起
		String linkText = link.text(); // "example""
		logger.info("linkText={}", linkText);

		// 获取本节点所有HTML文本信息
		String linkOuterH = link.outerHtml(); // "<a href="http://example.com"><b>example</b></a>"
		logger.info("linkOuterH={}", linkOuterH);
		    
		// 获取本节点字节点的html文本信息
		String linkInnerH = link.html(); // "<b>example</b>"
		logger.info("linkInnerH={}", linkInnerH);
	}
}
