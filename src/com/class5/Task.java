package com.class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {
	public static void main(String[] args) {
	/*TC 1: Swag Labs Positive login: Open chrome browser
			Go to “https://www.saucedemo.com/”. Enter valid username and valid password and click login
			Verify robot icon is displayed. Verify “Products” text is available next to the robot icon
---------------------------------------------------------------------------
	TC 2: Swag Labs Negative login: Open chrome browser. Go to “https://www.saucedemo.com/”
          Enter invalid username and password and click login. Verify error message contains: “Username and password do not match any user in this service” */

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize(); // maximize the window!!!
//		String userN="standard_user";
//		String pass="secret_sauce";
		
		driver.get("https://www.saucedemo.com");
	    WebElement userName = driver.findElement(By.cssSelector("input#user-name"));
	    userName.sendKeys("standard_user");
		WebElement password= driver.findElement(By.cssSelector("input#password"));
		password.sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
	
		// verify logo is displayed
		boolean logo = driver.findElement(By.cssSelector("div[class*='peek']")).isDisplayed();// checking if it's displayed
		if (logo) {
			System.out.println("Robot logo is displayed");
		} else {
			System.out.println("Robot logo is NOT displayed");
		}
		// verify the text "Products" is there
		WebElement product=driver.findElement(By.xpath("//div[text()='Products']")); 
	
		boolean displayP = product.isDisplayed();
		String logoText=product.getText();
		String expectedText="Products";
		
		 if (displayP && logoText.equals(expectedText)) {
			 System.out.println("Element is displayed and text is "+logoText);
		 }else {
			 System.out.println("Element is not displayed");
		 }
		driver.close();
		
		
	}

}
