package com.class5;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxes {
/** Check all Years of Experience radio buttons are clickable */
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		
		List<WebElement> expList = driver.findElements(By.name("exp")); //find ElementSS!
		System.out.println(expList.size());
		
		for(WebElement list:expList) {
			 if (list.isEnabled()) {
				String value= list.getAttribute("value");
				
				if (value.equals("5")) {
				list.click();
			 }
		 }
	 }
	
//----------------------------------------------------------------------------------------------------------------------------		
	/* Check all Automation Tools checkboxes are clickable  and keep “Selenium WebDriver” option as selected */
		
		List<WebElement> toolList = driver.findElements(By.name("tool"));
		for(WebElement tool:toolList) {
			if (tool.isEnabled()) {
			 String checkBox=tool.getAttribute("value");
				if (!checkBox.equals("Selenium Webdriver")) {
					tool.click();
				}
				Thread.sleep(3000);
			}
		}
			for(WebElement tool1:toolList) {
				tool1.click();
				Thread.sleep(2000);
			}
		
			Thread.sleep(2000);
		driver.quit();
	}
}		
		
		
		


