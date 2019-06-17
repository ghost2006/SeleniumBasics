package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test {

	public static void main(String[] args) {
	
//		System.setProperty("webdriver.crome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//
//	driver.get("http://facebook.com");
//	driver.get("http://www.amazon.com");
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\mailo\\Selenium\\geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.get("http://facebook.com");
	driver.get("http://www.amazon.com");
}
}