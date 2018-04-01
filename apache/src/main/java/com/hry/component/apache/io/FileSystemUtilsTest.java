package com.hry.component.apache.io;

import java.io.IOException;

import org.apache.commons.io.FileSystemUtils;

public class FileSystemUtilsTest {

	public static void main(String[] args) throws IOException {
        // FileSystemUtils
        System.out.println("Free disk space (in KB): " + FileSystemUtils.freeSpaceKb("C:"));
        System.out.println("Free disk space (in MB): " + FileSystemUtils.freeSpaceKb("C:") / 1024);
        
        
	}

}
