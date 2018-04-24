package com.hry.java.cls;

import java.util.Date;

public class VO {
	private String name = "qq";
    private String password = "qqpassword";
    private Date date;
    
    
    protected double protectedName;
    
    public Integer publicName;
    
    public VO(){
    	this.name = "ds";
    	this.password = "pwd";
    	this.date = new Date();
    	this.protectedName = 213333d;
    	this.publicName = 123;
    }
    
}
