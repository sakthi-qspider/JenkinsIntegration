package Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAction {
	
	WebDriver driver;
	WebDriverWait wait;
	Select sel;
	
	
	public PageAction(WebDriver driver) throws NumberFormatException, Exception {
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReader.getConfig("ExplicitWait"))));
		
	}
	
	public void enterInput(WebElement element,String inputText) {
		wait.until(ExpectedConditions.visibilityOf(element)).clear();
		
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(inputText);
		
	}
	public void clickElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}
	
	public String getText(WebElement element) {
		
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
		
		
	}
	
	public Boolean verifyElement(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
		
		
	}
	public void selectDropDown(WebElement element,String inputText) {
		sel=new Select(element);
		sel.selectByVisibleText(inputText);
	}
	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
		
	

}
