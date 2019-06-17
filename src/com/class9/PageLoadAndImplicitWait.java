package com.class9;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PageLoadAndImplicitWait {

	public static void main(String[] args) {
		//

		System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//managing timeouts of page load
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//managing timeouts for element finding - should do it once for all elements before it throws an Exception
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://cnn.com");
		
		//By.linkText("World") -- correct link text
		//driver.findElement(By.linkText("Worlds")).click();// will wait additional 20 sec before it'll throw an NoSuchElementExc
		
		driver.findElement(By.linkText("World")).click();
		
		boolean isDesplayed=driver.findElement(By.xpath("//h1[text()='World']")).isDisplayed();
		if (isDesplayed) {
			System.out.println("Element is present");
		} else {
			System.out.println("Element is not present");
		}
		driver.quit();
	}

}
