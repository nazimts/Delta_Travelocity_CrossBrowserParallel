package com.travelocity.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.travelocity.pages.HotelsPage;
import com.travelocity.utilities.BrowserUtilities;
import com.travelocity.utilities.ConfigReader;
import com.travelocity.utilities.Driver;
import com.travelocity.utilities.LoggerUtils;

public class Hotels {

	Logger logger = LoggerUtils.getLogger(FlightSearchStepDefs.class);

	@Given("Click on hotels")
	public void click_on_hotels() {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Clicking on Hotels");
		hotelspage.hotelsMenu.click();
		BrowserUtilities.waitFor(3);
				
	}

	@Then("The hotels page title should be Cheap Hotels: Book Hotel Deals With Our Hotel Finder | Travelocity")
	public void the_hotels_page_title_should_be_Cheap_Hotels_Book_Hotel_Deals_With_Our_Hotel_Finder_Travelocity() {
		logger.info("Getting the Hotels page title");
		String actual = Driver.getDriver().getTitle();
		String expected = "Cheap Hotels: Book Hotel Deals With Our Hotel Finder | Travelocity";
		logger.info("Verifying the title");

		try {
			assertEquals(expected, actual);
			logger.info("Title Verification passed");

		} catch (AssertionError e) {

			logger.error("Title Verification failed");
			logger.error(e.toString());
			throw e; // re-throw my error so that my test fails
		}
	}
	
	

	@Then("Destination field should contain {string}")
	public void destination_field_should_contain(String destination) {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Verifying the field should contains " + destination);
		try {
			assertTrue(destination.contains(hotelspage.goingToField.getText()));
			logger.info("Verification passed");

		} catch (AssertionError e) {

			logger.error("Verification failed");
			logger.error(e.toString());
			throw e; // re-throw my error so that my test fails
		}
	}
	
	@And("Set {string} {int} {int} date to Check in field")
	public void set_date_to_Check_in_field(String string, Integer int1, Integer int2) {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Setting " + string+int1+int2 + " on Check in field");
		//JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
		//js.executeScript("arguments[0].click()", hotelspage.setDate(string, int1, int2));
		//BrowserUtilities.waitFor(3);
		hotelspage.checkInField.sendKeys("May 10");
		logger.info("Clicking Done button");
		//js.executeScript("arguments[0].click()",hotelspage.calendarDoneButton);
		hotelspage.calendarDoneButton.click();
		//BrowserUtilities.waitFor(3);
	}

		
	@And("Set {string} {int} {int} date to Check out field")
	public void set_date_to_Check_out_field(String string, Integer int1, Integer int2) {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Setting " + string+int1+int2 + " on Check out field");
		//JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
		//js.executeScript("arguments[0].click()", hotelspage.setDate(string, int1, int2));
		//BrowserUtilities.waitFor(3);
		hotelspage.checkOutField.sendKeys("May 15");
		logger.info("Clicking Done button");
		hotelspage.calendarDoneButton.click();
		logger.info("Clicking Done button");
		//js.executeScript("arguments[0].click()",hotelspage.calendarDoneButton);
		//BrowserUtilities.waitFor(3);
	}

	@And("Click on guest field")
	public void click_on_guest_field() {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Clicking on guest field");
		hotelspage.guestField.click();
		BrowserUtilities.waitFor(3);
	}

	@And("Decrease the adult in first room")
	public void decrease_the_adult_in_first_room() {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Clicking minus button to decrease the adult in first room");
		hotelspage.room1AdultminusButton.click();
		BrowserUtilities.waitFor(3);
	}

	@And("Increase the child in first room")
	public void increase_the_child_in_first_room() {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Clicking plus button to increase the child in first room");
		hotelspage.room1ChildplusButton.click();
		BrowserUtilities.waitFor(3);
	}

	@And("Select age of child in first room")
	public void select_age_of_child_in_first_room() {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Selecting age of child in first room");
		BrowserUtilities.selectByValue(hotelspage.room1ChildSelect, "4");
		BrowserUtilities.waitFor(3);
	}

	@Then("Click to add another room")
	public void click_to_add_another_room() {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Clicking to add another room");
		hotelspage.addRoomButton.click();
		BrowserUtilities.waitFor(3);
	}

	@And("Increase the adult in second room")
	public void increase_the_adult_in_second_room() {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Clicking plus button to increase the adult in second room");
		hotelspage.room2AdultplusButton.click();
		BrowserUtilities.waitFor(3);
		logger.info("Scroll down");
		JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", hotelspage.addRoomButton);
		BrowserUtilities.waitFor(3);
	}

	@And("Click to remove third room")
	public void click_to_remove_third_room() {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Clicking to to remove third room");
		hotelspage.remove3rdRoomButton.click();
		BrowserUtilities.waitFor(3);
	}

	@And("Click Done button")
	public void click_Done_button() {
		HotelsPage hotelspage = new HotelsPage();
		logger.info("Clicking Done button");
		hotelspage.guestDoneButton.click();
		BrowserUtilities.waitFor(3);
	}


	@Then("The hotels page title should be Florida, United States of America Hotel Search Results")
	public void the_hotels_page_title_should_be_Florida_United_States_of_America_Hotel_Search_Results() {
		logger.info("Getting the Hotels page title");
		String actual = Driver.getDriver().getTitle();
		String expected = "Florida, United States of America Hotel Search Results";
		logger.info("Verifying the title");
		try {
			assertEquals(expected, actual);
			logger.info("Title Verification passed");

		} catch (AssertionError e) {

			logger.error("Title Verification failed");
			logger.error(e.toString());
			throw e; // re-throw my error so that my test fails
		}
	}
	
	
	
}
	
	
	


