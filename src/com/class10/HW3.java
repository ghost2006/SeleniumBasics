package com.class10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.CommonMethods;
public class HW3 extends CommonMethods{

	public static void main(String[] args) {
		// Verify element is enabled

		String url="https://the-internet.herokuapp.com/";
		setUpDriver("chrome", url );
		
		driver.findElement(By.linkText("Dynamic Controls")).click();
		String buttonXpath="//button[text()='Enable']";
		driver.findElement(By.xpath(buttonXpath)).click();		
		
		//1 way
//		WebDriverWait wait =new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']"))); -->passing the locator of our WE
//		
//		String textToBeEntered= "Hello";
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(textToBeEntered);
//		
//		String returnedText=driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
//		//compare entered & returned Text
//		if (returnedText.equals(textToBeEntered)) {
//			System.out.println("Text is entered");
//		}else {
//			System.out.println("text "+ textToBeEntered +" is not enetered");
//		}
		
		//2way
		//identify the element  & then pass it to the Expected conditions
		WebElement el=driver.findElement(By.xpath("//input[@type='text']"));
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(el));
		
		String textToEnter="Hi";
		el.sendKeys(textToEnter);
		String eneteredText = el.getAttribute("value");
		 
		if (eneteredText.equals(textToEnter)) {
			System.out.println("Text is entered");
		}else {
			System.out.println("text "+ textToEnter +" is not enetered");
		}
			
		driver.quit();
	}

}
