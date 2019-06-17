package com.class7;

import org.openqa.selenium.By;

import util.CommonMethods;

public class iframe extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		
		CommonMethods.setUpDriver("chrome","http://uitestpractice.com/Students/Switchto");
		
		//1 way by using name (view page/frame source)
		//driver.switchTo().frame("iframe_a");
	
		// 2 way WebElement
		//WebElement element= driver.findElement(By.xpath("//iframe[@name='iframe_a']"));  // or css selector - iframe[name='iframe_a']
		//driver.switchTo().frame(element);
		
		// 3d way By Index
		driver.switchTo().frame(0);
		//driver.switchTo().frame(2);   -->  NoSuchElementException!!!!
		
		driver.findElement(By.cssSelector("input#name")).sendKeys("lera");
		
		driver.switchTo().defaultContent();  // --> switch to main page only for FRAMES!
		
		boolean Switch =driver.findElement(By.xpath("//h2[text()='SwitchTo']")).isDisplayed();
		if (Switch==true) {
			driver.close();
		}
		
		
	
		
	}

}
