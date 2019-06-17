package com.class7;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import util.CommonMethods;

public class WindowsHomeWork extends CommonMethods{
		
		static String Url = "https://the-internet.herokuapp.com/";
	    static String expectedTitleFirstChildWindow = "Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro";
	    static String expectedTitleSecondChildWindow = "New Window";
	    static String mainWindowTitle = "The Internet";
	    
public static void main(String[] args) throws InterruptedException {
	
	/*TC 1: ToolsQA Windows verification
	Open chrome browser. Go to “https://the-internet.herokuapp.com/”. Click on “Multiple Windows” link. Click on “Elemental Selenium”
	Verify title of second window is “Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro”
	Close second window. Click on “Click Here” link. Verify title if newly open window is “New Window”
	Close second window. Verify title of second window is “The Internet”. Quit browser. please use Thread.sleep */
	
	setUpDriver("chrome",Url );
	driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
	String parentId = driver.getWindowHandle();
	driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
	Set<String> handle= driver.getWindowHandles();
	System.out.println(handle.size());
	Iterator<String> it = handle.iterator();
	while(it.hasNext()) {
		String childOneId= it.next();
		if(!childOneId.equals(parentId)) {
			driver.switchTo().window(childOneId);
			Thread.sleep(2000);
		}
	}
	
			String actualChildOneTitle = driver.getTitle();
			if(actualChildOneTitle.equalsIgnoreCase(expectedTitleFirstChildWindow)) {
				System.out.println("title is displayed ");
			}
			else {
				System.out.println("title is not displayed");
			}

	driver.close();
	driver.switchTo().window(parentId);
	
	driver.findElement(By.xpath("//a[text()='Click Here']")).click();
	handle=driver.getWindowHandles();
	it =handle.iterator();
	while(it.hasNext()) {
		String childTwoId= it.next();
		if(!childTwoId.equalsIgnoreCase(parentId)) {
			driver.switchTo().window(childTwoId);
			Thread.sleep(2000);
		}
	}
		String actualChildTwoTitle = driver.getTitle();
		if(actualChildTwoTitle .equals(expectedTitleSecondChildWindow)) {
			System.out.println("title is displayed ");
		}
		else {
			System.out.println("title is not displayed ");
		}
		
	driver.close();
	driver.switchTo().window(parentId);
	String actualParentTitle = driver.getTitle();
	if( actualParentTitle.equals(mainWindowTitle)){
		System.out.println("title is displayed ");
	}
	else {
		System.out.println("title is not displayed ");
	}
	driver.close();
	
	
}
}