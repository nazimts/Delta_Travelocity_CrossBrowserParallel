package com.travelocity.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;
import com.travelocity.pages.FlightResultPage;
import com.travelocity.pages.FlightsPage;
import com.travelocity.step_definitions.FlightSearchStepDefs;
import com.travelocity.utilities.LoggerUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;

import com.travelocity.utilities.BrowserUtilities;
import com.travelocity.utilities.ConfigReader;
import com.travelocity.utilities.Driver;
import com.travelocity.utilities.ExcelUtils;

public class FlightSearchStepDefs {
	public static String keyword;
	public static String tripType;
	
	Logger logger = LoggerUtils.getLogger(FlightSearchStepDefs.class);
	
	@Given("I am on the flights page")
	public void i_am_on_the_flights_page() {
		FlightsPage flightsPage = new FlightsPage();
		Driver.getDriver().get(ConfigReader.getConfiguration("url"));
		Driver.getDriver().manage().window().maximize();
		logger.info("Navigating to flights page");
		flightsPage.flightsButton.click();
	}
	
	@When("I click on Hotels button")
	public void i_click_on_Hotels_button() {
		FlightsPage flightsPage = new FlightsPage();
		flightsPage.hotelsButton.click();
	}	

	@When("I click on Flights button")
	public void i_click_on_flights_button() {
		FlightsPage flightsPage = new FlightsPage();
		flightsPage.flightsButton.click();
	}

	@Then("I should land on flights page")
	public void i_should_land_on_flights_page() {
		FlightsPage flightsPage = new FlightsPage();
		//String actualColor = flightsPage.flightsButton.getCssValue("background-color");
		//Assert.assertEquals("rgb(0,78,147)", actualColor);
		Assert.assertTrue(flightsPage.flightsText.getText().contains("Flights"));
	}
	
	@When("I type a keyword into Flying from field")
	public void i_type_a_keyword_into_Flying_from_field() {
		FlightsPage flightsPage = new FlightsPage();
		//keyword = flightsPage.generateKeyword();
		flightsPage.flyingFromAirport.sendKeys("New York");
	}

	@Then("I should see suggested options in the dropdown")
	public void i_should_see_suggested_options_in_the_dropdown() {
		FlightsPage flightsPage = new FlightsPage();
		List<String> options = BrowserUtilities.getElementsText(flightsPage.options);
		String[] letters = keyword.split("");
		for (String option : options) {
			for (String letter : letters) {
			Assert.assertTrue(option.contains(letter));
			}
		}
	}
	
	@When("I click on Clear button")
	public void i_click_on_Clear_button() {
		FlightsPage flightsPage = new FlightsPage();
		flightsPage.clearButton.click();
	}

	@Then("Flying from field should get cleared")
	public void flying_from_field_should_get_cleared() {
		FlightsPage flightsPage = new FlightsPage();
	    Assert.assertEquals(flightsPage.flyingFromAirport.getText(),"");
	}
	
	@When("I click on Search button")
	public void i_click_on_Search_button() {
		FlightsPage flightsPage = new FlightsPage();
		flightsPage.searchButton.submit();
	}
	
	@Then("Error messages should be displayed")
	public void error_messages_should_be_displayed() {
		FlightsPage flightsPage = new FlightsPage();
		Assert.assertEquals("Please correct the errors below.",flightsPage.errorMessage.getText());
	}
	
	/*@When("I enter flight details")
	public void i_enter_flight_details() {
		FlightsPage flightsPage = new FlightsPage();
		flightsPage.flyingFromAirport.click();
		flightsPage.flyingFromAirport.sendKeys("Istanbul");
		BrowserUtilities.selectFromList(flightsPage.airportList, "Istanbul (IST - All Airports)");
		flightsPage.flyingToAirport.click();
		flightsPage.flyingToAirport.sendKeys("Shanghai");
		BrowserUtilities.selectFromList(flightsPage.airportList, "Shanghai (PVG - Pudong Intl.)");
		flightsPage.departingDate.click();
		flightsPage.setDate("2020", "4", "6").click();
		flightsPage.returningDate.click();
		flightsPage.setDate("2020", "4", "15").click();
		BrowserUtilities.selectByVisibleText(flightsPage.adultsNumber, "2");
		BrowserUtilities.selectByValue(flightsPage.childrenNumber,"1");
		BrowserUtilities.selectByValue(flightsPage.childAge,"9");
		
		}*/
	
