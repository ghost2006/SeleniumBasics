package com.class10;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import util.CommonMethods;
public class Task2 extends CommonMethods{

	public static void main(String[] args) {
	
		String url="https://the-internet.herokuapp.com/";
		setUpDriver("chrome", url );
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		
		// number of rows
			List <WebElement> rows=driver.findElements(By.xpath("//table[@id='table2']/tbody/tr"));
		// number of columns
			List <WebElement> columns=driver.findElements(By.xpath("//table[@id='table2']/thead/tr/th"));
			
			for (int i=1; i<=rows.size(); i++) { //loop through rows
				for (int j=1; j<=columns.size(); j++) {//through cols
					String text=driver.findElement(By.xpath("//table[@id='table2']/tbody/tr["+i+"]/td["+j+"]")).getText();
					System.out.println(text);
				}
			}
			List <WebElement> cells=driver.findElements(By.xpath("//table[@id='table2']/tbody/tr/td")); //td=columns
			for (WebElement cell: cells){
				String cellText=cell.getText();
				System.out.println(cellText);
			}
			
			driver.close();
	}

}
