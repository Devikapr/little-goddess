package com.stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import page.objects.HomePageObjects;
import page.objects.LoginPageObjects;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import concepts.framework.practice.BaseClass;

@RunWith(Cucumber.class)
public class CucumberStepDefs extends BaseClass {
	public WebDriver driver;
LoginPageObjects loginPage;
    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
    	driver=initializeDriver();
    }

   
    
    @When("^user enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
    	loginPage=new LoginPageObjects(driver);
    	loginPage.getUserLogin().sendKeys(username);
		loginPage.getUserPassword().sendKeys(password);
		loginPage.getBottonLogin().click();
    }


    @Then("^verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() throws Throwable {
        
    }

    @And("^Navigate to \"([^\"]*)\" website$")
    public void navigate_to_something_website(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }

    @And("^click on LogIn link to land on Login page$")
    public void click_on_login_link_to_land_on_login_page() throws Throwable {
    	HomePageObjects homePage=new HomePageObjects(driver);
    	if(homePage.getPopUpSize()>0) {
    		homePage.getPopUp().click();
    	}
		homePage.getLoginLinkForCucumber().click();;
    }
    @And("^close browsers$")
    public void close_browsers() throws Throwable {
    	driver.close();
    }


}