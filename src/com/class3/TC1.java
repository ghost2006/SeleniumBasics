package com.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1 {

	public static void main(String[] args) {
		/*TC 1: Facebook login:
				Open chrome browser. Go to “https://www.facebook.com/”
				Enter valid username and valid password and click login User successfully logged in */

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.navigate().to("https://www.facebook.com");
			driver.findElement(By.name("firstname")).sendKeys("Mustafaa");
			driver.findElement(By.name("lastname")).sendKeys("Mustafaa");
			driver.findElement(By.name("reg_email__")).sendKeys("mailofMustafa@mail.ru");
			driver.findElement(By.name("reg_email_confirmation__")).sendKeys("mailofMustafa@mail.ru");
			driver.findElement(By.name("reg_passwd__")).sendKeys("mustafa000");
			driver.findElement(By.name("sex")).click();
			driver.findElement(By.name("websubmit")).click();
			
			
			
	}

}
