package com.travelocity.pages;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.travelocity.utilities.Driver;

public class FlightsPage {

	public FlightsPage() {
		PageFactory.initElements(Driver.getDriver(), this);

	}

	@FindBy(id = "tab-flight-tab-hp")
	public WebElement flightsButton;

	@FindBy(id = "tab-hotel-tab-hp")
	public WebElement hotelsButton;

	@FindBy(xpath = "//button[@id='tab-flight-tab-hp']//span[@class='tab-label']")
	public WebElement flightsText;

	@FindBy(xpath = "//button[@class='btn btn-clear']")
	public WebElement clearButton;

	@FindBy(id = "flight-origin-hp-flight")
	public WebElement flyingFromAirport;
	
	@FindBy(id = "flight-2-origin-hp-flight")
	public WebElement flyingFromAirport2;
	
	@FindBy(id = "flight-2-destination-hp-flight")
	public WebElement flyingToAirport2;
	
	@FindBy(xpath = "//div[@class='multiLineDisplay details']")
	public List<WebElement> airportList;

	@FindBy(id = "flight-destination-hp-flight")
	public WebElement flyingToAirport;

	@FindBy(id = "flight-departing-hp-flight")
	public WebElement departingDate;
	
	@FindBy(id = "flight-departing-single-hp-flight")
	public WebElement departingDateOneWay;
	
	@FindBy(id = "flight-2-departing-hp-flight")
	public WebElement departingDate2;

	@FindBy(id = "flight-returning-hp-flight")
	public WebElement returningDate;

	@FindBy(id = "flight-adults-hp-flight")
	public WebElement adultsNumber;

	@FindBy(id = "flight-children-hp-flight")
	public WebElement childrenNumber;

	@FindBy(xpath = "//label[@class='col search-btn-col']//button[.='Search']")
	public WebElement searchButton;

	@FindBy(className = "multiLineDisplay details")
	public List<WebElement> options;

	@FindBy(xpath = "//h5[@class='alert-title no-outline']")
	public WebElement errorMessage;

	@FindBy(xpath = "(//caption[@class='datepicker-cal-month-header'])[1]")
	public WebElement leftMonthYear;

	@FindBy(xpath = "(//caption[@class='datepicker-cal-month-header'])[2]")
	public WebElement rightMonthYear;

	@FindBy(xpath = "//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")
	public WebElement rightArrow;

	@FindBy(xpath = "(//table)[1]")
	public WebElement leftCalendar;

	@FindBy(xpath = "(//table)[2]")
	public WebElement rightCalendar;

	@FindBy(id = "flight-age-select-1-hp-flight")
	public WebElement childAge;
	
	@FindBy(id = "flight-type-one-way-label-hp-flight")
	public WebElement oneWay;
		
	@FindBy(id = "flight-type-roundtrip-label-hp-flight")
	public WebElement roundTrip;
	
	@FindBy(id = "flight-type-multi-dest-label-hp-flight")
	public WebElement multiCity;
	
	@FindBy(xpath="//select[starts-with(@id,'flight-age-select')]")
	public List<WebElement> childAgeList;
	
	public WebElement setTripType(String tripType) {
		String customXpath = "//span[.='"+ tripType + "']";
		return Driver.getDriver().findElement(By.xpath(customXpath));
	}
	
	public WebElement checkNumberOfChildren(int numberOfChildren) {
		String customID = "flight-age-select-" + numberOfChildren + "-hp-flight";
		return Driver.getDriver().findElement(By.id(customID));
	}
	
	
	
	public void selectMonthYearDay(String month, String year, String day) {
		if (leftMonthYear.getText().equals(month.concat(" " + year)))
			selectCalendarDay(leftCalendar, day);
		else if (rightMonthYear.getText().contains(month.concat(" " + year)))
			selectCalendarDay(rightCalendar, day);
		else
			rightArrow.click();
	}

	public static void selectCalendarDay(WebElement calendar, String day) {
		List<WebElement> rows = calendar.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				if (cell.getText().equals(" " + day)) {
					cell.click();
					break;
				}
			}
		}
	}

	public String generateKeyword() {
		String s = "gfk";
		int n = 1 + (int) (Math.random() * 11);// random number from 1 to 10
		for (int i = 0; i < n; i++) {
			int rnd = new Random().nextInt(2); // 0 or 1
			if (rnd == 0)
				s += (char) (65 + Math.random() * 26);// Capital letter
			else
				s += (char) (97 + Math.random() * 26);// Lowcase letter
		}
		return s;
	}

	public WebElement setDate(String year, String month, String day) {
		String customXpath = "//button[@data-year='" + year + "'][@data-month='" + month + "'][@data-day='" + day
				+ "']";
		return Driver.getDriver().findElement(By.xpath(customXpath));
	}

	public WebElement setDate2(String year, String month, String day) {

		String customXpath = "//button[@data-year='" + year + "'][@data-month='" + month + "'][@data-day='" + day
				+ "']";
		while (!Driver.getDriver().findElement(By.xpath(customXpath)).isDisplayed()){
				rightArrow.click();
		}
		return Driver.getDriver().findElement(By.xpath(customXpath));
	}

	

}
