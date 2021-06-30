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

public class PaymentPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;
	PaymentPage paymentPage;
	public PaymentPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		paymentPage = new PaymentPage();
		productPage = new ProductPage();
		homePage= new HomePage();
		loginPage= new LoginPage();
		
		
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(5000);
		homePage.searchProduct("Refrigerator ");
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));
        productPage.productBuyNow();
	}
	
	
	
	@Test(priority=2)
	public void payment() throws IOException, InterruptedException 
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map<String,String>testData = ExcelUtil.getMap();
		
		String creditcardNumber = paymentPage.paymentStep(testData.get("Credit Card Number"));
		String message=paymentPage.invalidCardNumber();
		Assert.assertEquals(message, "Not a valid card number","Valid Number");
		log.debug("Card validation");

	}

		
	@Test(priority=1)
	public void verifyPageIconTest() throws InterruptedException
	{
		Thread.sleep(5000);
	Assert.assertTrue(paymentPage.verefypageIcon());
	log.debug("Page icon verification");
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}



}
