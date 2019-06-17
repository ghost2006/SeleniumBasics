package com.class8;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.CommonMethods;
public class hoverOver extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		setUpDriver("chrome", "https://www.toolsqa.com/iframe-practice-page/");
		
		WebElement element=driver.findElement(By.xpath("//span[text()='Tutorial']"));
		
		Actions act=new Actions(driver);
		
		act.moveToElement(element).click().perform();
		
		driver.findElement(By.xpath("//span[text()='Agile & Scrum']")).click();
		
		driver.close();
		
		WebElement hoverOver = driver.findElement(By.xpath("//span[text()='DEMO SITES']"));
		
		act.moveToElement(hoverOver).click().perform();
	
		driver.findElement(By.xpath("//span[text()='Automation Practice Switch Windows']")).click();
		Thread.sleep(2000);
		driver.close();

		

	}

}
