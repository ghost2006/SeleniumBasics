package com.class2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2 {

	public static void main(String[] args) {
		/*TC 2: Syntax Page URL Verification:
		Open chrome browser
		Navigate to “https://www.syntaxtechs.com/”
		Navigate to “https://www.google.com/”
		Navigate back to Syntax Technologies Page
		Refresh current page
		Verify url contains “Syntax” */

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://www.syntaxtechs.com");
		driver.navigate().to("http://google.com/");
		driver.navigate().back();
		driver.navigate().refresh();
		String url= driver.getCurrentUrl();
		if (url.contains("syntax")) {
			System.out.println("url contains 'syntax'");
		}else {
			System.out.println("url doesn't contain 'syntax'");
		}
		driver.quit();
	}

}
