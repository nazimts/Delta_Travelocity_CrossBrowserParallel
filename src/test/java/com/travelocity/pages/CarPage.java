package com.travelocity.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travelocity.utilities.Driver;

public class CarPage {
	public CarPage() {
		
		PageFactory.initElements(Driver.getDriver(), this);
		
		
		
		
		
	}
	@FindBy (xpath = "//button[@data-section-id='#section-car-tab-hp']")
	public WebElement carsClickBitton;
	
	@FindBy (xpath = "//label[@for='car-pickup-hp-car']")
	public WebElement carPickingUp;
	
	@FindBy (xpath = "//label[@for='car-dropoff-hp-car']")
	public WebElement carDropingOff;
	
	@FindBy (xpath = "//input[@name='date1']")
	public WebElement carPickUpDate;
	
	@FindBy (xpath = "//input[@name='date2']")
	public WebElement carDropOffDate;
	
	@FindBy (xpath = "//select[@name='time1']")
	public WebElement carSelectPickUpTime;
	
	@FindBy (xpath = "//select[@name='time2']")
	public WebElement carSelectDropOffTime;
	
	@FindBy (id= "search-button-hp-car")
	public WebElement carsSearhButton;
	
	
	
	
	
	
	@FindBy (xpath = "(//span[@class='icon icon-close'])[2]")
	public WebElement travelUpdate;
	
	
	
	
	

}
