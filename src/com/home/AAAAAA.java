package com.home;
import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.CommonMethods;

public class AAAAAA extends CommonMethods{
	public static void main(String[] args) throws InterruptedException, AWTException {
				String url="http://www.google.com";
		setUpDriver("chrome", url);

		 
		
		Thread.sleep(8000);
		driver.quit();
		
}
}