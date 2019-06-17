package com.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSS {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.saucedemo.com");
		driver.findElement(By.cssSelector("input[data-test='username']")).sendKeys("performance_glitch_user"); //css with attribute tag[attribute ='value']
		driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce"); // css # with id
		driver.findElement(By.cssSelector("input.btn_action")).click(); // css (.) with class name tag.value of the class
		
		driver.close();
		
			/*  input[id^='ema']   -- starts with
			 *  input[id$='mail']  -- ends with
			 *  input[id*='mai']   -- contains     */
	}

}
