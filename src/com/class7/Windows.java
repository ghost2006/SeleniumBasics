package com.class7;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import util.CommonMethods;
public class Windows extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
	/*Task
		Ahead to http://uitestpractice.com/Students/Switchto. Get the parent title. Get the parentId. print the parent title and parentId
		Click on the open in a new window. Get the child title. Get the childId. print the child title and childId. close the child window*/

			setUpDriver("chrome", "http://uitestpractice.com/Students/Switchto");// open parent window
			String parentT=driver.getTitle();
			String parentId=driver.getWindowHandle(); //get parent id
			System.out.println("Parent title is "+parentT+ " parent id: "+parentId);
			
			driver.findElement(By.xpath("//a[text()='Opens in a new window']")).click(); //open a new tab
		
			Set<String>allWindows=driver.getWindowHandles(); //getting window handles (id's)
			Iterator<String> it= allWindows.iterator();
			String parent=it.next(); 
			String child=it.next();
			
			 driver.switchTo().window(child);
		     child=driver.getTitle();
		     String childId= driver.getWindowHandle();
		     System.out.println("title: "+child+" "+" ID: "+childId);
		     Thread.sleep(2000);
		 	
		 	driver.switchTo().window(parent);
		 	Thread.sleep(2000);
		 	
		 	driver.switchTo().window(child);
		 	driver.close();
			
	}

}
