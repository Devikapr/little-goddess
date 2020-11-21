package concepts.framework.practice;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.objects.HomePageObjects;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
public class ValidateTitle extends BaseClass {
	public WebDriver driver;
	HomePageObjects homePage;
	private static Logger log=LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	public void initializeTest() {
		driver=initializeDriver();//creating object without new operator
		log.info("Driver initialized..");
		driver.get(properties.getProperty("URL"));
		
		log.info("Navigated to home page");
	}
	@Test
	public void titleTextValidation() {
		
		
		 
		//out reuirement is to compare the h2 value from browser with actual value (provided in the client doc)
		//System.out.println(homePage.getTextData().getText());
		Assert.assertEquals(homePage.getTextData().getText(), "featured courses");
		log.info("Successfully validated..");
		
		
		
	}
	
	@Test
	public void headerTextValidation() {
		homePage=new HomePageObjects(driver);
		//out reuirement is to compare the h2 value from browser with actual value (provided in the client doc)
		System.out.println(homePage.getHeaderTitle().getText());
		//Assert.assertEquals(homePage.getHeaderTitle().getText(), "An Academy to learn Everything about Testing");
		log.info("Header successfully validated..");
		
		
		
	}
	
	@AfterTest
	public void cleanUp() {
		driver.close();
	}
}
