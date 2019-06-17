package com.class12;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;
		/* TC 13274 - search flight verification
		 * step 1- navigate
		 * step 2- enter details
		 * step 3- verify search is successful*/
public class flightSearch extends CommonMethods {

	@BeforeMethod
	public void setUp() {
		setUpDriver("chrome","https://www.aa.com/homePage.do");
	}
	
	@Test
	public void searchFligt() {
	//enter to and form	
		//sendText(driver.findElement(By.name("originAirport")), "DCA");
		sendText(driver.findElement(By.name("destinationAirport")), "JFK");
		//click on calendar icon
		driver.findElement(By.xpath("//input[@id='aa-leavingOn']/following-sibling::button")).click();
		//grab element that holds month & year
		WebElement depMonth=driver.findElement(By.xpath("//div[contains(@class, 'ui-corner-left')]/div"));//staleElementReference-->element doesn't attach to the page, it was refreshed so we have to find/grab it again!!!!!
		while (!depMonth.getText().contains("October")) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			//if we won't perform this action we'll get the staleElement exception
			depMonth=driver.findElement(By.xpath("//div[contains(@class, 'ui-corner-left')]/div")); // have to grab the element again
		}
		//capturing all cells & loop and search for a specific date
		List<WebElement> depCells=driver.findElements(By.xpath("//div[contains(@class,'group-first')]/table/tbody/tr/td"));
		for (WebElement cell:depCells) {
			if (cell.getText().equals("18")){
				cell.click();
				break;
			}
		}
	
	//select arrival as December 24
	driver.findElement(By.xpath("//input[@id='aa-returningFrom']/following-sibling::button")).click();
	WebElement arrMonth=driver.findElement(By.xpath("//div[contains(@class, 'ui-corner-right')]/div"));
	do {
		driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
		arrMonth=driver.findElement(By.xpath("//div[contains(@class,'ui-helper-clearfix ui-corner-right')]/div"));
	} while(!arrMonth.getText().contains("December"));
	List<WebElement>arrCells=driver.findElements(By.xpath("//div[contains(@class,'ui-datepicker-group-last')]/table/tbody/tr/td"));
	for (WebElement cell : arrCells) {
		if (cell.getText().equals("24")) {
			cell.click();
			break;
		}
	  }
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flightSearchForm.button.reSubmit")));
	driver.findElement(By.id("flightSearchForm.button.reSubmit")).click();
	boolean isDisp=driver.findElement(By.cssSelector("h1#findFlightsHeader")).isDisplayed();
	Assert.assertTrue(isDisp);
	System.out.println("Search is successful");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
}
	
}
