package com.goibibo.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.goibibo.base.BasePage;
import com.goibibo.util.TestUtil;


public class ApplicationPage extends BasePage {
	
	public ApplicationPage(){
		PageFactory.initElements(driver, this);
	}

		
		public static By fromTxt = By.xpath("//input[@class = 'inputSrch' and @placeholder = 'From']");
		public static By destinationTxt = By.xpath("//input[@class = 'inputSrch' and @placeholder = 'Destination']");
		public static By departureCalendar = By.xpath("//input[@id = 'departureCalendar']");
		public static By returnCalendar = By.xpath("//input[@id = 'returnCalendar']");
		public static By searchBtn = By.xpath("//button[contains(text(), 'SEARCH')]");
		
		
		
		
		public String validateApplicationPage() {
			return driver.getTitle();
		}
		
		public void enterFromCity() throws InterruptedException {
			//WebDriverWait nw = new WebDriverWait(driver, 10);
			//nw.until(ExpectedConditions.visibilityOfElementLocated(fromTxt));
			
			WebElement element = driver.findElement (By.id("gosuggest_inputSrc"));
			element.sendKeys("Delhi (DEL)");
			//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			//WebDriverWait nw1 = new WebDriverWait(driver, 10);
			//WebElement we = nw1.until(ExpectedConditions.visibilityOfElementLocated(By.id("gosuggest_inputSrc")));
			Thread.sleep(3000);
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.ENTER);
			//WebDriverWait wait = new WebDriverWait(driver, 10);
			//element= wait.until(ExpectedConditions.visibilityOfElementLocated(fromTxt));
}
		
		public void enterDestinationCity() throws InterruptedException {
	       // WebDriverWait nw = new WebDriverWait(driver, 10);
			//WebElement we1 = nw.until(ExpectedConditions.visibilityOfElementLocated(destinationTxt));
			WebElement element = driver.findElement (By.id("gosuggest_inputDest"));
			element.sendKeys("Mumbai (BOM)");
			//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			Thread.sleep(3000);
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.ENTER);
			//WebDriverWait nw1 = new WebDriverWait(driver, 10);
			//WebElement we= nw1.until(ExpectedConditions.visibilityOfElementLocated(By.id("gosuggest_inputDest")));

		}
		
		public void departureDate() {
			
	         WebDriverWait nw = new WebDriverWait(driver, 10);
			WebElement we1= nw.until(ExpectedConditions.elementToBeClickable(departureCalendar));
			driver.findElement(departureCalendar).click();
			//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			WebDriverWait nw1 = new WebDriverWait(driver, 10);
			WebElement we= nw1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#fare_20200817")));
			WebElement deptCal = driver.findElement(By.cssSelector("div#fare_20200817"));
			deptCal.click();
		
		}
		
		public void returnDate() {
			//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.findElement(returnCalendar).click();
			WebElement retCal = driver.findElement(By.id("fare_20200828"));
			retCal.click();
		}

		public SearchResultPage clickSearchBtn() {
			//WebDriverWait nw = new WebDriverWait(driver, 10);
			//nw.until(ExpectedConditions.visibilityOfElementLocated(searchBtn));
			driver.findElement(searchBtn).click();
			return new SearchResultPage();
		}
}