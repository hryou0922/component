package com.hry.component.apache.beanutils.support;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class BeanVO {
	private String name;
	private List<String> list;
	private int age;
	private Date date;
	private String[] array;
	private Map<String,String> map;

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("name = " + name)
			.append(" age = " + age)
			.append(" date = " + date)
			.append(" list = " + list);
		return sb.toString();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
}
