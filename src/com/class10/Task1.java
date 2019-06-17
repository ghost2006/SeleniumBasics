package com.class10;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import util.CommonMethods;
public class Task1 extends CommonMethods{

	public static void main(String[] args) {
		/*TC 1: Table headers and rows verification
				Open chrome browser.Go to “https://the-internet.herokuapp.com/”.
				Click on “Click on the “Sortable Data Tables” link. Verify tables consist of 4 rows and 6 columns
				Print name of all column headers. Print data of all rows*/
		
		String url="https://the-internet.herokuapp.com/";
		setUpDriver("chrome", url );
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		
		List <WebElement> rows=driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));// getting all rows
		System.out.println("The # of rows: "+rows.size());
		
		for (WebElement row:rows) {
			System.out.println("The data of each row " +row.getText());
		}
		
		List <WebElement> columns=driver.findElements(By.xpath("//table[@id='table1']//thead/tr/th"));//getting all columns
		System.out.println("The # of columns: "+ columns.size());
		Iterator <WebElement> it = columns.iterator();
		while(it.hasNext()) {
			String columnText=it.next().getText();
			System.out.println("The name of each column header is "+columnText);
	}
		driver.quit();
		
	}
}
