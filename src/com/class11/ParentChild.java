package com.class11;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.CommonMethods;
public class ParentChild extends CommonMethods{
        /*TC 1: OrangeHRM Login
		1. Navigate to “https://opensource-demo.orangehrmlive.com/”
		2. Login to the application by writing xpath based on “parent and child relation”*/
	
	public static void main(String[] args) {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");

		WebElement user=driver.findElement(By.xpath("//span[text()='Username']/preceding-sibling::input")); //using sibling's xpath
		// WebElement user=driver.findElement(By.xpath("//div[@id='divUsername']/input")); using parent xpath
		
		WebElement password=driver.findElement(By.xpath("//span[text()='Password']/preceding-sibling::input"));
		//WebElement user=driver.findElement(By.xpath("//span[@class='form-hint']/..         //input[@name='txtUsername']")); 
		//                                                         from sibling  to parent & to sibling
		user.sendKeys("Admin");
		password.sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		driver.quit();
	}

}
