package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import util.CommonMethods;

public class FillingUpApplicationForm extends CommonMethods{
public static void main(String[] args) throws InterruptedException {
	/*TC 1: Users Application Form Fill
     * 1. Open chrome browser. 2. Go to “http://uitestpractice.com/”
     * 3. Click on “Forms” link. 4. Fill out the entire form
     * 5. Close the browser MUST USE Functions*/
	
	setUpDriver("chrome", "http://uitestpractice.com/");
	driver.findElement(By.linkText("Form")).click();
	
	sendText(driver.findElement(By.id("firstname")), "Marry");
	sendText(driver.findElement(By.id("lastname")), "Tompson");
	List <WebElement> marStatus=driver.findElements(By.className("radio-inline"));
	for (WebElement status:marStatus) {
		if (status.getText().equals("Divorced")){
			status.click();
		}
	}
		selectCheckBox(driver.findElements(By.className("checkbox-inline")), "Dancing");
		//selectCheckBox(driver.findElements(By.className("checkbox-inline")), "Cricket"); OR
		driver.findElement(By.xpath("//label[@class='checkbox-inline']/following-sibling::label/following-sibling::label")).click();
		selectValueFromDD(driver.findElement(By.id("sel1")), "Belarus");
		driver.findElement(By.id("datepicker")).click();
		
		WebElement month=driver.findElement(By.cssSelector("select.ui-datepicker-month"));
		selectValueFromDD(month, "Oct");
		selectValueFromDD(driver.findElement(By.cssSelector("select.ui-datepicker-year")), 20);
		List <WebElement> dates=driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));
		for (WebElement date:dates) {
			if (date.getText().equals("18")){
				date.click();
				break;
			}
		}
		sendText(driver.findElement(By.id("phonenumber")), "2404569907");
		sendText(driver.findElement(By.id("username")), "user");
		sendText(driver.findElement(By.id("email")), "mail@gmail.com");
		sendText(driver.findElement(By.id("comment")), "hello");
		sendText(driver.findElement(By.id("pwd")), "0987654321");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		Thread.sleep(3000);
	
	driver.quit();
}
}
