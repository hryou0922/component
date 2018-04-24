package com.hry.java.apache.lang3;

import org.apache.commons.lang3.SystemUtils;

public class SystemUtilsTest {

	public static void main(String[] args) {
		System.out.println("java.home = " + SystemUtils.getJavaHome());
		System.out.println("java.io.tmpdir = " + SystemUtils.getJavaIoTmpDir());
		System.out.println("user.dir = " + SystemUtils.getUserDir());
		System.out.println("user.home = " + SystemUtils.getUserHome());
		System.out.println("file.encoding = " + SystemUtils.FILE_ENCODING);
		System.out.println("file.separator = " + SystemUtils.FILE_SEPARATOR);
		System.out.println("java.class.path = " + SystemUtils.JAVA_CLASS_PATH);
		System.out.println("java.class.version = " + SystemUtils.JAVA_CLASS_VERSION);
		System.out.println("java.compiler = " + SystemUtils.JAVA_COMPILER);
		System.out.println("java.endorsed.dirs = " + SystemUtils.JAVA_ENDORSED_DIRS);
		System.out.println("java.ext.dirs = " + SystemUtils.JAVA_EXT_DIRS);
		System.out.println("java.home = " + SystemUtils.JAVA_HOME);
		System.out.println("java.io.tmpdir = " + SystemUtils.JAVA_IO_TMPDIR);
		System.out.println("java.library.path = " + SystemUtils.JAVA_LIBRARY_PATH);
		System.out.println("" + SystemUtils.JAVA_RUNTIME_VERSION);
		System.out.println("java.runtime.name = " + SystemUtils.JAVA_RUNTIME_NAME);
		System.out.println("java.specification.name = " + SystemUtils.JAVA_SPECIFICATION_NAME);
		System.out.println("java.specification.vendor = " + SystemUtils.JAVA_SPECIFICATION_VENDOR);
		System.out.println("java.specification.version = " + SystemUtils.JAVA_SPECIFICATION_VERSION);
		System.out.println("java.util.prefs.PreferencesFactory = " + SystemUtils.JAVA_UTIL_PREFS_PREFERENCES_FACTORY);
		System.out.println("java.vendor = " + SystemUtils.JAVA_VENDOR);
		System.out.println("java.vendor.url = " + SystemUtils.JAVA_VENDOR_URL);
		System.out.println("java.version = " + SystemUtils.JAVA_VM_INFO);
		System.out.println("java.version = " + SystemUtils.JAVA_VERSION);
		System.out.println("java.vm.name = " + SystemUtils.JAVA_VM_NAME);
		System.out.println("java.vm.specification.name = " + SystemUtils.JAVA_VM_SPECIFICATION_NAME);
		System.out.println("java.vm.specification.vendor = " + SystemUtils.JAVA_VM_SPECIFICATION_VENDOR);
		System.out.println("java.vm.specification.version = " + SystemUtils.JAVA_VM_SPECIFICATION_VERSION);
		System.out.println("java.vm.vendor = " + SystemUtils.JAVA_VM_VENDOR); 
	}
}
