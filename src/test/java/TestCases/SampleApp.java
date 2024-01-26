package TestCases;



import org.testng.annotations.Test;

<<<<<<< HEAD
import BrowserFactory.Baetest;
=======
import com.relevantcodes.extentreports.LogStatus;

import BrowserFactory.BaeTest;
>>>>>>> 4adc410aae5fc4a8fce5c68f06fbe2485050753c
import PageObject.HomePage;


public class SampleApp extends Baetest {



	@Test
	public void verifyAutomobile() throws Exception {
		
		HomePage page=new HomePage(driver);
		page.clickAutomobile();
		test.log(LogStatus.PASS, "Click Automobile Tab");
		
	}
}
