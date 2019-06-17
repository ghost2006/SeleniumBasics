package com.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import util.CommonMethods;

public class Siblings extends CommonMethods{

	public static void main(String[] args) {
		/*TC 2: OrangeHRM Login
			 1. Navigate to “https://opensource-demo.orangehrmlive.com/”
			 2. Login to the application by writing xpath based on “following and preceding siblings" Test Case*/
		
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
		WebElement user=driver.findElement(By.xpath("//span[text()='Username']/preceding-sibling::input")); 
		sendText(user, "Admin");
		
		WebElement password=driver.findElement(By.xpath("//span[text()='Password']/preceding-sibling::input"));
		sendText(password, "admin123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		driver.quit();
	}

}
