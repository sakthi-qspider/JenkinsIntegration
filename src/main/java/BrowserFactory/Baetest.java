package BrowserFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ConfigReader;
import Utility.PageAction;

<<<<<<< HEAD:src/main/java/BrowserFactory/Baetest.java
public class Baetest {
=======
public class BaeTest {
	
	public ExtentReports report;
	public ExtentTest test;
	public String path="./Report/"+System.currentTimeMillis()+"ExtentReportResults.html";
>>>>>>> 4adc410aae5fc4a8fce5c68f06fbe2485050753c:src/main/java/BrowserFactory/BaeTest.java
	public WebDriver driver;
	
	//String browserName="Firefox";
	
	
	@BeforeMethod
	
	public void openApplication() throws Exception {
		
		if(ConfigReader.getConfig("browser").equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
			
		}else if(ConfigReader.getConfig("browser").equalsIgnoreCase("Firefox")) {
			
			driver=new FirefoxDriver();
			
		}else if(ConfigReader.getConfig("browser").equalsIgnoreCase("IE")) {
			
			driver=new EdgeDriver();
			
		}else {
			System.out.println("Please Specifi the browser....");
		}
		driver.manage().window().maximize();
		report=new ExtentReports(path, true);
		test=report.startTest("Demo");
		driver.get(ConfigReader.getConfig("url"));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getConfig("PageLoad"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getConfig("ImplicitWait"))));
		System.out.println(ConfigReader.getConfig("ImplicitWait"));
		
	}
	
	
	
	@AfterMethod
	public void closeApplication(ITestResult result) throws Exception {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(LogStatus.FAIL,result.getName());
			String screenshotPath =PageAction.getScreenhot(driver, result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		}
		
		
		
		
		
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
