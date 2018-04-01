package com.hry.component.httpclient.httpclient45.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 服务类
 * @author hry
 * 
 */
@Controller
@RequestMapping(value="/httpclient")
public class HttpClientCtl {
	
//	@RequestMapping(value="/responseHandler")
//	@ResponseBody
//	public String a(){ 
//		return "responseHandler";
//	}
	
	@RequestMapping(value="/responseHandler")
	@ResponseBody
	public String responseHandler(){
		return "responseHandler";
	}
}
