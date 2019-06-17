package com.class4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssTC1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.facebook.com");
	
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Mustafaa");
		driver.findElement(By.cssSelector("input[id^='u_0_e']")).sendKeys("Mustaffaa");
		driver.findElement(By.cssSelector("input[name*='reg_email__'")).sendKeys("mailofMustafa@mail.ru");
		driver.findElement(By.cssSelector("input#u_0_k")).sendKeys("mailofMustafa@mail.ru");
		driver.findElement(By.cssSelector("input#u_0_o")).sendKeys("mustafa000");
		driver.findElement(By.cssSelector("input[value='1']")).click();
		driver.findElement(By.cssSelector("button[name$='mit']")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
