package concepts.framework.practice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.objects.ForgotPasswordObjects;
import page.objects.HomePageObjects;
import page.objects.LoginPageObjects;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
public class HomePage extends BaseClass {
	public WebDriver driver;
	private static Logger log=LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	public void initializeTest() {
		driver=initializeDriver();//creating object without new operator
		
		
	}
	
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String uname,String pswd,String usertype) {
		driver.get(properties.getProperty("URL"));
		
		HomePageObjects homePage=new HomePageObjects(driver);
		LoginPageObjects loginPage=homePage.getLoginLink();
		
	
		loginPage.getUserLogin().sendKeys(uname);
		loginPage.getUserPassword().sendKeys(pswd);
		System.out.println("User Type is : "+usertype);
		loginPage.getBottonLogin().click();
		
		ForgotPasswordObjects forgotPswd=loginPage.getforgotPswd();
		forgotPswd.getUserEmail().sendKeys("xxxx@gmail.com");
		forgotPswd.getBtnInstructions().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data=new Object[2][3];
		
		data[0][0]="restricted@gmail.com";
		data[0][1]="ddddd";
		data[0][2]="restrictedUser";
		
		data[1][0]="nonrestricted@gmail.com";
		data[1][1]="ggggg";
		data[1][2]="nonrestrictedUser";
		
		return data;
	}
	
	@AfterTest
	public void cleanUp() {
		driver.close();
	}

}
