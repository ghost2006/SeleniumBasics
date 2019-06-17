package com.class8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.CommonMethods;

public class DoubleClick extends CommonMethods{

	public static void main(String[] args) {

		setUpDriver("chrome", "https://www.saucedemo.com");
		
		driver.findElement(By.cssSelector("input#password")).sendKeys("Bla bla");
		
		Actions act=new Actions(driver);
		
		act.doubleClick(driver.findElement(By.cssSelector("input#password"))).perform();
		
		driver.close();
	}

}
