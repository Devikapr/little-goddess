package concepts.framework.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	public WebDriver driver;
	Properties properties;
public WebDriver initializeDriver() {
	try {
		 properties=new Properties();
		FileInputStream stream=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		properties.load(stream);
		//String browserName=System.getProperty("Browser");//We can define the browser name from the maven command using this step
		String browserName=properties.getProperty("Browser");
		
		/*
		 * Here the test will trigger with the browser name given inside properties
		 * file,if we want to change browser,then we've to update the data.properties
		 * file
		 */
		
		
		// you are not allowed to use equality(==)operator when you are extracting valus from a properties file.
		//here variable browserName contains the valus that is extracted from data.properties
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			
			 driver=new ChromeDriver(options);
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe"); 
			 driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe"); 
			 driver = new InternetExplorerDriver();
		}
		
	}
	catch(Exception e){
		System.out.println(e);
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
}

public String getScreenshotOfTestFailures(String testcaseName,WebDriver driver) throws IOException {
	
	TakesScreenshot tk=(TakesScreenshot) driver;
	File source=tk.getScreenshotAs(OutputType.FILE);
	String destinationFilePath=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
	FileUtils.copyFile(source, new File(destinationFilePath));
	return destinationFilePath;
	
}
}
