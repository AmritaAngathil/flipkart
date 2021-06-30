package com.flipkart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class PaymentPage extends TestBase {

	@FindBy(xpath="//button[text()='CONTINUE']")
	WebElement paymentContinueClick;
	
	@FindBy(xpath="//div[text()='Credit / Debit / ATM Card' and @class='_2nxZhC']")
	WebElement selectCreditCard;
	
	@FindBy(xpath="//input[@name='cardNumber']")
	WebElement cardNumberField;
	
	@FindBy(xpath="//span[@class='_2XN54t']")
	WebElement invalidMessage;
	
	@FindBy(xpath="//*[@class='_2xm1JU']")
	WebElement pageIcon;


	
	public PaymentPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String paymentStep(String cno) throws InterruptedException
	{
		paymentContinueClick.click();
		Thread.sleep(5000);
		selectCreditCard.click();
		cardNumberField.click();
		cardNumberField.sendKeys(cno);
		return cno;
		
		
	

	}
	public String invalidCardNumber()
	{
		String sr="";
		if(driver.findElements(By.xpath("//span[@class='_2XN54t']")).size()<10)
		{
			System.out.println("Invalid Card Number");
			sr=invalidMessage.getText();
		}
		else
		{
			System.out.println("Not Found Eror");
		}
		return sr;
	}
	public boolean verefypageIcon()
	{
	return pageIcon.isDisplayed();

	}
}
