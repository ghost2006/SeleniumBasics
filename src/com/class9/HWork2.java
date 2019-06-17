package com.class9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.CommonMethods;

public class HWork2 extends CommonMethods{

	public static void main(String[] args) {
		/*TC 3: Verify element is enabled
			1. Open chrome browser. 2. Go to “https://the-internet.herokuapp.com/”
			3. Click on “Click on the “Dynamic Controls” link. 4. Click on enable button
			5. Enter “Hello” and verify text is entered successfully. 6. Close the browser */

		setUpDriver("chrome", "https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Dynamic Controls")).click();
		
		WebElement textBox=driver.findElement(By.cssSelector("input[type='text']"));
		if (!textBox.isEnabled()) {
			System.out.println("The textBox is Not enabled");
		driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
		}
		
		WebDriverWait wait =new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Disable']")));
		
		if (textBox.isEnabled()) {
			System.out.println("The textBox is enabled");
			textBox.sendKeys("Hello");
		} else {
			System.out.println("The textBox is Not enabled");
		}

		driver.findElement(By.xpath("//button[text()='Disable']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='swapInput()']")));
		
		if (textBox.getAttribute("value").equals("Hello")) {
			System.out.println("The text "+ textBox.getAttribute("value") + " entered successfully");
		} else {
			System.out.println("the text is not enetered");
		}
		driver.quit();
		
	}
}
