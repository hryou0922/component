package com.hry.component.fastjson.serializer;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public class VO {
	// name 序列化后的key名称
	@JSONField(name="idNew",ordinal = 3)
    private int id;
	
	// 日期格式化
	@JSONField(format="yyyy-MM-dd HH:mm:ss.SSS", ordinal = 2)
    public Date date;

	// 此字段不进行序列化
	@JSONField(serialize=false)
    public String notSerialize;
	 
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getNotSerialize() {
		return notSerialize;
	}


	public void setNotSerialize(String notSerialize) {
		this.notSerialize = notSerialize;
	}


	public static void main(String[] args) {
		VO vo = new VO();
		vo.setDate(new Date());
		vo.setId(123);
		vo.setNotSerialize("notSerialize");
		String jsonString = JSON.toJSONString(vo);
		System.out.println(jsonString);

	}

	
}
