package com.hry.component.jsoup.extractingdata;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtractingDataTest {
	@Autowired
	private ExtractingData extractingData;
	
	@Test
	public void extractDataByDOM() throws IOException{
		extractingData.extractDataByDOM();
	}
	
	@Test
	public void extractDataByCSSOrJqueryLikeSelectorSyntax() throws IOException{
		extractingData.extractDataByCSSOrJqueryLikeSelectorSyntax();
	}
	
	@Test
	public void extractAttributesTextAndHTML() throws IOException{
		extractingData.extractAttributesTextAndHTML();
	}
}