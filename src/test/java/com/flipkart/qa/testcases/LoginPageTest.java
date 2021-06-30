package com.flipkart.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest()
	{
	super();
	}


	@BeforeMethod
	public void setUp()
	{
	initialization();
	loginPage= new LoginPage();

	}


	@Test
	public void loginTest()
	{
		log.debug("login to flipkart");
		 homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}


	@AfterMethod
	public void tearDown()
	{
	driver.quit();
	}
}
