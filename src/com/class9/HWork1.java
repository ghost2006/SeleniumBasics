package com.class9;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.CommonMethods;
public class HWork1 extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		/*TC 2: Verify element is clickable.
			1. Open chrome browser. 2. Go to “https://the-internet.herokuapp.com/”
			3. Click on “Click on the “Dynamic Controls” link. 4. Select checkbox and click Remove
			5. Click on Add button and verify “It's back!” text is displayed. 6. Close the browser */
		
		setUpDriver("chrome", "https://the-internet.herokuapp.com/");
		 driver.findElement(By.linkText("Dynamic Controls")).click();
		 
		 WebElement checkBox= driver.findElement(By.xpath("//input[@type='checkbox']"));
		 if (checkBox.isEnabled()) {
			 checkBox.click();
		 } else {
			 System.out.println("The checkBox is unabled");
		 }
		//Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[text()='Remove']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add']")));
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		 //Thread.sleep(2000);
		
		WebElement text = driver.findElement(By.xpath("//p[@id='message']"));
		if (text.isDisplayed()){
			String txt=text.getText();
			System.out.println("The text "+txt+" is displayed");
		} else {
			System.out.println("The text is NOT displayed");
	
		}
		driver.quit();
		
		
		

	}
}
