package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	WebDriver driver;
	
	
	By userLogin=By.id("user_email");
	
	
	By userPassword=By.id("user_password");
	
	
	By bottonLogin=By.name("commit");
	
	By forgotPswd=By.cssSelector("a[href*='password']");

	public LoginPageObjects(WebDriver driver) {
		super();
		this.driver = driver;
		
	}

	public WebElement getUserLogin() {
		return driver.findElement(userLogin);
	}

	public WebElement getUserPassword() {
		return driver.findElement(userPassword);
	}

	public WebElement getBottonLogin() {
		return driver.findElement(bottonLogin);
	}
	
	public ForgotPasswordObjects getforgotPswd() {
		 driver.findElement(forgotPswd).click();
		 ForgotPasswordObjects fpswd=new ForgotPasswordObjects(driver);
		 return fpswd;
	}

	
	
	
}
