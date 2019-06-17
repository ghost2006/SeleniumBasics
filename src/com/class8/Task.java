package com.class8;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.CommonMethods;
public class Task extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		/*Task Two
	Ahead to http://uitestpractice.com/Students/Index
	Click on the Actions. Handle the drag and drop. Close the browser*/
	
		 setUpDriver("chrome", "http://uitestpractice.com/Students/Index");
		 driver.findElement(By.linkText("Actions")).click();
		 
		 WebElement drag= driver.findElement(By.cssSelector("div#draggable"));
		 WebElement drop= driver.findElement(By.cssSelector("div#droppable"));
		 
		 Actions act=new Actions(driver);
		 act.dragAndDrop(drag, drop).perform();
		
		 //act.clickAndHold(drag).moveToElement(drop).release(drag).perform(); //another way
		
		 driver.close();
	
		 /*Task Three
		Ahead to http://uitestpractice.com/Students/Index. Click on the Actions
        Click and hold on 1,2,3,4 boxes. Close the browser*/
		 
		 setUpDriver("chrome", "http://uitestpractice.com/Students/Index");
		 driver.findElement(By.linkText("Actions")).click();  //or By.xpath("//a[text()='Actions']")
		 
		 Actions actions=new Actions(driver);
		  
		WebElement box1 = driver.findElement(By.xpath("//li[@name='one']")); // Or // li[text()='one']
		WebElement box2 = driver.findElement(By.xpath("//li[@name='two']"));
		WebElement box3 = driver.findElement(By.xpath("//li[@name='three']"));
		WebElement box4 = driver.findElement(By.xpath("//li[@name='four']"));
		
		
		//OR 
//		actions.clickAndHold(driver.findElement(By.cssSelector("li[name='one']"))).perform();
//        actions.clickAndHold(driver.findElement(By.cssSelector("li[name='two']"))).perform();
//        actions.clickAndHold(driver.findElement(By.cssSelector("li[name='three']"))).perform();
//        actions.clickAndHold(driver.findElement(By.cssSelector("li[name='four']"))).perform();
//        Thread.sleep(1000);
//        actions.release();
     //Or
	//	 actions.clickAndHold(box1).clickAndHold(box2).clickAndHold(box3).clickAndHold(box4).release().build().perform();
	//	 actions.clickAndHold(box1).moveToElement(box4).release().build().perform();
		        Thread.sleep(2000);
		                                                                                             // use build() to compile multiple actions into one step   
		actions.moveToElement(box1).clickAndHold().moveToElement(box2).clickAndHold().moveToElement(box3).clickAndHold().moveToElement(box4).build().perform();
		Thread.sleep(2000);
		driver.close();
		
		//OR 
//		List<WebElement> boxes = driver.findElements(By.cssSelector());
//        for(int i=1; i<4; i++) {
//            actions.clickAndHold(boxes.get(i)).perform();
//            Thread.sleep(2000);
//       }
		
	}

}
