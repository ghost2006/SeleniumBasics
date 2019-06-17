package com.class2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1 {

	public static void main(String[] args) {
		/*TC 1: Amazon Page Title Verification:
		Open chrome browser
		Go to “https://www.amazon.com/”
		Verify Title “Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more” is displayed */

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://www.amazon.com/");
		
		String title=driver.getTitle();
		String actual=title;
		String expected="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		if (expected.equalsIgnoreCase(actual)) {
			System.out.println("the right title");
		}else {
			System.out.println("wrong title");
		}
		driver.close();
	}

}
