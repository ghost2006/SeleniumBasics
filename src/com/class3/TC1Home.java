package com.class3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1Home {

	public static void main(String[] args) throws InterruptedException {
		/*Using Xpath ONLY
			TC 1: Facebook login:nOpen chrome browser. Go to “https://www.facebook.com/”
			Enter valid username and valid password and click login. User successfully logged in*/

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.facebook.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='inputtext']")).sendKeys("mailofMustafa@mail.ru");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@data-testid='royal_pass']")).sendKeys("mustafa000");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
