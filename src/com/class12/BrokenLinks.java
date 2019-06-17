package com.class12;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;
/*
 *New Tour registration page broken links verification 
 */
public class BrokenLinks extends CommonMethods{
	
	@BeforeMethod
	public void setUp() {
		setUpDriver("chrome", "http://newtours.demoaut.com/mercurywelcome.phpt");
	}
	@Test
	public void brokenLinksVerification() {
		//grab all links
	List <WebElement>links=driver.findElements(By.tagName("a")); //or "img" for images
	
	for(WebElement link:links){
		String linkURL=link.getAttribute("href");  //get href attribute /or "rsc" attribute for images
		try {
			URL url=new URL(linkURL); //bring url obj of url class
			                         //downcasting     open connection
		HttpURLConnection conn=(HttpURLConnection)url.openConnection(); //HttpURLConnection abs class
		int code=conn.getResponseCode(); //getting response
		
			if (code==200) {
				System.out.println("Link is valid "+ link.getText());
			} else {
			System.out.println("Link is NOT valid "+ link.getText());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	  }
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
