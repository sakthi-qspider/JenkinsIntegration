package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {
	
	
	@Test
	
	public void verifyTest() throws Exception {
	  WebDriver driver=new FirefoxDriver();
	  driver.manage().window().minimize();
	  driver.get("https://sampleapp.tricentis.com/101/");
	 
	  Thread.sleep(4000);
	  boolean status=driver.findElement(By.xpath("(//a[@name='Navigation Automobile'])[1]")).isDisplayed();
	  Assert.assertTrue(status, "Automobile Tab is visible");
	  Assert.assertFalse(status);
	  
	  
	  
	  
	  
	  

		
		
	}

}
