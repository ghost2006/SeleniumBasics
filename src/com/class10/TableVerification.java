package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import util.CommonMethods;

public class TableVerification extends CommonMethods {
	/* TC 1: Table headers and rows verification 
	 * 1. Open browser and go to "http://secure.smartbearsoftware.com/samples/testcomplete11 /WebOrders/login.aspx" 
	 * 2. Login to the application. 3. Create an Order 
	 * 4. Verify order of that person is displayed in the table "List of All Orders". 5. Click on edit of that speciﬁc order 
	 * 6. Verify each order details.7. Update street address.8. Verify in the table that street has been updated. 9. Close browser */
	static String expectedProduct = "ScreenSaver";
	static String expectedQuantity = "11";
	static String expectedName = "John Doe";
	static String expectedStreet = "123 Main St.";
	static String expectedCity = "Fairfax";
	static String expectedState = "VA";
	static String expectedZip = "22030";
	
	static String expectedCard = "Visa";
	static String expectedCardNum = "123456789012345";
	static String expectedExDate = "12/23";

	static String updatedStreet = "456 Main St.";
	public static void main(String[] args) throws InterruptedException {
		
		setUpDriver("chrome","http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		sendText(driver.findElement(By.cssSelector("input[id$='name']")), "Tester");
		sendText(driver.findElement(By.cssSelector("input[id$='word']")), "test");
		driver.findElement(By.cssSelector("input[id$='button']")).click();
	
		//click order link
		driver.findElement(By.linkText("Order")).click();
		System.out.println("---------------- Fill out each order element ----------------");
		selectValueFromDD(driver.findElement(By.xpath("//select[contains(@id, 'ctl00_MainContent')]")), "FamilyAlbum");
		
		driver.findElement(By.cssSelector("input[id*='Quantity']")).clear();
		driver.findElement(By.cssSelector("input[id*='Quantity']")).sendKeys(expectedQuantity);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(3000);
	
		driver.findElement(By.cssSelector("input[id*='Name']")).sendKeys(expectedName);
		driver.findElement(By.cssSelector("input[id*='Box2']")).sendKeys(expectedStreet);
		driver.findElement(By.cssSelector("input[id*='Box3']")).sendKeys(expectedCity);
		driver.findElement(By.cssSelector("input[id*='Box4']")).sendKeys(expectedState);
		driver.findElement(By.cssSelector("input[id*='Box5']")).sendKeys(expectedZip);
		driver.findElement(By.cssSelector("input[value='"+expectedCard+"']")).click();
		
		driver.findElement(By.cssSelector("input[id*='Box6']")).sendKeys(expectedCardNum);
		driver.findElement(By.cssSelector("input[id*='Box1']")).sendKeys(expectedExDate);
		driver.findElement(By.cssSelector("a[id*='Button']")).click();
		
		if(driver.findElement(By.xpath("//strong[contains(text(), 'New order has been successfully added.')]")).isDisplayed()) {
			System.out.println("New order has been successfully added");
		} else {
			System.out.println("smth wrong");
		}
		
		System.out.println("---------------- Verify each order details ----------------");
		//Back to main page
		driver.findElement(By.linkText("View all orders")).click();
		//Verify order of that person is displayed in the table "List of All Orders" 
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr"));
		boolean isFound = false;
		for(int i=1; i<=rows.size(); i++) {
			String rowInfo = driver.findElement(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr["+i+"]")).getText();
			if(rowInfo.contains(expectedName)) {
				System.out.println("TC Pass: New Order for " + expectedName + " is found");
				driver.findElement(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr["+i+"]/td[13]")).click();
				isFound = true;
				break;
			}
		}
		if(!isFound) {
			System.out.println("TC Fail: New Order for "+ expectedName + " is NOT found");
		}
		
		if(driver.findElement(By.xpath("//h2[contains(text(),'Edit Order')]")).isDisplayed()){	// Edit order is displayed
			System.out.println("[d] On Edit Order page");
			//Verify each order details 
			verifyOrderDetail();
			Thread.sleep(2000);
			
			//update street
			driver.findElement(By.cssSelector("input[id*='Box2']")).clear();
			driver.findElement(By.cssSelector("input[id*='Box2']")).sendKeys(updatedStreet);
			// Submit modification
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("a[id*='Button']")).click();
		} else {
			System.out.println("Edit Order page is NOT present");
		}
		//Verify in the table that street has been updated 
		isFound = false;
		for(int i=1; i<=rows.size(); i++) {
			String rowInfo = driver.findElement(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr["+i+"]")).getText();
			if(rowInfo.contains(updatedStreet) && rowInfo.contains(expectedName)) {
				System.out.println("TC Pass: Information update " + updatedStreet + " is completed for " + expectedName);
				isFound = true;
				break;
			}
		}
		if(!isFound) {
			System.out.println("TC Fail: Information update " + updatedStreet + " is failed");
		}

		driver.quit();
	}
	
		public static void verifyOrderDetail() throws InterruptedException {
			//Verify each order details 
			System.out.println("---------------- Verify each order details ----------------");
			if(driver.findElement(By.cssSelector("select[id*='Product']")).getAttribute("value").equals(expectedProduct)){
				System.out.println(expectedProduct+ " is verified");
			} else {
				System.out.println("smth wrong");
			}
			if(driver.findElement(By.cssSelector("input[id*='Quantity']")).getAttribute("value").equals(expectedQuantity)){
				System.out.println(expectedQuantity + " is verified");
			}else {
				System.out.println("smth wrong");
			}
		
			Integer quantity = Integer.parseInt(driver.findElement(By.cssSelector("input[id*='Quantity']")).getAttribute("value"));
			Integer PricePerUnit = Integer.parseInt(driver.findElement(By.cssSelector("input[id*='Unit']")).getAttribute("value"));
			Integer Discount = Integer.parseInt(driver.findElement(By.cssSelector("input[id*='Discount']")).getAttribute("value"));
			Integer total = Integer.parseInt(driver.findElement(By.cssSelector("input[id*='Total']")).getAttribute("value"));
			
			if(total == quantity*PricePerUnit*(100-Discount)/100) {
				System.out.println("Total : " + total + " is verified");
			}
			Thread.sleep(3000);
			if(driver.findElement(By.cssSelector("input[id*='Name']")).getAttribute("value").equals(expectedName)){
				System.out.println(expectedName + " is verified");
			}else {
				System.out.println("smth wrong");
			}
			if(driver.findElement(By.cssSelector("input[id*='Box2']")).getAttribute("value").equals(expectedStreet)){
				System.out.println(expectedStreet + " is verified");
			}else {
				System.out.println("smth wrong");
			}
			if(driver.findElement(By.cssSelector("input[id*='Box3']")).getAttribute("value").equals(expectedCity)){
				System.out.println(expectedCity + " is verified");
			}else {
				System.out.println("smth wrong");
			}
			if(driver.findElement(By.cssSelector("input[id*='Box4']")).getAttribute("value").equals(expectedState)){
				System.out.println(expectedState + " is verified");
			}else {
				System.out.println("smth wrong");
			}
			if(driver.findElement(By.cssSelector("input[id*='Box5']")).getAttribute("value").equals(expectedZip)){
				System.out.println(expectedZip + " is verified");
			}else {
				System.out.println("smth wrong");
			}
			if(driver.findElement(By.cssSelector("input[checked='checked']")).getAttribute("value").equals(expectedCard)){
				System.out.println(expectedCard + " is verified");
			}else {
				System.out.println("smth wrong");
			}
			if(driver.findElement(By.cssSelector("input[id*='Box6']")).getAttribute("value").equals(expectedCardNum)){
				System.out.println(expectedCardNum + " is verified");
			}else {
				System.out.println("smth wrong");
			}
			if(driver.findElement(By.cssSelector("input[id*='Box1']")).getAttribute("value").equals(expectedExDate)){
				System.out.println(expectedExDate + " is verified");
			}else {
				System.out.println("smth wrong");
			}
		
		}
}