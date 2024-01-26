package TestCases;



import org.testng.annotations.Test;

import BrowserFactory.Baetest;
import PageObject.HomePage;


public class SampleApp extends Baetest {



	@Test
	public void verifyAutomobile() throws Exception {
		
		HomePage page=new HomePage(driver);
		page.clickAutomobile();
		
	}
}
