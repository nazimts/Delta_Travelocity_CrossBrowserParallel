	package com.travelocity.pages;

	import java.util.List;
	import java.util.Random;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;
import com.travelocity.utilities.Driver;

	public class FlightResultPage {

		public FlightResultPage() {
			PageFactory.initElements(Driver.getDriver(), this);

		}

		@FindBy(id = "stopFilter_stops-0")
		public WebElement nonStop;
		
		@FindBy(xpath="//span[@data-test-id='departure-time']")
		public WebElement departureTime;
		
		@FindBy(xpath="//span[@data-test-id='arrival-time']")
		public WebElement arrivalTime;
		
		@FindBy(xpath="//span[@data-test-id='airline-name']")
		public WebElement airlineName;
		
		@FindBy(xpath="//div[@data-test-id='route-happy-superlative']/a")
		public WebElement rating;
		
		@FindBy(xpath="//span[@class='duration-emphasis']")
		public WebElement flightDuration;
		
		@FindBy(xpath="//span[@class='number-stops']")
		public WebElement numberOfStops;
		
		@FindBy(xpath="(//div[@data-test-id='flight-info']/span)[1]")
		public WebElement departureAirport;
		
		@FindBy(xpath="(//div[@data-test-id='flight-info']/span)[3]")
		public WebElement arrivalAirport;
		
		@FindBy(xpath="//span[@data-test-id='listing-price-dollars']")
		public WebElement price;
		
		@FindBy(xpath="//div[@data-test-id='price-msg-route-type']")
		public WebElement typeOfTrip;
		
		@FindBy(xpath="//div[@data-test-id='flight-info']")
		public List<WebElement> departureAirports;
		
	
		
}
