package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import util.CommonMethods;

public class CalendarDemo extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		String url="https://jqueryui.com/datepicker/";
		setUpDriver("chrome", url);
		
		//store frame element and then switch
		WebElement frame=driver.findElement(By.cssSelector("iframe.demo-frame"));
		switchToFrame(frame);
		
		//click to bring calendar view
		driver.findElement(By.id("datepicker")).click();
		
		String expectedDate="30";
		
		//get all cells (td_s) using findElements method
		List <WebElement> cells=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement cell: cells) { //using for loop get text of all td_s elements
			//get text of each cell
			String cellText=cell.getText();
			if (cellText.equals(expectedDate)) { // using if else condition we will check specific date
				cell.click();
				System.out.println("Clicked");
			}
		}
		System.out.println(driver.findElement(By.id("datepicker")).getAttribute("value"));
		
		Thread.sleep(3000);
		driver.quit();
}
}