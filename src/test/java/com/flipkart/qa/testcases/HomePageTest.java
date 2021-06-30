package com.flipkart.qa.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.pages.ProductPage;
import com.flipkart.qa.util.ExcelUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;

	public HomePageTest()
	{
	super();
	}

	@BeforeMethod
	public void setUp()
	{
	initialization();
	productPage = new ProductPage();
	homePage= new HomePage();
	loginPage= new LoginPage();
	loginPage.login(prop.getProperty("username"),prop.getProperty("password"));

	}

	@Test(priority=1)
	public void verifyPageTitleTest() throws InterruptedException
	{
		Thread.sleep(5000);
	Assert.assertFalse(homePage.verefypageTitle());
	log.debug("Page title verification");
	}
	@Test(priority=2)
	public void veifyUserNameTest()
	{
	Assert.assertTrue(homePage.verefyCorrectUserName());
	log.debug("User name verification");
	}
	

	@Test(priority=3)
	public void searchProductStep() throws InterruptedException, IOException
	{
		
		Thread.sleep(5000);
		Map<String,String> testData = ExcelUtil.getMap();
		productPage = homePage.searchProduct(testData.get("Product Name"));
		
	
	ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(newTb.get(1));
    log.debug("Searching a product");
	}


	@AfterMethod
	public void tearDown()
	{
	driver.quit();
	}
}
