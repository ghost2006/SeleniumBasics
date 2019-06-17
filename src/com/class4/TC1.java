package com.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1 {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys("mustafa@mail.ru");
		driver.findElement(By.xpath("//input[starts-with(@id, 'pass')]")).sendKeys("mustafa000");
		driver.findElement(By.xpath("//input[contains(@type, 'submit')]")).click();
		driver.close(); 
		
		//Using xpath with a text
		//a[text()='Forgot account?']
		//a[starts-with(text(),'Forgot account?')]
		//a[contains(text(), 'Forgot')] OR a[contains(text(), 'account')]
		
		
	}

}
