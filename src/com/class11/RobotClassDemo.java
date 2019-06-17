package com.class11;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import util.CommonMethods;

public class RobotClassDemo extends CommonMethods{

	public static void main(String[] args) throws AWTException, InterruptedException {
		

		setUpDriver("chrome", "http://www.facebook.com");

		  driver.findElement(By.id("email")).sendKeys("Selenium@gmail.com");  // Enter Username
		  driver.findElement(By.id("pass")).sendKeys("mukesh"); // Enter password
		 
			//Using ROBOT CLASS
		
		   Robot r=new Robot();  // Create object of Robot class
		 
		   r.keyPress(KeyEvent.VK_ENTER);      // Press Enter
//		   r.keyRelease(KeyEvent.VK_ENTER);    // Release Enter
//		   r.keyPress(KeyEvent.VK_DOWN);    press down arrow key of keyboard
//		   r.keyPress(KeyEvent.VK_TAB);     press tab
//		   r.keyPress(KeyEvent.VK_CONTROL); press control
//		   r.keyPress(KeyEvent.VK_A);	    press A keyboard key
		   Thread.sleep(2000);
		   driver.quit();
		   
		   //Using Actions class
		   setUpDriver("chrome", "http://www.facebook.com");
           driver.findElement(By.id("email")).sendKeys("Selenium@gmail.com");
		   
		   Actions act=new Actions(driver);
		   act.sendKeys(Keys.TAB).perform(); //we use tab to move through textBoxes-->to email.field
		   act.sendKeys("Hello").perform();
		   act.sendKeys(Keys.ENTER).perform(); //press "enter" OR  act.sendKeys(Keys.RETURN).perform();
		   //act.sendKeys(Keys.ARROW_RIGHT).perform();
//		   act.sendKeys(Keys.CONTROL).perform();
//		   act.sendKeys(Keys.DELETE).perform();
		   Thread.sleep(2000);
		   
		   //Handle multiple Keyboard keys using Actions class:
		   //act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		 
		   driver.quit();
		   
		   
		  
		                  
	}

}
