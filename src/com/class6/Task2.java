package com.class6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import util.CommonMethods;

public class Task2 {

	public static void main(String[] args) throws InterruptedException {
		/*TC 2: Select and Deselect values
				Open chrome browser. Go to “http://uitestpractice.com/”. Click on “Select” tab
				Verify how many options available in the first drop down and then select “United states of America”
				Verify how many options available in the second drop down and then select all. Deselect China from the second drop down. Quit browser */
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://uitestpractice.com/");
		
		driver.findElement(By.linkText("Select")).click(); // or by xpath("//a[text()='Select']").click();
		
		//Working with Single DD
		WebElement firstDD =driver.findElement(By.cssSelector("select#countriesSingle"));
		Select select=new Select(firstDD);
		List<WebElement>firstOptions = select.getOptions();
		System.out.println(firstOptions.size());

		select.selectByIndex(1);
		
		//Working with Multiple DD
		WebElement secondDD=driver.findElement(By.id("countriesMultiple"));
		Select select2=new Select(secondDD);
		List <WebElement>secondOptions=select2.getOptions();
		System.out.println("# of options in multiple countries dd="+secondOptions.size());

		// CommonMethods.selectValueFromDD(secondDD, "United states of America"); OR BY CALLING A METHOD from CommonMethods class!
		 
		// check if we can select multiple options
		if (select2.isMultiple()){
		for (int i=0; i<secondOptions.size(); i++) {
			select2.selectByIndex(i);
			Thread.sleep(1000);
		}
		//another way
		for (WebElement option:secondOptions) {
			option.click();
		}
	}
		select2.deselectByIndex(2);
		//select2.deselectByValue("china");
		Thread.sleep(2000);
		driver.quit();
}
}
