package com.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTest {

	public static void main(String[] args) throws InterruptedException {
		// LinkText
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.navigate().to("https://www.toolsqa.com/automation-practice-form/");
        Thread.sleep(3000);
        
        //driver.findElement(By.linkText("Link Test")).click();
        driver.findElement(By.partialLinkText("Partial Link")).click();
	}

}
