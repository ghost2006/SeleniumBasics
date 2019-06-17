package com.class12;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;
import util.CommonMethods;

public class ReadingPropertFile {
	Properties prop;
	
	@Test
	 public void readFile() {
		String filePath="src/configs/credentials.properties";
		
		try {
			FileInputStream fis=new FileInputStream(filePath); //1 create stream obj 
			prop=new Properties();//prop class
		    prop.load(fis); //loading the stream
			} catch (FileNotFoundException e) {
				e.printStackTrace();
		    } catch (IOException e) {
			    e.printStackTrace();
		    }
		System.out.println(prop.getProperty("browser")); // Accessing element locators of all webElements using obj.getProperty(key);
		System.out.println(prop.getProperty("url"));
		
		CommonMethods.setUpDriver(prop.getProperty("browser"), prop.getProperty("url"));
		CommonMethods.driver.quit();
				}
}
