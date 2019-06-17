package com.class10;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import util.CommonMethods;

public class Task3Dynamic extends CommonMethods{

	public static void main(String[] args) {
		/*TC 1: Table headers and rows verification
			Open chrome browser. Go to “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx”
			Login to the application. Verify customer “Susan McLaren” is present in the table. Click on customer details*/
		
		String url="http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx";
		setUpDriver("chrome", url);
		
		//login to the application
		sendText(driver.findElement(By.cssSelector("input[id$='username']")), "Tester");
		sendText(driver.findElement(By.cssSelector("input[id*='password']")), "test");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		
		//get number of rows and cols
		List<WebElement> rows=driver.findElements(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr"));
		List<WebElement> cols=driver.findElements(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr[1]/th"));//how many cols we have by using 1st row
		
		//Verify customer “Susan McLaren” is present in the table. Click on customer details*
		String expectedValue="Susan McLaren";
		
		for (int i=1; i<=rows.size(); i++) {
			 String rowText= driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr["+i+"]")).getText();
			//String rowText= driver.findElement(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr["+i+"]")).getText();
			if (rowText.contains(expectedValue)) {
				System.out.println("the row contains name");
				driver.findElement(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr["+i+"]/td[13]")).click(); //if it contains--> click on the 13 table
				System.out.println("Clicked");
				break;
			}
		}
		driver.close();
	}

}
