package com.class4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssTC2Full {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		
		driver.findElement(By.cssSelector("a[href*='mercuryregist']")).click();  // or //a[text()='REGISTER']
		driver.findElement(By.cssSelector("input[name^='first'")).sendKeys("Mustafaa");
		driver.findElement(By.cssSelector("input[name*='last']")).sendKeys("Tom");
		driver.findElement(By.cssSelector("input[name$='ne'")).sendKeys("408765544");
		driver.findElement(By.cssSelector("input#userName")).sendKeys("mustafa@mail.ru");
		driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("198 grenary ln");
		driver.findElement(By.cssSelector("input[name$='ty']")).sendKeys("Silver Spring");
		driver.findElement(By.cssSelector("input[name*='tate']")).sendKeys("MD");
		driver.findElement(By.cssSelector("input[name*='Code']")).sendKeys("09099");
		driver.findElement(By.cssSelector("input#email")).sendKeys("mustafa986");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("mustafa000");
		driver.findElement(By.cssSelector("input[name$='Password']")).sendKeys("mustafa000");
		driver.findElement(By.cssSelector("input[type*='ag']")).click();
		
		Thread.sleep(1300);
		driver.close();

	}

}
