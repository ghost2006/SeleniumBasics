package com.class8;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.CommonMethods;

public class TaskOne extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		/*Task One
			Ahead to http://uitestpractice.com/Students/Index
			Click on the Actions. Click on the click me !Handle the alert and click okay. Double Click Double Click Me !
			Handle the alert and click okay. Close the browser*/
		
		
		setUpDriver("chrome", "http://uitestpractice.com/Students/Index");
		driver.findElement(By.linkText("Actions")).click();

		WebElement click= driver.findElement(By.xpath("//button[text()='Click Me !']"));

		Actions act=new Actions(driver);
		act.moveToElement(click).click().perform();
		Alert alert1=driver.switchTo().alert();  
		alert1.accept();  
		Thread.sleep(2000);
		
		WebElement dblclick=driver.findElement(By.cssSelector("button[name='dblClick']"));
		act.moveToElement(dblclick).doubleClick().perform();
		Thread.sleep(2000);
		
		Alert alertTwo= driver.switchTo().alert();
		alertTwo.accept();
          
		driver.close();
		
	}

}
