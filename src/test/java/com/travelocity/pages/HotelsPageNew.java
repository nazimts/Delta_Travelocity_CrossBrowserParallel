package com.travelocity.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.travelocity.utilities.Driver;

public class HotelsPageNew {

	public HotelsPageNew() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id = "tab-hotel-tab-hp")
	public WebElement hotelsMenu;

	@FindBy(id = "hotel-destination-hp-hotel")
	public WebElement goingToField;
	
	@FindBy(xpath="//a[@class='details']")
	public List<WebElement> destinationtList;
	

	@FindBy(xpath = "//input[@name='foo']")
	public WebElement destenationField;

	@FindBy(id = "hotel-checkin-hp-hotel")
	public WebElement checkInField;

	@FindBy(xpath = "//span[.='Aug 27, 2020']")
	public WebElement checkInCalendar;
	//button[@aria-label='May 6, 2020']
	
	public WebElement setDateNew(String year, String month, String day) {
		String customXpath = "//button[@data-year='" + year + "'][@data-month='" + month + "'][@data-day='" + day
				+ "']";
		return Driver.getDriver().findElement(By.xpath(customXpath));
	}
	
	public WebElement setDateNew2(String year, String month, String day) {
		String customXpath = "//button[@data-year='" + year + "'][@data-month='" + month + "'][@data-day='" + day
				+ "']";
		WebElement date = Driver.getDriver().findElement(By.xpath(customXpath));
		WebElement nextButton = Driver.getDriver().findElement(By.xpath("//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']"));
		while(!date.isDisplayed()) {
			nextButton.click();
		}
		return date;
	}
	
	@FindBy(id = "hotel-rooms-hp-hotel")
	public WebElement selectRoom;
	
	@FindBy(id = "hotel-1-adults-hp-hotel")
	public WebElement selectAdults;
	
	@FindBy(id = "hotel-1-children-hp-hotel")
	public WebElement selectChild;
	
	@FindBy(id = "hotel-1-age-select-1-hp-hotel")
	public WebElement selectChildAge;
	
	@FindBy(xpath = "//form[@id='gcw-hotel-form-hp-hotel']//button[contains(@class,'btn-primary btn-action gcw-submit')]")
	public WebElement searchButton;
	
	@FindBy(id = "hotel-add-flight-checkbox-hp-hotel")
	public WebElement addFlight;
	
	@FindBy(id = "hotel-add-car-checkbox-hp-hotel")
	public WebElement addCar;
	
	@FindBy(id = "hotel-flight-origin-hp-hotel")
	public WebElement flyingFromField;
	
	@FindBy(xpath="//a[@class='details']")
	public List<WebElement> airportList;
	
	
	
	
	
	
	
	
	
	
	
	public WebElement setDate(String month, int day, int year) {
		String customXpath = "//button[@aria-label='" + month + " " + day + ", " + year + "']";
		return Driver.getDriver().findElement(By.xpath(customXpath));
	}

	public WebElement setDate2(String month, int day, int year) {
		String customXpath = "//button[@aria-label='" + month + " " + day + ", " + year + "']";
		while(!Driver.getDriver().findElement(By.xpath(customXpath)).isDisplayed()) {
			Driver.getDriver().findElement(By.xpath("//div[@class='uitk-calendar']//button[2]")).click();
		}
		return Driver.getDriver().findElement(By.xpath(customXpath));
	}
	
	
	
	@FindBy(xpath = "//span[contains(text(),'Done')]")
	public WebElement calendarDoneButton;
	
	@FindBy(id = "hotel-checkout-hp-hotel")
	public WebElement checkOutField;
	
	
		
	
	
		
	
	
	@FindBy(xpath = "//button[@data-stid='fh-origin-dialog-trigger']")
	public WebElement airportInput;
	
	
	
	//div[@data-testid='room-1']//select[starts-with(@id,'age')] --> First room child age select
	
	
	
	
	
	
	
	
	@FindBy(xpath = "//button[.='Decrease adults in room 1']")
	public WebElement room1AdultminusButton;
	
	@FindBy(xpath = "//button[.='Increase adults in room 1']")
	public WebElement room1AdultplusButton;
	
	@FindBy(xpath = "//button[.='Decrease children in room 1']")
	public WebElement room1ChildminusButton;
	
	@FindBy(xpath = "//select[@name='child-0-0']")
	public WebElement room1ChildSelect;
	
	@FindBy(xpath = "//button[.='Increase children in room 1']")
	public WebElement room1ChildplusButton;
	
	@FindBy(xpath = "//button[.='Decrease adults in room 2']")
	public WebElement room2AdultminusButton;
	
	@FindBy(xpath = "//button[.='Increase adults in room 2']")
	public WebElement room2AdultplusButton;
	
	@FindBy(xpath = "//button[.='Decrease children in room 2']")
	public WebElement room2ChildminusButton;
	
	@FindBy(xpath = "//select[@name='child-1-0']")
	public WebElement room2ChildSelect;
	
	@FindBy(xpath = "//button[.='Increase children in room 2']")
	public WebElement room2ChildplusButton;
	
	@FindBy(xpath = "//button[@aria-label='Remove room 2 of 2']")
	public WebElement remove2ndRoomButton;
	
	@FindBy(xpath = "//button[@aria-label='Remove room 2 of 3']")
	public WebElement remove3rdRoomButton;
	
	@FindBy(xpath = "//button[.='Add another room']")
	public WebElement addRoomButton;
	
	@FindBy(linkText = "Request 9+ hotel rooms")
	public WebElement requestMoreRoomLink;
	
	@FindBy(xpath = "//div[@class='uitk-scrim guestsDoneBtn fade-button']")
	public WebElement guestDoneButton;

}
