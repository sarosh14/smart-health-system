package oopd.project.logging;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

/**
 * 
 *	this class is used for logging exceptions to a text file.
 */
public class LogExceptionsToFile {
	
	//static variable to make logger available everywhere.
	public static Logger LOGGER ;
	
	FileHandler fileHandler;
	
	/**
	 * 
	 * @param className  --> to print the class name in which exception is encountered. 
	 * 			
	 */
	public LogExceptionsToFile(String className) {
		
		LOGGER=Logger.getLogger(className);
		
		try {
			log();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * it is used for formatting date in the file and adding file handler.
	 * @throws IOException
	 */
	public void log() throws IOException{
		String fileName="Logs.log";
		
		//File file=new File(fileName);
		
	
		/*	if(!file.exists())
		{
			file.createNewFile();
		}*/
		
		fileHandler=new FileHandler(fileName,true);
		LOGGER.addHandler(fileHandler);
		
		SimpleFormatter simpleFormatter=new SimpleFormatter();
		fileHandler.setFormatter(simpleFormatter);
	}
	
}
