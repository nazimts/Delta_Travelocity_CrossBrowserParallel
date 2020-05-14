package com.travelocity.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travelocity.utilities.Driver;

public class HotelResultPage {
	
	public HotelResultPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "(//a[@class='listing__link uitk-card-link'])[1]")
	public WebElement hotelName;

	//@FindBy(xpath = "//span[.='Rooms']")
	@FindBy(xpath = "(//span[@class='uitk-tab-text'])[2]")
	public WebElement rooms;
	
	@FindBy(xpath = "(//div[@class='room_name all-b-padding-two'])[1]")
	public WebElement description;
	
	@FindBy(xpath = "(//span[@data-stid='content-hotel-lead-price'])[1]")
	public WebElement price;
	
	@FindBy(xpath = "(//span[starts-with(text(),'Sleeps')])[1]")
	public WebElement numberOfGuests;
	
	@FindBy(xpath = "(//span[contains(text(),'sq ft')])[1]")
	public WebElement square;
	
	@FindBy(xpath = "(//span[contains(text(),'Bed')])[1]")
	public WebElement bed;
	
	
}
