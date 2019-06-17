package com.class9;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.CommonMethods;
public class HWork extends CommonMethods{

	public static void main(String[] args) {
		/*TC 1: Verify element is present
				Open chrome browser. Go to “https://the-internet.herokuapp.com/”. Click on “Click on the “Dynamic Loading” link
				Click on “Example 1...” and click on “Start”. Verify element with text “Hello World!” is displayed. Close the browser*/
		
		String url="https://the-internet.herokuapp.com/";
		setUpDriver("chrome", url);
		
		driver.findElement(By.linkText("Dynamic Loading")).click();
		
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
	
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
			
		WebElement element= driver.findElement(By.xpath("//h4[text()='Hello World!']"));//our problematic element
		
		if (element.isDisplayed()) {
			String text=element.getText();
			System.out.println("Element is displayed with text "+text);
		}else {
			System.out.println("Elememnt is not displayed");
		}
		driver.quit();
	}

}
