package com.travelocity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.travelocity.utilities.Driver;

public class HotelsPage {

	public HotelsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id = "primary-header-hotel")
	public WebElement hotelsMenu;

	@FindBy(xpath = "//button[contains(@aria-label,'Going to')]")
	public WebElement goingToField;

	@FindBy(xpath = "//input[@name='foo']")
	public WebElement destenationField;

	@FindBy(id = "start-btn")
	public WebElement checkInField;

	@FindBy(xpath = "//span[.='Aug 27, 2020']")
	public WebElement checkInCalendar;
	//button[@aria-label='May 6, 2020']
	
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
	
	@FindBy(id = "end-btn")
	public WebElement checkOutField;
	
	@FindBy(id = "destination-field")
	public WebElement guestField;
	
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
	
	@FindBy(xpath = "//button[@data-testid='wizard-submit-button']")
	public WebElement searchButton;
	
	
	
	
	
	

}
