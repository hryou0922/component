package com.hry.java.apache.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.commons.io.monitor.FileEntry;

public class FileMonitorExample {
    private static final String EXAMPLE_PATH =
            "C:/UsersLilykosworkspaceApacheCommonsExampleExampleFolderexampleFileEntry.txt";
 
    private static final String PARENT_DIR =
            "C:/UsersLilykosworkspaceApacheCommonsExampleExampleFolder";
 
    private static final String NEW_DIR =
            "C:/UsersLilykosworkspaceApacheCommonsExampleExampleFoldernewDir";
 
    private static final String NEW_FILE =
            "C:/UsersLilykosworkspaceApacheCommonsExampleExampleFoldernewFile.txt";
    
	public static void main(String[] args) {
        System.out.println("File Monitor example...");
        
        // FileEntry
 
        // We can monitor changes and get information about files
        // using the methods of this class.
        FileEntry entry = new FileEntry(FileUtils.getFile(EXAMPLE_PATH));
 
        System.out.println("File monitored: " + entry.getFile());
        System.out.println("File name: " + entry.getName());
        System.out.println("Is the file a directory?: " + entry.isDirectory());
 
        // File Monitoring
 
        // Create a new observer for the folder and add a listener
        // that will handle the events in a specific directory and take action.
        File parentDir = FileUtils.getFile("c:");
 
        FileAlterationObserver observer = new FileAlterationObserver(parentDir);
        observer.addListener(new FileAlterationListenerAdaptor() {
 
                @Override
                public void onFileCreate(File file) {
                    System.out.println("File created: " + file.getName());
                }
 
                @Override
                public void onFileDelete(File file) {
                    System.out.println("File deleted: " + file.getName());
                }
 
                @Override
                public void onDirectoryCreate(File dir) {
                    System.out.println("Directory created: " + dir.getName());
                }
 
                @Override
                public void onDirectoryDelete(File dir) {
                    System.out.println("Directory deleted: " + dir.getName());
                }
        });
 
        // Add a monior that will check for events every x ms,
        // and attach all the different observers that we want.
        FileAlterationMonitor monitor = new FileAlterationMonitor(500, observer);
        System.out.println("---");
        try {
            monitor.start();
            System.out.println("---");
            // After we attached the monitor, we can create some files and directories
            // and see what happens!
            File newDir = new File(NEW_DIR);
            File newFile = new File(NEW_FILE);
 
            System.out.println(newDir.mkdirs());
            newFile.createNewFile();
           
            Thread.sleep(1000);
 
            FileDeleteStrategy.NORMAL.delete(newDir);
            FileDeleteStrategy.NORMAL.delete(newFile);
 
            Thread.sleep(1000);
 
            monitor.stop();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	

}
