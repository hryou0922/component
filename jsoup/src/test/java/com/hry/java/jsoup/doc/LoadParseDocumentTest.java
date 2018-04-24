package com.hry.java.jsoup.doc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoadParseDocumentTest {
	@Autowired
	private LoadParseDocument loadParseDocument;
	
	@Test
	public void parseDocumentFromString(){
		loadParseDocument.parseDocumentFromString();
	}
	
	@Test
	public void loadDocumentFromFile(){
		loadParseDocument.loadDocumentFromFile();
	}
	
	@Test
	public void loadDocumentFromURL(){
		loadParseDocument.loadDocumentFromURL();
	}
	
	@Test
	public void parsingBodyFragment(){
		loadParseDocument.parsingBodyFragment();
	}
}