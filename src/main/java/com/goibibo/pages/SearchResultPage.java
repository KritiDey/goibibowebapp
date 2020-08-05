package com.goibibo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.goibibo.base.BasePage;

public class SearchResultPage extends BasePage {
	
	
	public SearchResultPage(){
		PageFactory.initElements(driver, this);
	}
	     public static By bookBtn = By.xpath("//input[@type ='button' and @value= 'BOOK'][1]");
	//input[@type ='button' and @value= 'BOOK'][1]
		//public static By priceArrow = By.className(("span.fb.ico11.hpyBlueLt"));
		//public static By destinationTxt = By.xpath("//input[@class = 'inputSrch' and @placeholder = 'Destination']");
		//public static By departureCalendar = By.xpath("//input[@id = 'departureCalendar']");
		//public static By returnCalendar = By.xpath("//input[@id = 'returnCalendar']");
		//public static By searchBtn = By.xpath("//button[contains(text(), 'SEARCH')]");
		
		
		public void sortWithHigherPrice() {
			
			WebElement priceArrow = driver.findElement(By.cssSelector("span.fb.ico11.hpyBlueLt"));
			priceArrow.click();
				
		}
		
		public BookFlightPage clickBookButton() {
			WebDriverWait wd = new WebDriverWait(driver, 30);
			wd.until(ExpectedConditions.visibilityOfElementLocated(bookBtn));
			WebElement bookButton = driver.findElement(bookBtn);
			bookButton.click();
			return new BookFlightPage();
		}
		
		
		
		

}
