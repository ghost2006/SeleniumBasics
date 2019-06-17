package com.class2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class close {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("http://cnn.com");
	//	driver.close(); // closes only one window/tab
		driver.quit();// closes the entire browser
	
		driver.get("http://ebay.com");
		driver.close();
	}

}
