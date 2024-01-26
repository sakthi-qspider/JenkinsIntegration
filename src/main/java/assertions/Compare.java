package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Compare {
	
	
	public static  WebDriver driver;
	
	public Compare(WebDriver driver){
		this.driver=driver;
		
	}
	
	public static boolean validatePageURL(String expURL){
		
		boolean flag =false;
		if(driver.getCurrentUrl().equals(expURL)){
			flag=true;
		}
		return flag;
	}
	
	public static boolean validatePageTitle(String expTitle){
		boolean flag=false;
		if(driver.getTitle().equals(expTitle)){
			flag=true;	
		}
		return flag;
		
	}
public static boolean validateText(WebElement element,String exptext){
    boolean flag=false;
     String acutalText=element.getText();
    if(acutalText.equals(exptext)){
    	flag=true;
    }
    return flag;
}
}
