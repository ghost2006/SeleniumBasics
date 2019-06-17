package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorld {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe"); //webdriver.chrome.driver for chrome only
		WebDriver driver=new ChromeDriver();

		driver.get("http://google.com");
		
		
		
	}

}
