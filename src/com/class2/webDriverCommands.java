package com.class2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webDriverCommands {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("google")) {
			System.out.println("this is the right title");
		}else {
			System.out.println("sorry this is not the title");
		}

		driver.get("http://www.facebook.com");
		System.out.println(driver.getTitle());
	
		String title1=driver.getTitle();
		if (title1.equalsIgnoreCase("Facebook - Log In or Sign Up")) {
			System.out.println("this is the right title");
		}else {
			System.out.println("wrong title");
		}
	}

}