	@When("I select {int} children")
	public void i_select_children(Integer int1) {
		FlightsPage flightsPage = new FlightsPage();
		BrowserUtilities.selectByValue(flightsPage.childrenNumber,int1+""); // from 0 to 6
	}

	@Then("{int} options to enter children age shoud be displayed")
	public void options_to_enter_children_age_shoud_be_displayed(Integer int1) {
		FlightsPage flightsPage = new FlightsPage();
		int count = 0;
		if (int1==0) { 
			Assert.assertFalse(flightsPage.childAge.isDisplayed());
		}else { 
			//Assert.assertTrue(flightsPage.checkNumberOfChildren(int1).isDisplayed());
			for (WebElement age : flightsPage.childAgeList) 
				if (age.isDisplayed()) count++;
			Assert.assertTrue(int1==count);
		}	
	}


	@When("I select {string} as a trip type")
	public void i_select_as_a_trip_type(String string) {
		FlightsPage flightsPage = new FlightsPage();
		//flightsPage.setTripType(string).click();
		switch(string) {
		case "Roundtrip": 
			flightsPage.roundTrip.click();
			break;
		case "One way":
			flightsPage.oneWay.click();
			break;
		case "Multy-city":
			flightsPage.multiCity.click();
			break;
		}	
		tripType = string;
	}

	@When("I enter random flight details")
	public void i_enter_random_flight_details() {
		FlightsPage flightsPage = new FlightsPage();
		Faker f = new Faker();
		switch(tripType) {
		case "Roundtrip": 
			flightsPage.flyingFromAirport.sendKeys("New York");//(f.aviation().airport()); //airport from Faker class
			flightsPage.flyingToAirport.sendKeys("Istanbul");//(f.aviation().airport()); //airport from Faker class
			//flightsPage.departingDate.click();
			flightsPage.departingDate.sendKeys("05/10/2020");
			//flightsPage.setDate("2020", "5", "10").click();
			//flightsPage.returningDate.click();
			//flightsPage.returningDate.sendKeys("05/15/2020");
			//flightsPage.setDate2("2020", "5", "15").click();
			//BrowserUtilities.selectByVisibleText(flightsPage.adultsNumber, new Random().nextInt(6)+1+""); //random number from 1 to 6
			BrowserUtilities.selectByValue(flightsPage.childrenNumber,"0");
			break;
		case "One way": 
			flightsPage.flyingFromAirport.sendKeys("New York");//(f.aviation().airport()); //airport from Faker class
			flightsPage.flyingToAirport.sendKeys("Istanbul");//(f.aviation().airport()); //airport from Faker class
			flightsPage.departingDateOneWay.click();
			flightsPage.setDate("2020", "5", "10").click();
			//BrowserUtilities.selectByVisibleText(flightsPage.adultsNumber, new Random().nextInt(6)+1+""); //random number from 1 to 6
			BrowserUtilities.selectByValue(flightsPage.childrenNumber,"0");
			break;
		case "Multi-city":
			String transferAirport = f.aviation().airport();
			flightsPage.flyingFromAirport.sendKeys(f.aviation().airport()); //airport from Faker class
			flightsPage.flyingToAirport.sendKeys(transferAirport); //transferAirport
			flightsPage.departingDate.click();
			flightsPage.setDate("2020", "5", "10").click();
			BrowserUtilities.selectByVisibleText(flightsPage.adultsNumber, new Random().nextInt(6)+1+""); //
			BrowserUtilities.selectByValue(flightsPage.childrenNumber,"0");
			flightsPage.flyingFromAirport2.sendKeys(transferAirport); //airport from Faker class
			flightsPage.flyingToAirport2.sendKeys(f.aviation().airport()); //transferAirport
			flightsPage.departingDate2.click();
			flightsPage.setDate("2020", "5", "15").click();
			break;
		}
		
	 }

	@Then("Flight tickets of corresponding trip type should be displayed")
	public void flight_tickets_of_corresponding_trip_type_should_be_displayed(){
		FlightResultPage flightResultPage = new FlightResultPage();
		BrowserUtilities.waitFor(10);
		String actual = flightResultPage.typeOfTrip.getText();
		Assert.assertEquals(tripType.toLowerCase(), actual);
	}
	
