package com.class7;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import util.CommonMethods;
public class HWork extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
	/*TC 1: ToolsQA Windows verification
		Open chrome browser. Go to “https://the-internet.herokuapp.com/”. Click on “Multiple Windows” link. Click on “Elemental Selenium”
		Verify title of second window is “Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro”
		Close second window. Click on “Click Here” link. Verify title if newly open window is “New Window”
		Close second window. Verify title of second window is “The Internet”. Quit browser. please use Thread.sleep */

		setUpDriver("chrome", "https://the-internet.herokuapp.com/");
		
		//driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		String parentT=driver.getTitle();
		String parentId=driver.getWindowHandle();   //id
		System.out.println("Parent title is "+parentT+ " and parent id: "+parentId);
		
		driver.findElement(By.linkText("Elemental Selenium")).click(); //opened a new Tab
		
		Set <String> allTabs= driver.getWindowHandles(); //all Tabs id_s
		Iterator <String> it=allTabs.iterator();
		String parent=it.next();
		String child=it.next();
		
		driver.switchTo().window(child);
		String titleES= driver.getTitle();
		System.out.println(titleES);
		if (titleES.equals("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro")) {
			System.out.println("The title is displayed correctly");
		}
		    driver.close(); //closed Child Tab
			
			driver.switchTo().window(parent);
			driver.findElement(By.linkText("Click Here")).click(); //opened another Tab
			
			allTabs=driver.getWindowHandles();
			it=allTabs.iterator();
			parent=it.next();
			child=it.next();
			
			driver.switchTo().window(child); //switched to a child tab
			String newTitle=driver.getTitle();
			
			if (newTitle.equals("New Window")) {
				System.out.println("The New Window title is displayed correctly");
			}
				driver.close();
				Thread.sleep(2000);
				
		     driver.switchTo().window(parent);
		     if (driver.getTitle().equals("The Internet")){   // verifying parent title
		    	 System.out.println("The 2d window title is displayed correctly");
				}
		     	
				driver.close();
	

	}
}
