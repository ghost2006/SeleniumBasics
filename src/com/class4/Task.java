package com.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {

	public static void main(String[] args) {
	
		//click on login with either contains or starts-with xpath
		
		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("problem_user");
		driver.findElement(By.xpath("//input[starts-with(@type, 'password')]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[starts-with(@type, 'sub')]")).click();
		
		driver.close();
	}

}
