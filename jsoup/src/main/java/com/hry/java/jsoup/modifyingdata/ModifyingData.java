package com.hry.java.jsoup.modifyingdata;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.hry.java.jsoup.doc.LoadParseDocument;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 设置节点值：
 * 	1. 设置节点HTML的值
 *  2. 设置节点内容的值
 *  3. 设置节点属性的值
 * @author hry
 *
 */
@Component
public class ModifyingData {
	private static final Logger logger = LoggerFactory.getLogger(ModifyingData.class);
	
	/**
	 * 设置节点的html内容：
	 * 	1. html：使用新的HTML替换旧的值
	 *  2. prepend：将新html添加到指定节点内部的最前面
	 *  3. append：将新html添加到指定节点内部的最后面
	 *  4. wrap:将指定节点封装到html最里面
	 *  
	 *  html: https://jsoup.org/cookbook/modifying-data/set-html
	 * @throws IOException
	 */
	public void setHTMLofAnElement() throws IOException{
		Document doc = getDoucment();
		
		// 获取div节点
		Element div = doc.select("div").first(); // <div></div>
		// 使用新的HTML替换div旧的html值
		div.html("<p>lorem ipsum</p>"); // <div><p>lorem ipsum</p></div>
		// 将新html添加到div内部的最前面
		div.prepend("<p>First</p>"); // <div><p>First</p><p>lorem ipsum</p></div>
		// 将新html添加到div内部的最后面
		div.append("<p>Last</p>");	// now: <div><p>First</p><p>lorem ipsum</p><p>Last</p></div>
		logger.info("now div={}", div);

		Element span = doc.select("span").first(); // <span>One</span>
		// 将span节点封装到html最里面 --》 <li><a href="http://example.com"><span>One</span></a></li>
		span.wrap("<li><a href='http://example.com/'></a></li>");
	 
		logger.info("doc={}", doc);
	}
	
	/**
	 * 修改节点内容
	 * 	1. 完全替换内容
	 *  2. 在节点的内容最前面加内容
	 *  3. 在节点的内容最后面加内容
	 * 
	 * html: https://jsoup.org/cookbook/modifying-data/set-text
	 * @throws IOException
	 */
	public void setTextContentofAnElement() throws IOException{
		Document doc = getDoucment();
		
		Element div = doc.select("div").first(); // <div></div>
		// 替换div里的内容 输出 -->  <div>five four</div>
		div.text("five four"); 
		logger.info("text = {}", div);
		
		// 在div的内容最前面加内容  输出 --> <div> First five four</div>
		div.prepend("First ");
		logger.info("prepend = {}", div);
		
		// 在div的内容最后面加内容  输出 --> <div>First five four Last</div>
		div.append(" Last");
		logger.info("append = {}", div);
	}
	
	/**
	 * 设置节点的属性和class值
	 * 	1. 设置属性
	 *  2. 设置class
	 * 
	 * html:https://jsoup.org/cookbook/modifying-data/set-attributes
	 * @throws IOException
	 */
	public void setAttributeValues() throws IOException{
		Document doc = getDoucment();
		Element div = doc.select("div").first(); 
		// 在div节点上增加属性和其值：输出 --> <div title="nofollow"></div>
		div.attr("title", "nofollow");
		logger.info("div={}", div);
		// 在div节点上增加class和其值：输出 --> <div title="nofollow" class="round-box"></div>
		div.addClass("round-box");
		logger.info("div={}", div);
	}
	
	
	/**
	 *  从本地文件造成Document文本
	 * @return
	 * @throws IOException
	 */
	private Document getDoucment() throws IOException{
		URL fileUrl = LoadParseDocument.class.getResource("/com/hry/component/jsoup/modifyingdata/modifyingData.html");
		File input = new File(fileUrl.getFile());
		Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
		return doc;
	}
}
