package com.goibibo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.goibibo.base.BasePage;
import com.goibibo.pages.ApplicationPage;
import com.goibibo.pages.BookFlightPage;
import com.goibibo.pages.PaymentPage;
import com.goibibo.pages.SearchResultPage;

public class BookFlightPageTest  extends BasePage {

	    ApplicationPage applicationPage;
		SearchResultPage searchResultPage;
		BookFlightPage bookFlightPage;
		PaymentPage paymentPage;

	public BookFlightPageTest() {
		super();
	}
		
	@BeforeMethod
	public void setUp() throws InterruptedException {
	initialization();
	applicationPage = new ApplicationPage();
	applicationPage.enterFromCity();
	applicationPage.enterDestinationCity();
	applicationPage.departureDate();
	//applicationPage.returnDate();
	searchResultPage = applicationPage.clickSearchBtn();
	searchResultPage.sortWithHigherPrice();
	bookFlightPage = searchResultPage.clickBookButton();

		
	}
		
		
		
		//@Test(priority=1)
		//public void applicationPageTitleTest() {
		//	String title = loginPage.validateApplicationPage();
		//	Assert.assertEquals(title, "Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off");
		
		@Test
		public void enterBookingDetails()  {
			bookFlightPage.verifyTicketDetails();
			bookFlightPage.selectTravelProtection();	
			bookFlightPage.enterTravellerDetails();
			paymentPage = bookFlightPage.clickProceedToPaymentBtn();
		
		}
		
		
		
		@AfterMethod
		public void tearDown() {
		driver.quit();
			
		}
		

}
