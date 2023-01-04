package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestDemo {
	
	@Test
	
	public void testApp(){
		
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://thetestingworld.com/testings/");
		driver.manage().window().maximize();
		
	}

}
