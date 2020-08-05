package com.goibibo.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.goibibo.base.BasePage;
import com.goibibo.pages.ApplicationPage;
import com.goibibo.pages.SearchResultPage;

public class ApplicationPageTest extends BasePage {

		ApplicationPage applicationPage;
		SearchResultPage searchResultPage;

	public ApplicationPageTest() {
		super();
	}
		
		@BeforeMethod
		public void setUp() {
		initialization();
		applicationPage = new ApplicationPage();
			
		}
		
		
		
		//@Test(priority=1)
		//public void applicationPageTitleTest() {
		//	String title = loginPage.validateApplicationPage();
		//	Assert.assertEquals(title, "Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off");
		
		@Test
		public void validateAppPageAndenterItineraryDetailsTest() throws InterruptedException {
			String title = applicationPage.validateApplicationPage();
			Assert.assertEquals(title, "Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off");
			applicationPage.enterFromCity();
			applicationPage.enterDestinationCity();
			applicationPage.departureDate();
			//applicationPage.returnDate();
			searchResultPage = applicationPage.clickSearchBtn();
		
		}
		
		
		
		@AfterMethod
		public void tearDown() {
		driver.quit();
			
		}
		
		
}

	
