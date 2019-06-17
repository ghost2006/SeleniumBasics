package com.class2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://www.walmart.com");
		Thread.sleep(1000);
		driver.navigate().to("http://google.com");
		Thread.sleep(1000);// gives us time for walmart to load up and after 3 sec it will go forwad
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		driver.navigate().refresh(); // refreshes the page
		driver.close();
	}

}
