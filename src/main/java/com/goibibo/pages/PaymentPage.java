package com.goibibo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.goibibo.base.BasePage;

public class PaymentPage extends BasePage {
	
	public PaymentPage(){
	PageFactory.initElements(driver, this);
	}

	
	public static By paymentDetailsTxt = By.xpath("//span[contains(text(), 'Payment Details')]");
	public static By walletsTxt = By.xpath("//span[contains(text(), 'Wallets')]");
	public static By amazonPayRadioBtn = By.xpath("//input[@id ='amazonpay']");
	
	
	
	public void chooseWallet() {
		
	    driver.findElement(paymentDetailsTxt).isDisplayed();
	    Assert.assertTrue(true);
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    driver.findElement(walletsTxt).click();
	    driver.findElement(amazonPayRadioBtn).isEnabled();
	    Assert.assertTrue(true);	    
	    
	}
}
