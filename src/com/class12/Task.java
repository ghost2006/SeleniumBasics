package com.class12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class Task extends CommonMethods{
		/*TC 1: OrangeHRM Login
		Navigate to “https://opensource-demo.orangehrmlive.com/”
		Login to the application. Verify user is successfully logged in
		Note: must use properties file*/
	Properties prop;
	
	@BeforeMethod()
	 public void readFile() {
		String filePath="src/configs/credentials.properties";
		try {
			FileInputStream f=new FileInputStream(filePath);
			prop=new Properties();
			prop.load(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("user"));
		System.out.println(prop.getProperty("password"));
	}
	
	@Test
	public void navigate() {
		setUpDriver(prop.getProperty("browser"), prop.getProperty("url"));
		sendText(driver.findElement(By.id("txtUsername")), prop.getProperty("user"));
		sendText(driver.findElement(By.cssSelector("input#txtPassword")), prop.getProperty("password"));
		driver.findElement(By.id("btnLogin")).click();
		
		WebElement txt =driver.findElement(By.linkText("Dashboard"));
		Assert.assertTrue(txt.isDisplayed());
		
	}
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
}
