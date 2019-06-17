package com.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2 {

	public static void main(String[] args) {
		/*TC 2: Mercury Tours Registration:
				Open chrome browser. Go to “http://newtours.demoaut.com/”
				Click on Register Link. Fill out all required info
				Click Submit. User successfully registered. (Create 2 scripts using different locators) */
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://newtours.demoaut.com/");
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("Mustafaa");
		driver.findElement(By.name("lastName")).sendKeys("Tom");
		driver.findElement(By.name("phone")).sendKeys("2408765544");
		driver.findElement(By.id("userName")).sendKeys("mustafa@mail.ru");
		driver.findElement(By.name("address1")).sendKeys("198 grenary ln");
		driver.findElement(By.name("city")).sendKeys("Silver Spring");
		driver.findElement(By.name("state")).sendKeys("MD");
		driver.findElement(By.name("postalCode")).sendKeys("09099");
		driver.findElement(By.name("country")).sendKeys("United States");
		driver.findElement(By.id("email")).sendKeys("mustafa986");
		driver.findElement(By.name("password")).sendKeys("mustafa000");
		driver.findElement(By.name("confirmPassword")).sendKeys("mustafa000");
		driver.findElement(By.name("register")).click();
		
	}

}
