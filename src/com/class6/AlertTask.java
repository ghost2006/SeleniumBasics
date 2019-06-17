package com.class6;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTask {
	public static void main(String[] args) throws InterruptedException {
		/*TC 1: JavaScript alert text verification
				Open chrome browser. Go to “https://www.seleniumeasy.com/test/javascript-alert-box-demo.html” */
		
		// 1. Verify alert box with text “I am an alert box!” is present. 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		Alert confirmAlert=driver.switchTo().alert();
		String expected="I am an alert box!";
		
		String actualText=confirmAlert.getText();
		if (actualText.equals(expected)) {
			System.out.println(expected+ " String is presenttext");
		}else {
			System.out.println(expected+ " String is not presenttext");
		}
		confirmAlert.accept();
		Thread.sleep(3000);
		
		// 2. confirm box with text “Press a button!” is present
		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		Alert alert2=driver.switchTo().alert();
		
		expected="Press a button!";
		if (alert2.getText().equals(expected)) {
			System.out.println(expected+ " String is presenttext");
		}else {
			System.out.println(expected+ " String is not presenttext");
		}
		alert2.accept();
		Thread.sleep(3000);
		
		// 3. prompt box with text “Please enter your name” is present. Quit browser
		
		driver.findElement(By.cssSelector("button[onclick='myPromptFunction()']")).click();
		Alert promptAlert=driver.switchTo().alert();
		expected="Please enter your name";
		if (promptAlert.getText().equals(promptAlert)) {
			System.out.println(expected+ " String is presenttext");
		}else {
			System.out.println(expected+ " String is not presenttext");
		}
		//promptAlert.sendKeys("Lera"); 
		promptAlert.dismiss();
		Thread.sleep(3000);
		
		
		driver.quit();
		
	}

}
