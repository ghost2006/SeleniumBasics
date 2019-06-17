package com.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssTC2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.cssSelector("a[href*='mercuryreg']")).click();
		//driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
		driver.findElement(By.cssSelector("input[name^='email']")).sendKeys("Mustafaa");
		driver.findElement(By.cssSelector("input[name*='password']")).sendKeys("mustafa000");
		driver.findElement(By.cssSelector("input[name$='Password']")).sendKeys("mustafa000");
		driver.findElement(By.cssSelector("input[name='register']")).click();
		driver.close();

	}

}
