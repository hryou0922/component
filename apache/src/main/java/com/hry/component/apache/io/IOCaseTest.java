package com.hry.component.apache.io;

import java.io.IOException;

import org.apache.commons.io.IOCase;

public class IOCaseTest {
 
    
	public static void main(String[] args) throws IOException {
		String str1 = "This is a new String.";
        String str2 = "This is another new String, yes!";
 
        System.out.println("Ends with string (case sensitive): " +
                IOCase.SENSITIVE.checkEndsWith(str1, "string."));
        System.out.println("Ends with string (case insensitive): " +
                IOCase.INSENSITIVE.checkEndsWith(str1, "string."));
 
        System.out.println("String equality: " +
                IOCase.SENSITIVE.checkEquals(str1, str2));
	}

 
}
