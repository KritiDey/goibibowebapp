package com.goibibo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.goibibo.base.BasePage;

public class BookFlightPage extends BasePage {
	
	public BookFlightPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public static By ticketDetailsTxt = By.xpath("//span[contains(text(), 'Ticket')]");
	public static By titleTxt = By.xpath("//select[@id = 'Adulttitle1']");
	//public static By titleTxt = By.id("select#Adulttitle1");
	public static By firstNameTxt = By.xpath("//input[@name= 'AdultfirstName1']");
	//public static By firstNameTxt = By.id("input#AdultfirstName1");
	//public static By lastNameTxt = By.id("input#AdultlastName1"); 
	public static By lastNameTxt = By.xpath("//input[@name= 'AdultlastName1']");
	public static By emailTxt = By.xpath("//input[@type = 'email']");
	public static By mobileTxt = By.xpath("//input[@type = 'text' and @name = 'mobile']");
	public static By proccedBtn = By.xpath("//button[contains(@class, 'button orange')]");
	
			
	
	public void verifyTicketDetails() {
		boolean ticketDetails = driver.findElement(ticketDetailsTxt).isDisplayed();
		Assert.assertEquals(true, ticketDetails);
	}
	
	public void selectTravelProtection() {
	     JavascriptExecutor executor = (JavascriptExecutor)driver;
	     executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    // executor.executeScript("arguments[0].scrollIntoView(true);", ticketDetailsTxt);
		//Thread.sleep(500); 
		WebElement secureTripRadioBtn = driver.findElement(By.cssSelector("input#secure-trip"));
		WebDriverWait nw = new WebDriverWait(driver, 20);
		nw.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#secure-trip")));
		secureTripRadioBtn.click();
	}

	public void enterTravellerDetails() {
	     JavascriptExecutor travDet = (JavascriptExecutor)driver;
	     travDet.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    // executor.executeScript("arguments[0].scrollIntoView(true);", ticketDetailsTxt);
		//Thread.sleep(1000); 
	    WebDriverWait nw = new WebDriverWait(driver, 20);
		nw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'Adulttitle1']")));
		WebElement ele = driver.findElement(titleTxt);
		ele.sendKeys("Ms");
		ele.sendKeys(Keys.ENTER);
		ele.sendKeys(Keys.TAB);
		WebElement ele1 = driver.findElement(firstNameTxt);
		ele1.click();
		ele1.sendKeys("Kriti");
		ele1.sendKeys(Keys.TAB);
		WebElement ele2 = driver.findElement(lastNameTxt);
		ele2.sendKeys("Dey");
		ele2.sendKeys(Keys.TAB);
		WebElement ele3 = driver.findElement(emailTxt);
		ele3.sendKeys("kritidey16@gmail.com");
		ele3.sendKeys(Keys.TAB);
		WebElement ele4 = driver.findElement(mobileTxt);
		ele4.sendKeys("9108830276");
		ele4.sendKeys(Keys.TAB);
		
	}
	
	public PaymentPage clickProceedToPaymentBtn() {
		
		WebDriverWait nw = new WebDriverWait(driver, 20);
		nw.until(ExpectedConditions.visibilityOfElementLocated(proccedBtn));
		driver.findElement(proccedBtn).click();
		return new PaymentPage();
	}

	
}
