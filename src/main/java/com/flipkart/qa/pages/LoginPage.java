package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(xpath="//*[@class='_2IX_2- VJZDxU']")
	WebElement username;

	@FindBy(xpath="//*[@type='password']")
	WebElement password;

	@FindBy(xpath="//*[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement submitButton;

	public LoginPage ()
	{
	PageFactory.initElements(driver, this);


	}
	public HomePage login(String un, String pwd )
	{
	username.sendKeys(un);
	password.sendKeys(pwd);
	submitButton.click();
	return new HomePage();

	}
}
