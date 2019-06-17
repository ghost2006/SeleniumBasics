package com.class6;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlertHandling {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://uitestpractice.com/");
		
		//click on switch button & Single alert 
		driver.findElement(By.linkText("Switch to")).click();
		driver.findElement(By.id("alert")).click();
	
		// will get an UnhandeledAlertException if try to click on alert without switching the focus of current browser to this alert  
		// driver.findElement(By.id("confirm")).click();
		
		//switch focus to the alert window
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		//click on confirm button
		driver.findElement(By.id("confirm")).click();
		Alert confirmAlert=driver.switchTo().alert();
		//getting text of an alert
		String alertText=confirmAlert.getText();
	    System.out.println("the text of confirm alert is "+alertText);
		confirmAlert.dismiss();
		
		//promt alert
		driver.findElement(By.id("prompt")).click();
		Alert promptAlert=driver.switchTo().alert();
		System.out.println("text of an prompt alert "+promptAlert.getText());
		promptAlert.accept();
		
		Thread.sleep(2000);
		driver.quit();
	}

}
