package com.epam;

import java.io.IOException;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.epam.classloader.JarClassLoader;
import com.epam.myclass.Calculation;

public class App 
{
	static final Logger logger = Logger.getLogger(App.class);
	
	private static final String FILE_NAME = "function.jar";
	private static final String USER_DIR = "user.dir";
	private static final String CLASS_NAME = "com.epam.myclass.impl.CalculationImpl";
	
	private static final String ERROR_MESSAGE = "Please enter a correct value:";
	private static final String LOADING_MESSAGE_RESULT = "After Class loading result: ";
	private static final String RELOADING_MESSAGE_RESULT = "After Class reloading result: ";
	
	private static final String POINT1_MENU = "Push '1' for getting result (after class loading)";
	private static final String POINT2_MENU = "Push '2' for getting result (after class reloading)";
	private static final String POINT3_MENU = "Push '3' to exit";
	
	
    public static void main( String[] args ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException
    {
    	Scanner scanner = new Scanner(System.in);
    	
    	String workingDir = System.getProperty(USER_DIR);
    	
    	ClassLoader classLoader = new JarClassLoader(workingDir + "/" + FILE_NAME);
    	Class clazz = Class.forName(CLASS_NAME, true, classLoader); 
		Calculation myClassObject = (Calculation) clazz.newInstance(); 
    	
		
    	
    	for ( ; ;) {
    		System.out.println("\n" + POINT1_MENU);
        	System.out.println(POINT2_MENU);
        	System.out.println(POINT3_MENU);
        	
	    	int choice = scanner.nextInt();
	    	
	        switch (choice) {
	            case 1:
	            	logger.info(LOADING_MESSAGE_RESULT + myClassObject.mainOperation(7, 2));
	                break;
	            case 2:
	            	classLoader = new JarClassLoader(workingDir + "/" + FILE_NAME);
	            	clazz = Class.forName(CLASS_NAME, true, classLoader); 
					myClassObject = (Calculation) clazz.newInstance();
					
					logger.info(RELOADING_MESSAGE_RESULT + myClassObject.mainOperation(7, 2));
	                break;
	            case 3:
	            	scanner.close();
	            	System.exit(0);
	                break;
	            default:
	            	System.out.println(ERROR_MESSAGE);
	        }
    	}
    } 
}
