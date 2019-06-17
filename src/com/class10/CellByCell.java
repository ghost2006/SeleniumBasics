package com.class10;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.CommonMethods;
public class CellByCell extends CommonMethods{

	public static void main(String[] args) {
	
		String url="https://the-internet.herokuapp.com/";
		setUpDriver("chrome", url );
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		
		// number of rows
		List <WebElement> rows=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		// number of columns
		List <WebElement> columns=driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		
		for (WebElement r:rows) {
			System.out.println(r.getText());
		}
		/* how to print value cell by cell
		   1. loop through all rows --outer loop
		   2. loop through all columns
		   driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[rows]/td[cols]")).getText(); */
		
		//1st way
		for (int i=1; i<=rows.size(); i++) {  //Starting from the 1, so we have to use i<=rows.size()!!!
			for (int j=1; j<=columns.size(); j++) {
			   String cellText=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]")).getText();
			   System.out.println(cellText);
			}
		}
		System.out.println("---------2d way------------");
		//2d way can use for calendars
		List <WebElement> cells=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));//go inside row/col-->go through all cells (td_s elements)
		for (WebElement cell: cells){
			String cellText=cell.getText();
			System.out.println(cellText);
		}
		driver.quit();
	}
}
