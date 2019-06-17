package com.class5;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetLinksWithText {
	/*Open chrome browser
	Go to “https://www.amazon.com/”. Using Iterator get text of each link. Get number of links that has text */ 
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mailo\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https:amazon.com");
		
		                                              //specifying the tag--> a-->links
		List <WebElement> links = driver.findElements(By.tagName("a")); //findELEMENTS!!!!!! all links'll be stored in a List
		
		int count=0;
		Iterator<WebElement> it=links.iterator();  // iterator is an interface
		while (it.hasNext()) {
		String text=it.next().getText();  
		  if (!text.isEmpty()) {  // checking the links with the text
			System.out.println(text); //printing them
			count ++;	//counting
		   }
		}
		System.out.println("---Total number of links with text "+count);
		driver.quit();
}

}