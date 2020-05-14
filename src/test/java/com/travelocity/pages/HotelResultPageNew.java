package com.travelocity.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travelocity.utilities.Driver;

public class HotelResultPageNew {
	
	public HotelResultPageNew() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath = "//button[contains(@aria-label,'Going to')]")
	public WebElement goingToField;
	
	@FindBy(id = "hotels-check-in-btn")
	public WebElement checkInField;
	
	@FindBy(id = "hotels-check-out-btn")
	public WebElement checkOutField;
	
	@FindBy(id = "inpSearchFrom")
	public WebElement originField;
	
	@FindBy(id = "inpSearchNear")
	public WebElement destitation;
	
	@FindBy(id = "inpStartDate")
	public WebElement startDate;
	
	@FindBy(id = "inpEndDate")
	public WebElement endDate;
	
	@FindBy(xpath = "//span[@class='wizardTravellerSummaryRoom']")
	public WebElement roomInfo;
	
	@FindBy(xpath = "//span[@class='wizardTravellerSummaryAdults']")
	public WebElement adultInfo;
	
	@FindBy(xpath = "//span[@class='wizardTravellerSummaryChild']")
	public WebElement childInfo;
	
	@FindBy(id = "changeSearchWizard")
	public WebElement changeSearchLink;
	
	
	
	
	
	
	
	@FindBy(xpath = "//span[contains(text(),'room,')]")
	public WebElement guestField;
	
	@FindBy(xpath = "//button[@class='origin fakeLink']")
	public WebElement originInfo;
	
	@FindBy(xpath = "(//button[@class='destination fakeLink'])[2]")
	public WebElement destinationInfo;
	
	@FindBy(xpath = "(//button[@class='dates fakeLink'])[2]")
	public WebElement dateInfo;
	
	@FindBy(xpath = "//button[@class='rooms fakeLink']")
	public WebElement roomsInfo;
	
	@FindBy(xpath = "(//span[@class='wizardTravellerSummaryAdults'])[2]")
	public WebElement travelersInfo;
	
	
	
	
	
	
	

}
