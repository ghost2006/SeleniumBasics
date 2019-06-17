package com.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2Home {

	public static void main(String[] args) throws InterruptedException {
		/*TC 2: Mercury Tours Registration:
			Open chrome browser. Go to “http://newtours.demoaut.com/”
			Click on Register Link.	Fill out all required info. Click Submit. User successfully registered*/
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		//driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
		//driver.findElement(By.xpath("//a[@href='mercuryregister.php']")).click(); doesn't work
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Mustafaa");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Tom");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("408765544");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("mustafa@mail.ru");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("198 grenary ln");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Silver Spring");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("MD");
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("09099");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("mustafa986");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mustafa000");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("mustafa000");
		driver.findElement(By.xpath("//input[@name='register']")).click();
		
		Thread.sleep(1300);
		driver.close();
	}
	
}
