package com.class5;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {

	public static void main(String[] args) throws InterruptedException {
/* TC 1: Tools QA check all elements
         Open chrome browser. Go to “https://www.toolsqa.com/automation-practice-form/”. Fill out:
         First Name, Last Name. Check that sex radio buttons are enabled and select “Male”.
         Check all Years of Experience radio buttons are clickable Date. Select both checkboxes for profession. 
		 Check all Automation Tools checkboxes are clickable and keep “Selenium WebDriver” option as selected. Quit browser */

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("mustafa");
		driver.findElement(By.cssSelector("input[name*='last']")).sendKeys("Dzhaan");
//		WebElement sexRadioButton=driver.findElement(By.name("sex"));
//		if (!sexRadioButton.isSelected()) {
//			sexRadioButton.click();
//		} OR
		List<WebElement>sexRadioB=driver.findElements(By.cssSelector("input[id*='sex']"));
		 for (WebElement radioB:sexRadioB) {
			 if (radioB.isEnabled()) {
				 String value= radioB.getAttribute("value");
				 System.out.println(value);
				 if (value.equals("Male")) {
					 radioB.click();
				 }
			 }
		 }
		
		 List<WebElement>experienceRadioB=driver.findElements(By.name("exp"));
		    for (WebElement experienceB: experienceRadioB) {
			    String expValue= experienceB.getAttribute("value");
			    if (expValue.equals("6")) {
		    	experienceB.click();
		}
	 }
		    driver.findElement(By.id("datepicker")).sendKeys("1.18.2019");
		    Thread.sleep(3000);
		    
		    List<WebElement> autoCheckbox =driver.findElements(By.name("tool"));
		    Iterator <WebElement>it=autoCheckbox.iterator();
		      while(it.hasNext()) {
		    	  WebElement t=it.next();
		         String tValue=t.getAttribute("value");
   	             if (tValue.equals("Selenium Webdriver")) {
		             t.click();
		             Thread.sleep(3000);
		           }
		        }
		    driver.quit();
	}
}

