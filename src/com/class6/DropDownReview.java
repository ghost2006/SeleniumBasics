package com.class6;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownReview {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe"); if we don't setP we'll get IllegalStateException
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		
		// if we pass wrong element type to the Select class --> we will get UnexpectedTagNameException
//			WebElement button=driver.findElement(By.cssSelector("button#submit"));
//			Select select=new Select(button);
		
		// identify DD with <select>
		WebElement contriesDD=driver.findElement(By.cssSelector("select#continents"));
		// pass to the Select class constructor
		Select select=new Select(contriesDD);
		
		List<WebElement>allOptions=select.getOptions(); //finding how many options are available
		System.out.println("# of options in Country DD "+allOptions.size());
		System.out.println("-----All options from comuntries DD-----");
		
		Iterator<WebElement> it=allOptions.iterator(); // printing all options
		while (it.hasNext()) {
			String optionText=it.next().getText();//getting the text of an each element
			System.out.println(optionText);
		}
	
		select.selectByVisibleText("Africa");
		select.selectByIndex(5);
		
		//deselect from single DD
		// ! select.deselectByIndex(5); --> give UnsupportedOperationException -->You may only deselect options of a multi-select
		
		//Working with MultiSelect
		WebElement comandsDD=driver.findElement(By.id("selenium_commands"));
		Select select1=new Select(comandsDD);
		
		List<WebElement>allOptions1 =select1.getOptions(); 
		System.out.println("# of options in commands DD "+allOptions1.size());
		System.out.println("-----All options from commands DD-----");
		
		for (int i=0; i<allOptions1.size(); i++) {
			String text=allOptions1.get(i).getText();//getting the text of each element
			System.out.println(text);               // printing all options
		}
		
		if (select1.isMultiple()) {  //checks if DD supports multiple options
			select1.selectByVisibleText("Navigation Commands");
			select1.selectByIndex(2);
			select1.selectByIndex(3);
			select1.selectByIndex(4);
			Thread.sleep(7000);
		}
		//deselecting options from Multiple Select
			select1.deselectByIndex(2);
			Thread.sleep(3000);
			select1.deselectByVisibleText("Navigation Commands");
			select1.deselectAll(); //deselecting all options
		
		 Thread.sleep(3000);
	      driver.quit();
	}
	


}
