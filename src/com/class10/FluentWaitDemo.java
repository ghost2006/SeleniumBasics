package com.class10;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;

import util.CommonMethods;

public class FluentWaitDemo extends CommonMethods {

	public static void main(String[] args) {

		String url="https://the-internet.herokuapp.com/";
		setUpDriver("chrome", url );
		
		driver.findElement(By.linkText("Dynamic Controls")).click();
		
		FluentWait wait=new FluentWait(driver);
		wait.withTimeout(30, TimeUnit.SECONDS); // it's crossed --> deprecated --> is no longer been used
		wait.pollingEvery(1,TimeUnit.SECONDS); //how often we want to check our DOM
		wait.ignoring(NoSuchElementException.class);
		
		String buttonXpath="//button[text()='Enable']";
		driver.findElement(By.xpath(buttonXpath)).click();		
	}

}
