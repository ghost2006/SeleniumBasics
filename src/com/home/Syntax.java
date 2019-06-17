package com.home;
public class Syntax {
	public static void main(String[] args) {
		/*
		  driver.findElement(By.id("email"));
		  driver.findElement(By.name("register"));
		  driver.findElement(By.linkText("Downloads"));
		  driver.findElement(By.PartialLinkText("Download"));
		  driver.findElement(By.className("Password"));
		  driver.findElement(By.tagName("a"));
		 
		* X path
		   html/body/div/div[5]/div/div/div/[2]/div/form/fieldset/div[8]/input[@name='firstname']  Absolute
		  
	 Relative	// tag [@attribute=’value’]     
		    
		     //tag[contains(@attribute,'value')]
		     //tag[contains( text(),'value')]   OR tag[contains(.,'text')]
		    
		     //tag[starts-with(@attribute,’value’)]
		     //tag[starts-with(text(), ’value')]
		      
		     // h3[text()='Forgot account?'] - for Text
		     //*[.'Forgot account?'] -- find exact text
		  
   Advanced xPath 
 1. If Parent is having unique identification               --> parentXpath/childTagName
 2. If immediate child is having unique identification      --> childXpath/..
 3. If the next element is having unique identification     --> nextElementXpath/preceding-sibling::tagName
 4. If the previous element is having unique identification --> previousElementXpath/following-sibling::tagName
	OR //sibling xpath/..//input[@name='txtUsername'] -- from sibling--> to parent & --> to WE we are looking for using his actual xpath  
		
		 * CSS Selector
		    Tag & ID         tag[id='current time'] OR tag#current time   
		    Tag & class      input[name='firstname'] OR input.firstname
		    Tag & attribute  input[placeholder=‘Enter name’]
		    
		    input[id^='ema']   -- starts with
		    input[id$='mail']  -- ends with
			input[id*='mai']   -- contains  
		
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 */
	}

}
