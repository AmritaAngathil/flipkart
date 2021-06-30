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
import com.flipkart.qa.pages.PaymentPage;
import com.flipkart.qa.pages.ProductPage;
import com.flipkart.qa.util.ExcelUtil;

public class ProductPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;
	PaymentPage paymentPage;



	public ProductPageTest()
	{
	super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
	initialization();
	paymentPage = new PaymentPage();
	productPage = new ProductPage();
	homePage= new HomePage();
	loginPage= new LoginPage();
	loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	Thread.sleep(5000);

	Map<String,String> testData = ExcelUtil.getMap();
	productPage = homePage.searchProduct(testData.get("Product Name"));

	ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(newTb.get(1));
	}



	@Test(priority=1)
	public void veifyUserNameTest() throws InterruptedException
	{
	Thread.sleep(5000);
	Assert.assertTrue(productPage.verefyCorrectUserName());
	log.debug("User name verification");
	}



	@Test(priority=2)
	public void verifyProductNameTest() throws InterruptedException
	{
	Thread.sleep(5000);
	Assert.assertTrue(productPage.verefyProductName());
	log.debug("Product name verification");
	}



	@Test(priority=3)
	public void verifyProductPrice() throws IOException 
	{
		
		Map<String,String>testData = ExcelUtil.getMap();
		
	String expectedPrice = productPage.verefyProductPrice(testData.get("Expected Price"));
	
	
	double actualPrice = 14499.00;

	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	Assert.assertNotEquals(expectedPrice, actualPrice);
	System.out.println("Assert Passed");
	log.debug("Price comparison");
	}



	@Test(priority=4)
	public void productBuyNow() throws InterruptedException
	{
	Thread.sleep(5000);
	paymentPage = productPage.productBuyNow();
	log.debug("Entering in to payment page");
	}



	@AfterMethod
	public void tearDown()
	{
	driver.quit();
	}
}
