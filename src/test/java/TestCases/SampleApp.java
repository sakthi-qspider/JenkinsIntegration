package TestCases;



import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import BrowserFactory.BaeTest;
import PageObject.HomePage;


public class SampleApp extends BaeTest {



	@Test
	public void verifyAutomobile() throws Exception {
		
		HomePage page=new HomePage(driver);
		page.clickAutomobile();
		test.log(LogStatus.PASS, "Click Automobile Tab");
		
	}
}
