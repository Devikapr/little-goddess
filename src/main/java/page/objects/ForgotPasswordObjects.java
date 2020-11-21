package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordObjects {
	WebDriver driver;
	By userEmail=By.id("user_email");
	By btnInstructions=By.cssSelector("input.btn.btn-primary.btn-md.login-button");
	public ForgotPasswordObjects(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebElement getUserEmail() {
		return driver.findElement(userEmail);
	}
	public WebElement getBtnInstructions() {
		return driver.findElement(btnInstructions);
	}
	
	
	
}
