package com.class12;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import util.CommonMethods;

public class brokenImages extends CommonMethods{
public static void main(String[] args) {
	setUpDriver("chrome","https://the-internet.herokuapp.com/broken_images");
	List <WebElement>images=driver.findElements(By.tagName("img"));
	System.out.println(images.size());
	for (WebElement image:images) {
		String brokenImg=image.getAttribute("src");
		try {
			URL url=new URL(brokenImg);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			int code=con.getResponseCode();
			if(code==200) {
				System.out.println("The image is valid "+brokenImg);
			}else {
				System.out.println("the image is broken "+brokenImg);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	driver.close();
}
}