	@When("I enter {string} as a departing city")
	public void i_enter_as_a_departing_city(String departingCity) {
		FlightsPage flightsPage = new FlightsPage();
		flightsPage.flyingFromAirport.sendKeys(departingCity);
	}

	@When("I enter {string} as an arrival city")
	public void i_enter_as_an_arrival_city(String arrivalCity) {
		FlightsPage flightsPage = new FlightsPage();
		flightsPage.flyingToAirport.sendKeys(arrivalCity);
	}

	@When("I enter {string} as a departing date")
	public void i_enter_as_a_departing_date(String departingDate) {
		FlightsPage flightsPage = new FlightsPage();
		flightsPage.departingDate.click();
		flightsPage.departingDate.sendKeys(departingDate);
	}

	@Then("Flight tickets should contain {string}, {string}, {string} as departure airports")
	public void flight_tickets_should_contain_as_departure_airports(String da1, String da2, String da3) {
		String actualDA="";
		FlightResultPage flightResultPage = new FlightResultPage();
		for (WebElement da : flightResultPage.departureAirports)
			actualDA = da.getText().substring(0, 4);
			System.out.println(actualDA);
		   	Assert.assertTrue(actualDA.equals(da1) || actualDA.equals(da2) || actualDA.equals(da3));
	}

	
	@When("I enter the flight details")
	public void i_enter_the_flight_details() {
		FlightsPage flightsPage = new FlightsPage();
		
		ExcelUtils sheet = new ExcelUtils("src/test/resources/com/travelocity/test-data/2.xlsx", "Sheet1");
		
		List<Map<String, String>> allRows = sheet.getDataAsList();
		
		for (int i = 0; i < allRows.size(); i++) {
			
			  Map<String, String> row = allRows.get(i);
			  
			if(row.get("Execute").equalsIgnoreCase("Y")) {
				
				flightsPage.flyingFromAirport.sendKeys(row.get("Flying from"));
				flightsPage.flyingToAirport.sendKeys(row.get("Flying to"));
				flightsPage.departingDateOneWay.sendKeys(row.get("Departing"));
			}	
		}	
	}

	@Then("The details of the cheapest flight ticket should be correct")
	public void the_details_of_the_cheapest_flight_ticket_should_be_correct() {
		FlightResultPage flightResultPage = new FlightResultPage();
		
		ExcelUtils sheet = new ExcelUtils("src/test/resources/com/travelocity/test-data/1.xlsx", "Sheet1");
				
		List<Map<String, String>> allRows = sheet.getDataAsList();
		
		for (int i = 0; i < allRows.size(); i++) {
			
			  Map<String, String> row = allRows.get(i);
			 
			if(row.get("Execute").equalsIgnoreCase("Y")) {
				
				String expectedPrice = row.get("Price");
				String expectedDuration = row.get("Duration");
				String expectedStops = row.get("Stops");
				String expectedAirline = row.get("Airline");
				String expectedDepartureTime = row.get("Departure time");
				String expectedArrivalTime = row.get("Arrival time");
				String expectedRating = row.get("Rating");
				
				
				String actualPrice = flightResultPage.price.getText();
				String actualDuration = flightResultPage.flightDuration.getText();
				String actualStops = flightResultPage.numberOfStops.getText();
				String actualAirline = flightResultPage.airlineName.getText();
				String actualDepartureTime = flightResultPage.departureTime.getText();
				String actualArrivalTime = flightResultPage.arrivalTime.getText();
				String actualRating = flightResultPage.rating.getText();
				
				try {
				assertEquals(expectedPrice, actualPrice);
				assertEquals(expectedDuration, actualDuration);
				assertEquals(expectedStops, actualStops);
				assertEquals(expectedAirline, actualAirline);
				assertEquals(expectedDepartureTime, actualDepartureTime);
				assertEquals(expectedArrivalTime, actualArrivalTime);
				assertEquals(expectedRating, actualRating);
				sheet.setCellData("passed", "Status", i+1);
				
				}catch(AssertionError e) {
					e.printStackTrace();
					sheet.setCellData("fail", "Status", i+1);
					
				}
				
				Driver.getDriver().navigate().back();
			} else {
				sheet.setCellData("skipped", "Status", i+1);
			} 
			  
	}

}
	
	
}
