package page.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects {
	WebDriver driver;
	By loginLink=By.cssSelector("a[href*='sign_in']");
	By textData=By.cssSelector("div.text-center h2");
	By navBar=By.cssSelector("ul.nav.navbar-nav.navbar-right");
	By headerTitle=By.cssSelector("[class*='video-banner'] h3");
	By popup=By.xpath("//button[text()='NO THANKS']");
	
	public HomePageObjects(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public LoginPageObjects getLoginLink() {
		 driver.findElement(loginLink).click();
		 LoginPageObjects lp=new LoginPageObjects(driver);
		 return lp;
		 
	}
	public WebElement getLoginLinkForCucumber() {
		return driver.findElement(loginLink);
		
	}
	public int getPopUpSize() {
		return driver.findElements(popup).size();//popup is always part of html dom.so use findElements
		
	}
	
	public WebElement getPopUp() {
		return driver.findElement(popup);//popup is always part of html dom.so use findElements
		
	}


	public WebElement getTextData() {
		return driver.findElement(textData);
	}

	public WebElement getnavBar() {
		return driver.findElement(navBar);
	}
	
	public WebElement getHeaderTitle() {
		return driver.findElement(headerTitle);
	}
	
	}

	
	
	

