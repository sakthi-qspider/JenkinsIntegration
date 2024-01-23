package ExcelDemo;


import org.testng.annotations.Test;

public class dataTest {
	
	
	
	@Test(dataProvider="empLogin",dataProviderClass = dataProvider.class)
	
	public void sample(String username,String password) {
		
		
		 System.out.println("UserName : "+username+" __ "+"Password: "  +password);
	} 

}
