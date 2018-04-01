package com.hry.component.jsoup.modifyingdata;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModifyingDataTest {
	@Autowired
	private ModifyingData modifyingData;
	
	@Test
	public void setHTMLofAnElement() throws IOException{
		modifyingData.setHTMLofAnElement();
	}
	
	@Test
	public void setTextContentofAnElement() throws IOException{
		modifyingData.setTextContentofAnElement();
	}
	
	@Test
	public void setAttributeValues() throws IOException{
		modifyingData.setAttributeValues();
	}
 
}