package com.class10;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.CommonMethods;

public class CalendarTask extends CommonMethods{
	public static void main(String[] args) throws InterruptedException {
		/*TC 1: Table headers and rows verification
				1. Open chrome browser 2. Go to “https://jqueryui.com/”
				3. Click on “Datepicker” 4. Select August 10 of 2019
				5. Verify date “08/10/2019” has been entered successfully. 6. Close browser*/
		
		String url="https://jqueryui.com/datepicker/";
		setUpDriver("chrome", url);
		WebElement frame=driver.findElement(By.cssSelector("iframe.demo-frame"));
		switchToFrame(frame);
		//click to bring calendar view
		driver.findElement(By.id("datepicker")).click();
		
		String expMonth= "August";
		String expDate="10";
		String expectedDate = "08/10/2019";
		 
		WebElement monthX =driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
		String month=monthX.getText();
			while(!month.contains("August")) {
	            driver.findElement(By.cssSelector("a[title='Next']")).click();
		}
		List<WebElement>dates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement date:dates) {
			String dateAct=date.getText();
			if (dateAct.equals(expDate)) {
				date.click();
				System.out.println("Clicked");
			}
		}
		 WebElement date = driver.findElement(By.cssSelector("input#datepicker"));
	        if(date.isDisplayed()) {
	            if(date.getAttribute("value").equals(expectedDate)) {
	                System.out.println("TC Passed : Expected date is " + date.getAttribute("value"));
	            }
	        }
		
		Thread.sleep(8000);
		driver.quit();
		
}
}
