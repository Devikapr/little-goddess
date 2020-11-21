package concepts.framework.practice;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.objects.HomePageObjects;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
public class ValidateNavBar extends BaseClass {
	public WebDriver driver;
	private static Logger log=LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	public void initializeTest() {
		driver=initializeDriver();//creating object without new operator
		driver.get(properties.getProperty("URL"));
	}
	
	@Test
	public void navBarDisplayedOrNot() {
		
		HomePageObjects homePage=new HomePageObjects(driver);
		//out reuirement is to compare the h2 value from browser with actual value (provided in the client doc)
		//System.out.println(homePage.getTextData().getText());
		Assert.assertTrue(homePage.getnavBar().isDisplayed());		
	}
	
	@AfterTest
	public void cleanUp() {
		driver.close();
	}
}
