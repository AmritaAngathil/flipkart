package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//title[contains(text(),'Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!')]")
	WebElement pageTitle;

	@FindBy(xpath="//*[contains(text(),'Amrita')]")
	WebElement userName;

	@FindBy(xpath="//*[@type='text']")
	WebElement searchField;

	@FindBy(xpath="//*[@class='L0Z3Pu']")
	WebElement submitSearch;
	
	@FindBy(xpath="//*[contains(text(), 'SAMSUNG 198 L Direct Cool Single Door 5 Star Refrigerator with Base Drawer')]")
	WebElement selectProduct;

	public HomePage()
	{
	PageFactory.initElements(driver, this);
	}

	public boolean verefypageTitle()
	{
	return pageTitle.isDisplayed();

	}

	public boolean verefyCorrectUserName()
	{
	return userName.isDisplayed();

	}

	public ProductPage searchProduct(String sr) throws InterruptedException
	{
	searchField.click();
	searchField.sendKeys(sr);
	submitSearch.click();
	Thread.sleep(5000);
	selectProduct.click();
	return new ProductPage();

	}

}
