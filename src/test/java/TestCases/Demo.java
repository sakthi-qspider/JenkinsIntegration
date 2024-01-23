package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo {

	@Test(dataProvider="data-provider")
	public void userLogin(String UserName, String Password) throws Exception {
	    System.out.println("UserName"+UserName+"_____Password"+Password);
	    WebDriver driver=new ChromeDriver();
	    driver.get("https://sampleapp.tricentis.com/101/");
	    driver.manage().window().maximize();
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("(//a[text()='Automobile'])[1]")).click();
	}

	 @DataProvider (name = "data-provider")
     public Object[][] testDataGenerator(){
	 Object[][] data= {{"sakthiaero@ymail.com","111222"}, {"111222","saktthi"}};
	return data;
     }
	
	
}
