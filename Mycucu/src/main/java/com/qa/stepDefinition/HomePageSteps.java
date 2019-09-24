package com.qa.stepDefinition;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class HomePageSteps extends TestBase{
	LoginPage loginpage;
	HomePage homepage=new HomePage();

	@Given("^user opens browser$")
	public void user_opens_browser() throws Throwable {
		TestBase.initialization();
	} 

	@Then("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
		loginpage=new LoginPage();
		String logintitle=loginpage.verifyLoginpageTitle();
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", logintitle);
	}

	@Then("^user logs into the application$")
	public void user_enters_username_and_password() throws Throwable {
		//loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"),(prop.getProperty("password")));
	    
	}



	

	@Then("^Validate Homepage tile$")
	public void validate_Homepage_tile() throws Throwable {
		String homepagetitle=homepage.verifyHomepageTitle();
		Assert.assertEquals("CRMPRO", homepagetitle);
	    
	}


	
	
	
}
