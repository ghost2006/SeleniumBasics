package com.class7;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.CommonMethods;

public class Task extends CommonMethods{
	public static void main(String[] args) {
		
	/*TC 1: ToolsQA Frame verification
		Open chrome browser. Go to “https://www.toolsqa.com/iframe-practice-page/”
		Click on “Blogs” link inside first frame. Verify element “Interactions” is present in second frame
		Navigate to Home Page. Quit browser */
		
		setUpDriver("chrome", "https://www.toolsqa.com/iframe-practice-page/");
		
		WebElement element=driver.findElement(By.xpath("//iframe[@id='IF1']")); // OR driver.switchTo().frame("IF1"); --using its ID
		driver.switchTo().frame(element); //switching to the 1st frame 
		
		driver.findElement(By.xpath("//a[text()='Git Log']")).click(); 
		driver.switchTo().defaultContent();  // --> switch to main page
		
		driver.switchTo().frame(1); //switching to 2d frame
		
		boolean interaction=driver.findElement(By.xpath("//h3[text()='Interactions']")).isDisplayed();
				if (interaction==true) {
					System.out.println("element “Interactions” is present in second frame");
					driver.switchTo().defaultContent();// only for frames!!!!
					driver.quit();
				}
		
	}

}
