package com.class11;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import util.CommonMethods;
public class FileUpload extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
		String url="https://the-internet.herokuapp.com";
		setUpDriver("chrome", url);
		
		driver.findElement(By.linkText("File Upload")).click();
		
		String filePath="C:/Users/mailo/Desktop/ygol'.png"; // storing the direct (!) path (+extension of the file) to our file
		
		driver.findElement(By.id("file-upload")).sendKeys(filePath);// using SendKeys with the path to our file
		
		driver.findElement(By.id("file-submit")).click();
		
		boolean isDisplayed=driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).isDisplayed();
		if (isDisplayed) {
			System.out.println("File uploaded successfully");
		} else {
			System.out.println("File uploaded unSuccessfully");
		}
		
		//Steps to take a screenshot
		TakesScreenshot ts=(TakesScreenshot)driver; //using TakesScreenshot Interface & downCasting our driver into it
		File pic=ts.getScreenshotAs(OutputType.FILE); //using M() getScreenshot we'll get a File
		try {
			FileUtils.copyFile(pic, new File("screenshots/TheInternet/FileUpload.png"));
			                          //file /where we'll save it/the name of the file
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Screenshot wasn't taken");
		}
		                         
		
		Thread.sleep(4000);
		driver.quit();
	}

}
