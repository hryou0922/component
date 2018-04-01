package com.hry.component.apache.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class FileUtilsTest {
    private static final String EXAMPLE_TXT_PATH = 
            "c:/UsersLilykosworkspaceApacheCommonsExampleExampleFolderexampleTxt.txt";
 
    private static final String PARENT_DIR =  
            "c:/UsersLilykosworkspaceApacheCommonsExample";
    
	public static void main(String[] args) throws IOException {
        // FileUtils
		 
        // We can create a new File object using FileUtils.getFile(String)
        // and then use this object to get information from the file.
        File exampleFile = FileUtils.getFile(EXAMPLE_TXT_PATH);
        LineIterator iter = FileUtils.lineIterator(exampleFile);

        System.out.println("Contents of exampleTxt...");
        while (iter.hasNext()) {
            System.out.println("t" + iter.next());
        }
        iter.close();
 
        // We can check if a file exists somewhere inside a certain directory.
        File parent = FileUtils.getFile(PARENT_DIR);
        System.out.println("Parent directory contains exampleTxt file: " +
                FileUtils.directoryContains(parent, exampleFile));
        
        // FileUtils.write(file, data);
        // FileUtils.copyDirectory("", "");
	}

}
