package com.class6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task {

	public static void main(String[] args) throws InterruptedException {
		/*TC 1: Amazon Department List Verification
			Open chrome browser. Go to “http://amazon.com/”. Verify how many department options available.
			Print each department. Select Computers. Quit browser*/
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.amazon.com");
		WebElement departmentDD=driver.findElement(By.id("searchDropdownBox"));
		Select select=new Select(departmentDD);
	
		List<WebElement> allOptions=select.getOptions();
		System.out.println("All departments: "+allOptions.size());
		
		for (int i=0; i<allOptions.size(); i++) {
			System.out.println(allOptions.get(i).getText());
		}
		select.selectByVisibleText("Computers");
		Thread.sleep(3000);
		
		driver.quit();
	}

}
