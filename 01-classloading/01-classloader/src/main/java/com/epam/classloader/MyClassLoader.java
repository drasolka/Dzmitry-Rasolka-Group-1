package com.epam.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import org.apache.log4j.Logger;

public class MyClassLoader extends ClassLoader {
	
	static final Logger logger = Logger.getLogger(MyClassLoader.class);
	
	private final JarFile file;
		
	public MyClassLoader(String jarFileName) throws IOException {
		this.file = new JarFile(jarFileName); 
	}
	
	protected Class findClass(final String name) throws ClassNotFoundException {
        Class result = findLoadedClass(name);
        if (result != null) {
            logger.info("% Class " + name + " found in cache");
            return result;
        }
        
        ZipEntry entry = this.file.getEntry(name.replace('.', '/') + ".class");
        if (entry == null) {
        	logger.info("% Class " + name + " not found in jar-file.");
        	return findSystemClass(name);
        }
        
        try {
			byte[] classData = loadClassData(file, entry);
			result = defineClass(name, classData, 0, classData.length);
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
		return result;   
    }
	
	private byte[] loadClassData(JarFile jarFile, ZipEntry zipEntry) throws IOException {

        long size = zipEntry.getSize();     

        if (size == -1 || size == 0) {
        	return null;
        }

        byte[] data = new byte[(int)size];

        InputStream in = jarFile.getInputStream(zipEntry);
        in.read(data);       

        return data;
    }
}
