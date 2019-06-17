package com.class5;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HW2 {

	public static void main(String[] args) {
		/*TC 1: Facebook dropdown verification.
			 Open chrome browser. Go to “https://www.facebook.com”. Verify: month dd has 12 month options;
			 day dd has 31 day options; year dd has 115 year options. Select your date of birth. Quit browser*/

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https:/www.facebook.com");
		WebElement dropdownMonth =driver.findElement(By.name("birthday_month")); // identifying dropDownElement
		
		Select objM=new Select(dropdownMonth);  //if we have Select Tag --> have to crete an obj of this class & pass in constructor our DropdownElement!
		objM.selectByIndex(4);
		
		List<WebElement> monthOpt = objM.getOptions();  //getting all Options, using getOptions() -returns a list!
		System.out.println(monthOpt.size()); //13
		
		WebElement dropdownDay =driver.findElement(By.cssSelector("select#day"));
		Select objD=new Select(dropdownDay);
		objD.selectByValue("9");
		
		List<WebElement> dayOpt=objD.getOptions();
		System.out.println(dayOpt.size()); //32
		
		WebElement dropdownYear =driver.findElement(By.id("year")); 
		Select objY=new Select (dropdownYear);
		objY.selectByVisibleText("1990");
		
		List<WebElement> yearOpt=objY.getOptions();
		System.out.println(yearOpt.size()); //116
		
		driver.quit();
	}

}
