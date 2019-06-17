package com.class9;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.CommonMethods;
public class WebDriverWaitDemo extends CommonMethods{

	public static void main(String[] args) {
		
		String url="http://uitestpractice.com/";
		setUpDriver("chrome", url);
		
		driver.findElement(By.linkText("AjaxCall")).click();
		driver.findElement(By.linkText("This is a Ajax link")).click();
		
		//have to use Explicit wait by using WebDriverWait wait class 
		WebDriverWait wait=new WebDriverWait(driver, 50); // we'll wait extra 30 sec until el will be visible
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ContuctUs")));//specifying our conditions --> want our el will be visible
		//OR                                                                       // our element
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ContuctUs")));
		WebElement el=driver.findElement(By.cssSelector("div.ContuctUs"));// our slow element
		
		if (el.isDisplayed()) {
			String text=el.getText();
			System.out.println(text);
		}else {
			System.out.println("Elememnt is not displayed");
		}
		
		
		driver.quit();
	}

}
