package com.hry.java.apache.io;

import org.apache.commons.io.FilenameUtils;


public class FilenameUtilsTest {
    private static final String EXAMPLE_TXT_PATH = 
            "c:/UsersLilykosworkspaceApacheCommonsExampleExampleFolderexampleTxt.txt";
    
	public static void main(String[] args) {
		System.out.println("Full path of exampleTxt: " +
                FilenameUtils.getFullPath(EXAMPLE_TXT_PATH));
 
        System.out.println("Full name of exampleTxt: " +
                FilenameUtils.getName(EXAMPLE_TXT_PATH));
 
        System.out.println("Extension of exampleTxt: " +
                FilenameUtils.getExtension(EXAMPLE_TXT_PATH));
 
        System.out.println("Base name of exampleTxt: " +
                FilenameUtils.getBaseName(EXAMPLE_TXT_PATH));
        
 
	}

}
