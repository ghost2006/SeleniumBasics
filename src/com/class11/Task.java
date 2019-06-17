package com.class11;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import util.CommonMethods;
public class Task extends CommonMethods {

	public static void main(String[] args) {
		
		/*TC 1: Upload file and Take Screenshot
				Navigate to “http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload”
				Upload file. Verify file got successfully uploaded and take screenshot*/

		setUpDriver("chrome", "http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload");
		
		takeScreenshot("task", "Login");
		
		String filePath="C:/Users/mailo/Desktop/ygol'.png"; //always have to ad extension!!!!
		driver.findElement(By.id("gwt-debug-cwFileUpload")).sendKeys(filePath);
		driver.findElement(By.cssSelector("button.gwt-Button")).click();
		
		String expected="File uploaded!";
		String text=getAlertText();
		if (text.equals(expected)) {
			System.out.println("File is uploaded");
		}else {
			System.out.println("File isn't uploaded");
		}
		acceptAlert();
		takeScreenshot("task", "Upload");
		TakesScreenshot sc=(TakesScreenshot)driver;   //downCasting
		File pic=sc.getScreenshotAs(OutputType.FILE); // using getScrennshotAS m() --> returns a file
		try {
			FileUtils.copyFile(pic,new File("screenshots/task/Task.jpg")); //copy file into specified folder +extension
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("the screenshot was captured succssesfully");
		}
		
		driver.close();
	}

}
